package com.orca.savetravels.controllers;

import com.orca.savetravels.models.Expense;
import com.orca.savetravels.services.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @GetMapping("/")
    public String index(@ModelAttribute("expense") Expense expense, Model model){
        List<Expense> expenses = expenseService.allExpense();
        model.addAttribute("expenses", expenses);
        return "index.jsp";
    }

    @PostMapping("/expenses")
    public String create(Model model,@Valid @ModelAttribute("expense") Expense expense, BindingResult result){

        if (result.hasErrors()) {
            List<Expense> expenses = expenseService.allExpense();
            model.addAttribute("expenses", expenses);
            return "index.jsp";
        } else {
            expenseService.save(expense);
            return "redirect:/expenses";
        }
    }


    @GetMapping("/expenses")
    public String display(Model model){
        List<Expense> expenses = expenseService.allExpense();
        model.addAttribute("expenses", expenses);
        return "redirect:/";
    }

    @GetMapping("/expenses/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }

    @PutMapping ("/update/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result){
        if (result.hasErrors()){
            return "edit.jsp";
        }
        expenseService.save(expense);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        Expense expense = expenseService.findExpense(id);
        expenseService.delete(expense);
        return "redirect:/";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id")Long id, Model model){
        Expense expenses = expenseService.findExpense(id);
        model.addAttribute(expenses);
        return "show.jsp";

    }

}
