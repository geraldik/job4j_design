package ru.job4j.cache;

import java.util.Objects;

public class LoadFileAction implements UserAction {

    private final Output out;
    private  AbstractCache cache;

    public LoadFileAction(Output out) {
        this.out = out;
    }


    @Override
    public String name() {
        return "Select file for caching";
    }

    @Override
    public boolean execute(Input input) {
        out.println("=== Select file for caching ===");
        cache = PointAction.getCacheDir();
        if (Objects.isNull(cache)) {
            System.out.println("First you need to specify the path to the directory");
        } else {
            String name = input.askStr("Enter name of file: ");
            if (!Objects.isNull(cache.get(name))) {
                System.out.println(cache.get(name));
            }
        }
        return true;
    }
}
