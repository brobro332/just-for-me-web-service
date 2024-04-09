package kr.co.justforme.expense.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ExpenseReqDto {

    private String expenseDiv;
    private Long charge;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    private String expenseDesc;
}
