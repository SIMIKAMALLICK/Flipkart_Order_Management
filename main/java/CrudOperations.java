public interface CrudOperations {
    void addItem(Item item);
    void viewItems();
    void updateItem(int id, String name, double price);
    void deleteItem(int id);
    Item searchItem(String name);
    Item[] getAllItems();
}
