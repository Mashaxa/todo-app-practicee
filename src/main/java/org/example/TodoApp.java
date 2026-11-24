package org.example;

import java.util.List;
import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        System.out.println("=== TODO LIST ===");

        while (running) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add task");
            System.out.println("2. Show tasks");
            System.out.println("3. Delete task");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    todoList.add(task);
                    System.out.println("Task added!");
                    break;

                case "2":
                    List<String> tasks = todoList.getAll();

                    if (tasks.isEmpty()) {
                        System.out.println("The task list is empty.");
                    } else {
                        System.out.println("\nYour tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case "3":
                    List<String> currentTasks = todoList.getAll();

                    if (currentTasks.isEmpty()) {
                        System.out.println("There are no tasks to delete.");
                        break;
                    }

                    System.out.println("Enter the task number to delete:");
                    for (int i = 0; i < currentTasks.size(); i++) {
                        System.out.println((i + 1) + ". " + currentTasks.get(i));
                    }

                    try {
                        int number = Integer.parseInt(scanner.nextLine());

                        if (todoList.remove(number - 1)) {
                            System.out.println("Task deleted!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }

        scanner.close();
    }
}
