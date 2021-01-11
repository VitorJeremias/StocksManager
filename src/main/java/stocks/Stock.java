package stocks;

public class Stock {

	private String code;
	private String name;
	private Double evEbit;
	private Double price;
	private Double roic;
	private Double dailyLiquidity;
	private Double ebit;
	private Double ev;
	private Double earningYield;
	private int evEbitRank;
	private int roicRank;
	private int overallRankValue;
	private int overallRank;
	private int earningYieldRank;

	public Stock(String code, String name, Double evEbit, Double price, Double roic, Double dailyLiquidity, Double ebit, Double ev) {
		this.code = code;
		this.name = name;
		this.evEbit = evEbit;
		this.price = price;
		this.roic = roic;
		this.dailyLiquidity = dailyLiquidity;
		this.ebit = ebit;
		this.ev = ev;
	}

	public String getAllData() {
		return "Code: " + getCode() + "\n" +
				"Company: " + getName() + "\n" +
				"Price: " + getPrice() + "\n" +
				// "EV / EBIT: " + getEvEbit() + "\n" +
				"EBIT: " + getEbit() + "\n" +
				"EV: " + getEv() + "\n" +
				"EY: " + getEarningYield() + "\n" +
				"EY Rank: " + getEarningYieldRank() + "\n" +
				"ROIC: " + getRoic() + "\n" +
				"Liq: " + getDailyLiquidity() + "\n" +
				// "EV/EBIT Rank: " + getEvEbitRank() + "\n" +
				"ROIC Rank: " + getRoicRank() + "\n" +
				"Overall Rank value: " + getOverallRankValue() + "\n" +
				"Overall Rank: " + getOverallRank() + "\n\n";
	}

	public String getCode() {
		return this.code;
	}

	public Double getDailyLiquidity() {
		return dailyLiquidity;
	}

	public Double getEarningYield() {
		return earningYield;
	}

	public Double getEbit() {
		return ebit;
	}

	public Double getEv() {
		return ev;
	}

	public Double getEvEbit() {
		return this.evEbit;
	}

	public int getEvEbitRank() {
		return evEbitRank;
	}

	public String getName() {
		return this.name;
	}

	public int getOverallRank() {
		return overallRank;
	}

	public int getOverallRankValue() {
		return overallRankValue;
	}

	public Double getPrice() {
		return this.price;
	}

	public Double getRoic() {
		return this.roic;
	}

	public int getRoicRank() {
		return roicRank;
	}

	public void printData() {
		System.out.println("Code: " + getCode());
		System.out.println("Company: " + getName());
		System.out.println("Price: " + getPrice());
		// System.out.println("EV / EBIT: " + getEvEbit());
		System.out.println("EY: " + getEarningYield());
		System.out.println("ROIC: " + getRoic());
		System.out.println("Liq: " + getDailyLiquidity());
		// System.out.println("EV/EBIT Rank: " + getEvEbitRank());
		System.out.println("EY Rank: " + getEarningYieldRank());
		System.out.println("ROIC Rank: " + getRoicRank());
		System.out.println("Overall Rank value: " + getOverallRankValue());
		System.out.println("Overall Rank: " + getOverallRank());
	}

	public void setEarningYield(Double earningYield) {
		this.earningYield = earningYield;
	}

	public void setEbit(Double ebit) {
		this.ebit = ebit;
	}

	public void setEv(Double ev) {
		this.ev = ev;
	}

	public void setEvEbitRank(int evEbitRank) {
		this.evEbitRank = evEbitRank;
	}

	public void setOverallRank(int overallRank) {
		this.overallRank = overallRank;
	}

	public void setOverallRankValue(int overallRankValue) {
		this.overallRankValue = overallRankValue;
	}

	public void setRoicRank(int roicRank) {
		this.roicRank = roicRank;
	}

	public int getEarningYieldRank() {
		return earningYieldRank;
	}

	public void setEarningYieldRank(int earningYieldRank) {
		this.earningYieldRank = earningYieldRank;
	}

}