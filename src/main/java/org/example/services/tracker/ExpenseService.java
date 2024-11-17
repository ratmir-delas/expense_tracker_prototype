package org.example.services.tracker;

import org.example.models.tracker.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    Optional<Expense> getById(Long id);

    List<Expense> getAll();

    List<Expense> getAllByBudgetId(Long budgetId);

    List<Expense> getPersonalExpensesByUserId(Long userId);

    Expense create(Expense expense);

    Expense update(Expense expense);

    Expense assignBudget(Long expenseId, Long budgetId);

    boolean delete(Long id);

}
