package DeepParse;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewMyWebtoon {

	Pattern patternLink = Pattern.compile("^<a[^>]*href=[\"']?([^>\"']+)[\"']?[^>]*");
	Pattern patternLink2 = Pattern.compile("/.+");
	private String link;
	private String title;
	private String realLink;

	public String getNewMyWebtoon() throws IOException {
		Document doc = Jsoup.connect(link).get();
		Elements webtoons = doc.select(".title");
		Elements newWebtoon;
		for (Element webtoon : webtoons) {
			if (webtoon.toString().contains(
					"<img src=\"http://static.naver.net/comic/images/2012/ico_toonup.png\" width=\"27\" height=\"15\" alt=\"UP\">")) {
				String matchString = webtoon.toString();
				int start = matchString.indexOf("<a href");
				matchString = matchString.substring(19, matchString.length());

				Matcher matcher1 = patternLink.matcher(matchString);
				while (matcher1.find()) {
					Matcher matcher2 = patternLink2.matcher(matcher1.group(0));
					while (matcher2.find()) {
						realLink = matcher2.group(0).toString();
						int end = realLink.indexOf('"');
						realLink = realLink.substring(0, end);
						realLink = title + " : http://comic.naver.com" + realLink;
					}
				}

			}
		}
		return realLink;
	}

	public void setLink(String link, String title) {
		this.link = link;
		this.title = title;
	}
}
