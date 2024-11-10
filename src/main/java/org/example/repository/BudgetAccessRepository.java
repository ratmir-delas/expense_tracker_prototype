package org.example.repository;

import org.example.models.tracker.BudgetAccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetAccessRepository extends JpaRepository<BudgetAccess, Long> {
    
}
