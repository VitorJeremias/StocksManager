package url;

import utils.NumberUtils;

public class Fetcher {

	private static String fetchData(String stockCode, String selectQuery, int elementIndex) {
		try {
			return StocksCrawler.getStockPage(stockCode)
					.select(selectQuery)
					.get(elementIndex)
					.parent()
					.nextElementSibling()
					.text();
		} catch (Exception e) {
			return "0";
		}
	}

	public static Double fetchPrice(String stockCode) {
		return NumberUtils.getFormattedValue(StocksCrawler.getStockPage(stockCode)
				.select("td[class='data destaque w3']")
				.text());
	}

	public static String fetchEvEbit(String stockCode) {
		return fetchData(stockCode, "span:containsOwn(EV / EBIT)", 1);
	}

	public static String fetchName(String stockCode) {
		return fetchData(stockCode, "span:containsOwn(Empresa)", 0);
	}

	public static String fetchRoic(String stockCode) {
		return fetchData(stockCode, "span:containsOwn(ROIC)", 0);
	}

	public static String fetchDailyLiquidity(String stockCode) {
		return fetchData(stockCode, "span:containsOwn(Vol $ méd (2m))", 0);
	}

	public static String fetchEbit(String stockCode) {
		return fetchData(stockCode, "span:containsOwn(EBIT)", 5);
	}

	public static String fetchEv(String stockCode) {
		return fetchData(stockCode, "span:containsOwn(Valor da firma)", 0);
	}

	public static void main(String[] args) {
		System.out.println(fetchEbit("PINE4"));
	}
}
