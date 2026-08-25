package com.Jknpp.DesafioItau.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record EstatisticasResponse(
        @Schema(description = "Quantidade de transações")
        long count,

        @Schema(description = "Soma dos valores")
        double sum,

        @Schema(description = "Média dos valores")
        double avg,

        @Schema(description = "Menor valor")
        double min,

        @Schema(description = "Maior valor")
        double max) {
}
