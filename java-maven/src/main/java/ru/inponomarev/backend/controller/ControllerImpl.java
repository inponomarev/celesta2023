package ru.inponomarev.backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.curs.celesta.SystemCallContext;
import ru.inponomarev.backend.dto.ItemDTO;
import ru.inponomarev.backend.dto.OrderDTO;
import ru.inponomarev.backend.service.OrderService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControllerImpl implements Controller {
    private final OrderService orderService;

    @Override
    public String hello(HttpServletResponse response) {
        return "OK";
    }


    @Override
    public OrderDTO postOrder(OrderDTO request, HttpServletResponse response) {
        return orderService.postOrder(new SystemCallContext(), request);
    }

    @Override
    public List<ItemDTO> getAllItems(HttpServletResponse response) {
        return orderService.getAggregateReport(new SystemCallContext());
    }
}
