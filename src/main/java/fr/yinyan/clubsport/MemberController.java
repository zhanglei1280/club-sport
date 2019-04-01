package fr.yinyan.clubsport;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import javax.validation.Valid;
import java.util.ArrayList;
import static com.mongodb.client.model.Filters.eq;

@Controller
public class MemberController
{
    private Member member;
    MongoClient mongoClient = MongoClients.create();
    MongoDatabase database = mongoClient.getDatabase("club_sport");



    public MemberController(Member member)
    {
        this.member = member;
    }

    @GetMapping("/sign_up")
    public String sign_up(Model model)
    {
        model.addAttribute("member", member);
        return "sign_up";
    }

    @PostMapping("/sign_up_post")
    public String sign_up_post(@Valid Member m, Model model, BindingResult bindingResult)
    {
        this.member = m;
        System.out.println(m.getCompte());
        System.out.println(m.getVerifiePassword());

        if (bindingResult.hasErrors())
        {
            return "redirect:/sign_up";
        }

        if(m.getPassword().equals(m.getVerifiePassword()))
        {
            model.addAttribute("member", m);
            MongoCollection<Document> collection = database.getCollection("Member");
            ArrayList<String> tokens = new ArrayList<>();
            tokens.add(m.generateToken());
            Document doc = new Document("username", m.getUsername())
                    .append("compte", m.getCompte())
                    .append("password", m.getPassword())
                    .append("tokens", tokens);
            collection.insertOne(doc);
            return "member";
        }
        return "sign_up";
    }


    @GetMapping("/sign_in")
    public String sign_in(Model model, Member m)
    {
        this.member = m;
        model.addAttribute("member", member);
        model.addAttribute("info", "enter the data to sign in");
        return "sign_in";
    }

    @PostMapping("/sign_in_post")
    public String sign_in_post(@ModelAttribute Member m, Model model)
    {
        MongoCollection<Document> collection = database.getCollection("Member");
        try
        {
            Document doc = collection.find(eq("compte", m.getCompte())).first();

            if(m.getPassword().equals(doc.get("password")))
            {
                System.out.println(doc.toJson());
                this.member.setUsername(doc.get("username").toString());
                this.member.setCompte(doc.get("compte").toString());
                this.member.setPassword(doc.get("password").toString()) ;
                model.addAttribute(member);
                return "member";
            }
            else
            {
                System.out.println("erreur of password");
                return "sign_in";
            }
        }
        catch (Exception e)
        {
            System.out.println("eurrer");
            return "sign_in";
        }
    }
}
