package com.example.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("hats")
@Primary
public class Hats implements Outfit{
    @Override
    public void wear() {
        System.out.println("Đã đội mũ hats");
    }
}
