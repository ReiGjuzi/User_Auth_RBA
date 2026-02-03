package model;

import javax.swing.SwingUtilities;
import model.UserStore;

public class AppMain {
    public static void main(String[] args) {
        UserStore store = new UserStore();

        new model.Login_page(store).setVisible(true);
    }
}