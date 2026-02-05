package UI;

import java.awt.EventQueue;

import model.PasswordUtil;
import model.Role;
import model.User;
import model.UserStoreFile;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class New_user_updated2 extends JFrame {
	private static final long serialVersionUID = 1L;
	private final UserStoreFile store;
	private final JFrame parent;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_user_updated2 frame = new New_user_updated2(new UserStoreFile(), null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public New_user_updated2(UserStoreFile store, JFrame parent) {
		this.store = store;
		this.parent = parent;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 943);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register User");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(136, 11, 158, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(25, 79, 55, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Surname :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(25, 122, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(25, 165, 46, 19);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBackground(new Color(0, 0, 0));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(25, 206, 65, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Role :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(25, 247, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Salary :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBackground(new Color(0, 0, 0));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(25, 721, 55, 19);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Code :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBackground(new Color(0, 0, 0));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(25, 762, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Create User");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(153, 806, 114, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<- Go Back");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(25, 856, 106, 37);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(106, 80, 292, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(106, 121, 292, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(106, 166, 292, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 205, 292, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Employee1", "Employye2", "Employee3"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(106, 245, 292, 22);
		contentPane.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setBounds(106, 722, 292, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(106, 761, 245, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("<>");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 6));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_2.setBounds(363, 760, 35, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_8 = new JLabel("Costum Rights");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBackground(new Color(0, 0, 0));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(160, 287, 134, 30);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Read");
		lblNewLabel_9.setBackground(new Color(0, 0, 0));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(205, 328, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Write");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBackground(new Color(0, 0, 0));
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(278, 328, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Create an Order :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBackground(new Color(0, 0, 0));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(25, 365, 122, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("None");
		lblNewLabel_12.setBackground(new Color(0, 0, 0));
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(352, 328, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBackground(new Color(0, 0, 0));
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBounds(212, 365, 21, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_1.setBackground(Color.BLACK);
		chckbxNewCheckBox_1.setBounds(287, 365, 21, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setForeground(Color.WHITE);
		chckbxNewCheckBox_2.setBackground(Color.BLACK);
		chckbxNewCheckBox_2.setBounds(356, 365, 21, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		JLabel lblNewLabel_13 = new JLabel("Edit an Order\r\n :");
		lblNewLabel_13.setBackground(new Color(0, 0, 0));
		lblNewLabel_13.setForeground(new Color(255, 255, 255));
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(25, 413, 122, 14);
		contentPane.add(lblNewLabel_13);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		chckbxNewCheckBox_3.setForeground(Color.WHITE);
		chckbxNewCheckBox_3.setBackground(Color.BLACK);
		chckbxNewCheckBox_3.setBounds(212, 411, 21, 23);
		contentPane.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("");
		chckbxNewCheckBox_4.setForeground(Color.WHITE);
		chckbxNewCheckBox_4.setBackground(Color.BLACK);
		chckbxNewCheckBox_4.setBounds(287, 411, 21, 23);
		contentPane.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("");
		chckbxNewCheckBox_5.setForeground(Color.WHITE);
		chckbxNewCheckBox_5.setBackground(Color.BLACK);
		chckbxNewCheckBox_5.setBounds(356, 411, 21, 23);
		contentPane.add(chckbxNewCheckBox_5);
		
		JLabel lblNewLabel_14 = new JLabel("Confirm Purchase :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14.setBackground(new Color(0, 0, 0));
		lblNewLabel_14.setForeground(new Color(255, 255, 255));
		lblNewLabel_14.setBounds(25, 459, 140, 14);
		contentPane.add(lblNewLabel_14);
		
		JCheckBox chckbxNewCheckBox_3_1 = new JCheckBox("");
		chckbxNewCheckBox_3_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1.setBounds(212, 457, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1);
		
		JCheckBox chckbxNewCheckBox_3_2 = new JCheckBox("");
		chckbxNewCheckBox_3_2.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_2.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_2.setBounds(287, 457, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_2);
		
		JCheckBox chckbxNewCheckBox_3_3 = new JCheckBox("");
		chckbxNewCheckBox_3_3.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_3.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_3.setBounds(356, 457, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_3);
		
		JLabel lblNewLabel_14_1 = new JLabel("Delete Purchase :");
		lblNewLabel_14_1.setForeground(Color.WHITE);
		lblNewLabel_14_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1.setBackground(Color.BLACK);
		lblNewLabel_14_1.setBounds(25, 502, 140, 14);
		contentPane.add(lblNewLabel_14_1);
		
		JCheckBox chckbxNewCheckBox_3_1_1 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1.setBounds(212, 500, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1);
		
		JCheckBox chckbxNewCheckBox_3_1_2 = new JCheckBox("");
		chckbxNewCheckBox_3_1_2.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_2.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_2.setBounds(287, 500, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_2);
		
		JCheckBox chckbxNewCheckBox_3_1_3 = new JCheckBox("");
		chckbxNewCheckBox_3_1_3.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_3.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_3.setBounds(356, 500, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_3);
		
		JLabel lblNewLabel_14_1_1 = new JLabel("Edit Show Name :");
		lblNewLabel_14_1_1.setForeground(Color.WHITE);
		lblNewLabel_14_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1.setBackground(Color.BLACK);
		lblNewLabel_14_1_1.setBounds(25, 543, 140, 14);
		contentPane.add(lblNewLabel_14_1_1);
		
		JCheckBox chckbxNewCheckBox_3_1_1_1 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1_1.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1_1.setBounds(212, 541, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1_1);
		
		JCheckBox chckbxNewCheckBox_3_1_1_2 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1_2.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1_2.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1_2.setBounds(287, 541, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1_2);
		
		JCheckBox chckbxNewCheckBox_3_1_1_3 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1_3.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1_3.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1_3.setBounds(356, 541, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1_3);
		
		JLabel lblNewLabel_14_1_1_1 = new JLabel("Edit Show Info :");
		lblNewLabel_14_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_14_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_14_1_1_1.setBounds(25, 589, 140, 14);
		contentPane.add(lblNewLabel_14_1_1_1);
		
		JCheckBox chckbxNewCheckBox_3_1_1_1_1 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1_1_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1_1_1.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1_1_1.setBounds(212, 587, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1_1_1);
		
		JCheckBox chckbxNewCheckBox_3_1_1_1_1_1 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1_1_1_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1_1_1_1.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1_1_1_1.setBounds(287, 587, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1_1_1_1);
		
		JCheckBox chckbxNewCheckBox_3_1_1_1_1_2 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1_1_1_2.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1_1_1_2.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1_1_1_2.setBounds(356, 587, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1_1_1_2);
		
		JLabel lblNewLabel_14_1_1_1_1 = new JLabel("Add New Show :");
		lblNewLabel_14_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_14_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_14_1_1_1_1.setBounds(25, 631, 140, 14);
		contentPane.add(lblNewLabel_14_1_1_1_1);
		
		JCheckBox chckbxNewCheckBox_3_1_1_1_1_3 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1_1_1_3.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1_1_1_3.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1_1_1_3.setBounds(212, 629, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1_1_1_3);
		
		JCheckBox chckbxNewCheckBox_3_1_1_1_1_1_1 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1_1_1_1_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1_1_1_1_1.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1_1_1_1_1.setBounds(287, 629, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1_1_1_1_1);
		
		JCheckBox chckbxNewCheckBox_3_1_1_1_1_1_2 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1_1_1_1_2.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1_1_1_1_2.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1_1_1_1_2.setBounds(356, 629, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1_1_1_1_2);
		
		JLabel lblNewLabel_14_1_1_1_1_1 = new JLabel("Delete a Show :");
		lblNewLabel_14_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_14_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_14_1_1_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_14_1_1_1_1_1.setBounds(25, 674, 140, 14);
		contentPane.add(lblNewLabel_14_1_1_1_1_1);
		
		JCheckBox chckbxNewCheckBox_3_1_1_1_1_3_1 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1_1_1_3_1.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1_1_1_3_1.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1_1_1_3_1.setBounds(212, 672, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1_1_1_3_1);
		
		JCheckBox chckbxNewCheckBox_3_1_1_1_1_3_2 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1_1_1_3_2.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1_1_1_3_2.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1_1_1_3_2.setBounds(287, 672, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1_1_1_3_2);
		
		JCheckBox chckbxNewCheckBox_3_1_1_1_1_3_3 = new JCheckBox("");
		chckbxNewCheckBox_3_1_1_1_1_3_3.setForeground(Color.WHITE);
		chckbxNewCheckBox_3_1_1_1_1_3_3.setBackground(Color.BLACK);
		chckbxNewCheckBox_3_1_1_1_1_3_3.setBounds(356, 672, 21, 23);
		contentPane.add(chckbxNewCheckBox_3_1_1_1_1_3_3);

		btnNewButton.addActionListener(e -> {
			String username = textField.getText().trim();
			String plainPassword = textField_5.getText().trim();

			if (username.isEmpty() || plainPassword.isEmpty()) {
				lblNewLabel.setText("Missing username/password");
				return;
			}
			if (store.exists(username)) {
				lblNewLabel.setText("Username exists");
				return;
			}

			String roleStr = comboBox.getSelectedItem().toString();
			Role role = roleStr.equalsIgnoreCase("Admin") ? Role.ADMIN : Role.USER;

			String hashedPassword = PasswordUtil.hash(plainPassword);
			store.add(new User(username, hashedPassword, role));
			lblNewLabel.setText("Created: " + username);

			textField.setText("");
			textField_5.setText("");
		});

		btnNewButton_1.addActionListener(e -> {
			if (parent != null) {
				parent.setVisible(true);
			}
			dispose();
		});
	}
}
