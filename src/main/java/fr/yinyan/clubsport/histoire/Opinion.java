package fr.yinyan.clubsport.histoire;

public class Opinion
{

    private String title;
    private String description;

    public String getDescription()
    {
        return description;
    }

    public Opinion withDescription(String description)
    {
        this.description = description;
        return this;
    }

    public String getTitle()
    {
        return title;
    }

    public Opinion withTitle(String title)
    {
        this.title = title;
        return this;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
