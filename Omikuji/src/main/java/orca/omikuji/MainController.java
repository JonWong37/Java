package orca.omikuji;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class MainController {

    @GetMapping ("/")
    public String index(){
        return "index.jsp";
    }

    @PostMapping ("/login")
    public String login(HttpSession session,
            @RequestParam("years") String years,
            @RequestParam("city") String city,
            @RequestParam("person") String person,
            @RequestParam("hobby") String hobby,
            @RequestParam("thing") String thing,
            @RequestParam("comment") String comment

    ){
        session.setAttribute("years", years);
        session.setAttribute("city",city);
        session.setAttribute("person",person);
        session.setAttribute("hobby",hobby);
        session.setAttribute("thing",thing);
        session.setAttribute("comment",comment);

        return "redirect:/display";
    }

    @GetMapping("/display")
    public String display(){
        return "demo.jsp";
    }
}
