package ru.job4j.design.dip;

import java.util.List;

/**
 * Класс Manager зависит от конкретных классов Tester, Developer, Designer. Для того, что бы
 * устранить нарушение DIP нужно создать интерфейс Employee, который реализуют данные классы.
 * В качестве поля оставить List<Employee> employees и создать лишь один метод manage().
 * Тем самым можно ослабить зависимость класса Manager от конкретных реализаций.
 */
public class Manager {

    List<Tester> testers;
    List<Developer> developers;
    List<Designer> designers;


    public Manager(List<Tester> testers, List<Developer> developers, List<Designer> designers) {
        this.testers = testers;
        this.developers = developers;
        this.designers = designers;
    }

    public void manageTesters(List<Tester> testers) {
        testers.forEach(Tester::job);
    }
    public void manageDev(List<Developer> developers) {
        developers.forEach(Developer::job);
    }
    public void manageDesigners(List<Designer> testers) {
        testers.forEach(Designer::job);
    }
}
