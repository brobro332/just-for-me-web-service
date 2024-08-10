package kr.co.justforme.expense.controller;

import kr.co.justforme.expense.dto.ExpenseReqDto;
import kr.co.justforme.expense.entity.Expense;
import kr.co.justforme.expense.service.ExpenseService;
import kr.co.justforme.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseApiController {

    private final ExpenseService service;

    /**
     * 지출 등록
     */
    @PostMapping("/expense/api/v1")
    public ResponseDto<?> createExpense(@RequestBody ExpenseReqDto.Create dto) throws Exception {

        log.debug("ExpenseApiController.createExpense");

        service.createExpense(dto);

        return ResponseDto.ofSuccessMessage("지출 등록에 성공했습니다.");
    }

    /**
     * 지출 조회
     */
    @GetMapping("/expense/api/v1")
    public ResponseDto<?> readExpense() {

        log.debug("ExpenseApiController.readExpense");

        Pageable pageable = PageRequest.of(0, 10, Sort.by("expensedAt").descending());
        Page<Expense> page = service.readExpense(pageable);

        return ResponseDto.ofSuccessData("지출 조회에 성공했습니다.", page);
    }

    /**
     * 지출 수정
     */
    @PutMapping("/expense/api/v1/{expense_id}")
    public ResponseDto<?> updateExpense(@PathVariable(name = "expense_id") Long id, @RequestBody ExpenseReqDto.Update dto) throws Exception {

        log.debug("ExpenseApiController.updateExpense");

        service.updateExpense(id, dto);

        return ResponseDto.ofSuccessMessage("지출 수정에 성공했습니다.");
    }

    /**
     * 지출 삭제
     */
    @DeleteMapping("/expense/api/v1")
    public ResponseDto<?> deleteExpense(@RequestBody ExpenseReqDto.Delete idList) {

        log.debug("ExpenseApiController.deleteExpense");

        service.deleteExpense(idList);

        return ResponseDto.ofSuccessMessage("지출 삭제에 성공했습니다.");
    }
}
