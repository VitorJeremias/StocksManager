package utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class UrlUtils {

	public static Document getDocumentFromURL(URL url) {
		try {
			return Jsoup.connect(url.toString()).get();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static URL parseURL(String urlString) {
		try {
			return new URL(urlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
