package com.mbielecki.currencyconverter.commands;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

class JSonLoader implements Commands {
    public static final String JSON_FILE="/home/mbielecki1/Desktop/Homework/CurrencyConverter/currencies.json";
    @Override
    public void execute() {
        InputStream fis = null;
        try {
            fis = new FileInputStream(JSON_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("nie znalazł pliku!!!!!!!!!!!");
            e.printStackTrace();
        }

        //create JsonReader object
        JsonReader jsonReader = Json.createReader(fis);

        /**
         * We can create JsonReader from Factory also
         JsonReaderFactory factory = Json.createReaderFactory(null);
         jsonReader = factory.createReader(fis);
         */

        //get JsonObject from JsonReader
        JsonObject jsonObject = jsonReader.readObject();

        //we can close IO resource and JsonReader now
        jsonReader.close();
        try {
            fis.close();
        } catch (IOException e) {
            System.out.println("Nie zamknal pliku");
            e.printStackTrace();
        }
        JsonObject innerJsonObject = jsonObject.getJsonObject("baseCurrency");
        System.out.println(innerJsonObject.getString("code"));
        System.out.println(innerJsonObject.getString("name"));
        //System.out.println(innerJsonObject.getString("value"));




    }
}
