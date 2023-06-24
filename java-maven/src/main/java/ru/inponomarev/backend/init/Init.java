package ru.inponomarev.backend.init;


import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.curs.celesta.Celesta;
import ru.curs.celesta.DBType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

@Component
@Log
@RequiredArgsConstructor
public class Init implements ApplicationListener<ApplicationReadyEvent> {

    private final Celesta celesta;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        if (celesta.getDBAdaptor().getType() == DBType.H2) {
            initialize(celesta);
        }
    }

    public static void initialize(Celesta celesta) {
        try {
            log.info("Test data initialization started");
            String sql = getSQL("demodata.sql");
            try (Connection conn = celesta.getConnectionPool().get();
                 Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
            }
            log.info("Test data initialized successfully");
        } catch (SQLException | IOException e) {
            throw new IllegalStateException(String.format("Cannot initialize database: %s", e.getMessage()), e);
        }
    }

    private static String getSQL(String name) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        Init.class.getResourceAsStream(name),
                        StandardCharsets.UTF_8))) {
            return br.lines().collect(Collectors.joining("\n"));
        }
    }
}
