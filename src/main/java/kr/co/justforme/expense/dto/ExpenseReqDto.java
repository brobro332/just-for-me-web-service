package kr.co.justforme.expense.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

public class ExpenseReqDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Create {
        private String expenseDiv;
        private Long charge;
        private LocalDate expensedAt;
        private String expenseDesc;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Update {
        private String expenseDiv;
        private Long charge;
        private LocalDate expensedAt;
        private String expenseDesc;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Delete {
        private List<Long> expenseIdList;

        public Delete() { }
    }
}
