package ru.job4j.design.ocp.cat;

/**
 * Для добавления новой активности коту придется вносить
 * изменения в метод activity, что нарушит принцип открытости/закрытости
 */
public class CatActivity {

    public void activity(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Wrong activity argument");
        }
        if (activity instanceof Games) {
            ((Games) activity).playWithMouse();
        } else if (activity instanceof Hunting) {
            ((Hunting) activity).birdHunting();
        }
    }
}
