package ru.inponomarev.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import ru.inponomarev.backend.dto.ItemDTO;
import ru.inponomarev.backend.dto.OrderDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface Api {
    @GET(value = "hello")
    Call<String> hello();

    @POST(value = "order")
    @Headers("Content-Type: application/json")
    Call<OrderDTO> syncPlayerActivities(@Body OrderDTO request);

    @POST(value = "order")
    Call<OrderDTO> postOrder(@Body OrderDTO request);

    @GET(value = "item")
    Call<List<ItemDTO>> getAllItems();
}
