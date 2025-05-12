/*
 * Colton Kohler
 * 05/11/2025
 * M10: Programming Assignment
 *
 * Purpose: This program provides a user-friendly interface to view and update fan records
 *          stored in a MySQL database using a custom-designed Java Swing GUI.
 */

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FanManager extends JFrame {

    // GUI components
    private JTextField idInput, nameInput, surnameInput, teamInput;
    private JButton fetchButton, saveButton;

    // Database credentials
    private final String databaseUrl = "jdbc:mysql://localhost:3306/databasedb";
    private final String databaseUser = "student1";
    private final String databasePassword = "pass";

    public FanManager() {
        setTitle("Ultimate Fan Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // UI Labels and Fields
        JLabel idLabel = new JLabel("Enter Fan ID:");
        idLabel.setBounds(30, 20, 100, 25);
        add(idLabel);

        idInput = new JTextField();
        idInput.setBounds(150, 20, 200, 25);
        add(idInput);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(30, 60, 100, 25);
        add(firstNameLabel);

        nameInput = new JTextField();
        nameInput.setBounds(150, 60, 200, 25);
        add(nameInput);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(30, 100, 100, 25);
        add(lastNameLabel);

        surnameInput = new JTextField();
        surnameInput.setBounds(150, 100, 200, 25);
        add(surnameInput);

        JLabel teamLabel = new JLabel("Favorite Team:");
        teamLabel.setBounds(30, 140, 100, 25);
        add(teamLabel);

        teamInput = new JTextField();
        teamInput.setBounds(150, 140, 200, 25);
        add(teamInput);

        // Fetch Button
        fetchButton = new JButton("🎯 Load Fan");
        fetchButton.setBounds(60, 200, 120, 30);
        fetchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchFanDetails();
            }
        });
        add(fetchButton);

        // Save Button
        saveButton = new JButton("💾 Save Changes");
        saveButton.setBounds(200, 200, 140, 30);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFanChanges();
            }
        });
        add(saveButton);
    }

    /**
     * Loads fan details based on the ID entered in the GUI.
     */
    private void fetchFanDetails() {
        String idText = idInput.getText().trim();

        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Oops! You forgot to enter a Fan ID.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword)) {
            String sql = "SELECT firstname, lastname, favoriteteam FROM fans WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(idText));

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nameInput.setText(rs.getString("firstname"));
                surnameInput.setText(rs.getString("lastname"));
                teamInput.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "Fan not found. Are you sure that ID exists?");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Connection error: " + e.getMessage());
        }
    }

    /**
     * Updates the fan's record in the database based on the modified fields.
     */
    private void saveFanChanges() {
        String idText = idInput.getText().trim();
        String first = nameInput.getText().trim();
        String last = surnameInput.getText().trim();
        String team = teamInput.getText().trim();

        if (idText.isEmpty() || first.isEmpty() || last.isEmpty() || team.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields before saving.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword)) {
            String sql = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, first);
            stmt.setString(2, last);
            stmt.setString(3, team);
            stmt.setInt(4, Integer.parseInt(idText));

            int affected = stmt.executeUpdate();

            if (affected > 0) {
                JOptionPane.showMessageDialog(this, "Fan record updated successfully! 🙌");
            } else {
                JOptionPane.showMessageDialog(this, "No matching fan found. Try a different ID?");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Load JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "MySQL JDBC driver not found. Please check your setup.");
            return;
        }

        // Launch the GUI
        SwingUtilities.invokeLater(() -> {
            new FanManager().setVisible(true);
        });
    }
}
