package com.mbielecki.currencyconverter.commands;

import static java.lang.System.out;

class MenuPrinter implements Commands {
    public void execute() {
        out.println("----- Welcome in Currency Converter Magic -----");
        out.println("\t1. Load json");
        out.println("\t2. Convert currency");
        out.println("----- ----------------------------------- -----");
    }
}
