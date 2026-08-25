package com.Jknpp.DesafioItau.service;

import com.Jknpp.DesafioItau.entity.Estatisticas;
import com.Jknpp.DesafioItau.entity.Transacao;
import com.Jknpp.DesafioItau.exception.TransacaoInvalidaException;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service

public class TransacaoService {
    private final List<Transacao> transacoes = new ArrayList<>();

    public void fazerTransacao(Transacao transacao){
        if(transacao.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new TransacaoInvalidaException("O valor da trasação não pode ser negativo");
        }
        if(transacao.getDataHora().isAfter(OffsetDateTime.now())){
            throw new TransacaoInvalidaException("A data da transação não pode ser no futuro");
            }
        transacoes.add(transacao);
    }

    public void limparTransacoes(){
        transacoes.clear();
    }

    public Estatisticas mostrarEstatisticas(){
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);
        DoubleSummaryStatistics estatisticas = transacoes.stream()
                        .filter(tempo -> tempo.getDataHora().isAfter(limite))
                        .mapToDouble(transacao -> transacao.getValor().doubleValue())
                        .summaryStatistics();

        if (estatisticas.getCount() == 0) {
            return new Estatisticas(0L, 0, 0, 0, 0);
        }

        return new Estatisticas(
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                estatisticas.getMin(),
                estatisticas.getMax()
        );
    }
}
