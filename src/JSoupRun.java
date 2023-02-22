import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.LabelView;
import javax.swing.text.html.ListView;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class JSoupRun extends JFrame{
	private JPanel contentPane;

   public static void main(String[] args) throws IOException {
	   
	   Logger logger = Logger.getLogger(JSoupRun.class);
	   BasicConfigurator.configure();
	   
	   Document document = Jsoup.connect("https://kensoftph.com").get();
	   Elements body = document.select("h3.jeg_post_title");
	   logger.info("Main Method is activated and connected to website.");
	   
	   
	   //System.out.println(body.size());
	   logger.info("Webpage is scrapped.");

	   for (Element element : body.select("h3")) {
		   String title = element.select("a").text();
		   String selectedurl = element.select("a").attr("href");
		   
		   //System.out.println(title);
		   //System.out.println(selectedurl);
		   
		   //System.out.println(URLS);
		   
		   
		   
		   
	   }
	   
	   EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSoupRun frame = new JSoupRun();
					frame.setVisible(true);
				} catch (Exception e) {
					
					logger.error("There is an error.");
				}
			}
		});
	}
   
   public JSoupRun() throws IOException {
	   Logger logger = Logger.getLogger(JSoupRun.class);
	   logger.info("Swing is activated.");
	   setTitle("Java Tutorials");
		setBackground(new Color(128, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 644);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Document document = Jsoup.connect("https://kensoftph.com").get();
		Elements body = document.select("h3.jeg_post_title");
		ArrayList<String> URLS = new ArrayList<String>();
		
		
		
		
		JLabel lblNewLabel = new JLabel("Articles");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(48, 24, 122, 14);
		contentPane.add(lblNewLabel);
		
		JList ArticleList = new JList();
		ArticleList.setBounds(43, 49, 551, 433);
		contentPane.add(ArticleList);
		
		JScrollPane scroll = new JScrollPane(ArticleList);
		contentPane.add(scroll);
		scroll.setBounds(43, 49, 551, 433);
		
		JButton LoadArticleButton = new JButton("Load Articles");
		
		LoadArticleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Load Article button activated.");
				DefaultListModel DLM = new DefaultListModel();
				
				
				for (Element element : body.select("h3")) {
					   String title = element.select("a").text();
					   String selectedurl = element.select("a").attr("href");
					   DLM.addElement(title);
					   URLS.add(selectedurl);
					   
					   
				   }
				
				
				ArticleList.setModel(DLM);
				logger.info("Load Article method is done.");
			}
		});
		LoadArticleButton.setBounds(118, 574, 122, 23);
		contentPane.add(LoadArticleButton);
		
		
		JTextField textField = new JTextField();
		textField.setBounds(43, 532, 551, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Article URL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(48, 507, 111, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton GoArticleButton = new JButton("Show URL");
		GoArticleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Show URL button activated.");
				
				int i=0;
				String selectedArticle = "";
				String selectedURL = "";
				for(i=0;i<URLS.size();i++) {
					if(ArticleList.getSelectedIndex() == i) {
						textField.setText(URLS.get(i));
						
						
					}
				
				}
				   logger.info("Show URL method is done.");
	
			}
		});
		GoArticleButton.setBounds(371, 574, 122, 23);
		contentPane.add(GoArticleButton);
	}
	   
		
		
		
			
			
		}
	
	   
   
