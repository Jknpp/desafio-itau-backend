package com.Jknpp.DesafioItau.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estatisticas {
    private Long count;
    private double sum;
    private double avg;
    private double min;
    private double max;
}