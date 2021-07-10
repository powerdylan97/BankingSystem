
public class CheckingAccount implements Account{
	double checkingBalance = 0;
	
	@Override
	public double getBalance() {
		return this.checkingBalance;
	}
	
	@Override
	public void deposit(double amount) {
		checkingBalance += amount;
	}

	@Override
	public void withdrawal(double amount) {
		checkingBalance -= amount;
	}
}
