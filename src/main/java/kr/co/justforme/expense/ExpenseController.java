package kr.co.justforme.expense;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpenseController {

    @GetMapping("/expense")
    public String returnExpenseIndexPage() {

        return "expense/index_expense";
    }

    @GetMapping("/expense/crud")
    public String returnExpenseCreatePage() {

        return "expense/crud_expense";
    }
}
