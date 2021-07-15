import java.awt.event.*;
import javax.swing.*;
public class ATM {
	static JFrame f;
	static JPanel welcomePanel, checkingPanel, depositPanel, confirmdPanel, confirmedDep, withdrawalPanel;
	public static void main(String [] args){
		f = new JFrame("USABank ATM");
		f.setSize(400, 300);
		showWelcome();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void showWelcome() {
		welcomePanel = new JPanel();
		JLabel welcomeLabel = new JLabel("Welcome to USABank which account would you like access to?");
		welcomePanel.add(welcomeLabel);
		JButton checkingBut = new JButton("CHECKING:");
		JButton savingsBut = new JButton("SAVINGS:");
		welcomePanel.add(checkingBut);
		welcomePanel.add(savingsBut);
		checkingBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String acc = "CHECKING";
				showNext(acc);
			}
		});
		savingsBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String acc = "SAVINGS";
				showNext(acc);
			}
		});
		f.add(welcomePanel);
		f.setVisible(true);
	}
	public static void showNext(String acc) {
		f.remove(welcomePanel);
		checkingPanel = new JPanel();
		JLabel checkingLabel = new JLabel("Would you like to Withdrawal or Deposit into " + acc + "?");
		JButton depositBut = new JButton("DEPOSIT:");
		JButton withdrawalBut = new JButton("WITHDRAWAL:");
		checkingPanel.add(checkingLabel);
		checkingPanel.add(depositBut);
		checkingPanel.add(withdrawalBut);
		f.add(checkingPanel);
		f.setVisible(true);
		depositBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = "DEPOSIT";
				showDeposit(acc, action);
			}
		});
		withdrawalBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = "WITHDRAWAL";
				showDeposit(acc, action);
			}
		});
	}
	public static void showDeposit(String acc, String action) {
		f.remove(checkingPanel);
		depositPanel = new JPanel();
		JLabel depositMes = new JLabel("How much would you like to " +action+"?");
		JTextField depositInp = new JTextField("$00.00", 20);
		JButton depositEnter = new JButton("ENTER");
		depositPanel.add(depositInp);
		depositPanel.add(depositEnter);
		depositPanel.add(depositMes);
		f.add(depositPanel);
		f.setVisible(true);
		depositEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.remove(depositPanel);
				String amount = depositInp.getText();
				confirmdPanel = new JPanel();
				JLabel confirm = new JLabel("Are you sure you would like to "+action +": "+ amount);
				JButton yes = new JButton("YES");
				JButton no = new JButton("NO");
				confirmdPanel.add(confirm);
				confirmdPanel.add(yes);
				confirmdPanel.add(no);
				f.add(confirmdPanel);
				yes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						deposit(Double.parseDouble(amount),acc, action);
					}
				});
				no.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				f.setVisible(true);
			}
		});
	}
	public static void deposit(Double amount, String acc, String action) {
		f.remove(confirmdPanel);
		confirmedDep = new JPanel();
		if(acc.equals("CHECKING") && action.equals("DEPOSIT")) {
			BankGui.checkingacc.deposit(amount);
			JLabel showBal = new JLabel("Your "+acc+ " balance is now = " + BankGui.checkingacc.getBalance());
			confirmedDep.add(showBal);
		}
		if(acc.equals("SAVINGS") && action.equals("DEPOSIT")) {
			BankGui.savingsacc.deposit(amount);
			JLabel showBal = new JLabel("Your "+acc+ " balance is now = " + BankGui.savingsacc.getBalance());
			confirmedDep.add(showBal);
		}
		if(acc.equals("CHECKING") && action.equals("WITHDRAWAL")) {
			BankGui.checkingacc.withdrawal(amount);
			JLabel showBal = new JLabel("Your "+acc+ " balance is now = " + BankGui.checkingacc.getBalance());
			confirmedDep.add(showBal);
		}
		if(acc.equals("SAVINGS") && action.equals("WITHDRAWAL")) {
			BankGui.savingsacc.withdrawal(amount);
			JLabel showBal = new JLabel("Your "+acc+ " balance is now = " + BankGui.savingsacc.getBalance());
			confirmedDep.add(showBal);
		}
	
		JButton exit = new JButton("EXIT");
		JButton main = new JButton("MAIN");
		confirmedDep.add(exit);
		confirmedDep.add(main);
		f.add(confirmedDep);
		f.setVisible(true);
		main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.remove(confirmedDep);
				showWelcome();
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}