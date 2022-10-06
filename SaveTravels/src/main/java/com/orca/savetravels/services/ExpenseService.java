package com.orca.savetravels.services;

import com.orca.savetravels.models.Expense;
import com.orca.savetravels.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenserepository){
        this.expenseRepository = expenserepository;
    }

    public List<Expense> allExpense(){
        return expenseRepository.findAll();
    }

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    public void delete(Expense expense){
        expenseRepository.delete(expense);
    }
}
