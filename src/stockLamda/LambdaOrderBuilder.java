package stockLamda;


import stockBuilder.Order;
import stockBuilder.Trade;

import java.util.function.Consumer;

public class LambdaOrderBuilder {

    Order order = new Order();

    public static Order order(Consumer<LambdaOrderBuilder> consumer){
        LambdaOrderBuilder builder = new LambdaOrderBuilder();
        consumer.accept(builder);//주문 빌더로 전달된 람다 표현식 실행
        return builder.order; // OrderBuilder의 Consumer를 실행해 만들어진 주문을 반환
    }

    public void forCustomer(String customer){
        order.setCustomer(customer);// 주문을 요청한 고객 설정
    }

    public void buy(Consumer<TradeBuilder> consumer){
        trade(consumer, Trade.Type.BUY);//주식 매수 주문을 만들도록 TradeBuilder 소비
    }

    public void sell(Consumer<TradeBuilder> consumer){
        trade(consumer, Trade.Type.SELL);//주식 매도 주문을 만들도록 TradeBuilder 소비
    }

    public void trade(Consumer<TradeBuilder> consumer, Trade.Type type){
        TradeBuilder builder = new TradeBuilder();
        builder.trade.setType(type);
        consumer.accept(builder);//TradeBuilder로 전달할 람다 표현식 실행
        order.addTrade(builder.trade);//TradeBuilder의 Consumer를 실행해 만든 거래를 주문에 추기
    }
}
