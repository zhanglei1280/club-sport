package fr.yinyan.clubsport;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController
{
    Member member;

    public MemberController(){}

    public MemberController(Member member)
    {
        this.member = member;
    }

    @GetMapping("/sgin_up")
    public String sgin_up(Model model)
    {
        model.addAttribute("member", member);
        model.addAttribute("info", "enter the data to sgin up");
        return "sgin_up";
    }

//    @PostMapping("/member")
//    public void member(@ModelAttribute Member m, Model model)
//    {
//        this.member = m;
//        System.out.println(member.getCompte());
//        model.addAttribute("member", member);
//
//    }

    @GetMapping("/sgin_in")
    public String sgin_in(Model model)
    {
//        model.addAttribute("pdf", pdf);
        return "/sgin_in";
    }
}
