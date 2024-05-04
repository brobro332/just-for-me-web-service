package kr.co.justforme.expense.controller;

import kr.co.justforme.expense.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseRepository repository;

    /**
     * 지출 도메인 기본 페이지
     */
    @GetMapping("/expense")
    public String returnExpenseIndexPage() {
        return "expense/index";
    }

    /**
     * 지출도메인 지출관리 페이지
     */
    @GetMapping("/expense/crud")
    public String returnCrudPage() {
        return "expense/crud";
    }

    /**
     * 지출도메인 등록 페이지
     */
    @GetMapping("/expense/crud/create")
    public String returnCreatePage() {
        return "expense/create";
    }

    @GetMapping("/expense/crud/update/{expense_id}")
    public String returnUpdatePage(@PathVariable(name = "expense_id") Long id, Model model) {

        model.addAttribute("expense", repository.findById(id).get());

        return "expense/update";
    }
}
