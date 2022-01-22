package stockBuilder;

import static stockBuilder.MethodChainingOrderBuilder.forCustomer;

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


    }

}
