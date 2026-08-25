package com.Jknpp.DesafioItau.service;

import com.Jknpp.DesafioItau.dto.EstatisticasResponse;
import com.Jknpp.DesafioItau.dto.TransacaoRequest;
import com.Jknpp.DesafioItau.exception.TransacaoInvalidaException;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service

public class TransacaoService {
    private final List<TransacaoRequest> transacoes = new ArrayList<>();

    public void fazerTransacao(TransacaoRequest transacao){
        if(transacao.valor().compareTo(BigDecimal.ZERO) < 0){
            throw new TransacaoInvalidaException("O valor da trasação não pode ser negativo");
        }
        if(transacao.dataHora().isAfter(OffsetDateTime.now())){
            throw new TransacaoInvalidaException("A data da transação não pode ser no futuro");
            }
        transacoes.add(transacao);
    }

    public void limparTransacoes(){
        transacoes.clear();
    }

    public EstatisticasResponse mostrarEstatisticas(){
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);
        DoubleSummaryStatistics estatisticas = transacoes.stream()
                        .filter(tempo -> tempo.dataHora().isAfter(limite))
                        .mapToDouble(transacao -> transacao.valor().doubleValue())
                        .summaryStatistics();

        if (estatisticas.getCount() == 0) {
            return new EstatisticasResponse(0L, 0, 0, 0, 0);
        }

        return new EstatisticasResponse(
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                estatisticas.getMin(),
                estatisticas.getMax()
        );
    }
}
