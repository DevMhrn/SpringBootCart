package org.buildproduct.springbootcart.Services;

import org.buildproduct.springbootcart.models.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCart();

    Cart getSingleCart(Long id);
    Cart createNewCart(Cart cart);

    Cart updateCart(Cart cart);

    Cart deleteCart(Long id);


}
