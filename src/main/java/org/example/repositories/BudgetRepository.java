package org.example.repositories;

import org.example.models.tracker.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    List<Budget> findAllByCreatedById(Long userId);

}
