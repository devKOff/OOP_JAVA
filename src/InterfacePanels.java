import javax.swing.*;
import java.awt.*;

public class InterfacePanels {
    private JTextField loginAccNumField, loginPinField;
    private JLabel accMenuHeaderLabel, accMenuBalanceLabel;
    private JTextField newAccNameField, newAccDepositField, newAccPinField;
    private JTextField transactionAmountField;
    private JButton depositButton, withdrawButton;
    private JLabel transactionHeaderLabel;
    private BankApplicationGUI gui;
    private BankLogic.Bank bank;

    public InterfacePanels(BankApplicationGUI gui, BankLogic.Bank bank) {
        this.gui = gui;
        this.bank = bank;
    }

    // Interface 1: Main Menu
    public JPanel createInterface1() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel header = new JLabel("ACME BANK", SwingConstants.CENTER);
        header.setFont(new Font("SansSerif", Font.BOLD, 24));

        JButton newAccBtn = new JButton("New Account");
        newAccBtn.setActionCommand("NEW_ACCOUNT");
        newAccBtn.addActionListener(gui);

        JButton existingAccBtn = new JButton("Already Have Account");
        existingAccBtn.setActionCommand("LOGIN_SCREEN");
        existingAccBtn.addActionListener(gui);

        panel.add(header, gbc);
        panel.add(Box.createVerticalStrut(20), gbc);
        panel.add(newAccBtn, gbc);
        panel.add(existingAccBtn, gbc);

        return panel;
    }

    // Interface 1/3: Login Panel
    public JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel header = new JLabel("Existing Account Login", SwingConstants.CENTER);
        header.setFont(new Font("SansSerif", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(header, gbc);

        gbc.gridwidth = 1; gbc.gridy = 1; gbc.gridx = 0; gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Account Number:"), gbc);
        loginAccNumField = new JTextField(15);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panel.add(loginAccNumField, gbc);

        gbc.gridy = 2; gbc.gridx = 0; gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("PIN:"), gbc);
        loginPinField = new JPasswordField(15);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panel.add(loginPinField, gbc);

        JButton loginBtn = new JButton("Login");
        loginBtn.setActionCommand("PERFORM_LOGIN");
        loginBtn.addActionListener(gui);
        gbc.gridy = 3; gbc.gridx = 0; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(loginBtn, gbc);

        JButton backBtn = new JButton("Back to Main");
        backBtn.setActionCommand("BACK_MAIN_FROM_LOGIN");
        backBtn.addActionListener(gui);
        gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(backBtn, gbc);

        return panel;
    }

    // Interface 2: New Account
    public JPanel createInterface2() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel header = new JLabel("New Account Creation (Min Deposit: $" + bank.getMinBalance() + ")", SwingConstants.CENTER);
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(header, gbc);

        gbc.gridwidth = 1; gbc.gridy = 1; gbc.gridx = 0; gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Full Name (KYC):"), gbc);
        newAccNameField = new JTextField(15);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panel.add(newAccNameField, gbc);

        gbc.gridy = 2; gbc.gridx = 0; gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Initial Deposit ($):"), gbc);
        newAccDepositField = new JTextField(15);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panel.add(newAccDepositField, gbc);

        gbc.gridy = 3; gbc.gridx = 0; gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("4-Digit PIN:"), gbc);
        newAccPinField = new JPasswordField(15);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panel.add(newAccPinField, gbc);

        JButton createBtn = new JButton("Create Account");
        createBtn.setActionCommand("CREATE_ACCOUNT");
        createBtn.addActionListener(gui);
        gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(createBtn, gbc);

        JButton backBtn = new JButton("Back to Main");
        backBtn.setActionCommand("BACK_MAIN_FROM_NEW");
        backBtn.addActionListener(gui);
        gbc.gridy = 5; gbc.gridx = 0; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(backBtn, gbc);

        return panel;
    }

    // Interface 3: Account Menu
    public JPanel createInterface3() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 0, 8, 0);

        accMenuHeaderLabel = new JLabel("Account:", SwingConstants.CENTER);
        accMenuHeaderLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(accMenuHeaderLabel, gbc);

        accMenuBalanceLabel = new JLabel("Balance: N/A", SwingConstants.CENTER);
        accMenuBalanceLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panel.add(accMenuBalanceLabel, gbc);

        panel.add(Box.createVerticalStrut(10), gbc);

        JButton checkBalanceBtn = new JButton("Check Balance");
        checkBalanceBtn.setActionCommand("CHECK_BALANCE");
        checkBalanceBtn.addActionListener(gui);
        panel.add(checkBalanceBtn, gbc);

        JButton transactionBtn = new JButton("Transaction");
        transactionBtn.setActionCommand("GO_TO_TRANSACTION");
        transactionBtn.addActionListener(gui);
        panel.add(transactionBtn, gbc);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setActionCommand("LOGOUT");
        logoutBtn.addActionListener(gui);
        panel.add(logoutBtn, gbc);

        return panel;
    }

    // Interface 4: Transaction Menu
    public JPanel createInterface4() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        transactionHeaderLabel = new JLabel("Transaction for Account [N/A]", SwingConstants.CENTER);
        transactionHeaderLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(transactionHeaderLabel, gbc);

        gbc.gridwidth = 1; gbc.gridy = 1; gbc.gridx = 0; gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Amount ($):"), gbc);
        transactionAmountField = new JTextField(15);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panel.add(transactionAmountField, gbc);

        depositButton = new JButton("Deposit");
        depositButton.setActionCommand("DEPOSIT");
        depositButton.addActionListener(gui);
        gbc.gridy = 2; gbc.gridx = 0; gbc.gridwidth = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(depositButton, gbc);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setActionCommand("WITHDRAW");
        withdrawButton.addActionListener(gui);
        gbc.gridx = 1;
        panel.add(withdrawButton, gbc);

        JButton backBtn = new JButton("Back to Account Menu");
        backBtn.setActionCommand("BACK_TO_ACC_MENU");
        backBtn.addActionListener(gui);
        gbc.gridy = 3; gbc.gridx = 0; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(backBtn, gbc);

        return panel;
    }

    // Getters for components
    public JTextField getLoginAccNumField() { return loginAccNumField; }
    public JTextField getLoginPinField() { return loginPinField; }
    public JLabel getAccMenuHeaderLabel() { return accMenuHeaderLabel; }
    public JLabel getAccMenuBalanceLabel() { return accMenuBalanceLabel; }
    public JTextField getNewAccNameField() { return newAccNameField; }
    public JTextField getNewAccDepositField() { return newAccDepositField; }
    public JTextField getNewAccPinField() { return newAccPinField; }
    public JTextField getTransactionAmountField() { return transactionAmountField; }
    public JButton getDepositButton() { return depositButton; }
    public JButton getWithdrawButton() { return withdrawButton; }
    public JLabel getTransactionHeaderLabel() { return transactionHeaderLabel; }
}