package ru.job4j.design.dip;

import java.io.File;

/**
 * Класс App зависит от модуля нижнего уровня PDFExporter. Для ослабления связи нужно создать интерфейс Exporter,
 * который реализует класс PDFExporter и, если потребуется, другие классы-экспортеры. В классе конкретную реализацию
 * интерфейса Exporter нужно заменить на саму абстракцию.
 */

public class App {
    private PDFExporter exporter = new PDFExporter();

    public File export() {
        return exporter.toFile();
    }
}