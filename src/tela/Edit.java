package tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Edit {

	private JFrame frmEdit;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit window = new Edit();
					window.frmEdit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Edit() {
		initialize();
	}

	private void initialize() {
		frmEdit = new JFrame();
		frmEdit.getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		frmEdit.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/img/yoshi.png")));
		frmEdit.setTitle("PassOvoWord - Edit");
		frmEdit.setBounds(100, 100, 800, 500);
		frmEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEdit.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		//classe.conta conta = new classe.conta("loginLug", "senhaLug", "loginRag", "senhaRag", "loginEmail", "senhaEmail", "urlLug");
		
		String[] columnNames = {"Login LUG", "Senha LUG", "Login Rag", "Senha Rag", "Login Email", "Senha Email", "Url LUG"};
		
		Object[][] data = {
				 {"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
				 ,{"login09", "senha", "login09", "senha", "email09@hotmail.com.br", "senha", "https://minhaconta.levelupgames.com.br/web/esqueci-senha-jogo?identity=caminho"}
			};
		
		table = new JTable(data, columnNames);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		frmEdit.getContentPane().add(scrollPane);
		frmEdit.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = img.createGraphics();
		g2d.setFont(table.getFont());
		FontMetrics fm = g2d.getFontMetrics();
		for (int i = 0; i < table.getColumnCount(); i++) {
			String nome = table.getColumnName(i);
			int max = fm.stringWidth(nome);
			
			for (int j = 0; j < data.length; j++) {
				if (max < fm.stringWidth(data[j][i].toString()))
					max = fm.stringWidth(data[j][i].toString());		
			}
			
			table.getColumn(nome).setMinWidth(max + 5);
		}
		g2d.dispose();
		
		table.setColumnSelectionAllowed(true);
	}

}
