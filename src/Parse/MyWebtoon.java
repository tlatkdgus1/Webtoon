package Parse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.html.HTMLDocument.Iterator;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import DeepParse.NewMyWebtoon;

public class MyWebtoon {

	private ArrayList<String> myWebtoon = new ArrayList<String>();

	public void setMyWebtoon() {
		myWebtoon.add("외모지상주의");
		myWebtoon.add("갓 오브 하이스쿨");
		myWebtoon.add("악의는 없다");
	}

	public void getMyWebtoon(Element e) throws IOException {
		java.util.Iterator<String> iterator = myWebtoon.iterator();
		Pattern patternLink = Pattern.compile("^<a[^>]*href=[\"']?([^>\"']+)[\"']?[^>]* ");
		Pattern patternLink2 = Pattern.compile("/.+");
		NewMyWebtoon newMyWebtoon = new NewMyWebtoon();

		while (iterator.hasNext()) {
			String element = (String) iterator.next();

			if (e.html().contains(element)) {
				Elements link = e.select("a[href]");
				for (Element l : link) {

					String matchString = l.toString();
					Matcher matcher1 = patternLink.matcher(matchString);
					while (matcher1.find()) {
						Matcher matcher2 = patternLink2.matcher(matcher1.group(0));
						while (matcher2.find()) {

							String realLink = matcher2.group(0).toString();
							int end = realLink.indexOf('"');
							realLink = realLink.substring(0, end);
							realLink = "http://comic.naver.com" + realLink;
							newMyWebtoon.setLink(realLink, element);
							System.out.println(newMyWebtoon.getNewMyWebtoon());
						}
					}
				}
			}
		}
	}
}
