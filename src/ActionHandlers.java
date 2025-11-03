import javax.swing.*;

public class ActionHandlers {
    private BankApplicationGUI gui;
    private BankLogic.Bank bank;
    private InterfacePanels interfacePanels;

    public ActionHandlers(BankApplicationGUI gui, BankLogic.Bank bank, InterfacePanels interfacePanels) {
        this.gui = gui;
        this.bank = bank;
        this.interfacePanels = interfacePanels;
    }

    public void handleCreateAccount() {
        try {
            String name = interfacePanels.getNewAccNameField().getText().trim();
            double deposit = Double.parseDouble(interfacePanels.getNewAccDepositField().getText());
            int pin = Integer.parseInt(interfacePanels.getNewAccPinField().getText());

            if (name.isEmpty() || interfacePanels.getNewAccPinField().getText().length() != 4) {
                throw new IllegalArgumentException("Please enter a valid name and a 4-digit PIN.");
            }

            BankLogic.Account newAccount = bank.createAccount(name, deposit, pin);

            JOptionPane.showMessageDialog(gui,
                    "SUCCESS! Your account has been created.\n" +
                            "Account Name: " + newAccount.getAccountHolderName() + "\n" +
                            "Account Number: " + newAccount.getAccountNumber(),
                    "Account Created", JOptionPane.INFORMATION_MESSAGE);

            interfacePanels.getNewAccNameField().setText("");
            interfacePanels.getNewAccDepositField().setText("");
            interfacePanels.getNewAccPinField().setText("");
            gui.getCardLayout().show(gui.getCardPanel(), "Main");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(gui, "Invalid input for deposit or PIN.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(gui, "Creation Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void handleLogin() {
        try {
            String accNum = interfacePanels.getLoginAccNumField().getText().trim();
            int pin = Integer.parseInt(interfacePanels.getLoginPinField().getText());

            BankLogic.Account account = bank.login(accNum, pin);
            if (account != null) {
                gui.setCurrentAccount(account);
                displayBalance();
                JOptionPane.showMessageDialog(gui, "Login successful. Welcome, " + account.getAccountHolderName() + "!", "Success", JOptionPane.INFORMATION_MESSAGE);

                interfacePanels.getLoginAccNumField().setText("");
                interfacePanels.getLoginPinField().setText("");
                gui.getCardLayout().show(gui.getCardPanel(), "AccountMenu");
            } else {
                JOptionPane.showMessageDialog(gui, "Login failed. Account number or PIN is incorrect.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(gui, "Invalid PIN format.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayBalance() {
        BankLogic.Account currentAccount = gui.getCurrentAccount();
        if (currentAccount != null) {
            interfacePanels.getAccMenuHeaderLabel().setText("[3] Account: " + currentAccount.getAccountHolderName());
            interfacePanels.getAccMenuBalanceLabel().setText(String.format("Current Balance: $%.2f", currentAccount.getBalance()));
        }
    }

    public void prepareTransactionScreen() {
        BankLogic.Account currentAccount = gui.getCurrentAccount();
        if (currentAccount != null) {
            interfacePanels.getTransactionHeaderLabel().setText("Transaction for Account [" + currentAccount.getAccountNumber() + "]");
            interfacePanels.getTransactionAmountField().setText("");
        }
    }

    public void handleTransaction(String type) {
        BankLogic.Account currentAccount = gui.getCurrentAccount();
        if (currentAccount == null) return;

        try {
            double amount = Double.parseDouble(interfacePanels.getTransactionAmountField().getText());

            if (type.equals("deposit")) {
                bank.deposit(currentAccount.getAccountNumber(), amount);
                JOptionPane.showMessageDialog(gui, String.format("SUCCESS: Deposited $%.2f.", amount), "Deposit Success", JOptionPane.INFORMATION_MESSAGE);
            } else if (type.equals("withdraw")) {
                bank.withdraw(currentAccount.getAccountNumber(), amount);
                JOptionPane.showMessageDialog(gui, String.format("SUCCESS: Withdrew $%.2f.", amount), "Withdrawal Success", JOptionPane.INFORMATION_MESSAGE);
            }
            interfacePanels.getTransactionAmountField().setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(gui, "Invalid amount format.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(gui, "Transaction Error: " + e.getMessage(), "Transaction Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}