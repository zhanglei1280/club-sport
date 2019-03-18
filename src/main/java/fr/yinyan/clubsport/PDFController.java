package fr.yinyan.clubsport;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;


@SuppressWarnings("SpellCheckingInspection")
@Controller
public class PDFController
{
    private PDF pdf;


    public PDFController(PDF pdf)
    {
        this.pdf = pdf;
    }



    @PostMapping("/pdf")
    public void creerPDF(@ModelAttribute PDF pdfa, Model model, HttpServletResponse response)
    {
        this.pdf = pdfa;
        System.out.println(pdf.getNom());
        model.addAttribute("pdf", pdf);
        Document document = new Document();
        try
        {
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            document.add(new Paragraph("this is a test of pdf"));
            document.add(new Paragraph(pdf.nom));
            document.add(new Paragraph(pdf.age));
            document.add(new Paragraph(pdf.adresse));
            document.add(new Paragraph(pdf.telephone));
            document.add(new Paragraph(pdf.email));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (DocumentException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        document.close();
    }


    @GetMapping("/saisir_data_pdf")
    public String saisirDataPDF(Model model)
    {
        model.addAttribute("pdf", pdf);
        model.addAttribute("info", "something");
        return "saisir_data_pdf"; // nom de fichier html
    }

    @GetMapping("/inscrire")
    public String inscrire(Model model)
    {
//        model.addAttribute("pdf", pdf);
        return "/inscrire";
    }
}
