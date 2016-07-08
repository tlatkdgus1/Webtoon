package layout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Parse.MyWebtoon;
import Parse.TodayWebtoon;

public class Input extends Display implements ActionListener{
	private Container container;
	
	public void setContainer(Container container){
		this.container = container;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		MyWebtoon myWebtoon = new MyWebtoon();
		TodayWebtoon parse = new TodayWebtoon();
		
		String webtoon;
		webtoon = JOptionPane.showInputDialog(null,"test");
		try {
			myWebtoon.setMyWebtoon(webtoon);
			parse.Parse();		
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	
}
