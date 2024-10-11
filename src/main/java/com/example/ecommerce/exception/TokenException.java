/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.exception;

import lombok.Getter;

/**
 *
 * @author infoh
 */

@Getter
public class TokenException extends RuntimeException {

    String token;
    
    public TokenException(String message, String token) {
        super(message);
        this.token = token;
    }
}
