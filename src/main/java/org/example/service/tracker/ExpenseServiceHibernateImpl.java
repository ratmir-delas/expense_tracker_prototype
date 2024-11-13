package org.example.service.tracker;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.models.tracker.Budget;
import org.example.models.tracker.Expense;
import org.example.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseServiceHibernateImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Override
    @Transactional
    public Expense create(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Optional<Expense> getById(Long id) {
        return expenseRepository.findById(id);
    }

    @Override
    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    @Override
    public List<Expense> getAllByBudgetId(Long budgetId) {
        return expenseRepository.findAllByBudgetId(budgetId);
    }

    @Override
    public List<Expense> getPersonalExpensesByUserId(Long userId) {
        return expenseRepository.findAllByCreatedByIdAndBudgetNull(userId);
    }

    @Override
    @Transactional
    public Expense update(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense assignBudget(Long expenseId, Long budgetId) {
        Optional<Expense> optionalExpense = expenseRepository.findById(expenseId);
        if (optionalExpense.isPresent()) {
            Expense expense = optionalExpense.get();
            expense.setBudget(
                    Budget.builder()
                            .id(budgetId)
                            .build()
            );
            return expenseRepository.save(expense);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
