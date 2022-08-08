package andrzej.cieslik.ac.end_project.controller;

import andrzej.cieslik.ac.end_project.model.Product;
import andrzej.cieslik.ac.end_project.repository.ProductRepository;
import andrzej.cieslik.ac.end_project.service.Cart;
import andrzej.cieslik.ac.end_project.service.CartItem;
import andrzej.cieslik.ac.end_project.user.UserService;
import andrzej.cieslik.ac.end_project.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller

public class CartController {
    private final Cart cart;
    private final ProductRepository productRepository;
    private final UserService userService;

    public CartController(Cart cart, ProductRepository productRepository, UserService userService) {
        this.cart = cart;
        this.productRepository = productRepository;
        this.userService = userService;
    }

    @PostMapping("/add_to_cart")
    public String addToCart(Model model, @RequestParam Long id, @RequestParam int quantity ) {
        Optional<Product> productOptional = productRepository.findById(id);
        boolean flag = true;
        if(productOptional.isPresent()){
            for(CartItem cartItem: cart.getCartItems()){
              if(productOptional.get().getName().equals(cartItem.getProduct().getName())){
                  cartItem.setQuantity(cartItem.getQuantity() + quantity);
                  flag = false;
              }
            }
           if(flag){
               cart.addToCart(new CartItem(quantity, productOptional.get()));
           }
        }else{}
        return "redirect:/product-form/list";
    }

    @PostMapping("/edit_cart")
    public String editCart(@RequestParam Long id, @RequestParam int quantity){
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            for(CartItem cartItem: cart.getCartItems()){
                if(productOptional.get().getName().equals(cartItem.getProduct().getName())){
                    cartItem.setQuantity(cartItem.getQuantity() - cartItem.getQuantity() +quantity);
                }
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("cart",cart.getCartItems());
        return "cart/pay_list";
    }

    @PostMapping("/delete_position_in_cart")
    public String deletePositionFromCart(@RequestParam Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        CartItem temp = null;
        if(productOptional.isPresent()){
            for(CartItem cartItem: cart.getCartItems()){
                if(productOptional.get().getName().equals(cartItem.getProduct().getName())){
                    temp = cartItem;
                    //cart.getCartItems().remove(cartItem);
                }
            }
        }
        cart.getCartItems().remove(temp);
        return "redirect:/cart";
    }
    @PostMapping("/save_cart")
    public String saveCart (@RequestParam boolean save){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUserName(auth.getName());
        System.out.println("Bought by " + user.getUsername());
        if(save){
            for (CartItem cartItem: cart.getCartItems()){

            }
        }
        return null;
    }
}
