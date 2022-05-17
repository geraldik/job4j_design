package ru.job4j.design.lsp;

import java.util.List;

public class ControlQuality {

    private List<Storage> stores;

    public ControlQuality(List<Storage> stores) {
        this.stores = stores;
    }

    public void control(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Input product cannot be null");
        }
        for (Storage storage : stores) {
           if (storage.sort(Distributor.lifeBalance(food))) {
                storage.store(food, Distributor.lifeBalance(food));
                break;
            }

        }
    }
}
