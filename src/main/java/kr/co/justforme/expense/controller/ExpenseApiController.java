package kr.co.justforme.expense.controller;

import kr.co.justforme.expense.dto.ExpenseReqDto;
import kr.co.justforme.expense.service.ExpenseService;
import kr.co.justforme.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseDto<?> createExpense(@RequestBody ExpenseReqDto.Create dto) {

        log.debug("ExpenseApiController.createExpense");

        service.createExpense(dto);

        return ResponseDto.ofSuccessMessage("지출 등록에 성공했습니다.");
    }

    @GetMapping("/expense/api/v1")
    public ResponseDto<?> readExpense() {

        log.debug("ExpenseApiController.readExpense");

        return ResponseDto.ofSuccessData("지출 조회에 성공했습니다.", service.readExpense());
    }

    /**
     * 지출 수정
     */
    @PutMapping("/expense/api/v1/{expense_id}")
    public ResponseDto<?> updateExpense(@PathVariable(name = "expense_id") Long id, @RequestBody ExpenseReqDto.Update dto) {

        log.debug("ExpenseApiController.updateExpense");

        service.updateExpense(id, dto);

        return ResponseDto.ofSuccessMessage("지출 수정에 성공했습니다.");
    }

    /**
     * 지출 삭제
     */
    @DeleteMapping("/expense/api/v1/{expense_id}")
    public ResponseDto<?> deleteExpense(@PathVariable(name = "expense_id") Long id) {

        log.debug("ExpenseApiController.deleteExpense");

        service.deleteExpense(id);

        return ResponseDto.ofSuccessMessage("지출 삭제에 성공했습니다.");
    }
}
