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

     public static void main(String[] args) {


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