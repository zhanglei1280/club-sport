package fr.yinyan.clubsport.histoire;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("SpellCheckingInspection")
@Controller
public class HelloController
{
    @GetMapping("/hello")
    public ModelAndView hello()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("HelloTemplate");
        mv.addObject("name", "Guillaume");
        mv.addObject("testjson", "Guillaume");
        return mv;
    }

    @GetMapping("/sport_t") // nom du lien url
    public ModelAndView sport()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sport"); // nom du fichier html associer
        mv.addObject("sport1", "basket");
        return mv;
    }





//    @GetMapping("/opinion")
//    public ModelAndView opinion()
//    {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("new-opinion");
//        return mv;
//    }

//    @PostMapping(path = "/member")
//    public void addMemberV1(@RequestBody Member member)
//    {
//        //code
//    }

}
