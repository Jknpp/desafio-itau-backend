package com.Jknpp.DesafioItau.dto;

public record EstatisticasResponse(long count,
                                   double sum,
                                   double avg,
                                   double min,
                                   double max) {
}
