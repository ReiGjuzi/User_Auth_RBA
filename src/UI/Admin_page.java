package UI;

import model.UserStoreFile;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private final UserStoreFile store;
	private final JFrame parent;
	private JPanel contentPane;

	public Admin_page(UserStoreFile store, JFrame parent) {

		this.store = store;
		this.parent = parent;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(127, 21, 206, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add New User");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(22, 105, 391, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit User");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(22, 126, 391, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete User");
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(22, 149, 391, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Performe actions:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(22, 80, 152, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("Add product");
		btnNewButton_4.setBackground(new Color(0, 0, 0));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(22, 216, 391, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Edit Product");
		btnNewButton_5.setBackground(new Color(0, 0, 0));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBounds(22, 237, 391, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Delete Product");
		btnNewButton_6.setBackground(new Color(0, 0, 0));
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setBounds(22, 260, 391, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("<- Go Back to Log In Page");
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_7.setBackground(new Color(0, 0, 0));
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBounds(22, 341, 206, 40);
		contentPane.add(btnNewButton_7);

		btnNewButton.addActionListener(e -> { // Add New User
			new New_user(store, this).setVisible(true);
			setVisible(false);
		});

		btnNewButton_1.addActionListener(e -> { // Edit User
			new Edit_user(store, this).setVisible(true);
			setVisible(false);
		});

		btnNewButton_2.addActionListener(e -> { // Delete User
			new Delete_user(store, this).setVisible(true);
			setVisible(false);
		});

		btnNewButton_7.addActionListener(e -> { // Go Back to login
			parent.setVisible(true);
			dispose();
		});
	}


}
