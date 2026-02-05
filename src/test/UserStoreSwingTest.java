package test;
import model.PasswordUtil;
import model.Role;
import model.User;
import model.UserStoreFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserStoreSwingTest extends JFrame {

    private final UserStoreFile store = new UserStoreFile();
    private final JTextField usernameField = new JTextField(12);
    private final JTextField passwordField = new JTextField(12);
    private final JLabel status = new JLabel(" ");

    public UserStoreSwingTest() {
        super("UserStore Mini Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton saveBtn = new JButton("Save");

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String u = usernameField.getText().trim();
                String p = passwordField.getText().trim();

                if (u.isEmpty() || p.isEmpty()) {
                    status.setText("Username and password required");
                    return;
                }

                if (store.exists(u)) {
                    status.setText("User already exists");
                    return;
                }

                String hashed = PasswordUtil.hash(p);
                store.add(new User(u, hashed, Role.BOX_OFFICE));
                status.setText("Stored user: " + u);
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(saveBtn);
        panel.add(status);

        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new UserStoreSwingTest().setVisible(true);
    }
}
