package com.totvs.tiozap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

@RestController
public class TiozapController {
    @GetMapping("/")/// Ele mostra na web a String
    public String dizerHello(){
        return "Hello Kitty";
    }

    @GetMapping("/data")
    public LocalDate mostrarData(){
        return LocalDate.of(2000, Month.DECEMBER, 22);
    }




}
