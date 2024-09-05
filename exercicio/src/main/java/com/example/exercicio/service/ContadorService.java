package com.example.exercicio.service;

import org.springframework.stereotype.Service;

@Service
public class ContadorService {

    public int contarCaracteres(String input) {
        if (input == null) {
            return 0;
        }
        // Remove espaços em branco e conta os caracteres restantes
        return input.replace(" ", "").length();
    }
}

