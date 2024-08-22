import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

}

class Atm {
    private BankAccount account;

    public Atm(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("ATM Interface");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");

    }

    public void checkBalance() {
        System.out.printf("Current Balance: %.2f\n", account.getBalance());
    }

    public void depositMoney(double amount) {
        if (account.deposit(amount)) {
            System.out.printf("Successfully deposited %.2f. New Balance: %.2f\n", amount, account.getBalance());
        } else {
            System.out.println("Deposit Filed.Please enter a valid amount.");
        }
    }

    public void WithdrawMoney(double amount) {
        if (account.withdraw(amount)) {
            System.out.printf("Successfully withdraw %.2f. New Balance: %.2f\n", amount, account.getBalance());
        } else {
            System.out.println("Withdrawal Failed.Insufficient balance or invalid amount.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.00);
        Atm atm = new Atm(account);

        while (true) {
            atm.displayMenu();
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    atm.depositMoney(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    atm.WithdrawMoney(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.GoodBye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invlid choice .Please try again.");
            }
        }
    }

}
