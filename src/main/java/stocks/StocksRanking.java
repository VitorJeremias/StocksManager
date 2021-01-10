package stocks;

import java.util.List;

public class StocksRanking {

	private static void setEvEbitRanks() {
		for (int i = 0; i < StocksManager.getSortedEvEbitList().size(); i++) {
			StocksManager.getSortedEvEbitList().get(i).setEvEbitRank(i + 1);
		}
	}

	public static void setOverallRanks() {
		setOverallRankValues();
		System.out.println();
		for (int i = 0; i < StocksManager.getSortedRankValueList().size(); i++) {
			Stock currentStock = StocksManager.getSortedRankValueList().get(i);
			currentStock.setOverallRank(i + 1);
			System.out.println(currentStock.getCode() + ": " + currentStock.getOverallRank() + "(" + currentStock.getOverallRankValue() + ")");
		}
	}

	private static void setOverallRankValues() {
		setEvEbitRanks();
		setRoicRanks();
		setEarningYieldRanks();
		for (int i = 0; i < StocksManager.stocksList.size(); i++) {
			Stock currentStock = StocksManager.stocksList.get(i);
			int evEbitRank = StocksManager.stocksList.get(i).getEvEbitRank();
			// int roicRank = StocksManager.stocksList.get(i).getRoicRank();
			int earningYieldRank = StocksManager.stocksList.get(i).getEarningYieldRank();
			currentStock.setOverallRankValue(evEbitRank + earningYieldRank);
			System.out.println(currentStock.getCode() + ": " + currentStock.getOverallRankValue());
		}
	}

	private static void setEarningYieldValues() {
		for (int i = 0; i < StocksManager.stocksList.size(); i++) {
			Stock currentStock = StocksManager.stocksList.get(i);
			Double ebitValue = currentStock.getEbit();
			Double evValue = currentStock.getEv();
			currentStock.setEarningYield(ebitValue / evValue);
		}
	}

	private static void setRoicRanks() {
		for (int i = 0; i < StocksManager.getSortedRoicList().size(); i++) {
			StocksManager.getSortedRoicList().get(i).setRoicRank(i + 1);
		}
	}

	private static void setEarningYieldRanks() {
		setEarningYieldValues();
		List<Stock> sortedEarningYieldList = StocksManager.getSortedEarningYieldList();
		for (int i = 0; i < sortedEarningYieldList.size(); i++) {
			sortedEarningYieldList.get(i).setEarningYieldRank(i + 1);
		}
	}
}
