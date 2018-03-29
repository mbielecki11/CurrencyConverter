package com.mbielecki.currencyconverter;

import java.util.Scanner;

import com.mbielecki.currencyconverter.commands.CommandsTranslator;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

class Main {
    private static CommandsTranslator commands = CommandsTranslator.init();

    //public static final String JSON_FILE="/home/mbielecki1/Desktop/Homework/CurrencyConverter/currencies.json";
    public static void main(String[] args) {

         /*   InputStream fis = null;
            try {
                fis = new FileInputStream(JSON_FILE);
            } catch (FileNotFoundException e) {
                System.out.println("nie znalazł pliku!!!!!!!!!!!");
                e.printStackTrace();
            }

            //create JsonReader object
            JsonReader jsonReader = Json.createReader(fis);

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
*/

        boolean finished = false;
        Scanner reader = new Scanner(System.in);

        System.out.println("Aby zakończyć, wpisz 'exit'.\n");
        while (!finished) {
            commands.execute("menu");

            System.out.print("Twój wybór: ");
            String input = reader.next();

            finished = input.equals("exit");

            System.out.println();
            commands.execute(input);
            System.out.println();
        }
        reader.close();
    }
}