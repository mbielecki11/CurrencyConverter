package com.mbielecki.currencyconverter.commands;

import java.util.Scanner;

class CurrencyConverter implements Commands {
    @Override
    public void execute() {
        Double targetAmount;
        Double dAmountPLN;
        Double amountCurrency;

        try
        {
            int vsize = JSonLoader.cu.getCode().length;
        }catch (NullPointerException e) {
            System.out.println("Please LOAD json file");
            return;
        }

        System.out.println("Please write amount of PLN");
        Scanner reader = new Scanner(System.in);
        String amountPLN = reader.next();
        dAmountPLN = Double.parseDouble(amountPLN);

        System.out.println("Please write target currency");
        String targetCurrency = reader.next();

        for (int i = 0; i < JSonLoader.cu.getCode().length ; i++) {
            if(JSonLoader.cu.getCode()[i].equalsIgnoreCase(targetCurrency))
            {
                amountCurrency = Double.parseDouble( JSonLoader.cu.getValue()[i]);
                targetAmount = dAmountPLN * amountCurrency;
                System.out.println("Target amount is: " + targetAmount.toString());
            }
        }



    }
}
