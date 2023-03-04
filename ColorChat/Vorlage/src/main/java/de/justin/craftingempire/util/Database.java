package de.justin.craftingempire.util;

import de.justin.craftingempire.Main;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Base64;

public class Database {

        public static Connection connectToDatabase(String database) {
            Connection conn;
            conn = null;
            try {
                Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:" + Main.getPlugin().getDataFolder().getAbsolutePath() + "/data/" + database);
            }catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return conn;
        }

        public static PreparedStatement prepareStatement(String database, String statement) {
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connectToDatabase(database).prepareStatement(statement);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return preparedStatement;
        }

        public static void runStatement(String database, PreparedStatement preparedStatement) {
            try {
                preparedStatement.execute();
                connectToDatabase(database).close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    public static void runStatement(String database, String preparedStatementString) {
        try {
            PreparedStatement preparedStatement = Database.prepareStatement(database, preparedStatementString);
            preparedStatement.execute();
            connectToDatabase(database).close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ResultSet runSelectStatement(String database, PreparedStatement preparedStatement) {
            ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
            connectToDatabase(database).close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public static ResultSet runSelectStatement(String database, String preparedStatementString) {
            PreparedStatement preparedStatement = Database.prepareStatement(database,preparedStatementString);
            ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
            connectToDatabase(database).close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public static String convertObjectToString(Object object) {
        String encodedOnject;
        try {
            ByteArrayOutputStream io = new ByteArrayOutputStream();
            BukkitObjectOutputStream os = new BukkitObjectOutputStream(io);
            os.writeObject(object);
            os.flush();
            byte[] serializedObject = io.toByteArray();
            encodedOnject = Base64.getEncoder().encodeToString(serializedObject);
            return encodedOnject;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object convertStringToObject(String string) {
            try {
                byte[] serializedObject;
                serializedObject = Base64.getDecoder().decode(string);
                ByteArrayInputStream in = new ByteArrayInputStream(serializedObject);
                BukkitObjectInputStream is = new BukkitObjectInputStream(in);
                return is.readObject();

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
    }
}
