package tela;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.Font;

public class Menu {

	private JFrame frmPassovoword;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmPassovoword.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		initialize();
	}

	private void initialize() {
		frmPassovoword = new JFrame();
		frmPassovoword.getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		frmPassovoword.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/img/yoshi.png")));
		frmPassovoword.setTitle("PassOvoWord - Menu");
		frmPassovoword.setBounds(100, 100, 371, 205);
		frmPassovoword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPassovoword.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
	}

}
