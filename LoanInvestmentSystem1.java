import java.util.*;

 class LoanInvestmentSystem1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Borrower> borrowers = new ArrayList<>();
        ArrayList<Investor> investors = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Loan Investment System ---");
            System.out.println("1. Add Borrower");
            System.out.println("2. Add Investor");
            System.out.println("3. View Borrowers");
            System.out.println("4. View Investors");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Borrower Name: ");
                    String bName = sc.next();
                    System.out.print("Enter Borrower ID: ");
                    int bId = sc.nextInt();
                    System.out.print("Enter Loan Amount: ");
                    double loan = sc.nextDouble();
                    System.out.print("Enter Interest Rate: ");
                    double rate = sc.nextDouble();

                    borrowers.add(new Borrower(bName, bId, loan, rate));
                    System.out.println("Borrower Added Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Investor Name: ");
                    String iName = sc.next();
                    System.out.print("Enter Investor ID: ");
                    int iId = sc.nextInt();
                    System.out.print("Enter Investment Amount: ");
                    double invest = sc.nextDouble();

                    investors.add(new Investor(iName, iId, invest));
                    System.out.println("Investor Added Successfully!");
                    break;

                case 3:
                    System.out.println("\n--- Borrower Details ---");
                    for (Borrower b : borrowers) {
                        System.out.println("Name: " + b.name +
                                ", Loan: " + b.loanAmount +
                                ", Interest: " + b.calculateInterest());
                    }
                    break;

                case 4:
                    System.out.println("\n--- Investor Details ---");
                    for (Investor i : investors) {
                        System.out.println("Name: " + i.name +
                                ", Investment: " + i.investment);
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
