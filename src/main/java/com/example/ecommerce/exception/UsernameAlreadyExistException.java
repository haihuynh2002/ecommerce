/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.exception;

/**
 *
 * @author infoh
 */
public class UsernameAlreadyExistException extends RuntimeException {
    
    public UsernameAlreadyExistException(String message) {
        super(message);
    }
}
