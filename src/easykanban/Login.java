/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package easykanban;

/**
 *
 * @author RC_Student_lab
 */


public class Login {
    private UserManager userManager;

    public Login(UserManager userManager) {
        this.userManager = userManager;
    }

    public void start() {
        while (true) {
            String option = JOptionPane.showInputDialog(null, "1) Register\n2) Login\n3) Quit");
            if (option == null || option.isEmpty()) {
                continue;
            }

            switch (option) {
                case "1":
                    userManager.registerUser();
                    break;
                case "2":
                    if (userManager.loginUser()) {
                        EasyKanban.runKanban();
                    }
                    break;
                case "3":
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice, please try again.");
            }
        }
    }
}
