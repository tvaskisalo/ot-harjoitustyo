 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.dao;

import java.sql.*;

/**
 *
 * @author Tapan
 */
public class DataBase {
    private String username;
    private Connection conn;

    public DataBase() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:src/main/java/exerciseapp/dao/userdata.db");
            Statement s = conn.createStatement();
            s.execute("CREATE TABLE Users (id INTEGER PRIMARY KEY, username TEXT UNIQUE, exercises INTEGER, correct INTEGER)");
        } catch(Exception e) {
        }
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void createUser() {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (username, exercises, correct) VALUES (?,0,0)");
            ps.setString(1, username);
            ps.execute();
            ps.close();
        } catch(Exception e) {
            
        }
    }
    
    public int getPoints() {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT correct FROM Users WHERE username=?");
            ps.setString(1, username);
            ResultSet r = ps.executeQuery();
            int points = r.getInt("correct");
            ps.close();
            return points;
        } catch(Exception e) {

        }
        return 0;
    }
    
    public void addPoints() {
        int points = getPoints();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE Users SET correct=? WHERE username=?");
            ps.setInt(1, points+1);
            ps.setString(2, username);
            ps.execute();
            ps.close();
        } catch(Exception e) {

        }
    }
    
    public double getPercent() {
        return 0;
    }
    
    
    
}
