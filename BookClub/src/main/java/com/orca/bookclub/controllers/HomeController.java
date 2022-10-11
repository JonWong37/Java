package com.orca.bookclub.controllers;

import com.orca.bookclub.models.Book;
import com.orca.bookclub.models.LoginUser;
import com.orca.bookclub.models.User;
import com.orca.bookclub.services.BookService;
import com.orca.bookclub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    // Add once service is implemented:
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;
    // private UserService userServ;

    @GetMapping("/")
    public String index(Model model, @ModelAttribute("user") User user) {

        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("user", new User());
        model.addAttribute("loginUser", new LoginUser());
        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult result, Model model, HttpSession session) {
        User newUser = userService.register(user,result);
        if(result.hasErrors()) {
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("userId", newUser.getId());
        return "dashboard.jsp";

    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser,
                        BindingResult result,
                        Model model,
                        HttpSession session) {
        User loggedInUser = userService.login(loginUser, result);
        if(result.hasErrors()|| loggedInUser==null) {
            model.addAttribute("user", new User());
            return "index.jsp";
        }
        session.setAttribute("userId", loggedInUser.getId());
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String welcome(@ModelAttribute("books") Book books, HttpSession session, Model model){
        if (session.getAttribute("userId") == null){
            return "redirect:/";
        }
        User user = userService.findById((Long) session.getAttribute("userId"));
        model.addAttribute("user", user);
        model.addAttribute("books", bookService.allBooks());
        return "dashboard.jsp";
    }
}
