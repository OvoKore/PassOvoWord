package tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

	public void OpenStart() {
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
		frmStart.setTitle("PassOvoWord - Reset");
		frmStart.setBounds(100, 100, 800, 500);
		frmStart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		frmStart.getContentPane().add(scrollPane);
		
		btnStart = new JButton("Contemple o ovo!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int row : table.getSelectedRows()) {
					String loginLug = table.getValueAt(row, table.getColumn("Login LUG").getModelIndex()).toString();
					String senhaLug = table.getValueAt(row, table.getColumn("Senha LUG").getModelIndex()).toString();
					String loginRag = table.getValueAt(row, table.getColumn("Login Rag").getModelIndex()).toString();
					String senhaRag = table.getValueAt(row, table.getColumn("Senha Rag").getModelIndex()).toString();
					String loginEmail = table.getValueAt(row, table.getColumn("Login Email").getModelIndex()).toString();
					String senhaEmail = table.getValueAt(row, table.getColumn("Senha Email").getModelIndex()).toString();
					String urlLug = table.getValueAt(row, table.getColumn("Url LUG").getModelIndex()).toString();
					
					new Thread(new Runnable() {
						@Override
						public void run() {
							new Reset().reset(loginLug, senhaLug, loginRag, senhaRag, loginEmail, senhaEmail, urlLug);			
						}
					}).start();
				}
				if (table.getSelectedRowCount() != 0)
					JOptionPane.showMessageDialog(null, "Requisições enviadas");
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
			for (int j = 0; j < table.getRowCount(); j++) {
				if (max < fm.stringWidth(obj[j][i].toString()))
					max = fm.stringWidth(obj[j][i].toString());
			}
			
			table.getColumn(nome).setMinWidth(max + 5);
		}
		g2d.dispose();
	}

}
