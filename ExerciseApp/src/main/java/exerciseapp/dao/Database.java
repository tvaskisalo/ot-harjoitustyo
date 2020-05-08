 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciseapp.dao;

import java.sql.*;

/**
 *  Luokalla voidaan luoda SQLite tietokanta, johon tallennetaan käyttäjiä, niiden pisteitä ja määriä niiden tehdyistä tehtävistä
 * 
 */
public class Database {
    private String username;
    private Connection conn;

    public Database(String filename) {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+filename+".db");
            Statement s1 = conn.createStatement();
            s1.execute("CREATE TABLE Users (id INTEGER PRIMARY KEY, username TEXT UNIQUE, exercises INTEGER, correct INTEGER)");
            Statement s2 = conn.createStatement();
            s2.execute("CREATE TABLE Custom (id INTEGER UNIQUE, question TEXT, answer TEXT)");
        } catch (Exception e) {

        }
    }
    
    /**
     * Metodi asettaa käyttäjänimen, jolla haetaan ja muutetaan tietokannasta dataa
     * @param username Käyttäjän antama käyttäjänimi 
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Metodi luo uuden käyttäjän tietokantaan
     */
    public void createUser() {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (username, exercises, correct) VALUES (?,0,0)");
            ps.setString(1, username);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            
        }
    }
    
    /**
     * Metodi hakee tietokannasta jo asetetun käyttäjän pisteet.
     * @return Käyttäjän pisteet
     */
    public int getPoints() {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT correct FROM Users WHERE username=?");
            ps.setString(1, username);
            ResultSet r = ps.executeQuery();
            int points = r.getInt("correct");
            ps.close();
            return points;
        } catch (Exception e) {

        }
        return 0;
    }
    
    /**
     * Metodi kasvattaa yhdellä käyttäjän pisteitä tietokannassa
     */
    public void addPoints() {
        int points = getPoints();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE Users SET correct=? WHERE username=?");
            ps.setInt(1, points + 1);
            ps.setString(2, username);
            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }
    
    /**
     * Metodi palauttaa, kuinka monta tehtävää käyttäjä on tehnyt
     * @return  Käyttäjän tehtyjen tehtävien määrä
     */
    public int getExerciseCount() {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT exercises FROM Users WHERE username=?");
            ps.setString(1, username);
            ResultSet r = ps.executeQuery();
            int count = r.getInt("exercises");
            ps.close();
            return count;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    /**
     * Metodi kasvattaa yhdellä tehtyjen tehtävien määrää.
     */
    public void increaseExerciseCount() {
        int count = getExerciseCount();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE Users SET exercises=? WHERE username=?");
            ps.setInt(1, count + 1);
            ps.setString(2, username);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            
        }
    }
    
    public int getAmountOfCustomExercises() {
 
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(id) FROM Custom");
            ResultSet r = ps.executeQuery();
            int max = r.getInt(1);
            ps.close();
            return max;
        } catch (Exception e) {
            
        }
        return 0;
    }
    
    public String getCustomExerciseQuestion(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT question FROM Custom WHERE id=?");
            ps.setInt(1, id);
            ResultSet r = ps.executeQuery();
            String question = r.getString("question");
            ps.close();
            return question;
        } catch (Exception e) {

        }
        return "";
    }
    
    public String getCustomExerciseAnswer(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT answer FROM Custom WHERE id=?");
            ps.setInt(1, id);
            ResultSet r = ps.executeQuery();
            String answer = r.getString("answer");
            ps.close();
            return answer;
        } catch (Exception e) {

        }
        return "";
    }
    
    public void createNewCustomExercise(String question, String answer) {
        int nro = this.getAmountOfCustomExercises();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Custom (id, question, answer) VALUES (?,?, ?)");
            ps.setInt(1, nro + 1);
            ps.setString(2, question);
            ps.setString(3, answer);
            ps.execute();
            ps.close();
        } catch (Exception e) {

        }
    }
    
    public double getPercent() {
        return this.getPoints() * 100 / this.getExerciseCount();
    }
    
    public void dropTables() {
        try {
            Statement s1 = conn.createStatement();
            s1.execute("DROP TABLE Custom");
            Statement s2 = conn.createStatement();
            s2.execute("DROP TABLE Users");
        } catch (Exception e) {
            
        }
    }
    
}
