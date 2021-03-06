package fr.yinyan.clubsport;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class Club
{
    private String clubName;
    private  List<Member> members;
    private Integer nbMemberRest;
    private Member administrator;
    private String description;
    private Image logo;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getLogo()
    {
        System.out.println(logo.toString());
        return logo;
    }

    public void setLogo(Image logo)
    {
        this.logo = logo;
    }
//    public Club() {
//        this(, , );
//    }
//
//    public Club(String clubName, Integer nbMemberRest, Member administrator)
//    {
//        this.clubName = clubName;
//        this.nbMemberRest = nbMemberRest;
//        this.administrator = administrator;
//    }

    public String getClubName()
    {
        return clubName;
    }

    public void setClubName(String clubName)
    {
        this.clubName = clubName;
    }

    public void setMembers(List<Member> members)
    {
        this.members = members;
    }

    public Member getAdministrator()
    {
        return administrator;
    }

    public void setAdministrator(Member administrator)
    {
        this.administrator = administrator;
    }

    public Integer getNbMemberRest()
    {
        return nbMemberRest;
    }

    public void setNbMemberRest(Integer nbMemberRest)
    {
        this.nbMemberRest = nbMemberRest;
    }

    public List<Member> getMembers()
    {
        return members;
    }

    public void addMember(Member m)
    {
        members.add(m);
        nbMemberRest -= 1;
    }


}
