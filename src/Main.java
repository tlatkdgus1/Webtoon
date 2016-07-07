import java.io.IOException;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import Parse.*;

public class Main {

	public static void main(String[] args) throws IOException {
		TodayWebtoon parse = new TodayWebtoon();
		parse.Parse();
	}
}
