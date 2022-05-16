package ru.job4j.design.lsp;

import org.junit.Test;

import org.junit.Before;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ControlQualityTest {

    Shop shop;

    Trash trash;

    Warehouse warehouse;

    List<Storage> stores;

    ControlQuality controlQuality;

    @Before
    public void date() {
        shop = new Shop();
        trash = new Trash();
        warehouse = new Warehouse();
        stores = List.of(warehouse, shop, trash);
        controlQuality = new ControlQuality(stores);
    }

    @Test
    public void whenAddMilkThanGoToWarehouse() {
        Food expected = new Milk("Sarafanovo", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(2), 100, 50);
        controlQuality.control(expected);
        assertThat(expected, is(warehouse.getFoodList().get(0)));
    }

    @Test
    public void whenAddBreadThanGoToShop() {
        Food expected = new Bread("Borodinsky", LocalDate.now(),
                LocalDate.now().minusDays(5), 100, 50);
        controlQuality.control(expected);
        assertThat(expected, is(shop.getFoodList().get(0)));
    }

    @Test
    public void whenAddCookieThanGoToShopAndGetDiscount() {
        Food expected = new Cookie("Kreker", LocalDate.now().plusDays(1),
                LocalDate.now().minusDays(5), 100, 50);
        double expectedPrice = expected.getPrice() / 2;
        controlQuality.control(expected);
        assertThat(expected, is(shop.getFoodList().get(0)));
        assertThat(expected.getPrice(), is(expectedPrice));
    }

    @Test
    public void whenAddMilkThanGoToTrash() {
        Food expected = new Milk("Sarafanovo", LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(10), 100, 50);
        controlQuality.control(expected);
        assertThat(expected, is(trash.getFoodList().get(0)));
    }

    @Test
    public void whenAddThreeFoodThanGoToTrashWarehouseShop() {
        Food expected1 = new Milk("Sarafanovo", LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(10), 100, 50);
        Food expected2 = new Milk("M", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(2), 100, 50);
        Food expected3 = new Bread("Borodinsky", LocalDate.now(),
                LocalDate.now().minusDays(5), 100, 50);
        controlQuality.control(expected1);
        controlQuality.control(expected2);
        controlQuality.control(expected3);
        assertThat(1, is(trash.getFoodList().size()));
        assertThat(1, is(warehouse.getFoodList().size()));
        assertThat(1, is(shop.getFoodList().size()));
        assertThat(expected1, is(trash.getFoodList().get(0)));
        assertThat(expected2, is(warehouse.getFoodList().get(0)));
        assertThat(expected3, is(shop.getFoodList().get(0)));
    }
}