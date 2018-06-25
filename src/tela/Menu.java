package tela;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import codigo.Json;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frmPassovoword;

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
		frmPassovoword.getContentPane().setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new Save().OpenSave();;
			}
		});
		btnSave.setFont(new Font("Arial", Font.BOLD, 22));
		btnSave.setBounds(10, 11, 264, 60);
		frmPassovoword.getContentPane().add(btnSave);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new File(new Json().arquivo).exists())
					new Edit().OpenEdit();
				else
					JOptionPane.showMessageDialog(null, "Arquivo passOvoWord.json não encontrado");
			}
		});
		btnEdit.setFont(new Font("Arial", Font.BOLD, 22));
		btnEdit.setBounds(10, 82, 264, 60);
		frmPassovoword.getContentPane().add(btnEdit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new File(new Json().arquivo).exists())
					new Start().OpenStart();
				else
					JOptionPane.showMessageDialog(null, "Arquivo passOvoWord.json não encontrado");
			}
		});
		btnReset.setFont(new Font("Arial", Font.BOLD, 22));
		btnReset.setBounds(10, 153, 264, 60);
		frmPassovoword.getContentPane().add(btnReset);
		frmPassovoword.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/img/yoshi.png")));
		frmPassovoword.setTitle("PassOvoWord - Menu");
		frmPassovoword.setBounds(100, 100, 300, 260);
		frmPassovoword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
