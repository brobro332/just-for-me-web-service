package kr.co.justforme.expense.controller;

import kr.co.justforme.expense.dto.ExpenseReqDto;
import kr.co.justforme.expense.service.ExpenseService;
import kr.co.justforme.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseApiController {

    private final ExpenseService service;

    /**
     * 지출 등록
     */
    @PostMapping("/expense/api/v1")
    public ResponseDto<?> createExpense(@RequestBody ExpenseReqDto dto) {

        log.debug("ExpenseApiController.createExpense");

        service.createExpense(dto);

        return ResponseDto.ofSuccessMessage("지출 등록에 성공했습니다.");
    }
}
