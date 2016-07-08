package layout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Parse.MyWebtoon;

public class Display extends JFrame {
	private JButton button = new JButton("관심 웹툰 추가");
	public JTextArea textArea = new JTextArea("", 0, 0);
	
	public void display(){		

		JFrame jFrame = new JFrame("Webtoon");
		JScrollPane js = new JScrollPane(textArea);
	
		jFrame.add(button, BorderLayout.SOUTH);
		jFrame.add(textArea);
		textArea.setEditable(true);
		textArea.append("test");
		jFrame.setSize(400, 800);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button.addActionListener(new Input());
	}
	
	
	public void setText(String text){
		System.out.println(text);
		textArea.append(text);
	}	
}
