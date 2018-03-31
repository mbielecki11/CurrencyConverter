package com.mbielecki.currencyconverter.commands;

import com.mbielecki.currencyconverter.data.BaseCurrency;
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

class CurrencyValues implements Commands {
    @Override
    public void execute() {
        System.out.println("Please give path to json (default = /home/mbielecki1/Desktop/Homework/CurrencyConverter/currencies.json)");
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        if(!input.equals("default") ) {
            JSonLoader.JSON_FILE = input;
        }

        JSonLoader jsCurrency = new JSonLoader(JSonLoader.JSON_FILE);
        jsCurrency.execute();
      //  JsonObject innerJsonObject = jsCurrency.getJsonObject("baseCurrency");


        System.out.println("------BASE CURRENCY--------");

        System.out.println(JSonLoader.bc.getCode());
        System.out.println(JSonLoader.bc.getName());
        System.out.println(JSonLoader.bc.getValue());

        System.out.println("------OTHERS CURRENCIES--------");

        for (int i = 0; i < JSonLoader.cu.getCode().length; i++) {

            System.out.println(JSonLoader.cu.getCode()[i]);
            System.out.println(JSonLoader.cu.getName()[i]);
            System.out.println(JSonLoader.cu.getValue()[i]);
        
        }
/*
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
        */

    }
}
