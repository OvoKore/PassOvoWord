package tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
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
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JSplitPane;

public class Edit {

	private JFrame frmEdit;
	private JTable table;
	private JSplitPane splitPane;
	private JButton btnEdit;
	private JButton btnDelete;

	public void OpenEdit() {
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
	
	public Object[][] GetAll() {
		Object[][] contas = new Object[table.getRowCount()][7];
		for (int row = 0; row < table.getRowCount(); row++) {
			contas[row][0] = table.getValueAt(row, table.getColumn("Login LUG").getModelIndex()).toString();
			contas[row][1] = table.getValueAt(row, table.getColumn("Senha LUG").getModelIndex()).toString();
			contas[row][2] = table.getValueAt(row, table.getColumn("Login Rag").getModelIndex()).toString();
			contas[row][3] = table.getValueAt(row, table.getColumn("Senha Rag").getModelIndex()).toString();
			contas[row][4] = table.getValueAt(row, table.getColumn("Login Email").getModelIndex()).toString();
			contas[row][5] = table.getValueAt(row, table.getColumn("Senha Email").getModelIndex()).toString();
			contas[row][6] = table.getValueAt(row, table.getColumn("Url LUG").getModelIndex()).toString();
		}
		
		return contas;
	}

	private void initialize() {
		frmEdit = new JFrame();
		frmEdit.getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		frmEdit.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/img/yoshi.png")));
		frmEdit.setTitle("PassOvoWord - Edit");
		frmEdit.setBounds(100, 100, 800, 500);
		frmEdit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String[] columnNames = {"Login LUG", "Senha LUG", "Login Rag", "Senha Rag", "Login Email", "Senha Email", "Url LUG"};
		
		Json json = new Json();
		Object[][] obj = json.ReadObj();
				
		table = new JTable(obj, columnNames);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.getTableHeader().setReorderingAllowed(false);
		frmEdit.getContentPane().setLayout(new BoxLayout(frmEdit.getContentPane(), BoxLayout.X_AXIS));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		frmEdit.getContentPane().add(scrollPane);
		
		splitPane = new JSplitPane();
		scrollPane.setRowHeaderView(splitPane);
		
		btnEdit = new JButton("Edit   ");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog((Component) null, "Deseja realizar as alterações?", "alert", JOptionPane.OK_CANCEL_OPTION);
				if (result == 0) {
					new Json().Edit(GetAll());
					frmEdit.dispose();
				}
			}
		});
		splitPane.setLeftComponent(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog((Component) null, "Deseja deletar os campos?", "alert", JOptionPane.OK_CANCEL_OPTION);
				if (result == 0) {
					new Json().Delete(table.getSelectedRows());
					frmEdit.dispose();
				}
			}
		});
		splitPane.setRightComponent(btnDelete);
		frmEdit.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
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
