package com.jos.lab.sgq_api.controller;

import com.jos.lab.sgq_api.service.CalculoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculos")
public class CalculoController {

    private final CalculoService calculoService;

    // Construtor para o Java reconhecer o Service
    public CalculoController(CalculoService calculoService) {
        this.calculoService = calculoService;
    }

    // Rota para o cálculo padrão (Geral/Estimado)
    @GetMapping("/ufc")
    public String ufcPadrao(
            @RequestParam double colonias, 
            @RequestParam int diluicao, 
            @RequestParam double volume) {
        return "Resultado (Geral/Estimado): " + calculoService.calcularUFC(colonias, diluicao, volume);
    }

    // Rota específica para Estafilococos
    @GetMapping("/estafilococos")
    public String estafilococos(
            @RequestParam double suspeitas, 
            @RequestParam double confirmadas, 
            @RequestParam double testadas, 
            @RequestParam int diluicao, 
            @RequestParam double volume) {
        return "Resultado (Estafilococos): " + calculoService.calcularEstafilococos(suspeitas, confirmadas, testadas, diluicao, volume);
    }
}