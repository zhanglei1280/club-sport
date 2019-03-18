package fr.yinyan.clubsport;

import org.springframework.stereotype.Service;

@Service
public class PDF
{
    public String name;
    public String age;
    public String adress;
    public String telephone;
    public String email = "11111";

    public PDF withInfo(String name, String age, String adress, String telephone, String email)
    {
        this.name = name;
        this.age = age;
        this.adress = adress;
        this.telephone = telephone;
        this.email = email;
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

}
