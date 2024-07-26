// Class contains methods for backend tax calculation
public class TaxCalculator {
    private double income;

    // Print users income and tax details to the screen
    public void showTaxDetails(){
        System.out.printf("My Income: %f\n", this.income);
    }

    // Constructor sets attributes
    public TaxCalculator(double income){
        this.income = income;
        showTaxDetails();
    }



}