package com.Jknpp.DesafioItau.controller;

import com.Jknpp.DesafioItau.entity.Estatisticas;
import com.Jknpp.DesafioItau.entity.Transacao;
import com.Jknpp.DesafioItau.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {
    private final TransacaoService transacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void fazerTransacao(@Valid @RequestBody Transacao transacao){
        transacaoService.fazerTransacao(transacao);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void limparTransacoes(){
        transacaoService.limparTransacoes();
    }

    @GetMapping("/estatistica")
    @ResponseStatus(HttpStatus.OK)
    public Estatisticas buscarEstatisticas(){
        return transacaoService.mostrarEstatisticas();
    }
}
