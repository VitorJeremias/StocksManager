package stocks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import url.StocksCrawler;

public class StocksManager {

	public static ArrayList<Stock> stocksList = StocksCrawler.getStocksList();

	static List<Stock> getSortedEvEbitList() {
		return stocksList.stream().sorted(Comparator.comparing(Stock::getEvEbit)).collect(Collectors.toList());
	}

	public static List<Stock> getSortedRoicList() {
		return stocksList.stream().sorted(Comparator.comparing(Stock::getRoic).reversed()).collect(Collectors.toList());
	}

	public static List<Stock> getSortedRankValueList() {
		return stocksList.stream().sorted(Comparator.comparing(Stock::getOverallRankValue)).collect(Collectors.toList());
	}

	public static List<Stock> getSortedEarningYieldList() {
		return stocksList.stream().sorted(Comparator.comparing(Stock::getEarningYield).reversed()).collect(Collectors.toList());
	}

}
