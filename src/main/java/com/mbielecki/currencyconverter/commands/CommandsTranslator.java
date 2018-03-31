package com.mbielecki.currencyconverter.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandsTranslator implements Commands {
    private final Map<String, Commands> commands;

    public static CommandsTranslator init() {
        CommandsTranslator result = new CommandsTranslator();

        result.commands.put("menu", new MenuPrinter());
        result.commands.put("err", () -> System.out.println("Try one more time."));
        result.commands.put("1", new CurrencyValues());
        result.commands.put("2", new CurrencyConverter());

        result.commands.put("exit", () -> System.out.println("Thanks for using this software."));

        return result;
    }

    private CommandsTranslator() {
        commands = new HashMap<>();
    }


    public void execute(String name) {
        if (!commands.containsKey(name)) {
            name = "err";
        }
        commands.get(name).execute();
    }

    public void execute() {

    }
}
