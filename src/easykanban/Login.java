/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package easykanban;

/**
 *
 * @author RC_Student_lab
 */
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Login {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        // Initialize users map with sample data
        users.put("user1", "password1");
        users.put("user2", "password2");

        // Proceed to login
        if (login()) {
            EasyKanban.main(args);  // Start the main application after successful login
        }
    }

    public static boolean login() {
        String username = JOptionPane.showInputDialog(null, "Enter your username:");
        String password = JOptionPane.showInputDialog(null, "Enter your password:");

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Login failed. Please enter both username and password.");
            return false;
        }

        if (users.containsKey(username) && users.get(username).equals(password)) {
            JOptionPane.showMessageDialog(null, "Login successful!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.");
            return false;
        }
    }
}
