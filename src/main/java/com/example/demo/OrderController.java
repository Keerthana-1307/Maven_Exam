package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if (username.equals("admin") && password.equals("1234")) {
            return "order";
        } else {
            return "login";
        }
    }

    
    @PostMapping("/order")
    public String placeOrder(@RequestParam String item,
                             @RequestParam int quantity,
                             Model model) {

        String message = "Order Confirmed! Item: " + item +
                         " Quantity: " + quantity;

        model.addAttribute("msg", message);
        return "result";
    }
}