package com.example.tw_movie_rental.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import static java.lang.Float.parseFloat;

public class Invoice {
    PDDocument invc;
    Float total = 0.0f;
    Float price;
    String CustName;
    String CustPh;
    String address;
    List<String> ProductName = new ArrayList<String>();
    List<Float> ProductPrice = new ArrayList<>();
    String InvoiceTitle = "LeCozyRaccoon";
    String SubTitle = "Factura";
    public Invoice() {
        //Create Document
        invc = new PDDocument();
        //Create Blank Page
        PDPage newpage = new PDPage();
        //Add the blank page
        invc.addPage(newpage);
    }

    public void getData(String customerName, String phoneNumber, Map<String, String> listOfProducts, String address ) {
        CustName = customerName;
        CustPh = phoneNumber;
        this.address =address;
        int i=0;
        for(Map.Entry<String,String> entry : listOfProducts.entrySet()) {
            if(entry.getKey().equals("prodName"+i))
                ProductName.add(entry.getValue());
            else if(entry.getKey().equals("priceProd"+i)){
                ProductPrice.add(parseFloat(entry.getValue()));
                total = total + parseFloat(entry.getValue());
                i++;
            }
            System.out.println(entry);
        }
    }

    public void writeInvoice() {
        //get the page
        PDPage mypage = invc.getPage(0);
        try {
            PDPageContentStream cs = new PDPageContentStream(invc, mypage);

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 15);
            cs.newLineAtOffset(250, 750);
            cs.showText(InvoiceTitle);
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 15);
            cs.newLineAtOffset(270, 690);
            cs.showText(SubTitle);
            cs.endText();

            //Writing Multiple Lines
            //writing the customer details
            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 12);
            cs.setLeading(20f);
            cs.newLineAtOffset(60, 610);
            cs.showText("Customer Name: ");
            cs.newLine();
            cs.showText("Phone Number: ");
            cs.newLine();
            cs.showText("Address: ");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 11);
            cs.setLeading(20f);
            cs.newLineAtOffset(170, 610);
            cs.showText(CustName);
            cs.newLine();
            cs.showText(CustPh);
            cs.newLine();
            cs.showText(address);
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 11);
            cs.newLineAtOffset(80, 540);
            cs.showText("Product Name");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 11);
            cs.newLineAtOffset(300, 540);
            cs.showText("Unit Price");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 11);
            cs.newLineAtOffset(410, 540);
            cs.showText("Quantity");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 11);
            cs.newLineAtOffset(510, 540);
            cs.showText("Price");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 6);
            cs.setLeading(20f);
            cs.newLineAtOffset(80, 520);
            for (int i = 0; i < ProductName.size(); i++) {
                cs.showText(ProductName.get(i));
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 9);
            cs.setLeading(20f);
            cs.newLineAtOffset(300, 520);
            for (int i = 0; i < ProductPrice.size(); i++) {
                cs.showText("$"+ProductPrice.get(i).toString());
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 9);
            cs.setLeading(20f);
            cs.newLineAtOffset(410, 520);
            for (int i = 0; i < ProductName.size(); i++) {
                cs.showText("     1");
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 9);
            cs.setLeading(20f);
            cs.newLineAtOffset(500, 520);
            for (int i = 0; i < ProductPrice.size(); i++) {
                price = ProductPrice.get(i);
                cs.showText("   $"+price.toString());
                cs.newLine();
            }
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 11);
            cs.newLineAtOffset(420, (500 - (20 * ProductName.size())));
            cs.showText("Total: $");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 11);
            cs.newLineAtOffset(480, (500 - (20 * ProductName.size())));
            cs.showText(total.toString());
            cs.endText();


            cs.close();
            invc.save("C:\\Users\\mihai\\Desktop\\fisie.pdf");
            invc.close();
            System.out.println("da");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
