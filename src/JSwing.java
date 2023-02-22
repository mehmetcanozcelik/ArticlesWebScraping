import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextField;

public class JSwing extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		
		
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSwing frame = new JSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JSwing() {
		setTitle("Java Tutorials");
		setBackground(new Color(128, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1176, 644);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton GoArticleButton = new JButton("Show Article URL");
		GoArticleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				
			}
		});
		GoArticleButton.setBounds(371, 574, 122, 23);
		contentPane.add(GoArticleButton);
		
		JLabel lblNewLabel = new JLabel("Articles");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(48, 24, 122, 14);
		contentPane.add(lblNewLabel);
		
		JList ArticleList = new JList();
		ArticleList.setBounds(43, 49, 551, 433);
		contentPane.add(ArticleList);
		
		JButton LoadArticleButton = new JButton("Load Articles");
		LoadArticleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel DLM = new DefaultListModel();
				DLM.addElement("a");
				ArticleList.setModel(DLM);
			}
		});
		LoadArticleButton.setBounds(118, 574, 122, 23);
		contentPane.add(LoadArticleButton);
		
		textField = new JTextField();
		textField.setBounds(43, 532, 551, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Article URL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(48, 507, 111, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(611, 24, 539, 514);
		contentPane.add(lblNewLabel_2);
	}
}
