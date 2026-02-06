package UI;

import model.User;
import model.UserStoreFile;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Edit_user extends JFrame {

    private static final long serialVersionUID = 1L;
    private final UserStoreFile store;
    private final JFrame parent;
    private JPanel contentPane;
    private JComboBox userComboBox;
    private JLabel statusLabel;

    public Edit_user(UserStoreFile store, JFrame parent) {
        this.store = store;
        this.parent = parent;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 260);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("Edit User");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(160, 11, 140, 29);
        contentPane.add(titleLabel);

        JLabel selectLabel = new JLabel("Select User :");
        selectLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        selectLabel.setForeground(Color.WHITE);
        selectLabel.setBounds(25, 80, 100, 19);
        contentPane.add(selectLabel);

        userComboBox = new JComboBox();
        userComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        userComboBox.setBounds(130, 80, 270, 22);
        contentPane.add(userComboBox);

        JButton editButton = new JButton("Edit");
        editButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        editButton.setBackground(new Color(0, 0, 0));
        editButton.setForeground(new Color(255, 255, 255));
        editButton.setBounds(160, 125, 110, 32);
        contentPane.add(editButton);

        JButton backButton = new JButton("<- Go Back");
        backButton.setBackground(new Color(0, 0, 0));
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setBounds(25, 178, 106, 32);
        contentPane.add(backButton);

        statusLabel = new JLabel("");
        statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setBounds(25, 210, 375, 19);
        contentPane.add(statusLabel);

        refreshUsers();

        editButton.addActionListener(e -> {
            String username = userComboBox.getSelectedItem() == null
                    ? null
                    : userComboBox.getSelectedItem().toString();
            if (username == null || username.isEmpty()) {
                statusLabel.setText("No user selected");
                return;
            }
            User user = store.get(username);
            if (user == null) {
                statusLabel.setText("User not found");
                refreshUsers();
                return;
            }
            new New_user_updated2(store, this, user).setVisible(true);
            setVisible(false);
        });

        backButton.addActionListener(e -> {
            if (parent != null) {
                parent.setVisible(true);
            }
            dispose();
        });
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            refreshUsers();
        }
        super.setVisible(visible);
    }

    private void refreshUsers() {
        List<String> usernames = new ArrayList<>();
        for (User user : store.getAll()) {
            if (user != null && user.getUsername() != null && !user.getUsername().isEmpty()) {
                usernames.add(user.getUsername());
            }
        }
        Collections.sort(usernames);
        userComboBox.setModel(new DefaultComboBoxModel(usernames.toArray(new String[0])));
        if (usernames.isEmpty()) {
            statusLabel.setText("No users found");
        } else {
            statusLabel.setText("");
        }
    }
}
