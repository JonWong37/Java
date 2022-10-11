package com.orca.bookclub.controllers;


import com.orca.bookclub.models.Book;
import com.orca.bookclub.models.User;
import com.orca.bookclub.services.BookService;
import com.orca.bookclub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @GetMapping("/newbook")
    public String newbook(HttpSession session, Model model, @ModelAttribute("book") Book book) {
        User user = userService.findById((Long) session.getAttribute("userId"));
        model.addAttribute("user", user);
        return "newbook.jsp";

    }

    @PostMapping("/addbook")
    public String createbook(Model model, @Valid @ModelAttribute("book") Book book, BindingResult result){
        if (result.hasErrors()){
            return "newbook.jsp";
        }
        else{

            bookService.save(book);
            return "redirect:/dashboard";
        }
    }

    @GetMapping("/users/{id}")
    public String showuser(Model model, @PathVariable("id")Long id){
        return "user.jsp";
    }
}
