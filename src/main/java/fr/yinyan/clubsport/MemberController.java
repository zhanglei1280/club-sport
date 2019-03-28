package fr.yinyan.clubsport;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;


import javax.validation.Valid;
import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;

@Controller
public class MemberController
{
    private Member member;
    MongoClient mongoClient = MongoClients.create();
    MongoDatabase database = mongoClient.getDatabase("club_sport");

//    public MemberController(){}

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

    @PostMapping("/sgin_up")
    public String sgin_up_post(@Valid Member m, Model model, BindingResult bindingResult)
    {
        this.member = m;
        System.out.println(member.getCompte());
        System.out.println(member.getVerifiePassword());

        if (bindingResult.hasErrors())
        {
            return "redirect:/sgin_up";
        }
        if(member.getPassword().equals(member.getVerifiePassword()))
        {
            model.addAttribute("member", member);
            MongoCollection<Document> collection = database.getCollection("Member");
            Document doc = new Document("username", member.getUsername())
                    .append("compte", member.getCompte())
                    .append("password", member.getPassword());
            collection.insertOne(doc);
            return "member";
        }
        return "sgin_up";
    }

//    @PostMapping("/member")
//    public void member(@ModelAttribute Member m, Model model, String message)
//    {
//        this.member = m;
//        System.out.println(member.getUsername());
//        System.out.println(member.getCompte());
//        System.out.println(member.getVerifiePassword());
//        if(member.getPassword().equals(member.getVerifiePassword()))
//        {
//            System.out.println("sgin up Ok");
//            // inserer dans la base de donnees
//            model.addAttribute("member", member);
//            message = "sgin up Ok";
//        }
//        else
//        {
//            System.out.println("eurrer of password");
//            message = "eurrer of password";
//
//        }
//        model.addAttribute("message", message);
//
//    }





    @GetMapping("/sgin_in")
    public String sgin_in(Model model, Member m)
    {
        this.member = m;
        model.addAttribute("member", member);
        model.addAttribute("info", "enter the data to sgin in");
        return "sgin_in";
    }

    @PostMapping("/sgin_in")
    public String sgin_in_post(@ModelAttribute Member m)
    {
        MongoCollection<Document> collection = database.getCollection("Member");
        try
        {
            Document doc = collection.find(eq("compte", m.getCompte())).first();

            if(m.getPassword().equals(doc.get("password")))
            {
                System.out.println(doc.toJson());
                return "member";
            }
            else
            {
                System.out.println("erreur of password");
                return "sgin_in";
            }
        }

        catch (Exception e)
        {
            System.out.println("eurrer");
            return "sgin_in";
        }
    }

//    @PostMapping("/sgin_in_post")
//    public String sgin_in_post(@ModelAttribute String compte, String password)
//    {
//        MongoCollection<Document> collection = database.getCollection("Member");
//        try
//        {
//            Document doc = collection.find(eq("compte", compte)).first();
//            System.out.println(doc.toJson());
//            return "member";
//        }
//        catch (Exception e)
//        {
//            System.out.println("eurrer");
//            Document doc = null;
//            return "member";
//        }
//
//    }
//    @GetMapping("/sgin_in_manager")
//    public String sgin_up_manager(Model model)
//    {
//        model.addAttribute("var", "var test");
//        return "sgin_in_manager";
//    }


}
