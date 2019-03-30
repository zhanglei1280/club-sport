package fr.yinyan.clubsport;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

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

    private ArrayList<String> tokens = new ArrayList<String>();

    private Key key;


    public Member(){}

    public Member(String username, String compte, String password)
    {
        this.username = username;
        this.compte = compte;
        this.password = password;
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        this.generateToken();
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

    public String generateToken(){
        String jws = Jwts.builder().setSubject(username).signWith(key).compact();
        this.tokens.add(jws);
        return jws;
    }

    public boolean verifyToken(String token){
        return this.tokens.contains(token);
    }


}
