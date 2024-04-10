package kr.co.justforme.expense.service;

import kr.co.justforme.expense.Expense;
import kr.co.justforme.expense.dto.ExpenseReqDto;
import kr.co.justforme.expense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseService {

    private final ExpenseRepository repository;

    /**
     * 지출 등록
     */
    public void createExpense(ExpenseReqDto.Create dto) {

        log.debug("ExpenseService.createExpense");

        log.debug("지출구분 : " + dto.getExpenseDiv());
        log.debug("지출비용 : " + dto.getCharge());
        log.debug("지출명세 : " + dto.getExpenseDesc());

        Expense expense = Expense.builder()
                .expenseDiv(dto.getExpenseDiv())
                .charge(dto.getCharge())
                .expensedAt(dto.getExpensedAt())
                .createdAt(LocalDateTime.now())
                .lastModifiedAt(LocalDateTime.now())
                .expenseDesc(dto.getExpenseDesc())
                .build();

        repository.save(expense);
    }

    /**
     * 지출 수정
     */
    @Transactional
    public void updateExpense(Long id, ExpenseReqDto.Update dto) {

        log.debug("ExpenseService.updateExpense");

        log.debug("지출구분 : " + dto.getExpenseDiv());
        log.debug("지출비용 : " + dto.getCharge());
        log.debug("지출명세 : " + dto.getExpenseDesc());

        Expense expense = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 지출 정보가 존재하지 않습니다."));

        if (expense != null) {
            expense.updateExpense(
                    dto.getExpenseDiv(),
                    dto.getCharge(),
                    dto.getExpensedAt(),
                    LocalDateTime.now(),    // 수정일시
                    dto.getExpenseDesc());
        }
    }

    /**
     * 지출 삭제
     */
    public void deleteExpense(Long id) {

        log.debug("ExpenseService.deleteExpense");

        Expense expense = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 지출 정보가 존재하지 않습니다."));

        log.debug("지출아이디 : " + expense.getExpenseId());
        log.debug("지출구분 : " + expense.getExpenseDiv());
        log.debug("지출명세 : " + expense.getExpenseDesc());
        log.debug("지출일시 : " + expense.getExpensedAt());
        // log.debug("지출작성자 : " + expense.getMemberId());

        repository.delete(expense);
    }
}
