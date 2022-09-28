import java.util.ArrayList;
import java.util.Scanner;

// Here we're creating a new data type called Order
public class Order {

    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null
    public ArrayList<Item> menu;
    public ArrayList<Order> orders;


    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.

    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<>();

    }

    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.

    public Order(String name) {
        this();
        this.name = name;
    }

    // ORDER METHODS

    // Most of your code will go here,
    // so implement the getters and setters first!
    public void addItems(Item item){
        items.add(item);
    }

    public  String getStatusMessage(){
        if(ready)
        {
            return "Your order is ready.";
        }
        else
        {
            return "Your order will be ready soon.";
        }
    }

    public double getOrderTotal(){
        double sum = 0.00;

        for(int i = 0; i<this.items.size();i++){
            sum += (items.get(i).getPrice());
        }
        return sum;

    }

    public ArrayList<String> displayMenu(){
        System.out.println("Customer Name: " + name);
        for(int i = 0; i<this.items.size();i++){
            System.out.printf("%s - $%,.2f\n",items.get(i).getName(),items.get(i).getPrice());
        }
        System.out.printf("Total: $%,.2f", getOrderTotal());



        return new ArrayList<>();
    }

    // GETTERS & SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addCustomer(ArrayList<String> customers)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your name");
        String userName = s.nextLine();
        System.out.println("Hello " + userName);
        System.out.format("There are %d people in front of you",customers.size());
        customers.add(userName);



    }



    public void newOrder() {
        Scanner s = new Scanner(System.in);
        Order order1 = new Order();
        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String userName = s.nextLine();
        System.out.println("0 banana -- $2.00");
        System.out.println("1 coffee -- $1.50");
        System.out.println("2 latte -- $4.50");
        System.out.println("3 cappuccino -- $3.00");
        System.out.println("4 muffin -- $4.00");

        Item item1 = new Item();
        item1.setName("Banana");
        item1.setPrice(2);
        Item item2 = new Item();
        item2.setName("Coffee");
        item2.setPrice(1.5);
        Item item3 = new Item();
        item3.setName("latte");
        item3.setPrice(4.5);
        Item item4 = new Item();
        item4.setName("cappuccino");
        item4.setPrice(3);
        Item item5 = new Item();
        item5.setName("cappuccino");
        item5.setPrice(3);

        // Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.

        // Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = s.nextLine();
        while(!itemNumber.equals("q")) {
            if( itemNumber.equals("0")) {
                order1.addItems(item1);
                System.out.println("Please enter a menu item index or q to quit:");
                itemNumber = s.nextLine();
            }
            else if( itemNumber.equals("1")) {
                order1.addItems(item2);
                System.out.println("Please enter a menu item index or q to quit:");
                itemNumber = s.nextLine();
            }
            else if( itemNumber.equals("2")) {
                order1.addItems(item3);
                System.out.println("Please enter a menu item index or q to quit:");
                itemNumber = s.nextLine();
            }
            else if( itemNumber.equals("3")) {
                order1.addItems(item4);
                System.out.println("Please enter a menu item index or q to quit:");
                itemNumber = s.nextLine();
            }
        }

        // Write a while loop to collect all user's order items
        order1.displayMenu();

            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        }
        // After you have collected their order, print the order details
        // as the example below. You may use the order's display method.

    }

