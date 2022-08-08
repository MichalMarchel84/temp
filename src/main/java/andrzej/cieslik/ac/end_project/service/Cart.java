package andrzej.cieslik.ac.end_project.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private final List<CartItem> cartItems= new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }
    public void addToCart(CartItem cartItem){
        cartItems.add(cartItem);
    }
}
