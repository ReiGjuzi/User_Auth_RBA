package app;

import UI.Login_page;
import model.UserStoreFile;

public class AppMain {
    public static void main(String[] args) {
        UserStoreFile store = new UserStoreFile();

        new Login_page(store).setVisible(true);
    }
}