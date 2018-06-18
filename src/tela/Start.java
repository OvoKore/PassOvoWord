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
import codigo.Json;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import codigo.Reset;

public class Start {

	private JFrame frmStart;
	private JTable table;
	private JButton btnStart;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frmStart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Start() {
		initialize();
	}

	private void initialize() {
		frmStart = new JFrame();
		frmStart.getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		frmStart.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/img/yoshi.png")));
		frmStart.setTitle("PassOvoWord - Edit");
		frmStart.setBounds(100, 100, 800, 500);
		frmStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStart.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		String[] columnNames = {"Login LUG", "Senha LUG", "Login Rag", "Senha Rag", "Login Email", "Senha Email", "Url LUG"};
		
		Json json = new Json();
		Object[][] obj = json.ReadObj();
				
		table = new JTable(obj, columnNames) {
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		frmStart.getContentPane().add(scrollPane);
		
		btnStart = new JButton("Contemple o ovo!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int row : table.getSelectedRows()) {
					String loginLug = table.getValueAt(row, 0).toString();
					String senhaLug = table.getValueAt(row, 1).toString();
					String loginRag = table.getValueAt(row, 2).toString();
					String senhaRag = table.getValueAt(row, 3).toString();
					String loginEmail = table.getValueAt(row, 4).toString();
					String senhaEmail = table.getValueAt(row, 5).toString();
					String urlLug = table.getValueAt(row, 6).toString();
					
					new Reset().reset(loginLug, senhaLug, loginRag, senhaRag, loginEmail, senhaEmail, urlLug);
				}
			}
		});
		scrollPane.setRowHeaderView(btnStart);
		frmStart.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = img.createGraphics();
		g2d.setFont(table.getFont());
		FontMetrics fm = g2d.getFontMetrics();
		for (int i = 0; i < table.getColumnCount(); i++) {
			String nome = table.getColumnName(i);
			int max = fm.stringWidth(nome);
			for (int j = 0; j < obj[i].length; j++) {
				if (max < fm.stringWidth(obj[j][i].toString()))
					max = fm.stringWidth(obj[j][i].toString());
			}
			
			table.getColumn(nome).setMinWidth(max + 5);
		}
		g2d.dispose();
	}

}
