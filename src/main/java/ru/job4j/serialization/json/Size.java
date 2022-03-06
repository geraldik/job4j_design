package ru.job4j.serialization.json;

public class Size {
    private int length;
    private int height;
    private int width;

    public Size(int length, int height, int width) {
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Size{"
                + "length=" + length
                + ", height=" + height
                + ", width=" + width
                + '}';
    }
}
