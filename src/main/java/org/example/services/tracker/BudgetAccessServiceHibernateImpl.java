package org.example.services.tracker;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.models.tracker.Budget;
import org.example.models.tracker.BudgetAccess;
import org.example.models.tracker.BudgetAccessLevel;
import org.example.models.user.User;
import org.example.repositories.BudgetAccessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetAccessServiceHibernateImpl implements BudgetAccessService {

    private final BudgetAccessRepository budgetAccessRepository;

    @Override
    public List<BudgetAccess> getAllByUserId(Long userId) {
        return budgetAccessRepository.findAllByUserId(userId);
    }

    @Override
    public List<BudgetAccess> getAllByBudgetId(Long budgetId) {
        return budgetAccessRepository.findAllByBudgetId(budgetId);
    }

    @Override
    @Transactional
    public BudgetAccess create(Long budgetId, Long userId, BudgetAccessLevel accessLevel) {
        return budgetAccessRepository.save(
                BudgetAccess.builder()
                        .budget(Budget.builder().id(budgetId).build())
                        .user(User.builder().id(userId).build())
                        .accessLevel(accessLevel)
                        .build()
        );
    }

    @Override
    public BudgetAccess update(BudgetAccess access) {
        return budgetAccessRepository.save(access);
    }

    @Override
    @Transactional
    public boolean delete(Long accessId) {
        if (budgetAccessRepository.existsById(accessId)) {
            budgetAccessRepository.deleteById(accessId);
            return true;
        }
        return false;
    }
}
