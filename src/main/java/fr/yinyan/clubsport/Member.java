package fr.yinyan.clubsport;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Service
public class Member
{
    @NotNull
    @Size(min=4, max=30)
    private String username;

    @NotNull
    @Size(min=4, max=30)
    private String compte;

    @NotNull
    @Size(min=6, max=30)
    private String password;

    @NotNull
    @Size(min=6, max=30)
    private String verifiePassword;


    public Member(){}

    public Member(String username, String compte, String password)
    {
        this.username = username;
        this.compte = compte;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getCompte()
    {
        return compte;
    }

    public void setCompte(String compte)
    {
        this.compte = compte;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getVerifiePassword() {
        return verifiePassword;
    }

    public void setVerifiePassword(String verifiePassword) {
        this.verifiePassword = verifiePassword;
    }
}
