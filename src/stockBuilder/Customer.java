package stockBuilder;

import tax.Tax;
import tax.TaxCalculator;
import tax.TaxCalculator2;

import static stockBuilder.MethodChainingOrderBuilder.forCustomer;
import static tax.Tax.calculate;

public class Customer {
    public static void main(String[] args) {
        Order order = forCustomer("BigBank")
                .buy( 80 )
                .stock( "IBM" )
                .on( "NYSE" )
                .at( 125.00 )
                .sell( 50 )
                .stock( "GOOGLE" )
                .on( "NASDAQ" )
                .at( 375.00 )
                .end();

        double value = calculate(order, true, false, true);
        System.out.println("최종값 = " + value);//최종값 = 43168.12500000001

        double value2 = new TaxCalculator().withTaxRegional()
                .withTaxSurcharge()
                .calculate(order);
        System.out.println("최종값 = " + value2);//최종값 = 43168.12500000001

        double value3 = new TaxCalculator2().with(Tax::regional)
                                            .with(Tax::surcharge)
                                            .calculate(order);
        System.out.println("최종값 = " + value3);//최종값 = 33206.25000000001
    }

}
