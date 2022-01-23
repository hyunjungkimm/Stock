package tax;

import stockBuilder.Order;

import java.util.function.DoubleUnaryOperator;

public class TaxCalculator2 {
    public DoubleUnaryOperator taxFunction = d -> d; //주문값에 적용된 모든 세금을 계산하는 함수

    public TaxCalculator2 with(DoubleUnaryOperator f){
        taxFunction = taxFunction.andThen(f);//새로운 세금 계산 함수를 얻어서 인수로 전달된 함수와 현재 함수를 합침
        return this; //유창하게 세금 함수가 연결할 수 있도록 결과를 반환
    }

    public double calculate(Order order){
        return taxFunction.applyAsDouble(order.getValue());//주문의 총 합에 세금 계싼 함수를 적용해 최종 주문값을 계산
    }
}
