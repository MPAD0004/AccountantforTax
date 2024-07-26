// Class contains methods for backend tax calculation
public class TaxCalculator {
    private double taxableIncome;
    private double deductions = 0;
    private double taxLiability = 0;
    private double distanceTravelled;

    // Print users taxableIncome and tax details to the screen
    public void showTaxDetails(){
        System.out.printf("My Income: %f\n", this.taxableIncome);
        System.out.printf("Tax Liability: %f\n", this.taxLiability);
    }

    // Constructor sets attributes
    public TaxCalculator(double taxableIncome, double toolDeductions, double distanceTravelled){
        this.deductions = toolDeductions;
        this.taxableIncome = taxableIncome;
        this.distanceTravelled = distanceTravelled;
        calculateTaxLiability();
        //showTaxDetails();
    }

    // Getter: Return tax liability
    public double getTaxLiability(){
        return this.taxLiability;
    }

    // Based on taxableIncome, calculate tax payable
    private void calculateTaxLiability(){
        // Calculate deductions

        // Fuel deduction equivalent to 88c per km up to 5,000 km
        if (this.distanceTravelled > 5000){
            this.deductions += (5000 * 0.88);
        }else{
            this.deductions += (this.distanceTravelled * 0.88);
        }

        // Subtract deductions from taxable income
        this.taxableIncome -= this.deductions;


        // Calculate tax payable for respective tax bracket
        // 0-$18,2000 : Nil
        // >= $190,001: $51,638 + 45c for each dollar over $190,000
        if (this.taxableIncome >= 190001){
            this.taxLiability = (51638 + .45 * (this.taxableIncome - 190000));

        // $135,001 - $190,000: $31,288 + 37c for each dollar over $135,000
        }else if (this.taxableIncome >= 135001){
            this.taxLiability = (31288 + .37 * (this.taxableIncome - 135000));

        // $45,001 - $135,000: $4,288 + 30c for each dollar over $45,000
        }else if (this.taxableIncome >= 45001){
            this.taxLiability = (4288 + .30 *(this.taxableIncome - 45000));

        // $18,201 - $45,000: 16c for each dollar over $18,200
        }else if (this.taxableIncome >= 18201){
            this.taxLiability = (.16 * (this.taxableIncome - 18201));
        }else{
            this.taxLiability = 0;
        }
        // Round number to 2 decimal places
        this.taxLiability = Math.round(this.taxLiability * 100.0) / 100.0;
    }



}