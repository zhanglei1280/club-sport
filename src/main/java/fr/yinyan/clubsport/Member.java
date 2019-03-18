package fr.yinyan.clubsport;

import org.springframework.stereotype.Service;

@Service
public class Member
{
    private String compte = "123456";
    private String password;

    public Member(){}

    public Member(String compte, String password)
    {
        this.compte = compte;
        this.password = password;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
