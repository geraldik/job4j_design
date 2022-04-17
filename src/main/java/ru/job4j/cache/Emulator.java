package ru.job4j.cache;

public class Emulator {

    private DirFileCache dirFileCache;

    private void loadDir(String dir) {
        dirFileCache = new DirFileCache(dir);
    }

    private void cacheFile(String name) {
        if (dirFileCache == null) {
            System.out.println("First you need to load the directory path.");
        } else {
            dirFileCache.load(name);
        }
    }

    private String readCache(String name) {
        String rsl = null;
        if (dirFileCache == null) {
            System.out.println("First you need to load the directory path.");

        } else {
            rsl = dirFileCache.get(name);
        }
        return rsl;
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        emulator.loadDir("cache");
        emulator.cacheFile("Names.txt");
        System.out.println(emulator.readCache("Names.txt"));
    }
}
