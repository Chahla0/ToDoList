package DB_new;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskListImp extends TaskList {

    @Override
    public void addTask(Task task) {
        Connection con = DataBseCon.getConnection();
        if (con == null) {
            return;
        }

        String query = "INSERT INTO tasks (id, name, description, date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setInt(1, task.getId());
            preparedStatement.setString(2, task.getName());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setString(4, task.getDate());

            preparedStatement.executeUpdate();
            System.out.println("Task added successfully!");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                System.err.println("Error closing connection: " + se.getMessage());
            }
        }
    }

    @Override
    public void DeleteTask(Task task) {
        Connection con = DataBseCon.getConnection();
        if (con == null) {
            return;
        }

        String query = "DELETE FROM tasks WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, task.getId());

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Task deleted successfully!");
            } else {
                System.out.println("No task found with ID: " + task.getId());
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                System.err.println("Error closing connection: " + se.getMessage());
            }
        }
    }

    @Override
    public void EditTask(Task task) {
        Connection con = DataBseCon.getConnection(); // Corrected typo
        if (con == null) {
            return;
        }

        String query = "UPDATE tasks SET name = ?, date = ?, description = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

            // Set values for placeholders
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDate());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setInt(4, task.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Task updated successfully!");
            } else {
                System.out.println("No task found with ID: " + task.getId());
            }

        } catch (SQLException se) {
            System.err.println("Error while updating task: " + se.getMessage());
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                System.err.println("Error closing connection: " + se.getMessage());
            }
        }
    }
}
