package th.ku;

public class CATaxCalculator implements TaxCalculator {
    public double calculate(double amount) {
        return amount * 0.075;
    }
}
