package tax;

import stockBuilder.Order;

public class TaxCalculator {
    private boolean useRegional;
    private boolean useGeneral;
    private boolean useSurcharge;

    public TaxCalculator withTaxRegional(){
        useRegional = true;
        return this;
    }

    public TaxCalculator withTaxGeneral(){
        useGeneral = true;
        return this;
    }

    public TaxCalculator withTaxSurcharge(){
        useSurcharge = true;
        return this;
    }

    public double calculate(Order order) {
        return Tax.calculate(order, this.useRegional, this.useGeneral, this.useSurcharge);
    }
}
