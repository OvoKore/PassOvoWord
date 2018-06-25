package tela;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Save {

	private JFrame frmSave;
	private JTextField txfLoginLuG;
	private JTextField txfSenhaLug;
	private JTextField txfLoginRag;
	private JTextField txfSenhaRag;
	private JTextField txfLoginEmail;
	private JTextField txfSenhaEmail;
	private JTextField txfUrlLug;

	public void OpenSave() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Save window = new Save();
					window.frmSave.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Save() {
		initialize();
	}

	private void initialize() {
		frmSave = new JFrame();
		frmSave.getContentPane().setFont(new Font("Arial", Font.PLAIN, 12));
		frmSave.setTitle("PassOvoWord - Save");
		frmSave.setIconImage(Toolkit.getDefaultToolkit().getImage(Save.class.getResource("/img/yoshi.png")));
		frmSave.setBounds(100, 100, 690, 260);
		frmSave.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSave.getContentPane().setLayout(null);
		
		JLabel lblLoginLug = new JLabel("Login LevelUp");
		lblLoginLug.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLoginLug.setBounds(10, 11, 85, 14);
		frmSave.getContentPane().add(lblLoginLug);
		
		JLabel lblSenhaLevelup = new JLabel("Senha LevelUp");
		lblSenhaLevelup.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSenhaLevelup.setBounds(10, 36, 85, 14);
		frmSave.getContentPane().add(lblSenhaLevelup);
		
		JLabel lblLoginRag = new JLabel("Login Rag");
		lblLoginRag.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLoginRag.setBounds(10, 61, 85, 14);
		frmSave.getContentPane().add(lblLoginRag);
		
		JLabel lblSenhaRag = new JLabel("Senha Rag");
		lblSenhaRag.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSenhaRag.setBounds(10, 86, 85, 14);
		frmSave.getContentPane().add(lblSenhaRag);
		
		JLabel lblLoginEmail = new JLabel("Login Email");
		lblLoginEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLoginEmail.setBounds(10, 111, 85, 14);
		frmSave.getContentPane().add(lblLoginEmail);
		
		JLabel lblSenhaEmail = new JLabel("Senha Email");
		lblSenhaEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSenhaEmail.setBounds(10, 136, 85, 14);
		frmSave.getContentPane().add(lblSenhaEmail);
		
		JLabel lblUrlLevelup = new JLabel("Url LevelUp");
		lblUrlLevelup.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUrlLevelup.setBounds(10, 161, 85, 14);
		frmSave.getContentPane().add(lblUrlLevelup);
		
		txfLoginLuG = new JTextField();
		txfLoginLuG.setFont(new Font("Arial", Font.PLAIN, 12));
		txfLoginLuG.setBounds(105, 9, 550, 20);
		frmSave.getContentPane().add(txfLoginLuG);
		txfLoginLuG.setColumns(10);
		
		txfSenhaLug = new JTextField();
		txfSenhaLug.setFont(new Font("Arial", Font.PLAIN, 12));
		txfSenhaLug.setColumns(10);
		txfSenhaLug.setBounds(105, 34, 550, 20);
		frmSave.getContentPane().add(txfSenhaLug);
		
		txfLoginRag = new JTextField();
		txfLoginRag.setFont(new Font("Arial", Font.PLAIN, 12));
		txfLoginRag.setColumns(10);
		txfLoginRag.setBounds(105, 59, 550, 20);
		frmSave.getContentPane().add(txfLoginRag);
		
		txfSenhaRag = new JTextField();
		txfSenhaRag.setFont(new Font("Arial", Font.PLAIN, 12));
		txfSenhaRag.setColumns(10);
		txfSenhaRag.setBounds(105, 83, 550, 20);
		frmSave.getContentPane().add(txfSenhaRag);
		
		txfLoginEmail = new JTextField();
		txfLoginEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txfLoginEmail.setColumns(10);
		txfLoginEmail.setBounds(105, 109, 550, 20);
		frmSave.getContentPane().add(txfLoginEmail);
		
		txfSenhaEmail = new JTextField();
		txfSenhaEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txfSenhaEmail.setColumns(10);
		txfSenhaEmail.setBounds(105, 134, 550, 20);
		frmSave.getContentPane().add(txfSenhaEmail);
		
		txfUrlLug = new JTextField();
		txfUrlLug.setFont(new Font("Arial", Font.PLAIN, 12));
		txfUrlLug.setColumns(10);
		txfUrlLug.setBounds(105, 159, 550, 20);
		frmSave.getContentPane().add(txfUrlLug);
		
		JButton btnSave = new JButton("Contemple o ovo!");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				if (!txfLoginLuG.getText().isEmpty() && !txfSenhaEmail.getText().isEmpty() && !txfLoginRag.getText().isEmpty() && 
				!txfSenhaRag.getText().isEmpty() && !txfLoginLuG.getText().isEmpty() && !txfSenhaLug.getText().isEmpty() && !txfUrlLug.getText().isEmpty()) {
					
					boolean bol = new codigo.Json().Save(txfLoginLuG.getText(), txfSenhaEmail.getText(), txfLoginRag.getText(), 
							txfSenhaRag.getText(), txfLoginLuG.getText(), txfSenhaLug.getText(), txfUrlLug.getText());
					if (bol)
						JOptionPane.showMessageDialog(null, "Conta cadastrada.");
					else
						JOptionPane.showMessageDialog(null, "Conta já está cadastrada");
				}
				else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				}
			}
		});
		btnSave.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSave.setBounds(10, 186, 645, 23);
		frmSave.getContentPane().add(btnSave);
	}
}
