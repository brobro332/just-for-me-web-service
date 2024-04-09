package kr.co.justforme.expense.service;

import kr.co.justforme.expense.Expense;
import kr.co.justforme.expense.dto.ExpenseReqDto;
import kr.co.justforme.expense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseService {

    private final ExpenseRepository repository;

    /**
     * 지출 등록
     */
    public void createExpense(ExpenseReqDto dto) {

        log.debug("ExpenseService.createExpense");

        log.debug("지출구분: " + dto.getExpenseDiv());
        log.debug("지출비용: " + dto.getCharge());
        log.debug("지출명세: " + dto.getExpenseDesc());

        Expense expense = Expense.builder()
                .expenseDiv(dto.getExpenseDiv())
                .charge(dto.getCharge())
                .createdAt(LocalDateTime.now())
                .lastModifiedAt(LocalDateTime.now())
                .expenseDesc(dto.getExpenseDesc())
                .build();

        repository.save(expense);
    }
}
