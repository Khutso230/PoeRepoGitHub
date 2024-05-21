/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package easykanban;

/**
 *
 * @author RC_Student_lab
 */


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void registerUser() {
        String username = JOptionPane.showInputDialog(null, "Enter a username:");
        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username cannot be empty.");
            return;
        }

        String password = JOptionPane.showInputDialog(null, "Enter a password:");
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty.");
            return;
        }

        users.add(new User(username, password));
        JOptionPane.showMessageDialog(null, "Registration successful!");
    }

    public boolean loginUser() {
        String username = JOptionPane.showInputDialog(null, "Enter your username:");
        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username cannot be empty.");
            return false;
        }

        String password = JOptionPane.showInputDialog(null, "Enter your password:");
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty.");
            return false;
        }

        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                JOptionPane.showMessageDialog(null, "Login successful!");
                return true;
            }
        }

        JOptionPane.showMessageDialog(null, "Invalid username or password.");
        return false;
    }
}
