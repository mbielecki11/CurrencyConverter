package com.mbielecki.currencyconverter;

import java.util.Scanner;

import com.mbielecki.currencyconverter.commands.CommandsTranslator;

class Main {
    private static CommandsTranslator commands = CommandsTranslator.init();

     public static void main(String[] args) {


        boolean finished = false;
        Scanner reader = new Scanner(System.in);

        System.out.println("To finish write 'exit'.\n");
        while (!finished) {
            commands.execute("menu");

            System.out.print("Your choice: ");
            String input = reader.next();

            finished = input.equals("exit");

            System.out.println();
            commands.execute(input);
            System.out.println();
        }
        reader.close();
    }
}