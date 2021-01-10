package runner;

import java.util.List;

import stocks.Stock;
import stocks.StocksManager;
import stocks.StocksRanking;
import utils.Constants;
import utils.FileManager;

public class StocksRunner {
	public static void main(String[] args) {
		StocksRanking.setOverallRanks();
		List<Stock> sortedRanksList = StocksManager.getSortedRankValueList();
		FileManager.eraseDataFromFile(Constants.ranksTextFile);
		for (int i = 0; i < sortedRanksList.size(); i++) {
			FileManager.appendToFile(Constants.ranksTextFile, sortedRanksList.get(i).getAllData());
		}
	}
}
