package org.example.repositories;

import org.example.models.tracker.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByCreatedByIdAndBudgetNull(Long userId);

    List<Expense> findAllByBudgetId(Long budgetId);

}
