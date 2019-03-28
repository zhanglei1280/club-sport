package fr.yinyan.clubsport.histoire;
import fr.yinyan.clubsport.PDF;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PDFService {


    private PDF pdf;

    public PDFService(){
        pdf = new PDF();
    }

    @PostConstruct
    private void postConstruct(){
        pdf.withInfo("zhang", "24", "xxxxx", "123456", "xxxx", "sport", "A", "other");
    }

    public PDF getPdf() {
        return pdf;
    }

    public void setPdf(PDF pdf) {
        this.pdf = pdf;
    }

}
