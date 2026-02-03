package UI;

import model.PasswordUtil;
import model.Role;
import model.UserStoreFile;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField passwordField;

	private UserStoreFile store;

	public Login_page(UserStoreFile store) {

		this.store = store;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(117, 82, 210, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(117, 145, 210, 14);
		contentPane.add(lblPassword);

		passwordField = new JTextField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(150, 165, 117, 30);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(137, 215, 139, 44);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(150, 117, 117, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(131, 31, 169, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);

		btnNewButton.addActionListener(e -> {
			String u = textField.getText().trim();
			String p = passwordField.getText().trim();

			if (u.isEmpty() || p.isEmpty()) {
				lblNewLabel_1.setText("Enter username and password");
				return;
			}

			if (!store.exists(u)) {
				lblNewLabel_1.setText("User not found");
				return;
			}

			String hashedInput = PasswordUtil.hash(p);

			if (!store.get(u).getPassword().equals(hashedInput)) {
				lblNewLabel_1.setText("Wrong password");
				return;
			}

			if (store.get(u).getRole() == Role.ADMIN) {
				new Admin_page(store, this).setVisible(true);
				setVisible(false);
			} else {
				lblNewLabel_1.setText("Logged in as USER: " + u);
			}
		});



	}

}
