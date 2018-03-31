package com.mbielecki.currencyconverter.commands;

import java.util.Scanner;

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
    }
}
