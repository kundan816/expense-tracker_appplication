package com.expensetracker.Expensetracker.service;

import com.expensetracker.Expensetracker.DTO.FinanceDTO;
import com.expensetracker.Expensetracker.model.Finance;

import java.util.List;

public interface FinanceService {
    Finance createEntry(FinanceDTO financeDTO);
    List<Finance> getAllEntries();
    Finance getEntryById(Long id);
    Finance updateEntry(Long id, FinanceDTO financeDTO);
    void deleteEntry(Long id);
    String getSummary();
}
