package ru.job4j.cache;

import java.util.List;
import java.util.Scanner;

public class Emulator {

    private final Output out;

    public Emulator(Output out) {
        this.out = out;
    }



//    private void loadDir(String dir) {
//        dirFileCache = new DirFileCache(dir);
//    }
//
//    private void cacheFile(String name) {
//        if (dirFileCache == null) {
//            System.out.println("First you need to load the directory path.");
//        } else {
//            dirFileCache.load(name);
//        }
//    }

//    private String readCache(String name) {
//        String rsl = null;
//        if (dirFileCache == null) {
//            System.out.println("First you need to load the directory path.");
//
//        } else {
//            rsl = dirFileCache.get(name);
//        }
//        return rsl;
//    }

    public void init(Input input, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        List<UserAction> actions = List.of(
                new PointAction(output),
                new LoadFileAction(output),
                new GetFileAction(output),
                new ExitAction()
        );
        new Emulator(output).init(input, actions);
//        System.out.println("Enter path for caching directory:");
//        emulator.cacheFile("Names.txt");
//        System.out.println(emulator.readCache("Names.txt"));
    }
}
