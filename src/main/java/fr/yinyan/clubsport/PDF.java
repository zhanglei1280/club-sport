package fr.yinyan.clubsport;

import org.springframework.stereotype.Service;

@Service
public class PDF
{
    public String nom;
    public String age;
    public String adresse;
    public String telephone;
    public String email;

    public PDF withInfo(String nom, String age, String adresse, String telephone, String email)
    {
        this.nom = nom;
        this.age = age;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
