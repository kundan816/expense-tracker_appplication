package com.expensetracker.Expensetracker.dao;

import com.expensetracker.Expensetracker.model.Finance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.expensetracker.Expensetracker.repository.FinanceRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class FinanceDAO {

    @Autowired
    private FinanceRepository financeRepository;

    public Finance save(Finance finance) {
        return financeRepository.save(finance);
    }

    public List<Finance> findAll() {
        return financeRepository.findAll();
    }

    public Optional<Finance> findById(Long id) {
        return financeRepository.findById(id);
    }

    public void delete(Finance finance) {
        financeRepository.delete(finance);
    }
}
