package ru.job4j.cache;

import java.nio.file.Path;

public class PointAction implements UserAction {

        private final Output out;
        private static AbstractCache cache;

        public PointAction(Output out) {
            this.out = out;
            cache = null;
        }

        @Override
        public String name() {
            return "Point the path";
        }

        @Override
        public boolean execute(Input input) {
            out.println("=== Point path to destination directory ===");
            String name = input.askStr("Enter path: ");
            if (DirFileCache.validatePath(name)) {
                cache = new DirFileCache(name);
                System.out.println("Selected directory is: " + Path.of(name).toAbsolutePath());
            } else {
                System.out.println("Path does not exist or does not point to a directory.");
            }
            return true;
        }

    public static AbstractCache getCacheDir() {
        return cache;
    }
}
