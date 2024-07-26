import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Application {
    public Application() {
        this.setupComponents();
    }

    private void setupComponents() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = 17;
        JLabel lblAppHeader = new JLabel("---Tradie Tax Calculator ---", 0);
        lblAppHeader.setFont(new Font("Arial", 1, 20));
        frame.add(lblAppHeader, "North");
        JLabel lblIncome = new JLabel("Total Income: $");
        lblIncome.setFont(new Font("Arial", 1, 20));
        final JTextField txtIncome = new JTextField(15);
        txtIncome.setFont(new Font("Arial", 0, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(lblIncome, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtIncome, gbc);
        JLabel lblToolsCost = new JLabel("Total Spent on Tools: $");
        lblToolsCost.setFont(new Font("Arial", 1, 20));
        final JTextField txtToolsCost = new JTextField(15);
        txtToolsCost.setFont(new Font("Arial", 0, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(lblToolsCost, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtToolsCost, gbc);
        frame.add(mainPanel, "West");
        final JLabel lblTaxLiability = new JLabel("Tax Liability: $");
        lblTaxLiability.setFont(new Font("Arial", 1, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(lblTaxLiability, gbc);
        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setFont(new Font("Arial", 1, 22));
        gbc.gridy = 3;
        mainPanel.add(btnCalculate, gbc);
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInputIncome = txtIncome.getText();
                String userInputToolsCost = txtToolsCost.getText();
                double inputIncomeDouble = Double.parseDouble(userInputIncome);
                double inputToolsCostDouble = Double.parseDouble(userInputToolsCost);
                TaxCalculator taxCalc = new TaxCalculator(inputIncomeDouble, inputToolsCostDouble);
                String taxLiability = String.valueOf(taxCalc.getTaxLiability());
                lblTaxLiability.setText("Tax Liability: $" + taxLiability);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
