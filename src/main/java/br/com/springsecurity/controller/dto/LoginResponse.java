package br.com.springsecurity.controller.dto;

public record LoginResponse(String accessToken, Long expireIn) {
    
}
