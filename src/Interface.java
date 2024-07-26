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


        // Add banner
        JLabel banner = new JLabel("Enter your income for the financial year:");
        banner.setPreferredSize(new Dimension(300, 50));
        banner.setFont(new Font("Arial", Font.BOLD, 20));

        // Bottom banner
        JLabel taxLiteralLabel = new JLabel("Your Calculated Tax Liability: ");
        taxLiteralLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        // create text field
        JTextField fieldTotalIncome = new JTextField();
        fieldTotalIncome.setFont(new Font("Arial", Font.PLAIN, 20));
        fieldTotalIncome.setPreferredSize(new Dimension(200, 30)); // Example dimensions


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
                TaxCalculator taxCalc = new TaxCalculator(inputIncomeDouble);
                // TODO: Sanitise user input to make sure it is a number
                String taxLiability = String.valueOf(taxCalc.getTaxLiability());

                // Update UI with users tax liability
                updateTaxLiability(taxLiteralLabel, taxLiability);
            }
        });

        // Add objects to panel
        frame.add(panel);
        panel.add(banner);
        panel.add(fieldTotalIncome);
        panel.add(calcButton);
        panel.add(taxLiteralLabel);

        frame.setVisible(true);
    }

}
