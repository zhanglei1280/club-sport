//package fr.yinyan.clubsport;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class MemberController
//{
//
//    private Member member;
//
//    public MemberController(Member member)
//    {
//        this.member = member;
//    }
//
//    @GetMapping("/inscrire")
//    public String inscrire(Model model)
//    {
////        model.addAttribute("pdf", pdf);
//        return "/inscrire";
//    }
//
//    @PostMapping("/member")
//    public void member(@ModelAttribute Member member, Model model)
//    {
//        this.member = member;
//        member.toString();
//
//    }
//}
//
