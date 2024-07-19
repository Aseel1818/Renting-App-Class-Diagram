
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Customer customer = createCustomer();
        boolean continueRenting = true;

        while (continueRenting) {
            Building building = selectBuilding();
            Contract contract = createContract(building);
            PaymentWay paymentWay = selectPaymentWay();
            contract.setPaymentMethod(paymentWay);
            customer.addContract(contract);
            scanner.nextLine();

            System.out.println("Do you want to rent another building? (yes/No)");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("yes")) {
                continueRenting = false;
            }
        }
        printDetails(customer);
        processPayments(customer);
    }

    private static Customer createCustomer() {
        System.out.println("Welcome to the renting application");
        System.out.println("Please enter your name :");
        String name = scanner.nextLine();
        return new Customer(name);
    }

    private static Building selectBuilding() {
        System.out.println("Select Building type to rent : ");
        System.out.println("1. Shop");
        System.out.println("2. Apartment");
        System.out.println("3. Separate House");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("**************************************");
        System.out.println("Enter building details:");
        System.out.println();
        System.out.println("Enter building name: ");
        String name = scanner.nextLine();
        System.out.println("Enter building address: ");
        String address = scanner.nextLine();
        System.out.println("Enter building size:");
        String size = scanner.nextLine();
        System.out.println("**************************************");


        switch (choice) {
            case 1:
                return new Shop(name, address, size);
            case 2:
                return new Apartment(name, address, size);
            case 3:
                return new SeparateHouse(name, address, size);
            default:
                throw new IllegalArgumentException("Invalid building type.");
        }
    }

    private static Contract createContract(Building building) {
        System.out.println("Enter rental period:");
        String rentalPeriod = scanner.nextLine();
        System.out.println("Enter price:");
        float price = scanner.nextFloat();
        System.out.println("**************************************");
        return new Contract(rentalPeriod, price, building);
    }

    ////////// to create contract with a default values ,so I use overloading
    private static Contract createContract(Building building, String rentalPeriod, float price) {
        return new Contract(rentalPeriod, price, building);
    }

    private static PaymentWay selectPaymentWay() {
        System.out.println("Select payment method: ");
        System.out.println("1. PayPal");
        System.out.println("2. MasterCard");
        System.out.println("3. Visa");
        int choice = scanner.nextInt();
        System.out.println("**************************************");
        switch (choice) {
            case 1:
                return new PayPal();
            case 2:
                return new MasterCard();
            case 3:
                return new VisaCard();
            default:
                throw new IllegalArgumentException("Invalid payment method.");
        }
    }

    public static void printDetails(Customer customer) {
        customer.printData();
        System.out.println("**************************************");
    }

    public static void processPayments(Customer customer) {
        System.out.println("Processing Payments ..........");
        customer.pay();
        System.out.println("Payments processes successfully ..........");
    }
}