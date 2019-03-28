package fr.yinyan.clubsport;

import org.springframework.stereotype.Service;

@Service
public class PDF
{
    public String name;
    public String age;
    public String adress;
    public String telephone;
    public String email;
    public String sport;
    public String level;
    public String other;


    public PDF withInfo(String name, String age, String adress, String telephone, String email, String sport, String level, String other)
    {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.telephone = telephone;
        this.email = email;
        this.sport = sport;
        this.level = level;
        this.other = other;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getadress() {
        return adress;
    }

    public void setadress(String adress) {
        this.adress = adress;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
