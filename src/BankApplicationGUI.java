import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankApplicationGUI extends JFrame implements ActionListener {
    private static final String CARD_MAIN = "Main";
    private static final String CARD_NEW_ACC = "NewAccount";
    private static final String CARD_LOGIN = "Login";
    private static final String CARD_ACC_MENU = "AccountMenu";
    private static final String CARD_TRANSACTION = "Transaction";

    private BankLogic.Bank bank = new BankLogic.Bank();
    private BankLogic.Account currentAccount = null;

    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);

    // Common Components
    private JTextField loginAccNumField, loginPinField;
    private JLabel accMenuHeaderLabel, accMenuBalanceLabel;
    private JTextField newAccNameField, newAccDepositField, newAccPinField;
    private JTextField transactionAmountField;
    private JButton depositButton, withdrawButton;
    private JLabel transactionHeaderLabel;

    private InterfacePanels interfacePanels;
    private ActionHandlers actionHandlers;

    public BankApplicationGUI() {
        setTitle("ACME Bank Application System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);

        // Initialize helper classes
        interfacePanels = new InterfacePanels(this, bank);
        actionHandlers = new ActionHandlers(this, bank, interfacePanels);

        // Add card panel to the frame
        add(cardPanel);

        // Initialize and add all interfaces (panels)
        cardPanel.add(interfacePanels.createInterface1(), CARD_MAIN);
        cardPanel.add(interfacePanels.createInterface2(), CARD_NEW_ACC);
        cardPanel.add(interfacePanels.createLoginPanel(), CARD_LOGIN);
        cardPanel.add(interfacePanels.createInterface3(), CARD_ACC_MENU);
        cardPanel.add(interfacePanels.createInterface4(), CARD_TRANSACTION);

        // Set component references
        loginAccNumField = interfacePanels.getLoginAccNumField();
        loginPinField = interfacePanels.getLoginPinField();
        accMenuHeaderLabel = interfacePanels.getAccMenuHeaderLabel();
        accMenuBalanceLabel = interfacePanels.getAccMenuBalanceLabel();
        newAccNameField = interfacePanels.getNewAccNameField();
        newAccDepositField = interfacePanels.getNewAccDepositField();
        newAccPinField = interfacePanels.getNewAccPinField();
        transactionAmountField = interfacePanels.getTransactionAmountField();
        depositButton = interfacePanels.getDepositButton();
        withdrawButton = interfacePanels.getWithdrawButton();
        transactionHeaderLabel = interfacePanels.getTransactionHeaderLabel();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        try {
            switch (command) {
                case "NEW_ACCOUNT":
                    cardLayout.show(cardPanel, CARD_NEW_ACC);
                    break;
                case "LOGIN_SCREEN":
                    cardLayout.show(cardPanel, CARD_LOGIN);
                    break;
                case "BACK_MAIN_FROM_NEW":
                case "BACK_MAIN_FROM_LOGIN":
                    cardLayout.show(cardPanel, CARD_MAIN);
                    break;
                case "CREATE_ACCOUNT":
                    actionHandlers.handleCreateAccount();
                    break;
                case "PERFORM_LOGIN":
                    actionHandlers.handleLogin();
                    break;
                case "CHECK_BALANCE":
                    actionHandlers.displayBalance();
                    break;
                case "GO_TO_TRANSACTION":
                    actionHandlers.prepareTransactionScreen();
                    cardLayout.show(cardPanel, CARD_TRANSACTION);
                    break;
                case "DEPOSIT":
                    actionHandlers.handleTransaction("deposit");
                    break;
                case "WITHDRAW":
                    actionHandlers.handleTransaction("withdraw");
                    break;
                case "BACK_TO_ACC_MENU":
                    actionHandlers.displayBalance();
                    cardLayout.show(cardPanel, CARD_ACC_MENU);
                    break;
                case "LOGOUT":
                    currentAccount = null;
                    JOptionPane.showMessageDialog(this, "Logged out successfully.", "Logout", JOptionPane.INFORMATION_MESSAGE);
                    cardLayout.show(cardPanel, CARD_MAIN);
                    break;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Getters for components used by ActionHandlers
    public JTextField getLoginAccNumField() { return loginAccNumField; }
    public JTextField getLoginPinField() { return loginPinField; }
    public JLabel getAccMenuHeaderLabel() { return accMenuHeaderLabel; }
    public JLabel getAccMenuBalanceLabel() { return accMenuBalanceLabel; }
    public JTextField getNewAccNameField() { return newAccNameField; }
    public JTextField getNewAccDepositField() { return newAccDepositField; }
    public JTextField getNewAccPinField() { return newAccPinField; }
    public JTextField getTransactionAmountField() { return transactionAmountField; }
    public JLabel getTransactionHeaderLabel() { return transactionHeaderLabel; }
    public BankLogic.Account getCurrentAccount() { return currentAccount; }
    public void setCurrentAccount(BankLogic.Account account) { this.currentAccount = account; }
    public CardLayout getCardLayout() { return cardLayout; }
    public JPanel getCardPanel() { return cardPanel; }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankApplicationGUI());
    }
}