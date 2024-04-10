package kr.co.justforme.expense.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ExpenseReqDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Create {
        private String expenseDiv;
        private Long charge;
        private LocalDateTime expensedAt;
        private String expenseDesc;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Update {
        private String expenseDiv;
        private Long charge;
        private LocalDateTime expensedAt;
        private String expenseDesc;
    }
}
