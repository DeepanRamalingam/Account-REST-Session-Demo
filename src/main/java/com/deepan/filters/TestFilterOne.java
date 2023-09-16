package com.deepan.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class TestFilterOne implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Test filter invoked");
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        System.out.println(req.getHeader("x-api-key"));
//        verify the token
//        if the token is valid, request will be processed
        filterChain.doFilter(req,res);
//        else return a error response
    }
}



//specification Open API -- swagger
//api first
