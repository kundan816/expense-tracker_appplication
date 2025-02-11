package com.expensetracker.Expensetracker.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinanceDTO {
    private BigDecimal amount;
    private String category;
    private LocalDate date;
    private String description;
    private String type;
}
