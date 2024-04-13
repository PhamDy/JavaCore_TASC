package com.example.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("shirt")
public class Shirt implements Outfit{

    @Override
    public void wear() {
        System.out.println("Đã mặc áo shirt");
    }
}
