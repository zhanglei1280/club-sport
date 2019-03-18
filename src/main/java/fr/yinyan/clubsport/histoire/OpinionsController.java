package fr.yinyan.clubsport.histoire;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@SuppressWarnings("SpellCheckingInspection")
@Controller
public class OpinionsController
{
    private OpinionsService opinions;

    public OpinionsController(OpinionsService opinions)
    {
        this.opinions = opinions;
    }


    @GetMapping("/new-opinion")
    public String newOpinions(Model model) // model est une variable map object pour communiquer entre le html et le controller
    {
        model.addAttribute("opinion", new Opinion());
        return "new-opinion";
    }


    @PostMapping("/new-opinion")
    public String newOpinion(@ModelAttribute Opinion opinion, Model model)
    {
        opinions.add(opinion);
        model.addAttribute("opinions", opinions.findAll());
        return "redirect:/opinions";
    }


    @GetMapping("/opinions")
    public String opinions(Model model)
    {
        model.addAttribute("opinions", opinions.findAll()); // nom de la variable dans le model
        return "opinions"; // nom de fichier html
    }
}
