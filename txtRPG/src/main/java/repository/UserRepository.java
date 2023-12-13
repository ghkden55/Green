package repository;

import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// DB 접근
public class UserRepository {

    private Connection connection = null;

    public UserRepository() {
        try{
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:h2:mem:test",
                    "sa",
                    "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }





    // -------------- <Create> --------------------------------
    public void createTable(){
        String tableSQL = "CREATE TABLE IF NOT EXISTS User (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "Intel VARCHAR(255) NOT NULL, " +
                "Wealth VARCHAR(255) NOT NULL, " +
                "Sociability VARCHAR(255) NOT NULL, " +
                "Morality VARCHAR(255) NOT NULL, " +
                "Artistry VARCHAR(255) NOT NULL, " +
                "PTSD VARCHAR(255) NOT NULL)";
        try {
            try (PreparedStatement statement = connection.prepareStatement(tableSQL)) {
                statement.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public User findById(Long ID) {
        String selectSQL = "SELECT * FROM User WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setLong(1, ID);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getInt("Intel"),
                        resultSet.getInt("Wealth"),
                        resultSet.getInt("Sociability"),
                        resultSet.getInt("Morality"),
                        resultSet.getInt("Artistry"),
                        resultSet.getInt("PTSD"));

            }

            resultSet.close();
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void create(User user) {
        try {
            String insertSQL = "INSERT INTO User (Intel, Wealth, Sociability, Morality, Artistry, PTSD) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);

            insertStatement.setInt(1, user.getIntel());
            insertStatement.setInt(2, user.getWealth());
            insertStatement.setInt(3, user.getSociability());
            insertStatement.setInt(4, user.getMorality());
            insertStatement.setInt(5, user.getArtistry());
            insertStatement.setInt(6, user.getPTSD());

            insertStatement.execute();
            insertStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateuser(User user) {

        try {
            String updateSQL = "UPDATE User SET  Intel = ?, Wealth = ?, Sociability = ?, Morality = ?, Artistry = ?, PTSD = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
            updateStatement.setLong(1, user.getIntel());
            updateStatement.setLong(2, user.getWealth());
            updateStatement.setLong(3, user.getSociability());
            updateStatement.setLong(4, user.getMorality());
            updateStatement.setLong(5, user.getArtistry());
            updateStatement.setLong(6, user.getPTSD());
            updateStatement.setLong(7, 1);
            updateStatement.executeUpdate();
            updateStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void save(User user) {
//
//        try{
//            if(user.getID() == null)
//            {
//                System.out.println("11111111111111111111111");
//                String insertSQL = "INSERT INTO User (Intel, Wealth, Sociability, Morality, Artistry, PTSD) VALUES (?, ?, ?, ?, ?, ?)";
//                PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
//                insertStatement.setLong(1, user.getIntel());
//                insertStatement.setLong(2, user.getWealth());
//                insertStatement.setLong(3, user.getSociability());
//                insertStatement.setLong(4, user.getMorality());
//                insertStatement.setLong(5, user.getArtistry());
//                insertStatement.setLong(6, user.getPTSD());
//                insertStatement.executeUpdate();
//                insertStatement.close();
//            }
//            else {
//                System.out.println("222222222222222222222");
//                String updateSQL = "UPDATE User SET  Intel = ?, Wealth = ?, Sociability = ?, Morality = ?, Artistry = ?, PTSD = ? WHERE id = ?";
//                PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
//                updateStatement.setLong(1, user.getIntel());
//                updateStatement.setLong(2, user.getWealth());
//                updateStatement.setLong(3, user.getSociability());
//                updateStatement.setLong(4, user.getMorality());
//                updateStatement.setLong(5, user.getArtistry());
//                updateStatement.setLong(6, user.getPTSD());
//                updateStatement.setLong(7, user.getID());
//                updateStatement.executeUpdate();
//                updateStatement.close();
//            }
//
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    // -------------- <Select> --------------------------------


    public List<User> findAll() {
        String selectSQL = "SELECT * FROM User";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

            List<User> users = new ArrayList<>();

            while(resultSet.next()){
                users.add(
                        new User(
                                resultSet.getLong("id"),
                                resultSet.getInt("Intel"),
                                resultSet.getInt("Wealth"),
                                resultSet.getInt("Sociability"),
                                resultSet.getInt("Morality"),
                                resultSet.getInt("Artistry"),
                                resultSet.getInt("PTSD"))
                );
            }

            resultSet.close();
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    // -------------- <Delete> --------------------------------
    public void deleteUser(Long id){
        String selectSQL = "DELETE FROM User WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
