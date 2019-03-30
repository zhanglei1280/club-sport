package fr.yinyan.clubsport;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ClubController
{
    Member manager;// chef final
    Club newClub;

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase database = mongoClient.getDatabase("club_sport");

    @GetMapping("/sign_in_manager")
    public String sign_in_manager(Model model, Member manager)
    {
        this.manager = manager;
        model.addAttribute(manager);
        return "sign_in_manager";
    }

    @PostMapping("/sign_in_manager")
    public String sign_in_manager_post(@ModelAttribute Member manager)
    {
        if(manager.getCompte().equals("manager") && (manager.getPassword().equals("123456")))
        {

            return "manage_clubs";
        }
        else
        {
            System.out.println("erreur of password");
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

    @PostMapping("/create_club")
    public String sign_in_post(@ModelAttribute Club club)
    {
        System.out.println(club.getClubName());
        System.out.println(club.getAdministrator().getCompte());
        System.out.println(club.getAdministrator().getPassword());
        System.out.println(club.getNbMemberRest());

        MongoCollection<Document> collectionClub = database.getCollection("Club");
        Document document = new Document();
        document.put("nameClub",club.getClubName());
        document.put("AdministratorCompte",club.getAdministrator().getCompte());
        document.put("AdministratorPassword",club.getAdministrator().getPassword());
        document.put("nbMemberRest",club.getNbMemberRest());
        collectionClub.insertOne(document);
        return "manage_clubs";
    }


}

