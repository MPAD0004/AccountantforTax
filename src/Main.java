public class Main {
    public static void main(String[] args) {
        System.out.println("Tax Accountant for tradies!");
        double income = 150000;
        TaxCalculator taxCalc = new TaxCalculator(income);

        // Interfact testing
        Interface ui = new Interface();
    }
}
