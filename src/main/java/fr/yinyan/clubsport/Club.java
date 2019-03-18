//package fr.yinyan.clubsport;
//
//import java.util.List;
//
//public class Club
//{
//    private String name;
//    private  List<Member> members;
//    private Integer nbMemberRest;
//
//    public Club(String name, Integer nbMemberRest, Member administrator)
//    {
//        this.name = name;
//        this.nbMemberRest = nbMemberRest;
//        this.administrator = administrator;
//    }
//
//    private Member administrator;
//
//
//    public Integer getNbMemberRest()
//    {
//        return nbMemberRest;
//    }
//
//    public void setNbMemberRest(Integer nbMemberRest)
//    {
//        this.nbMemberRest = nbMemberRest;
//    }
//
//
//
//    public List<Member> getMembers() {
//        return members;
//    }
//
//    public void addMember(Member m)
//    {
//        members.add(m);
//        nbMemberRest -= 1;
//    }
//
//
//}
