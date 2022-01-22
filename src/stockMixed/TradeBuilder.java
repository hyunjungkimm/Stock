package stockMixed;


import stockBuilder.Trade;

public class TradeBuilder {
    Trade trade = new Trade();

    public TradeBuilder quantity(int quantity){
        trade.setQuantity(quantity);
        return this;
    }

    public TradeBuilder at(double price){
        trade.setPrice(price);
        return this;
    }

    public StockBuilder stock(String symbol){
        return new StockBuilder(this, trade, symbol);
    }
}
