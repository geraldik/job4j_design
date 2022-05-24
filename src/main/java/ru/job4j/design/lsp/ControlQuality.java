package ru.job4j.design.lsp;

import java.util.List;
import java.util.stream.Collectors;

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

    public void resort() {
        List<Food> temp = stores.stream()
                        .flatMap(x -> x.getFoodList().stream())
                        .collect(Collectors.toList());
        stores.forEach(Storage::clear);
        temp.forEach(this::control);
    }
}
