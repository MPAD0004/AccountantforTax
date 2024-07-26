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
        // Create frame and set layout to BorderLayout
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create new Panel to house fields
        frame.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = 17;

        // Create header label and add to frame
        JLabel lblAppHeader = new JLabel("---Tradie Tax Calculator ---", 0);
        lblAppHeader.setFont(new Font("Arial", 1, 20));
        frame.add(lblAppHeader, "North");

        JLabel lblIncome = new JLabel("Total Income: $");
        lblIncome.setFont(new Font("Arial", 1, 20));
        final JTextField txtIncome = new JTextField(15);
        txtIncome.setFont(new Font("Arial", 0, 18));

        // Add lbl to left
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(lblIncome, gbc);
        // Add txt field adjacent
        gbc.gridx = 1;
        mainPanel.add(txtIncome, gbc);

        // Add toolscost label and field
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

        // Add distanceTravelled label and field
        JLabel lblDistanceTravelled = new JLabel("Distance Driven to Work (km): ");
        lblDistanceTravelled.setFont(new Font("Arial", 1, 20));
        final JTextField txtDistanceTravelled = new JTextField(15);
        txtDistanceTravelled.setFont(new Font("Arial", 0, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(lblDistanceTravelled, gbc);
        gbc.gridx = 1;
        mainPanel.add(txtDistanceTravelled, gbc);


        // Add taxLiability which will show the output to user
        final JLabel lblTaxLiability = new JLabel("Tax Liability: $");
        lblTaxLiability.setFont(new Font("Arial", 1, 20));
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(lblTaxLiability, gbc);

        // Add button
        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setFont(new Font("Arial", 1, 22));
        gbc.gridy = 4;
        mainPanel.add(btnCalculate, gbc);

        // Button event listener
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double toolsCostDouble = 0;  // Default cast for deductions
                double distanceTravelledDouble = 0;
                String userInputIncome = txtIncome.getText();
                String userInputToolsCost = txtToolsCost.getText();
                String userInputDistanceTravelled = txtDistanceTravelled.getText();

                // Convert input distance from String to double
                if (!userInputDistanceTravelled.isEmpty()){
                    distanceTravelledDouble = Double.parseDouble(txtDistanceTravelled.getText());
                }
                // Safe conversion to number if no deductions
                if (!userInputToolsCost.isEmpty()){
                    toolsCostDouble = Double.parseDouble(userInputToolsCost);
                }
                double inputIncomeDouble = Double.parseDouble(userInputIncome);
                TaxCalculator taxCalc = new TaxCalculator(inputIncomeDouble, toolsCostDouble, distanceTravelledDouble);
                String taxLiability = String.valueOf(taxCalc.getTaxLiability());
                lblTaxLiability.setText("Tax Liability: $" + taxLiability);
            }
        });

        // Pack and show
        frame.pack();
        frame.setVisible(true);
    }
}
