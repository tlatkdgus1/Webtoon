import java.io.IOException;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import Parse.*;
import layout.Display;

public class Main {

	public static void main(String[] args) throws IOException {
		Display display = new Display();
		display.display();
	}
}
