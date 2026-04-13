import java.util.*;
class Item {
    int id;
    String name;
    int quantity;

    Item(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
}
public class InventorySystem {
    static ArrayList<Item> items = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addItem() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Qty: ");
        int q = sc.nextInt();
        items.add(new Item(id, name, q));
    }
    static void viewItems() {
        for (Item i : items) {
            System.out.println(i.id + " " + i.name + " " + i.quantity);
        }
    }
    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("\n1.Add 2.View 3.Exit");
            ch = sc.nextInt();

            if (ch == 1) addItem();
            else if (ch == 2) viewItems();

        } while (ch != 3);
    }
}
