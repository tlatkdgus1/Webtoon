package Parse;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.html.HTMLDocument.Iterator;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import DeepParse.NewMyWebtoon;
import layout.Display;
import layout.Input;

public class MyWebtoon extends Display{

	private String[] myWebtoon;
	private String link;

	public void setMyWebtoon(String webtoon) throws IOException {
		
		
		BufferedReader fi = new BufferedReader(new FileReader("C:\\Users\\Sim\\workspace\\Webtoon\\list.txt"));
		String list = fi.readLine();
		fi.close();
		try {
			if(list.contains(webtoon)){
				System.out.println("이미 등록되있는 웹툰입니다.");
			}else{
				FileWriter fw = new FileWriter("C:\\Users\\Sim\\workspace\\Webtoon\\list.txt",true);
				fw.append(webtoon+":");
				System.out.println("등록됬습니다.");
				fw.close();
					}
		} catch (Exception e) {
			FileWriter fw = new FileWriter("C:\\Users\\Sim\\workspace\\Webtoon\\list.txt",true);
			fw.append(webtoon+":");
			System.out.println("등록됬습니다.");
			System.out.println("test");
			fw.close();
		}
		//myWebtoon.add("외모지상주의");
		//myWebtoon.add("갓 오브 하이스쿨");
		//myWebtoon.add("악의는 없다");
	}

	public void getMyWebtoon(Element e) throws IOException  {
		
		Pattern patternLink = Pattern.compile("^<a[^>]*href=[\"']?([^>\"']+)[\"']?[^>]* ");
		Pattern patternLink2 = Pattern.compile("/.+");
		NewMyWebtoon newMyWebtoon = new NewMyWebtoon();
		Input input = new Input();
		BufferedReader fi = new BufferedReader(new FileReader("C:\\Users\\Sim\\workspace\\Webtoon\\list.txt"));
		String list = fi.readLine();
		myWebtoon = list.split(":");
		for(int i=0; i<myWebtoon.length;i++ ) {

			String element = myWebtoon[i];
			
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
							realLink = newMyWebtoon.getNewMyWebtoon();
							input.setText(realLink);
						}
					}
				}
			}
		}
	fi.close();
	}
}
