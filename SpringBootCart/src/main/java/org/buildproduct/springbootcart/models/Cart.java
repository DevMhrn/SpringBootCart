package org.buildproduct.springbootcart.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Cart {
    private long id;
    private long userId;
    private Date date;
    private List<Products> products;
}
