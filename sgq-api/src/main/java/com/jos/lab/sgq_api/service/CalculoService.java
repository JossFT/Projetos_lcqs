package com.jos.lab.sgq_api.service;

import com.jos.lab.sgq_api.model.ResultadoUfc;
import com.jos.lab.sgq_api.repository.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Service
public class CalculoService {

    @Autowired
    private ResultadoRepository resultadoRepository;

    private final DecimalFormat df = new DecimalFormat("0.00E00", new DecimalFormatSymbols(Locale.US));

    // 1 & 3. Cálculo Geral e Estimado (Spread-Pour Plate)
    public String calcularUFC(double colonias, int diluicao, double volume) {
        if (volume <= 0) return "Volume Inválido";
        
        double resultado = (colonias * diluicao) / volume;
        String resultadoFinal;

        if (resultado < 10) {
            resultadoFinal = "< 1.0 × 10¹";
        } else {
            resultadoFinal = formatar(resultado);
        }

        // SALVANDO NO MYSQL
        ResultadoUfc registro = new ResultadoUfc();
        registro.setTipoCalculo("UFC Geral");
        registro.setResultado(resultadoFinal);
        resultadoRepository.save(registro);

        return resultadoFinal;
    }

    // 2. Cálculo de Estafilococos spp. (Com Confirmação)
    public String calcularEstafilococos(double suspeitas, double confirmadas, double testadas, int diluicao, double volume) {
        if (testadas <= 0 || volume <= 0) return "Dados Inválidos";
        
        double coloniasCalculadas = suspeitas * (confirmadas / testadas);
        double resultado = (coloniasCalculadas * diluicao) / volume;
        String resultadoFinal = formatar(resultado);

        // SALVANDO ESTAFILOCOCOS NO MYSQL
        ResultadoUfc registro = new ResultadoUfc();
        registro.setTipoCalculo("Estafilococos");
        registro.setResultado(resultadoFinal);
        resultadoRepository.save(registro);

        return resultadoFinal;
    }

    private String formatar(double valor) {
        String formatado = df.format(valor);
        return formatado.replace("E", " × 10^").replace("+", "");
    }
}