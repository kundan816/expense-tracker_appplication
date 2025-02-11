package com.expensetracker.Expensetracker.service;

import com.expensetracker.Expensetracker.dao.FinanceDAO;
import com.expensetracker.Expensetracker.DTO.FinanceDTO;
import com.expensetracker.Expensetracker.exception.ResourceNotFoundException;
import com.expensetracker.Expensetracker.model.Finance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private FinanceDAO financeDAO;

    @Override
    public Finance createEntry(FinanceDTO financeDTO) {
        Finance finance = new Finance();
        finance.setAmount(financeDTO.getAmount());
        finance.setCategory(financeDTO.getCategory());
        finance.setDate(financeDTO.getDate());
        finance.setDescription(financeDTO.getDescription());
        finance.setType(financeDTO.getType());
        return financeDAO.save(finance);
    }

    @Override
    public List<Finance> getAllEntries() {
        return financeDAO.findAll();
    }

    @Override
    public Finance getEntryById(Long id) {
        return financeDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Finance entry not found with ID: " + id));
    }

    @Override
    public Finance updateEntry(Long id, FinanceDTO financeDTO) {
        Finance finance = getEntryById(id);
        finance.setAmount(financeDTO.getAmount());
        finance.setCategory(financeDTO.getCategory());
        finance.setDate(financeDTO.getDate());
        finance.setDescription(financeDTO.getDescription());
        finance.setType(financeDTO.getType());
        return financeDAO.save(finance);
    }

    @Override
    public void deleteEntry(Long id) {
        Finance finance = getEntryById(id);
        financeDAO.delete(finance);
    }

    @Override
    public String getSummary() {
        List<Finance> entries = financeDAO.findAll();
        BigDecimal totalIncome = entries.stream()
                .filter(entry -> "income".equalsIgnoreCase(entry.getType()))
                .map(Finance::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpenses = entries.stream()
                .filter(entry -> "expense".equalsIgnoreCase(entry.getType()))
                .map(Finance::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return "Total Income: " + totalIncome + ", Total Expenses: " + totalExpenses;
    }
}
