package org.buildproduct.springbootcart.controllers;

import org.buildproduct.springbootcart.Services.CartService;
import org.buildproduct.springbootcart.models.Cart;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public class CartController {

    final CartService cartservice ;
    public CartController(CartService cartservice){
        this.cartservice = cartservice;
    }


    @GetMapping("/carts")
    public List<Cart> getAllCart(){
        return cartservice.getAllCart();
    }
    @GetMapping("/carts/{id}")
    public Cart getSingleCart(@PathVariable("id") Long iD){
        return cartservice.getSingleCart(iD);
    }
    @PutMapping("/carts")
    public Cart createNewCart(Cart cart){
        return cartservice.createNewCart(cart);
    }
    @PutMapping("/carts/{id}")
    public Cart updateCart(@PathVariable("id") Cart cart){
        return cartservice.updateCart(cart);
    }
    @DeleteMapping("/carts/{id}")
    public Cart deleteCart(@PathVariable("id") Long iD){
        return cartservice.deleteCart(iD);
    }
}
