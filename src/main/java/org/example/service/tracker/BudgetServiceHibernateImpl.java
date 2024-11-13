package org.example.service.tracker;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.models.tracker.Budget;
import org.example.models.tracker.BudgetAccess;
import org.example.models.tracker.BudgetAccessLevel;
import org.example.repository.BudgetAccessRepository;
import org.example.repository.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BudgetServiceHibernateImpl implements BudgetService {

    private final BudgetRepository budgetRepository;
    private final BudgetAccessRepository budgetAccessRepository;

    @Override
    @Transactional
    public Budget create(Budget budget) {
        budget = budgetRepository.save(budget);

        BudgetAccess budgetAccess = BudgetAccess.builder()
                .budget(budget)
                .user(budget.getCreatedBy())
                .accessLevel(BudgetAccessLevel.OWNER)
                .build();
        budgetAccessRepository.save(budgetAccess);

        return budget;
    }

    @Override
    public Optional<Budget> getById(Long id) {
        return budgetRepository.findById(id);
    }

    @Override
    public List<Budget> getAllByUserId(Long userId) {
        return budgetAccessRepository.findAllByUserId(userId).stream()
                .map(BudgetAccess::getBudget)
                .collect(Collectors.toList());
    }

    @Override
    public List<Budget> getAll() {
        return budgetRepository.findAll();
    }

    @Override
    @Transactional
    public Budget update(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        if (budgetRepository.existsById(id)) {
            budgetRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
