package com.itext;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.MalformedInputException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException,MalformedInputException
    {
        try {

            new BarCode();
           
            String currentWorkingDir = System.getProperty("user.dir");
            //adding phn symbal png
            String phnpng = currentWorkingDir + "\\media\\defaultpng\\phone.png";
            ImageData phnsym = ImageDataFactory.create(phnpng);
            Image phn = new Image(phnsym).setWidth(20).setHeight(20);

            //adding site symbal png
            String sitepng = currentWorkingDir + "\\media\\defaultpng\\site.png";
            ImageData sitesym = ImageDataFactory.create(sitepng);
            Image site = new Image(sitesym).setWidth(20).setHeight(20);

            //adding mail symbal png
            String mailpng = currentWorkingDir + "\\media\\defaultpng\\mail.png";
            ImageData mailsym = ImageDataFactory.create(mailpng);
            Image mail = new Image(mailsym).setWidth(20).setHeight(20);

            //adding barcode to pdf
            String code128 = currentWorkingDir + "\\media\\outputpng\\CODE_128.png";
            ImageData imagedata = ImageDataFactory.create(code128);
            Image a = new Image(imagedata).setWidth(300).setHeight(75);
        
            //adding 2nd barcode to pdf
            String ean13 = currentWorkingDir + "\\media\\outputpng\\EAN_13.png";
            ImageData imageData2 = ImageDataFactory.create(ean13);
            Image b = new Image(imageData2).setWidth(150).setHeight(85);

            
            String path = currentWorkingDir + "\\media\\outputpng\\label.pdf";
            PdfWriter pdfWriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.addNewPage();
            // pdfDocument.setDefaultPageSize(PageSize.B10);
            
            
            //for addding something in pdf we have to create Document object.
            Document document = new Document(pdfDocument);
            PdfFont pdfFont = PdfFontFactory.createFont(FontConstants.HELVETICA);
            Paragraph p = new Paragraph().setFont(pdfFont).setFontSize(22)
                .add(new Text("Marked By :").setUnderline().setBold()).add(" Bata India Ltd. 27B, Camac   Street, \n 1st Floor Kolkata, West Bengal - 700016\n")

                .add(new Text("\nManufactured by :").setBold().setUnderline()).add(new Text(" Bata India Ltd. \n24 Parganas (South), Batanagar Kolkata-700140, West Bengal\n\n").setBold())

                .add(new Text("Generic Name : One Pair Footwear\n"))
                .add(new Text("Size         : 25.1cm\n"))
                .add(new Text("Article No   : 824-6241\n").setBold().setFontSize(24)).add("Dept Plan    : 422/1121F\n")
                .add(new Text("MRP          : ₹2499(Incl. of All Taxes)\n").setBold().setFontSize(24))
                .add(new Text("Month Year of Mfg : 03 2021 Net Quantity : 2N\n\n"))

                .add(new Text("For Consumer Complaints :").setUnderline().setBold()).add(" Customer Service,\n 418/02,Sector 17,M.G. Road, Gurugram, Haryana-122001\n")
                ;
            
            Paragraph telephone = new Paragraph().add(phn).setFixedPosition(1, 35, 200, null);
            Paragraph sitesymbal = new Paragraph().add(site).setFixedPosition(1, 300, 200, null);
            Paragraph mailsymbal = new Paragraph().add(mail).setFixedPosition(1, 35,170, null);

            Paragraph detail = new Paragraph().setFont(pdfFont).setFontSize(20).add(new Text("800-419-2282 (Toll Free)        WWW.bata.in\n      in-customer.service@bata.com     V 2.2 D\n").setBold()).setMarginLeft(25);

            Paragraph p2 = new Paragraph().add(a).setMargins(0, 0, 0, 200).setFixedPosition(1, 170, 80, null);
            Paragraph p3 = new Paragraph().add(b).setRotationAngle(1.55).setRelativePosition(500, 0, 0, 350);
            
            
            
            document.add(p);
            document.add(telephone);
            document.add(sitesymbal);
            document.add(mailsymbal);
            document.add(detail);
            document.add(p3);
            document.add(p2);
           
           

            document.close();
            
            new Pdf_To_Png();

            //--> Deleting files after successful PNG Generation <--

            System.out.println("Deleting... CODE_128.png ");
            File originalFilecode128 = new File(currentWorkingDir+"\\media\\outputpng\\CODE_128.png");
            boolean isCode_128DeleteDone = originalFilecode128.delete();
            System.out.println("Delete Status: "+isCode_128DeleteDone);
            
            System.out.println("Deleting... EAN_13.png ");
            File originalFileean13 = new File(currentWorkingDir+"\\media\\outputpng\\EAN_13.png");
            boolean isEan_13DeleteDone = originalFileean13.delete();
            System.out.println("Delete Status: "+isEan_13DeleteDone);
            
            System.out.println("Deleting... Label.pdf");
            File originalFilelabel = new File(currentWorkingDir+"\\media\\outputpng\\label.pdf");
            boolean islabelDeleteDone = originalFilelabel.delete();
            System.out.println("Delete Status: "+islabelDeleteDone);
            

            System.out.println( "Final PNG is Ready" );
            
        } catch (Exception e) {
            System.out.println("Error In App class");
        }
    }
}
