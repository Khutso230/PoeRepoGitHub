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

public class EasyKanban {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Login login = new Login(userManager);
        login.start();
    }

    public static void runKanban() {
        String welcomeMessage = "Welcome to EasyKanban";
        JOptionPane.showMessageDialog(null, welcomeMessage);

        while (true) {
            String choice = JOptionPane.showInputDialog(null, "Please choose an option:\n1) Add tasks\n2) Show report\n3) Quit");

            if (choice == null || choice.isEmpty()) {
                continue;
            }

            switch (choice) {
                case "1" -> addTasks();
                case "2" -> JOptionPane.showMessageDialog(null, "Coming Soon");
                case "3" -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Invalid choice, please try again.");
            }
        }
    }

    private static void addTasks() {
        String numTasksStr = JOptionPane.showInputDialog(null, "How many tasks do you want to enter?");
        if (numTasksStr == null || numTasksStr.isEmpty()) {
            return;
        }

        int numTasks;
        try {
            numTasks = Integer.parseInt(numTasksStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number of tasks.");
            return;
        }

        Task[] tasks = new Task[numTasks];

        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog(null, "Enter task name:");
            if (taskName == null || taskName.isEmpty()) {
                i--;
                continue;
            }

            String taskDescription = JOptionPane.showInputDialog(null, "Enter task description:");
            if (taskDescription == null || taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                i--;
                continue;
            }

            String developerFirstName = JOptionPane.showInputDialog(null, "Enter developer first name:");
            String developerLastName = JOptionPane.showInputDialog(null, "Enter developer last name:");
            String taskDurationStr = JOptionPane.showInputDialog(null, "Enter task duration (in hours):");

            int taskDuration;
            try {
                taskDuration = Integer.parseInt(taskDurationStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid task duration.");
                i--;
                continue;
            }

            String[] statusOptions = {"To Do", "Doing", "Done"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

            if (taskStatus == null || taskStatus.isEmpty()) {
                i--;
                continue;
            }

            Task task = new Task(taskName, taskDescription, developerFirstName, developerLastName, taskDuration, taskStatus);
            JOptionPane.showMessageDialog(null, task.checkTaskDescription());
            if (task.checkTaskDescription().equals("Task successfully captured")) {
                tasks[i] = task;
                JOptionPane.showMessageDialog(null, task.printTaskDetails());
            } else {
                i--;
            }
        }

        int totalHours = Task.returnTotalHours(tasks);
        JOptionPane.showMessageDialog(null, "Total duration for all tasks: " + totalHours + " hours");
    }
}
