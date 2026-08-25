package com.Jknpp.DesafioItau.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoRequest(
        @Schema(
                description = "Valor da transação",
                example = "150.75"
        )
        @NotNull(message = "O valor é obrigatório")
        BigDecimal valor,

        @Schema(
                description = "Data e hora da transação",
                example = "2026-08-25T14:30:00-03:00"
        )
        @NotNull(message = "A data e hora são obrigatórias")
        OffsetDateTime dataHora) {
}
