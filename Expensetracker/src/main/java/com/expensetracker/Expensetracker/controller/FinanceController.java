package com.expensetracker.Expensetracker.controller;

import com.expensetracker.Expensetracker.DTO.FinanceDTO;
import com.expensetracker.Expensetracker.model.Finance;
import com.expensetracker.Expensetracker.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entries")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @PostMapping
    public Finance createEntry(@RequestBody FinanceDTO financeDTO) {
        return financeService.createEntry(financeDTO);
    }

    @GetMapping
    public List<Finance> getAllEntries() {
        return financeService.getAllEntries();
    }

    @GetMapping("/{id}")
    public Finance getEntryById(@PathVariable Long id) {
        return financeService.getEntryById(id);
    }

    @PutMapping("/{id}")
    public Finance updateEntry(@PathVariable Long id, @RequestBody FinanceDTO financeDTO) {
        return financeService.updateEntry(id, financeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        financeService.deleteEntry(id);
    }

    @GetMapping("/summary")
    public String getSummary() {
        return financeService.getSummary();
    }
}
