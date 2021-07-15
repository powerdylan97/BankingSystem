import java.util.Scanner;


public class Bank  {

	static SavingsAccount savings = new SavingsAccount();
	static CheckingAccount checking = new CheckingAccount();
	static boolean keep = true;
	public static void main(String[] args) {
		
		while(keep) {
			System.out.println("Welcome to USABank!");
			System.out.println("What would you like to do today?");
			System.out.println("1.) Withdrawal from Checking.");
			System.out.println("2.) Withdrawal from Savings.");
			System.out.println("3.) Deposit into Checking.");
			System.out.println("4.) Deposit into Savings.");
			System.out.println("5.) View Balance.");
			getUserInput();
			printEndingMessage();
		}
	}
	public static void getUserInput() {
		int userInp;
		Scanner scan = new Scanner(System.in);
		userInp = scan.nextInt();
		switch(userInp) {
			case 1:
				System.out.println("How much would you like to withdrawal from checking?");
				double withDrawalC = scan.nextDouble();
				checking.withdrawal(withDrawalC);
				break;
			case 2:
				System.out.println("How much would you like to withdrawal from savings?");
				double withDrawalS = scan.nextDouble();
				savings.withdrawal(withDrawalS);
				break;
			case 3:
				System.out.println("How much would you like to deposit into checking.");
				double depositC = scan.nextDouble();
				checking.deposit(depositC);
				break;
			case 4:
				System.out.println("How much would you like to deposit into savings?");
				double depositS = scan.nextDouble();
				savings.deposit(depositS);
				break;
			case 5:
				break;
		}
		scan.close();
	}
	public static void printEndingMessage() {
		System.out.println("TRANSACTION COMPLETED YOUR BALANCES ARE NOW ");
		System.out.println("CHECKING: " + checking.getBalance());
		System.out.println("SAVINGS: " + savings.getBalance());
		System.out.println("Would you like anything else today?(Y/N)");
		Scanner scan = new Scanner(System.in);
		String response = scan.nextLine();
		switch(response) {
			case "N":
			case "n":
				keep = false;
				System.out.println("Thank you for using USABank, have a nice day!");
				break;
			default:
				keep = true;
		}
		scan.close();
	}
}
