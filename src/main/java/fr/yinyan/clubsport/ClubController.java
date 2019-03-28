package fr.yinyan.clubsport;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static com.mongodb.client.model.Filters.eq;

@Controller
public class ClubController
{
//    String var;
//    public ClubController(String var)
//    {
//        this.var = var;
//    }

    @GetMapping("/sign_in_manager")
    public String sign_in_manager(Model model)
    {
        model.addAttribute("compte", "compte");
        model.addAttribute("password", "passord");
        return "sign_in_manager";
    }

    @PostMapping("/sign_in_manager")
    public String sign_in_manager_post(@ModelAttribute String compte, @ModelAttribute String password)
    {

        if(compte.equals("zhanglei1280@foxmail.com") && (password.equals("123456")))
        {
            return "manage_clubs";
        }
        else
        {
            System.out.println("erreur of password");
            return "sign_in_manager";
        }
    }
}

