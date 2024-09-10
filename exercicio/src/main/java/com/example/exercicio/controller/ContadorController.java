package com.example.exercicio.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exercicio.service.ContadorService;

@RestController
public class ContadorController {

    @Autowired
    private ContadorService caracterContadoService;

    @RequestMapping("/count")
    public int contarCaracteres(@RequestBody String input) {
        return caracterContadoService.contarCaracteres(input);
    }

    @RequestMapping("/count2")
    public int contarCaracteres2(@RequestParam String input) {
        return caracterContadoService.contarCaracteres(input);
    }
}
