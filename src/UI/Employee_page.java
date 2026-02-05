package UI;

import java.awt.EventQueue;

import model.AccessLevel;
import model.User;
import model.UserPermissions;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class Employee_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JFrame parent;
	private final User user;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel newTicketPanel;
	private JPanel ordersPanel;
	private JPanel changesPanel;
	private JComboBox showComboBox;
	private JComboBox hallComboBox;
	private JTextField timeField;
	private JTextField dateField;
	private JTextField seatField;
	private JTextField ticketPriceField;
	private JTextField ticketQuantityField;
	private JTextField totalPriceField;
	private JButton quantityPlusButton;
	private JButton quantityMinusButton;
	private JButton saveOrderButton;
	private JButton orderSlot1Button;
	private JButton orderSlot2Button;
	private JButton confirmPurchaseButton;
	private JButton deleteOrderButton;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_page frame = new Employee_page(new User("Employee", "", model.Role.BOX_OFFICE), null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Employee_page(User user, JFrame parent) {
		this.user = user;
		this.parent = parent;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 565);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(buildDisplayName(user));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 177, 29);
		contentPane.add(lblNewLabel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 80, 517, 435);
		contentPane.add(tabbedPane);
		
		newTicketPanel = new JPanel();
		newTicketPanel.setBackground(new Color(0, 0, 0));
		newTicketPanel.setForeground(new Color(255, 255, 255));
		tabbedPane.addTab("New Ticket", null, newTicketPanel, null);
		newTicketPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Show Name :");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 11, 102, 19);
		newTicketPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hall :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 41, 102, 19);
		newTicketPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Time :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 71, 102, 19);
		newTicketPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Seat :");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 126, 102, 19);
		newTicketPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ticket Price :");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 156, 102, 25);
		newTicketPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ticket Quantinty :");
		lblNewLabel_6.setBackground(new Color(0, 0, 0));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 192, 122, 19);
		newTicketPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Date :");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBackground(new Color(0, 0, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 101, 46, 14);
		newTicketPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Total Price :");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBackground(new Color(0, 0, 0));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(10, 222, 122, 25);
		newTicketPanel.add(lblNewLabel_8);
		
		showComboBox = new JComboBox();
		showComboBox.setForeground(new Color(255, 255, 255));
		showComboBox.setBackground(new Color(0, 0, 0));
		showComboBox.setModel(new DefaultComboBoxModel(new String[] {"Name1", "Name2", "Name3", "Name4", "Don't pick Name 4", "Pick Name2", "Name1 will cause", "System32 to be deleted"}));
		showComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		showComboBox.setBounds(176, 11, 326, 22);
		newTicketPanel.add(showComboBox);
		
		hallComboBox = new JComboBox();
		hallComboBox.setBackground(new Color(0, 0, 0));
		hallComboBox.setForeground(new Color(255, 255, 255));
		hallComboBox.setModel(new DefaultComboBoxModel(new String[] {"Hall 1", "Hall 2", "Hall 3", "Hall 4", "Hall 5", "Hall X", "Hall 7", "Hall Z"}));
		hallComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		hallComboBox.setBounds(176, 41, 326, 22);
		newTicketPanel.add(hallComboBox);
		
		timeField = new JTextField();
		timeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		timeField.setBounds(176, 72, 326, 20);
		newTicketPanel.add(timeField);
		timeField.setColumns(10);
		
		dateField = new JTextField();
		dateField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateField.setBounds(176, 100, 326, 20);
		newTicketPanel.add(dateField);
		dateField.setColumns(10);
		
		seatField = new JTextField();
		seatField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		seatField.setBounds(176, 127, 326, 20);
		newTicketPanel.add(seatField);
		seatField.setColumns(10);
		
		ticketPriceField = new JTextField();
		ticketPriceField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ticketPriceField.setBounds(176, 160, 326, 20);
		newTicketPanel.add(ticketPriceField);
		ticketPriceField.setColumns(10);
		
		ticketQuantityField = new JTextField();
		ticketQuantityField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ticketQuantityField.setBounds(176, 193, 86, 20);
		newTicketPanel.add(ticketQuantityField);
		ticketQuantityField.setColumns(10);
		
		quantityPlusButton = new JButton("+");
		quantityPlusButton.setForeground(new Color(255, 255, 255));
		quantityPlusButton.setBackground(new Color(0, 0, 0));
		quantityPlusButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		quantityPlusButton.setBounds(277, 192, 46, 23);
		newTicketPanel.add(quantityPlusButton);
		
		quantityMinusButton = new JButton("-");
		quantityMinusButton.setBackground(new Color(0, 0, 0));
		quantityMinusButton.setForeground(new Color(255, 255, 255));
		quantityMinusButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		quantityMinusButton.setBounds(333, 192, 46, 23);
		newTicketPanel.add(quantityMinusButton);
		
		totalPriceField = new JTextField();
		totalPriceField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		totalPriceField.setBounds(176, 226, 203, 20);
		newTicketPanel.add(totalPriceField);
		totalPriceField.setColumns(10);
		
		saveOrderButton = new JButton("Save Order");
		saveOrderButton.setForeground(new Color(255, 255, 255));
		saveOrderButton.setBackground(new Color(0, 0, 0));
		saveOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		saveOrderButton.setBounds(155, 300, 183, 49);
		newTicketPanel.add(saveOrderButton);
		
		ordersPanel = new JPanel();
		tabbedPane.addTab("Orders", null, ordersPanel, null);
		ordersPanel.setLayout(null);
		
		orderSlot1Button = new JButton("Save1");
		orderSlot1Button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		orderSlot1Button.setBounds(10, 11, 106, 101);
		ordersPanel.add(orderSlot1Button);
		
		orderSlot2Button = new JButton("Save2");
		orderSlot2Button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		orderSlot2Button.setBounds(150, 11, 106, 101);
		ordersPanel.add(orderSlot2Button);
		
		confirmPurchaseButton = new JButton("Confirm Purchase");
		confirmPurchaseButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		confirmPurchaseButton.setBounds(280, 375, 147, 23);
		ordersPanel.add(confirmPurchaseButton);
		
		deleteOrderButton = new JButton("Delete Order");
		deleteOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteOrderButton.setBounds(93, 375, 147, 23);
		ordersPanel.add(deleteOrderButton);
		
		changesPanel = new JPanel();
		tabbedPane.addTab("Changes", null, changesPanel, null);
		changesPanel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Add New Show :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(10, 48, 125, 19);
		changesPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Edit Show Information :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(10, 94, 160, 19);
		changesPanel.add(lblNewLabel_10);
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(438, 20, 89, 23);
		contentPane.add(btnNewButton_2);

		btnNewButton_2.addActionListener(e -> {
			if (parent != null) {
				parent.setVisible(true);
			}
			dispose();
		});

		UserPermissions permissions = user == null || user.getPermissions() == null
				? UserPermissions.none()
				: user.getPermissions();
		applyPermissions(permissions);
	}

	private void applyPermissions(UserPermissions permissions) {
		AccessLevel createOrder = permissions.getCreateOrder();
		boolean createEnabled = createOrder != AccessLevel.NONE;
		showComboBox.setEnabled(createEnabled);
		hallComboBox.setEnabled(createEnabled);
		timeField.setEnabled(createEnabled);
		dateField.setEnabled(createEnabled);
		seatField.setEnabled(createEnabled);
		ticketPriceField.setEnabled(createEnabled);
		ticketQuantityField.setEnabled(createEnabled);
		totalPriceField.setEnabled(createEnabled);
		boolean createWrite = createOrder == AccessLevel.WRITE || createOrder == AccessLevel.READ_WRITE;
		quantityPlusButton.setEnabled(createWrite);
		quantityMinusButton.setEnabled(createWrite);
		saveOrderButton.setEnabled(createWrite);

		boolean editWrite = permissions.getEditOrder() == AccessLevel.WRITE
				|| permissions.getEditOrder() == AccessLevel.READ_WRITE;
		orderSlot1Button.setEnabled(editWrite);
		orderSlot2Button.setEnabled(editWrite);

		confirmPurchaseButton.setEnabled(permissions.getConfirmPurchase() == AccessLevel.WRITE
				|| permissions.getConfirmPurchase() == AccessLevel.READ_WRITE);
		deleteOrderButton.setEnabled(permissions.getDeletePurchase() == AccessLevel.WRITE
				|| permissions.getDeletePurchase() == AccessLevel.READ_WRITE);

		boolean showAccess = permissions.getEditShowName() != AccessLevel.NONE
				|| permissions.getEditShowInfo() != AccessLevel.NONE
				|| permissions.getAddShow() != AccessLevel.NONE
				|| permissions.getDeleteShow() != AccessLevel.NONE;
		int changesIndex = tabbedPane.indexOfComponent(changesPanel);
		if (changesIndex >= 0) {
			tabbedPane.setEnabledAt(changesIndex, showAccess);
		}
	}

	private String buildDisplayName(User user) {
		if (user == null) {
			return "Employee";
		}
		String firstName = user.getFirstName() == null ? "" : user.getFirstName().trim();
		String lastName = user.getLastName() == null ? "" : user.getLastName().trim();
		if (!firstName.isEmpty() && !lastName.isEmpty()) {
			return firstName + " " + lastName;
		}
		if (!firstName.isEmpty()) {
			return firstName;
		}
		if (!lastName.isEmpty()) {
			return lastName;
		}
		String username = user.getUsername();
		return username == null || username.isEmpty() ? "Employee" : username;
	}
}
