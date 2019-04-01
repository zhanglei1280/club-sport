package fr.yinyan.clubsport;

import com.mongodb.Block;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;


@Controller
public class ClubController
{
    Member manager;// chef final
    Club newClub;

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase database = mongoClient.getDatabase("club_sport");
    FindIterable<Document> iterable = database.getCollection("Club").find();



    @GetMapping("/sign_in_manager")
    public String sign_in_manager(Model model, Member manager)
    {
        this.manager = manager;
        model.addAttribute(manager);
        return "sign_in_manager";
    }

    @PostMapping("/sign_in_manager_post")
    public String sign_in_manager_post(@ModelAttribute Member manager, Model model)
    {
        if(manager.getCompte().equals("manager@foxmail.com") && (manager.getPassword().equals("123456")))
        {
            this.manager.setCompte(manager.getCompte());
            this.manager.setPassword(manager.getPassword());
            ArrayList<Document> documents = new ArrayList<>();
            iterable.forEach((Block<Document>) document -> documents.add(document));
            model.addAttribute(documents);
            return "manage_clubs";
        }
        else
        {
            return "sign_in_manager";
        }
    }

    @GetMapping("/create_club")
    public String create_club(Model model, Club club)
    {
        this.newClub = club;
        model.addAttribute(club);
        return "create_club";
    }

    @PostMapping("/create_club_post")
    public String create_club_post(@ModelAttribute Club club)
    {
        MongoCollection<Document> collectionClub = database.getCollection("Club");
        Document document = new Document();
        document.put("nameClub",club.getClubName());
        document.put("AdministratorCompte",club.getAdministrator().getCompte());
        document.put("AdministratorPassword",club.getAdministrator().getPassword());
        document.put("nbMemberRest",club.getNbMemberRest());
        document.put("description",club.getDescription());
        collectionClub.insertOne(document);
        return "redirect:/manage_clubs";
    }

    @GetMapping("/sign_in_club")
    public String sign_in_club(Model model, Club club)
    {
        this.newClub = club;
        model.addAttribute(club);
        return "sign_in_club";
    }

    @PostMapping("/sign_in_club_post")
    public String sign_in_club_post(@ModelAttribute Club club, Model model)
    {
        MongoCollection<Document> collectionClub = database.getCollection("Club");
//        System.out.println(club.getAdministrator().getCompte());
//        System.out.println(club.getAdministrator().getPassword());
        try
        {
            Document doc = collectionClub.find(eq("AdministratorCompte", club.getAdministrator().getCompte())).first();
            if(club.getAdministrator().getPassword().equals(doc.get("AdministratorPassword")))
            {
                club.setClubName(doc.get("nameClub").toString());
                club.setDescription(doc.get("description").toString());
                club.setNbMemberRest(Integer.parseInt(doc.get("nbMemberRest").toString()));
                return "club";
            }
            else
            {
                System.out.println("erreur of password");
                return "sign_in_club";
            }
        }
        catch (Exception e)
        {
            System.out.println("eurrer");
            return "sign_in_club";
        }

    }

    @GetMapping("/manage_clubs")
    public String manage_clubs(Model model)
    {
        if(manager.getCompte().equals("manager@foxmail.com") &&  manager.getPassword().equals("123456"))
        {
            ArrayList<Document> documents = new ArrayList<>();
            iterable.forEach((Block<Document>) (Document document) -> documents.add(document));
            model.addAttribute(documents);
        }
        return "manage_clubs";
    }


    @GetMapping("/")
    public String index(Model model)
    {
        ArrayList<Document> documents = new ArrayList<>();
        iterable.forEach((Block<Document>) (Document document) -> documents.add(document));
        model.addAttribute(documents);
        return "first";
    }
}

