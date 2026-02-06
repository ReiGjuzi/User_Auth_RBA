package UI;

import model.User;
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
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel statusLabel;

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

		statusLabel = new JLabel(" ");
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		statusLabel.setForeground(Color.WHITE);
		statusLabel.setBounds(117, 65, 210, 14);
		contentPane.add(statusLabel);

		usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setBounds(117, 95, 210, 14);
		contentPane.add(usernameLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(150, 115, 117, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordLabel = new JLabel("Code:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(117, 145, 210, 14);
		contentPane.add(passwordLabel);

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
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(131, 31, 169, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);

		btnNewButton.addActionListener(e -> {
			String username = textField.getText().trim();
			String code = passwordField.getText().trim();

			if (username.isEmpty()) {
				statusLabel.setText("Enter username");
				return;
			}
			if (code.isEmpty()) {
				statusLabel.setText("Enter code");
				return;
			}
			if (!code.matches("\\d{4}")) {
				statusLabel.setText("Code must be 4 digits");
				return;
			}
			User user = store.authenticate(username, code);
			if (user == null) {
				statusLabel.setText("Invalid credentials");
				return;
			}
			statusLabel.setText(" ");
			if (user.getRole().isAdmin()) {
				new Admin_page(store, this).setVisible(true);
			} else {
				new Employee_page(user, this).setVisible(true);
			}
			setVisible(false);
		});

	}

}
