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
        //showTaxDetails();
    }

    // Getter: Return tax liability
    public double getTaxLiability(){
        return this.taxLiability;
    }

    // Based on income, calculate tax payable
    private void calculateTaxLiability(){
        // Calculate tax payable for each tax bracket
        // 0-$18,2000 : Nil

        // >= $190,001: $51,638 + 45c for each dollar over $190,000
        if (this.income >= 190001){
            this.taxLiability = (51638 + .45 * (this.income - 190000));

        // $135,001 - $190,000: $31,288 + 37c for each dollar over $135,000
        }else if (this.income >= 135001){
            this.taxLiability = (31288 + .37 * (this.income - 135000));

        // $45,001 - $135,000: $4,288 + 30c for each dollar over $45,000
        }else if (this.income >= 45001){
            this.taxLiability = (4288 + .30 *(this.income - 45000));

        // $18,201 - $45,000: 16c for each dollar over $18,200
        }else if (this.income >= 18201){
            this.taxLiability = (.16 * (this.income - 18201));
        }else{
            this.taxLiability = 0;
        }
        // Round number to 2 decimal places
        this.taxLiability = Math.round(this.taxLiability * 100.0) / 100.0;
    }



}