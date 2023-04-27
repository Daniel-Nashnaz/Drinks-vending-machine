import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame implements ActionListener {
    private JLabel stateLabel;

    private JPanel bottomPanel;
    private JPanel topPanel;
    private JLabel titleLabel;

    private JPanel buttonPanel;

    private JButton coffeeButton;

    private JButton teaButton;
    private JButton waterButton;
    private JButton chocolateButton;

    private Client client;

    public ClientGUI() {
        setTitle("Coffee Machine");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(400, 500);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 245, 245));
        stateLabel = new JLabel("");
        bottomPanel = new JPanel();
        topPanel = new JPanel();
        topPanel.setBackground(new Color(253, 204, 159));
        titleLabel = new JLabel("Select Your Drink");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        topPanel.add(titleLabel);

        add(topPanel, BorderLayout.NORTH);
        buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBackground(new Color(255, 230, 204));

        chocolateButton = new JButton("Chocolate");
        chocolateButton.setForeground(Color.WHITE);
        chocolateButton.setBackground(new Color(231, 213, 210, 255));
        chocolateButton.setPreferredSize(new Dimension(200, 50));
        chocolateButton.setFont(new Font("Arial", Font.PLAIN, 18));
        chocolateButton.addActionListener(this);

        coffeeButton = new JButton("Coffee");
        coffeeButton.setForeground(Color.WHITE);
        coffeeButton.setBackground(new Color(92, 76, 57));
        coffeeButton.setPreferredSize(new Dimension(200, 50));
        coffeeButton.setFont(new Font("Arial", Font.PLAIN, 18));
        coffeeButton.addActionListener(this);

        teaButton = new JButton("Tea");
        teaButton.setForeground(Color.WHITE);
        teaButton.setBackground(new Color(239, 163, 72));
        teaButton.setPreferredSize(new Dimension(200, 50));
        teaButton.setFont(new Font("Arial", Font.PLAIN, 18));
        teaButton.addActionListener(this);

        waterButton = new JButton("Water");
        waterButton.setForeground(Color.WHITE);
        waterButton.setBackground(new Color(158, 233, 243));
        waterButton.setPreferredSize(new Dimension(200, 50));
        waterButton.setFont(new Font("Arial", Font.PLAIN, 18));
        waterButton.addActionListener(this);

        buttonPanel.add(chocolateButton);
        buttonPanel.add(coffeeButton);
        buttonPanel.add(teaButton);
        buttonPanel.add(waterButton);
        bottomPanel.setBackground(new Color(245, 245, 245));
        stateLabel.setText("Awaiting selection.");
        stateLabel.setFont(new Font("Arial", Font.BOLD, 18));
        bottomPanel.add(stateLabel);
        add(buttonPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
        client = new Client();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                client.writeToServer("exit");
                client.close();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new ClientGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.chocolateButton) {
            this.stateLabel.setText("prepares the drink...");
            client.writeToServer("chocolate");
            getResultFromServer();
        } else if (e.getSource() == this.coffeeButton) {
            this.stateLabel.setText("prepares the drink...");
            client.writeToServer("coffee");
            getResultFromServer();
        } else if (e.getSource() == this.teaButton) {
            this.stateLabel.setText("prepares the drink...");
            client.writeToServer("tea");
            getResultFromServer();
        } else if (e.getSource() == this.waterButton) {
            this.stateLabel.setText("prepares the drink...");
            client.writeToServer("water");
            getResultFromServer();
        }
    }




    private void getResultFromServer() {
        String serverResponse = client.readFromServer();
        if (serverResponse != null) {
            this.stateLabel.setText(serverResponse);
        } else {
            this.stateLabel.setText("Error: server did not send a response");
        }

    }
}

