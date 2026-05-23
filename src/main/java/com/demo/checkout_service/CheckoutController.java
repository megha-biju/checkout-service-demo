package com.demo.checkout_service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController {

    private final JdbcTemplate jdbcTemplate;

    public CheckoutController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/checkout")
    public String checkout() {

        String result = jdbcTemplate.queryForObject(
                "SELECT NOW()",
                String.class
        );

        return "Checkout Successful : " + result;
    }
}