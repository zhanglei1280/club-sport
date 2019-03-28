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
        System.out.println("create a pdf with the name: " + pdf.getName());
        model.addAttribute("pdf", pdf);
        Document document = new Document();
        try
        {
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            document.add(new Paragraph("Application form"));
            document.add(new Paragraph("Name: " + pdf.name));
            document.add(new Paragraph("Age: " + pdf.age));
            document.add(new Paragraph("Telephone: " + pdf.telephone));
            document.add(new Paragraph("Email: " + pdf.email));
            document.add(new Paragraph("Adress: " + pdf.adress));
            document.add(new Paragraph("Sport: " + pdf.sport));
            document.add(new Paragraph("Level: " + pdf.level));
            document.add(new Paragraph("Other: " + pdf.other));

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


    @GetMapping("/enter_data_pdf")
    public String saisirDataPDF(Model model)
    {
        model.addAttribute("pdf", pdf);
        return "enter_data_pdf"; // nom de fichier html
    }
}
