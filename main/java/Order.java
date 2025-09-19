public class Order implements CrudOperations {
    private Item[] items;
    private int count;

    public Order(int size) {
        items = new Item[size];
        count = 0;
    }

    @Override
    public void addItem(Item item) {
        if (count < items.length) {
            items[count++] = item;
        } else {
            IO.println("Storage Full! Cannot add more items.");
        }
    }

    @Override
    public void viewItems() {
        if (count == 0) {
            IO.println("No items available.");
            return;
        }
        for (int i = 0; i < count; i++) {
            IO.println(items[i].toString());
        }
    }

    @Override
    public void updateItem(int id, String name, double price) {
        for (int i = 0; i < count; i++) {
            if (items[i].getId() == id) {
                items[i].setName(name);
                items[i].setPrice(price);
                return;
            }
        }
        IO.println("Item not found!");
    }

    @Override
    public void deleteItem(int id) {
        for (int i = 0; i < count; i++) {
            if (items[i].getId() == id) {
                items[i] = items[count - 1];
                items[count - 1] = null;
                count--;
                return;
            }
        }
        IO.println("Item not found!");
    }

    @Override
    public Item searchItem(String name) {
        for (int i = 0; i < count; i++) {
            if (items[i].getName().equalsIgnoreCase(name)) {
                return items[i];
            }
        }
        return null;
    }

    @Override
    public Item[] getAllItems() {
        Item[] result = new Item[count];
        for (int i = 0; i < count; i++) {
            result[i] = items[i];
        }
        return result;
    }
}
