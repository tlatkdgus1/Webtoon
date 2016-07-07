package Parse;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TodayWebtoon {

	public void Parse() throws IOException {
		Document doc = Jsoup.connect("http://comic.naver.com/webtoon/weekday.nhn").get();
		Elements weeks = doc.select(".col");
		Elements webtoons;
		MyWebtoon myWebtoon = new MyWebtoon();

		myWebtoon.setMyWebtoon();
		for (Element e : weeks) {
			if (e.html().contains("<em class=\"ico_updt\"></em>")) {
				webtoons = e.select(".thumb");
				for (Element l : webtoons) {
					myWebtoon.getMyWebtoon(l);
				}
			}
		}
	}
}
