package org.example.repositories;

import org.example.models.tracker.BudgetAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetAccessRepository extends JpaRepository<BudgetAccess, Long> {

    List<BudgetAccess> findAllByUserId(Long userId);

    List<BudgetAccess> findAllByBudgetId(Long budgetId);

}
