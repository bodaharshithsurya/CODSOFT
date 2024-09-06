import your.ATM.name.BankAccount; 
public class ATMMain {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();

            if (choice == 4) {
                break;
            }

            atm.processTransaction(choice);
        }
    }
}