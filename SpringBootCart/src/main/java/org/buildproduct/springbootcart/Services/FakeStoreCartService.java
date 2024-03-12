package org.buildproduct.springbootcart.Services;

import org.buildproduct.springbootcart.DTOs.FakeStoreCartDto;
import org.buildproduct.springbootcart.models.Cart;
import org.buildproduct.springbootcart.models.Products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service

public class FakeStoreCartService implements CartService {
final RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<Cart> getAllCart() {

        FakeStoreCartDto[] all_cart =  restTemplate.getForObject(
                "https://fakestoreapi.com/carts",
                FakeStoreCartDto[].class
        );

        List<Cart> cartlist = new ArrayList<>();

        for(FakeStoreCartDto ele: all_cart){
            Cart cart = getCart(ele);
            cartlist.add(cart);

        }
        return cartlist;




    }

    private static Cart getCart(FakeStoreCartDto ele) {
        Cart cart = new Cart();
        cart.setId(ele.getId());
        cart.setUserId(ele.getUserId());
        cart.setDate(ele.getDate());

        List<Products> products = new ArrayList<>();

        for(Products ele1: ele.getProducts()){
            Products product = new Products();
            product.setQuantity(ele1.getQuantity());
            product.setProductId(ele1.getProductId());
            products.add(product);

        }
        cart.setProducts(products);
        return cart;
    }

    @Override
    public Cart getSingleCart(Long id) {
        FakeStoreCartDto fakeStoreCartDto = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/" +id,
                FakeStoreCartDto.class

        );
        Cart cart1 = new Cart();
        cart1.setId(fakeStoreCartDto.getId());
        cart1.setUserId(fakeStoreCartDto.getUserId());
        cart1.setDate(fakeStoreCartDto.getDate());
        List<Products> products = new ArrayList<>();

       for(Products ele: fakeStoreCartDto.getProducts()){
           Products product = new Products();
           product.setQuantity(ele.getQuantity());
           product.setProductId(ele.getProductId());
           products.add(product);

       }
       cart1.setProducts(products);

       return cart1;

    }

    @Override
    public Cart createNewCart(Cart cart) {
        Cart newcart = new Cart();
        newcart.setProducts(cart.getProducts());
        newcart.setId(cart.getId());
        newcart.setUserId(cart.getUserId());
        newcart.setDate(cart.getDate());
        restTemplate.postForObject(
                "https://fakestoreapi.com/carts",
                newcart,
                FakeStoreCartDto.class
        );
        return newcart;
    }

    @Override
    public Cart updateCart(Cart cart) {
        Cart newcart = new Cart();
        newcart.setProducts(cart.getProducts());
        newcart.setId(cart.getId());
        newcart.setUserId(cart.getUserId());
        newcart.setDate(cart.getDate());

        restTemplate.put(
                "https://fakestoreapi.com/carts/" + cart.getId(),
                newcart

        );
        return newcart;
    }

    @Override
    public Cart deleteCart(Long id) {
        Cart cart = getSingleCart(id);
        restTemplate.delete(
                "https://fakestoreapi.com/carts/"+id,
                cart
        );
        return cart;
    }
}
