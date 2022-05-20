package ru.job4j.design.icp.menu;

import java.util.List;

public interface MenuItem {

    String getName();

    List<MenuItem> getChildren();

    ActionDelegate getActionDelegate();

}