package ru.job4j.design.icp.menu;

import java.util.*;

public class SimpleMenu implements Menu {

    private final List<MenuItem> rootElements = new ArrayList<>();

    @Override
    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        var rsl = false;
        var menuItem = new SimpleMenuItem(childName, actionDelegate);
        boolean flag = findItem(childName).isEmpty();
        if (flag && Objects.equals(parentName, Menu.ROOT)) {
            rsl = rootElements.add(menuItem);
        } else if (flag) {
            Optional<ItemInfo> itemInfo = findItem(parentName);
            rsl = itemInfo.isPresent()
                    && itemInfo.get().menuItem.getChildren().add(menuItem);
        }

        return rsl;
    }

    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        return findItem(itemName).map(x -> new MenuItemInfo(findItem(itemName).get().menuItem,
                findItem(itemName).get().number));
    }

    @Override
    public Iterator<MenuItemInfo> iterator() {
        return new Iterator<>() {
            Iterator<ItemInfo> iterator = new DFSIterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public MenuItemInfo next() {
                ItemInfo next = iterator.next();
                return new MenuItemInfo(next.menuItem, next.number);
            }
        };
    }

    private Optional<ItemInfo> findItem(String name) {
        Optional<ItemInfo> rsl = Optional.empty();
        var iterator = new DFSIterator();
        while (iterator.hasNext()) {
            var itemInfo = iterator.next();
            var itemName = itemInfo.menuItem.getName();
            if (name.equals(itemName)) {
                rsl = Optional.of(itemInfo);
                break;
            }
        }
        return rsl;
    }

    private static class SimpleMenuItem implements MenuItem {

        private String name;
        private List<MenuItem> children = new ArrayList<>();
        private ActionDelegate actionDelegate;

        public SimpleMenuItem(String name, ActionDelegate actionDelegate) {
            this.name = name;
            this.actionDelegate = actionDelegate;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<MenuItem> getChildren() {
            return children;
        }

        @Override
        public ActionDelegate getActionDelegate() {
            return actionDelegate;
        }
    }

    private class DFSIterator implements Iterator<ItemInfo> {

        Deque<MenuItem> stack = new LinkedList<>();

        Deque<String> numbers = new LinkedList<>();

        DFSIterator() {
            int number = 1;
            for (MenuItem item : rootElements) {
                stack.addLast(item);
                numbers.addLast(String.valueOf(number++).concat("."));
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public ItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MenuItem current = stack.removeFirst();
            String lastNumber = numbers.removeFirst();
            List<MenuItem> children = current.getChildren();
            int currentNumber = children.size();
            for (var i = children.listIterator(children.size()); i.hasPrevious();) {
                stack.addFirst(i.previous());
                numbers.addFirst(lastNumber.concat(String.valueOf(currentNumber--)).concat("."));
            }
            return new ItemInfo(current, lastNumber);
        }

    }

    private class ItemInfo {

        MenuItem menuItem;
        String number;

        public ItemInfo(MenuItem menuItem, String number) {
            this.menuItem = menuItem;
            this.number = number;
        }
    }
}

