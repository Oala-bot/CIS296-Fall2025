import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard=  new Scanner(System.in);
        System.out.println("Do you want to load a shopping cart? (y/n)");
        String load = keyboard.nextLine();
        ShoppingCart cart = new ShoppingCart();
        if ( load.equalsIgnoreCase("y") ){
            System.out.println("Enter the name of the file");
            String fileName = keyboard.nextLine();
            try (BufferedReader input = new BufferedReader(
                    new FileReader(fileName))) {
                String itemName = input.readLine();
                while (itemName != null) {
                    int quantity = Integer.parseInt(input.readLine());
                    double price = Double.parseDouble(input.readLine());
                    cart.addItem(new Item(itemName, quantity, price));
                    itemName = input.readLine();
                }
            }
            catch (IOException e) {
                System.out.println(e.toString());
            }
        }

        String addItems = "y";
        while ( addItems.equalsIgnoreCase("y")){
            System.out.println("Enter the name of an item to add to your cart");
            String name = keyboard.nextLine();
            System.out.println("Enter the quantity");
            int quantity = Integer.parseInt(keyboard.nextLine());
            System.out.println("Enter the price");
            double price = Double.parseDouble(keyboard.nextLine());
            cart.addItem(new Item(name, quantity, price));

            System.out.println("Do you have more items to add? (y/n");
            addItems = keyboard.nextLine();

        }


        try (BufferedWriter output = new BufferedWriter(
               new FileWriter("shoppingCart.txt"))) {
            for ( Item item : cart.getItems()){
                output.write(item.getName() + "\n");
                output.write(item.getQuantity() + "\n");
                output.write(item.getPrice() + "\n");
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }






        System.out.println("Do you want to read or write a file?");
        String choice = keyboard.nextLine();

        if ( choice.equalsIgnoreCase("read")){
            System.out.println("Enter the name of the file");
            String fileName = keyboard.nextLine();

            // please don't crash on file not existing

            try (BufferedReader input = new BufferedReader(
                    new FileReader(fileName))) {
                String line = input.readLine();
                while ( line != null ){
                    System.out.println(line);
                    line = input.readLine();
                }


            } catch (FileNotFoundException e) {
                System.out.println(e.toString());
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        } else if ( choice.equalsIgnoreCase("write")){
            System.out.println("Enter the name of the file");
            String fileName = keyboard.nextLine();

            File file = new File(fileName);
            String append = "n";
            if ( file.exists()){
                System.out.println("Do you want to append the file? (y/n)");
                // validate?
                append = keyboard.nextLine();
            }


            // will erase a file that already exists without append mode
            try (BufferedWriter output = new BufferedWriter(
                    // https://stackoverflow.com/questions/1225146/java-filewriter-with-append-mode
                    new FileWriter(fileName, append.equalsIgnoreCase("y")))) {

                System.out.println("Enter some content or quit to stop");
                String content = keyboard.nextLine();
                while ( !content.equalsIgnoreCase("quit")){
                    output.write(content);
                    output.write("\n");
                    System.out.println("Enter some content or quit to stop");
                    content = keyboard.nextLine();
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
    }
}