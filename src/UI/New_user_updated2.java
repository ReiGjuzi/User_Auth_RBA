package UI;

import java.awt.EventQueue;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import model.AccessLevel;
import model.PasswordUtil;
import model.Role;
import model.User;
import model.UserPermissions;
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
	private final SecureRandom random = new SecureRandom();
	private final boolean editing;
	private User currentUser;
	private boolean adjustingPermissions;
	private JPanel contentPane;
	private JLabel titleLabel;
	private JLabel codeLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox roleComboBox;
	private JButton saveButton;
	private PermissionRow createOrderRow;
	private PermissionRow editOrderRow;
	private PermissionRow confirmPurchaseRow;
	private PermissionRow deletePurchaseRow;
	private PermissionRow editShowNameRow;
	private PermissionRow editShowInfoRow;
	private PermissionRow addShowRow;
	private PermissionRow deleteShowRow;

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
		this(store, parent, null);
	}

	public New_user_updated2(UserStoreFile store, JFrame parent, User user) {
		this.store = store;
		this.parent = parent;
		this.currentUser = user;
		this.editing = user != null;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 943);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleLabel = new JLabel(editing ? "Edit User" : "Register User");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		titleLabel.setBackground(new Color(0, 0, 0));
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setBounds(136, 11, 158, 37);
		contentPane.add(titleLabel);
		
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
		
		codeLabel = new JLabel(editing ? "New Code :" : "Code :");
		codeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		codeLabel.setBackground(new Color(0, 0, 0));
		codeLabel.setForeground(new Color(255, 255, 255));
		codeLabel.setBounds(25, 762, 80, 14);
		contentPane.add(codeLabel);
		
		saveButton = new JButton(editing ? "Save Changes" : "Create User");
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		saveButton.setBackground(new Color(0, 0, 0));
		saveButton.setForeground(new Color(255, 255, 255));
		saveButton.setBounds(153, 806, 140, 37);
		contentPane.add(saveButton);
		
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
		
		roleComboBox = new JComboBox();
		roleComboBox.setModel(new DefaultComboBoxModel(buildRoleDisplayNames()));
		roleComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		roleComboBox.setBounds(106, 245, 292, 22);
		contentPane.add(roleComboBox);
		
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

		createOrderRow = new PermissionRow(chckbxNewCheckBox, chckbxNewCheckBox_1, chckbxNewCheckBox_2);
		editOrderRow = new PermissionRow(chckbxNewCheckBox_3, chckbxNewCheckBox_4, chckbxNewCheckBox_5);
		confirmPurchaseRow = new PermissionRow(chckbxNewCheckBox_3_1, chckbxNewCheckBox_3_2, chckbxNewCheckBox_3_3);
		deletePurchaseRow = new PermissionRow(chckbxNewCheckBox_3_1_1, chckbxNewCheckBox_3_1_2, chckbxNewCheckBox_3_1_3);
		editShowNameRow = new PermissionRow(chckbxNewCheckBox_3_1_1_1, chckbxNewCheckBox_3_1_1_2, chckbxNewCheckBox_3_1_1_3);
		editShowInfoRow = new PermissionRow(chckbxNewCheckBox_3_1_1_1_1, chckbxNewCheckBox_3_1_1_1_1_1, chckbxNewCheckBox_3_1_1_1_1_2);
		addShowRow = new PermissionRow(chckbxNewCheckBox_3_1_1_1_1_3, chckbxNewCheckBox_3_1_1_1_1_1_1, chckbxNewCheckBox_3_1_1_1_1_1_2);
		deleteShowRow = new PermissionRow(chckbxNewCheckBox_3_1_1_1_1_3_1, chckbxNewCheckBox_3_1_1_1_1_3_2, chckbxNewCheckBox_3_1_1_1_1_3_3);

		bindRow(createOrderRow);
		bindRow(editOrderRow);
		bindRow(confirmPurchaseRow);
		bindRow(deletePurchaseRow);
		bindRow(editShowNameRow);
		bindRow(editShowInfoRow);
		bindRow(addShowRow);
		bindRow(deleteShowRow);

		if (editing && currentUser != null) {
			textField.setText(currentUser.getUsername());
			textField_1.setText(currentUser.getLastName());
			textField_2.setText(currentUser.getAge());
			textField_3.setText(currentUser.getGender());
			textField_4.setText(currentUser.getSalary());
			if (currentUser.getRole() != null) {
				roleComboBox.setSelectedItem(currentUser.getRole().getDisplayName());
			}
		}

		applyRoleSelection(Role.fromDisplayName(roleComboBox.getSelectedItem().toString()));

		if (editing && currentUser != null && currentUser.getRole() == Role.CUSTOM) {
			if (currentUser.getPermissions() != null) {
				setPermissionsOnRows(currentUser.getPermissions());
			}
		}

		roleComboBox.addActionListener(e -> {
			Role role = Role.fromDisplayName(roleComboBox.getSelectedItem().toString());
			applyRoleSelection(role);
		});

		btnNewButton_2.addActionListener(e -> {
			Role role = Role.fromDisplayName(roleComboBox.getSelectedItem().toString());
			textField_5.setText(generateCode(role));
		});

		saveButton.addActionListener(e -> {
			String username = textField.getText().trim();
			String surname = textField_1.getText().trim();
			String age = textField_2.getText().trim();
			String gender = textField_3.getText().trim();
			String salary = textField_4.getText().trim();
			String code = textField_5.getText().trim();

			if (username.isEmpty()) {
				titleLabel.setText("Missing name");
				return;
			}

			Role role = Role.fromDisplayName(roleComboBox.getSelectedItem().toString());
			String hashedCode = null;

			if (editing) {
				if (!code.isEmpty()) {
					if (!code.matches("\\d{4}")) {
						titleLabel.setText("Code must be 4 digits");
						return;
					}
					if (store.codeInUseByOther(code, currentUser.getUsername())) {
						titleLabel.setText("Code already used");
						return;
					}
					if (code.charAt(0) != role.getCodePrefix()) {
						titleLabel.setText("Code must start with " + role.getCodePrefix());
						return;
					}
					hashedCode = PasswordUtil.hash(code);
				} else {
					hashedCode = currentUser.getPassword();
				}
				if (!username.equals(currentUser.getUsername()) && store.exists(username)) {
					titleLabel.setText("Username exists");
					return;
				}
			} else {
				if (code.isEmpty()) {
					titleLabel.setText("Missing code");
					return;
				}
				if (!code.matches("\\d{4}")) {
					titleLabel.setText("Code must be 4 digits");
					return;
				}
				if (store.exists(username)) {
					titleLabel.setText("Username exists");
					return;
				}
				if (store.codeExists(code)) {
					titleLabel.setText("Code already used");
					return;
				}
				if (code.charAt(0) != role.getCodePrefix()) {
					titleLabel.setText("Code must start with " + role.getCodePrefix());
					return;
				}
				hashedCode = PasswordUtil.hash(code);
			}

			UserPermissions permissions = role == Role.CUSTOM
					? readPermissionsFromRows()
					: UserPermissions.forRole(role);

			User updatedUser = new User(username, hashedCode, role, username, surname, age, gender, salary, permissions);
			if (editing) {
				String existingUsername = currentUser.getUsername();
				if (!store.update(existingUsername, updatedUser)) {
					titleLabel.setText("User not found");
					return;
				}
				currentUser = updatedUser;
				textField_5.setText("");
				titleLabel.setText("Updated: " + username);
			} else {
				store.add(updatedUser);
				titleLabel.setText("Created: " + username);

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}
		});

		btnNewButton_1.addActionListener(e -> {
			if (parent != null) {
				parent.setVisible(true);
			}
			dispose();
		});
	}

	private void bindRow(PermissionRow row) {
		row.none.setSelected(true);
		row.none.addActionListener(e -> {
			if (adjustingPermissions) {
				return;
			}
			adjustingPermissions = true;
			if (row.none.isSelected()) {
				row.read.setSelected(false);
				row.write.setSelected(false);
			}
			adjustingPermissions = false;
		});

		row.read.addActionListener(e -> syncRowSelection(row));
		row.write.addActionListener(e -> syncRowSelection(row));
	}

	private void applyRoleSelection(Role role) {
		if (role == Role.CUSTOM) {
			setPermissionRowsEnabled(true);
			setPermissionsOnRows(UserPermissions.none());
			return;
		}
		setPermissionsOnRows(UserPermissions.forRole(role));
		setPermissionRowsEnabled(false);
	}

	private void setPermissionRowsEnabled(boolean enabled) {
		setRowEnabled(createOrderRow, enabled);
		setRowEnabled(editOrderRow, enabled);
		setRowEnabled(confirmPurchaseRow, enabled);
		setRowEnabled(deletePurchaseRow, enabled);
		setRowEnabled(editShowNameRow, enabled);
		setRowEnabled(editShowInfoRow, enabled);
		setRowEnabled(addShowRow, enabled);
		setRowEnabled(deleteShowRow, enabled);
	}

	private void setRowEnabled(PermissionRow row, boolean enabled) {
		row.read.setEnabled(enabled);
		row.write.setEnabled(enabled);
		row.none.setEnabled(enabled);
	}

	private void setPermissionsOnRows(UserPermissions permissions) {
		setRowLevel(createOrderRow, permissions.getCreateOrder());
		setRowLevel(editOrderRow, permissions.getEditOrder());
		setRowLevel(confirmPurchaseRow, permissions.getConfirmPurchase());
		setRowLevel(deletePurchaseRow, permissions.getDeletePurchase());
		setRowLevel(editShowNameRow, permissions.getEditShowName());
		setRowLevel(editShowInfoRow, permissions.getEditShowInfo());
		setRowLevel(addShowRow, permissions.getAddShow());
		setRowLevel(deleteShowRow, permissions.getDeleteShow());
	}

	private UserPermissions readPermissionsFromRows() {
		return new UserPermissions(
				getRowLevel(createOrderRow),
				getRowLevel(editOrderRow),
				getRowLevel(confirmPurchaseRow),
				getRowLevel(deletePurchaseRow),
				getRowLevel(editShowNameRow),
				getRowLevel(editShowInfoRow),
				getRowLevel(addShowRow),
				getRowLevel(deleteShowRow)
		);
	}

	private void setRowLevel(PermissionRow row, AccessLevel level) {
		adjustingPermissions = true;
		row.read.setSelected(level == AccessLevel.READ || level == AccessLevel.READ_WRITE);
		row.write.setSelected(level == AccessLevel.WRITE || level == AccessLevel.READ_WRITE);
		row.none.setSelected(level == AccessLevel.NONE);
		adjustingPermissions = false;
	}

	private AccessLevel getRowLevel(PermissionRow row) {
		if (row.none.isSelected()) {
			return AccessLevel.NONE;
		}
		boolean read = row.read.isSelected();
		boolean write = row.write.isSelected();
		if (read && write) {
			return AccessLevel.READ_WRITE;
		}
		if (write) {
			return AccessLevel.WRITE;
		}
		if (read) {
			return AccessLevel.READ;
		}
		return AccessLevel.NONE;
	}

	private void syncRowSelection(PermissionRow row) {
		if (adjustingPermissions) {
			return;
		}
		adjustingPermissions = true;
		boolean read = row.read.isSelected();
		boolean write = row.write.isSelected();
		row.none.setSelected(!read && !write);
		adjustingPermissions = false;
	}

	private String generateCode(Role role) {
		char prefix = role == null ? Role.CUSTOM.getCodePrefix() : role.getCodePrefix();
		for (int attempt = 0; attempt < 1000; attempt++) {
			int suffix = random.nextInt(1000);
			String code = prefix + String.format("%03d", suffix);
			if (!store.codeExists(code)) {
				return code;
			}
		}
		return prefix + String.format("%03d", random.nextInt(1000));
	}

	private String[] buildRoleDisplayNames() {
		Role[] roles = Role.selectableRoles();
		List<Role> roleList = new ArrayList<>();
		for (Role role : roles) {
			roleList.add(role);
		}
		if (editing && currentUser != null && currentUser.getRole() != null) {
			boolean found = false;
			for (Role role : roleList) {
				if (role == currentUser.getRole()) {
					found = true;
					break;
				}
			}
			if (!found) {
				roleList.add(currentUser.getRole());
			}
		}
		String[] names = new String[roleList.size()];
		for (int i = 0; i < roleList.size(); i++) {
			names[i] = roleList.get(i).getDisplayName();
		}
		return names;
	}

	private static class PermissionRow {
		private final JCheckBox read;
		private final JCheckBox write;
		private final JCheckBox none;

		private PermissionRow(JCheckBox read, JCheckBox write, JCheckBox none) {
			this.read = read;
			this.write = write;
			this.none = none;
		}
	}
}
