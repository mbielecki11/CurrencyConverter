package com.mbielecki.currencyconverter.commands;


import netscape.javascript.JSObject;

import java.util.Scanner;
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
    public String JSON_FILE="/home/mbielecki1/Desktop/Homework/CurrencyConverter/currencies.json";
    @Override
    public void execute() {

        System.out.println("Please give path to json (default = /home/mbielecki1/Desktop/Homework/CurrencyConverter/currencies.json)");
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        if(!input.equals("default") ) {
            JSON_FILE = input;
        }

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
        JsonObject innerJsonObject = jsonObject.getJsonObject("baseCurrency");


        System.out.println("------BASE CURRENCY--------");

        System.out.println(innerJsonObject.getString("code"));
        System.out.println(innerJsonObject.getString("name"));
        System.out.println(innerJsonObject.get("value").toString());

        System.out.println("------OTHERS CURRENCIES--------");

        JsonArray jsonArray = (JsonArray) jsonObject.get("currencies");

        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.getJsonObject(i).getString("code"));
            System.out.println(jsonArray.getJsonObject(i).getString("name"));
            System.out.println(jsonArray.getJsonObject(i).get("value").toString());
            System.out.println(":");

        }




    }
}
