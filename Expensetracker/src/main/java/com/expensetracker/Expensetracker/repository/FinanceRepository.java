package com.expensetracker.Expensetracker.repository;

import com.expensetracker.Expensetracker.model.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, Long> {
}
