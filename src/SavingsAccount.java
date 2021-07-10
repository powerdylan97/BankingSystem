
public class SavingsAccount implements Account{
	double savingsBalance=0;
	
	@Override
	public double getBalance() {
		return this.savingsBalance;
	}

	@Override
	public void deposit(double amount) {
		savingsBalance += amount;
	}

	@Override
	public void withdrawal(double amount) {
		savingsBalance -= amount;
	}

}
