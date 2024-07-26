// Class contains methods for backend tax calculation
public class TaxCalculator {
    private double income;
    private double taxLiability = 0;

    // Print users income and tax details to the screen
    public void showTaxDetails(){
        System.out.printf("My Income: %f\n", this.income);
        System.out.printf("Tax Liability: %f\n", this.taxLiability);
    }

    // Constructor sets attributes
    public TaxCalculator(double income){
        this.income = income;
        calculateTaxLiability();
        showTaxDetails();
    }

    // Based on income, calculate tax payable
    private void calculateTaxLiability(){
        // Calculate tax payable for each tax bracket
        // 0-$18,2000 : Nil

        // $18,201 - $45,000: 16c for each $1 over $18,200
        if (this.income > 190001){
            this.taxLiability =  (51638 + .45 * (this.income - 190000));
        }else if (this.income >= 135001 && this.income <= 190000){
            this.taxLiability += (31288 + .37 * (this.income - 135000));
        }else{
            // TODO: Add other tax brackets
            this.taxLiability = 0;
        }
    }



}