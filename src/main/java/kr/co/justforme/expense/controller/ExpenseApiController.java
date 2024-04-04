package kr.co.justforme.expense.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseApiController {

    @PostMapping("/expense/api/v1")
    public ResponseEntity<String> createExpense() {
        
        // 서비스 호출

        return ResponseEntity.ok("success");
    }
}
