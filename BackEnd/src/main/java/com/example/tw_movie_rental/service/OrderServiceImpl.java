package com.example.tw_movie_rental.service;

import com.example.tw_movie_rental.Model.Invoice;
import com.example.tw_movie_rental.response.OrdersResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService {
    final
    EmailService emailService;

    public OrderServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public ResponseEntity<OrdersResponse> sendOrder(String json) throws InterruptedException {
        System.out.println(json);
        Map<String, String> listProduct = new LinkedHashMap<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement elem = gson.fromJson(json, JsonElement.class);
        JsonObject obj = elem.getAsJsonObject();
        for(int i=0;i<obj.get("nrprod").getAsInt();i++) {
            listProduct.put("prodName"+i, obj.get("prod"+i).getAsString());
            listProduct.put("priceProd"+i, obj.get("pret"+i).getAsString());
        }

        Invoice invoice = new Invoice();
        invoice.getData(obj.get("name").getAsString(),obj.get("nrtlf").getAsString(), listProduct, obj.get("adrs").getAsString());
        invoice.writeInvoice();

        TimeUnit.SECONDS.sleep(5);
        emailService.sendEmail(obj.get("email").getAsString(),"Comanda de la LeCozyRaccoon","Va multumim pentru comanda!\n\nAveti atasat mai jos factura electronica.");


        return new ResponseEntity<>(new OrdersResponse(), HttpStatus.NO_CONTENT);
    }
}
