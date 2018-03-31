package com.mbielecki.currencyconverter.commands;


import com.mbielecki.currencyconverter.data.BaseCurrency;
import com.mbielecki.currencyconverter.data.Currencies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;


public class JSonLoader implements Commands {
    public static String JSON_FILE="/home/mbielecki1/Desktop/Homework/CurrencyConverter/currencies.json";

    public static BaseCurrency bc = new BaseCurrency();
    public static Currencies cu = new Currencies();

    public JSonLoader(String JSON_FILE) {
        this.JSON_FILE = JSON_FILE;
    }


    @Override
    public void execute() {

        InputStream fis = null;
        try {
            fis = new FileInputStream(JSON_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("There is no json file");
            return;
        }

        //create JsonReader object
        JsonReader jsonReader = Json.createReader(fis);

        //get JsonObject from JsonReader
        JsonObject jsonObject = jsonReader.readObject();

        jsonReader.close();
        try {
            fis.close();
        } catch (IOException e) {
            System.out.println("ERROR. File not close.");
        }

        //base currency
        JsonObject innerJsonObject = jsonObject.getJsonObject("baseCurrency");
        bc.setCode(innerJsonObject.getString("code"));
        bc.setName(innerJsonObject.getString("name"));
        bc.setValue( innerJsonObject.get("value").toString());

        //other currencies
        JsonArray jsonArray = (JsonArray) jsonObject.get("currencies");

        String[] codes = new String[jsonArray.size()];
        String[] names = new String[jsonArray.size()];
        String[] values = new String[jsonArray.size()];

        for (int i = 0; i < jsonArray.size(); i++) {
            codes[i] = jsonArray.getJsonObject(i).getString("code");
            names[i] = jsonArray.getJsonObject(i).getString("name");
            values[i] = jsonArray.getJsonObject(i).get("value").toString();
        }
        cu.setCode(codes);
        cu.setName(names);
        cu.setValue(values);

    }
}
