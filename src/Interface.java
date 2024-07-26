import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {

    public Interface(){
        setInitialLayout();
    }

    // Update UI with users tax liability
    private void updateTaxLiability(JLabel taxLiableLabel, String taxLiability){
        // create UI objects
        taxLiableLabel.setText("Your Calculated Tax Liability: $" + taxLiability);
    }

    // set the initial ui layout
    private void setInitialLayout(){
        JFrame frame = new JFrame("Tradie Tax Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        // Application header label
        JLabel banner = new JLabel("Total income for the financial year 2024-2025:");
        banner.setPreferredSize(new Dimension(500, 80));
        banner.setFont(new Font("Arial", Font.BOLD, 20));

        // Bottom footer label
        JLabel taxLiteralLabel = new JLabel("Your Calculated Tax Liability: ");
        taxLiteralLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        // Total income text field
        JTextField fieldTotalIncome = new JTextField();
        fieldTotalIncome.setFont(new Font("Arial", Font.PLAIN, 20));

        // Field for cost of tools
        JLabel labelToolsCost = new JLabel("Cost of Tools: ");
        labelToolsCost.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField fieldToolsCost = new JTextField();
        fieldToolsCost.setFont(new Font("Arial", Font.PLAIN, 20));


        // Create a button
        JButton calcButton = new JButton("Submit");

        // Add an action listener to the button
        calcButton.addActionListener(new ActionListener() {
            @Override
            // When button is pressed, extract user input and perform calculations
            public void actionPerformed(ActionEvent e) {
                // Get user input and convert to double
                String userInputIncome = fieldTotalIncome.getText();
                double inputIncomeDouble = Double.parseDouble(userInputIncome);

                // Calculate tax liability
                //TaxCalculator taxCalc = new TaxCalculator(inputIncomeDouble);
                // TODO: Sanitise user input to make sure it is a number
                //String taxLiability = String.valueOf(taxCalc.getTaxLiability());

                // Update UI with users tax liability
                //updateTaxLiability(taxLiteralLabel, taxLiability);
            }
        });

        // Add objects to panel
        frame.add(panel);
        panel.add(banner);
        panel.add(fieldTotalIncome);
        panel.add(labelToolsCost, BorderLayout.WEST);
        panel.add(fieldToolsCost, BorderLayout.CENTER);
        panel.add(calcButton);
        panel.add(taxLiteralLabel);

        // pack and make visible
        frame.pack();
        frame.setVisible(true);

    }

}
