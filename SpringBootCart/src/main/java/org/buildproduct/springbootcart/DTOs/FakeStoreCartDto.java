package org.buildproduct.springbootcart.DTOs;

import jakarta.websocket.server.ServerEndpoint;
import lombok.Getter;
import lombok.Setter;
import org.buildproduct.springbootcart.models.Products;

import java.util.Date;
import java.util.List;
@Getter
@Setter

public class FakeStoreCartDto {
    private long id;
    private  long userId;
    private Date date;
    private List<Products> products;
}
