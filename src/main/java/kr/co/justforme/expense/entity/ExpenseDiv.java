package kr.co.justforme.expense.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExpenseDiv {
    FOOD("식비"),
    TRANSPORTATION("교통비"),
    EDUCATION("교육비"),
    DUES("공과금"),
    OTHERS("기타비용");

    final private String name;

    private ExpenseDiv(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ExpenseDiv toEnum(String str) {
        for (ExpenseDiv div : ExpenseDiv.values()) {
            if (div.toString().equals(str)) {
                return div;
            }
        }
        return null;
    }
}
