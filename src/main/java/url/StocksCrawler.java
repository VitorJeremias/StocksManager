package url;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import stocks.Stock;
import utils.Constants;
import utils.NumberUtils;
import utils.UrlUtils;

public class StocksCrawler {

	public static ArrayList<Stock> getStocksList() {
		ArrayList<Stock> stocksList = new ArrayList<>();
		Elements paperTags = UrlUtils.getDocumentFromURL(UrlUtils.parseURL(Constants.fundamentusStocksListUrlString))
				.select("span[class='tips']");
		int listSize = paperTags.size();
		// int listSize = 50;
		for (int i = 0; i < listSize; i++) {
			String currentPaperCode = paperTags.get(i).text();
			Double dailyLiquidity = getDailyLiquidity(currentPaperCode);
			if (dailyLiquidity >= 200000) {
				stocksList.add(new Stock(currentPaperCode, getName(currentPaperCode), getEvEbit(currentPaperCode), getPrice(currentPaperCode), getRoic(currentPaperCode),
						getDailyLiquidity(currentPaperCode), getEbit(currentPaperCode), getEv(currentPaperCode)));
				System.err.println(i + "/" + listSize + " Adding " + currentPaperCode + ". Daily Liquidity = " + dailyLiquidity + "   Added " + stocksList.size());
			} else {
				System.out.println(i + "/" + listSize + " Not adding " + currentPaperCode + ". Daily Liquidity = " + dailyLiquidity + "   Added " + stocksList.size());
			}
		}
		return stocksList;
	}

	private static Double getDailyLiquidity(String stockCode) {
		return NumberUtils.getFormattedValue(Fetcher.fetchDailyLiquidity(stockCode));
	}

	public static Document getStockPage(String stockCode) {
		return UrlUtils.getDocumentFromURL(UrlUtils.parseURL(Constants.fundamentusStockPageString + stockCode));
	}

	private static Double getPrice(String stockCode) {
		return Fetcher.fetchPrice(stockCode);
	}

	private static Double getEvEbit(String stockCode) {
		return NumberUtils.getFormattedValue(Fetcher.fetchEvEbit(stockCode));
	}

	private static String getName(String stockCode) {
		return Fetcher.fetchName(stockCode);
	}

	private static Double getRoic(String stockCode) {
		return NumberUtils.getFormattedRoicValue(Fetcher.fetchRoic(stockCode));
	}

	private static Double getEbit(String stockCode) {
		return NumberUtils.getFormattedRoicValue(Fetcher.fetchEbit(stockCode));
	}

	private static Double getEv(String stockCode) {
		return NumberUtils.getFormattedRoicValue(Fetcher.fetchEv(stockCode));
	}
}