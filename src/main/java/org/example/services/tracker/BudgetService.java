package org.example.services.tracker;

import org.example.models.tracker.Budget;

import java.util.List;
import java.util.Optional;

public interface BudgetService {

    Optional<Budget> getById(Long id);

    List<Budget> getAllByUserId(Long userId);

    List<Budget> getAll();

    Budget create(Budget budget);

    Budget update(Budget budget);

    boolean delete(Long id);

}
