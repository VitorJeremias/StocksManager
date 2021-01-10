package utils;

public class NumberUtils {

	public static Double getFormattedValue(String rawValue) {
		if (rawValue.equals("-")) {
			return 0.0;
		}
		if (rawValue.contains(".")) {
			return Double.parseDouble(rawValue.replace(".", "").replace(",", "."));
		}
		return Double.parseDouble(rawValue.replace(",", "."));
	}

	public static String removePercentageSymbol(String numberWithPercentageSymbol) {
		return numberWithPercentageSymbol.replace("%", "");
	}

	public static Double getFormattedRoicValue(String roic) {
		return getFormattedValue(removePercentageSymbol(roic));
	}
}
