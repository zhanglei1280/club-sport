package fr.yinyan.clubsport.histoire;

import fr.yinyan.clubsport.histoire.Opinion;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpinionsService
{

    private final List<Opinion> opinions;

    public OpinionsService()
    {
        this.opinions = new ArrayList<>();
    }

    @PostConstruct
    private void postConstruct()
    {
        opinions.add(new Opinion().withTitle("UX is terrible").withDescription("you should really add a minor CSS"));
        opinions.add(new Opinion().withTitle("Updates are slow to come").withDescription("may be you should invest in a continous deployement chain"));

    }

    public List<Opinion> findAll()
    {
        return opinions;
    }

    public void add(Opinion opinion)
    {
        opinions.add(opinion);
    }
}
