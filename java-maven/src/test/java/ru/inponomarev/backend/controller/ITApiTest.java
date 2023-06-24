package ru.inponomarev.backend.controller;

import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ru.inponomarev.backend.dto.ItemDTO;
import ru.inponomarev.backend.dto.OrderDTO;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ITApiTest {
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8080/api/v1/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    private Api api = retrofit.create(Api.class);

    @Test
    void helloTest() throws IOException {
        Response<String> response = api.hello().execute();
        assertThat(response.code()).isEqualTo(200);
        assertThat(response.body()).isEqualTo("OK");
    }

    @Test
    void getItemTest() throws IOException {
        Response<List<ItemDTO>> response = api.getAllItems().execute();
        assertThat(response.code()).isEqualTo(200);
        assertThat(response.body()).hasSize(3);
    }

    @Test
    void postOrder() throws IOException {
        var dto = new OrderDTO();
        dto.setCustomerId(1);
        dto.setItemId("item001");
        dto.setQuantity(1);
        Response<OrderDTO> response = api.postOrder(dto).execute();
        assertThat(response.code()).isEqualTo(200);
        assertThat(response.body().getPrice()).isEqualTo(10);
    }
}
