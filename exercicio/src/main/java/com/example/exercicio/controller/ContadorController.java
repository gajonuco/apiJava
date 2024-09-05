package com.example.exercicio.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exercicio.service.ContadorService;

@RestController
public class ContadorController {

    @Autowired
    private ContadorService caracterContadoService;

    @GetMapping("/count")
    public int contarCaracteres(@RequestParam String input) {
        return caracterContadoService.contarCaracteres(input);
    }
}
