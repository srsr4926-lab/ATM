import java.util.Scanner;

class ATM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int balance = 1000000;
        int choice, amount;

        System.out.println("===== ATM MACHINE SERVICES =====");
        System.out.println("1. Balance Enquiry");
        System.out.println("2. Cash Withdrawal");
        System.out.println("3. Cash Deposit");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Your Balance is: ₹" + balance);
                break;

            case 2:
                System.out.print("Enter amount to withdraw: ");
                amount = sc.nextInt();
                if (amount <= balance) {
                    balance = balance - amount;
                    System.out.println("Please collect your cash");
                    System.out.println("Remaining Balance: ₹" + balance);
                } else {
                    System.out.println("Insufficient Balance");
                }
                break;

            case 3:
                System.out.print("Enter amount to deposit: ");
                amount = sc.nextInt();
                balance = balance + amount;
                System.out.println("Amount Deposited Successfully");
                System.out.println("Updated Balance: ₹" + balance);
                break;

            case 4:
                System.out.println("Thank you for using ATM");
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}
