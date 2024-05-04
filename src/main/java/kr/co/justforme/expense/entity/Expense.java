package kr.co.justforme.expense.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "expense_id")
    private Long expenseId;                 // ID
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExpenseDiv expenseDiv;          // 구분 - 01: 식비, 02: 교통비, 03: 공과금, 04: 기타
    @Column(nullable = false)
    private Long charge;                    // 비용
    @Column(nullable = false)
    private LocalDate expensedAt;       // 지출일자
    @Column(nullable = false)
    private LocalDateTime createdAt;        // 생성일시
    @Column(nullable = false)
    private LocalDateTime lastModifiedAt;   // 수정일시
    private String expenseDesc;             // 설명

    @Builder
    public Expense(ExpenseDiv expenseDiv, Long charge, LocalDate expensedAt, LocalDateTime createdAt, LocalDateTime lastModifiedAt, String expenseDesc) {

        this.expenseDiv = expenseDiv;
        this.charge = charge;
        this.expensedAt = expensedAt;
        this.createdAt = createdAt;
        this.lastModifiedAt = lastModifiedAt;
        this.expenseDesc = expenseDesc;
    }

    public void updateExpense(ExpenseDiv expenseDiv, Long charge, LocalDate expensedAt, LocalDateTime lastModifiedAt, String expenseDesc) {

        this.expenseDiv = expenseDiv;
        this.charge = charge;
        this.expensedAt = expensedAt;
        this.lastModifiedAt = lastModifiedAt;
        this.expenseDesc = expenseDesc;
    }
}
