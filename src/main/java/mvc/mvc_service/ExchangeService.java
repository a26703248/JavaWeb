package mvc.mvc_service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import mvc.mvc_entity.Exchange;
import mvc.mvc_repository.ExchangeDao;
import yahoofinance.Stock;

public class ExchangeService {
  private ExchangeDao dao = new ExchangeDao();
  private List<Exchange> list = new CopyOnWriteArrayList<>();

  public Exchange getExchange(Double amount, String from, String to) {
    String symbol = from + to + "=x"; // 組合
    try {
      Stock stock = dao.get(symbol);
      Exchange exchange = new Exchange();
      exchange.setFrom(from);
      exchange.setAmount(amount);
      exchange.setTo(to);
      double price = stock.getQuote().getPrice().doubleValue(); // 匯率或股價
      exchange.setExchange(price);
      double result = amount * price; // 換匯結果
      exchange.setResult(result);
      exchange.setDatetime(stock.getQuote().getLastTradeTime().getTime()); // 最後交易時間
      list.add(exchange);
      return exchange;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  public List<Exchange> queryAllExchanges(){
    return list;
  }

}
