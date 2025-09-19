import java.util.ArrayList;

public class ShoppingCart {
    ArrayList<Item> items;

    public ShoppingCart() {
       items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    // manual deep copy
    public ArrayList<Item> getItems(){
        ArrayList<Item> copy = new ArrayList<>();
        for ( Item item : items ){
            copy.add(new Item(item.getName(), item.getQuantity(), item.getPrice()));
        }
        return copy;
    }
}
