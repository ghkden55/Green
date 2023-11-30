package DAO;

import DTO.MealkitDTO;
import OBJ.Mealkit;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MealkitDAOImplement implements MealkitDAO {

    private static MealkitDAOImplement instance = new MealkitDAOImplement();

    private Connection connection = null;

    private MealkitDAOImplement(){
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

    public static MealkitDAOImplement getInstance() {return instance;}



    @Override
    public void createTable() {
        String tableSQL = "CREATE TABLE IF NOT EXISTS Mealkit (" +
                "MealID INT AUTO_INCREMENT PRIMARY KEY," +
                "MealName VARCHAR(255) NOT NULL," +
                "MealCategory VARCHAR(255) NOT NULL," +
                "MealPrice VARCHAR(255) NOT NULL," +
                "MealInfo VARCHAR(255) NOT NULL)";
        try {
            try (PreparedStatement statement = connection.prepareStatement(tableSQL)) {
                statement.execute();
            }
        }catch (SQLException e) {
            e.getMessage();
        }
    }

  
    @Override
    public void create(MealkitDTO mealkitDTO) {
        try {
            String insertSQL = "INSERT INTO Mealkit (MealName, MealCategory, MealPrice, MealInfo) VALUES (?, ?, ?, ?)";

            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);

            insertStatement.setString(1, mealkitDTO.getMealName());
            insertStatement.setString(2, mealkitDTO.getMealCategory());
            insertStatement.setInt(3, mealkitDTO.getMealPrice());
            insertStatement.setString(4, mealkitDTO.getMealInfo());

            insertStatement.execute();
            insertStatement.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    }


    @Override
    public List<Mealkit> findAll(){
        String selectSQL = "SELECT * FROM Mealkit";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

            List<Mealkit> mealkits = new ArrayList<>();

            while(resultSet.next()){
                mealkits.add(
                        new Mealkit(
                                resultSet.getLong("MealID"),
                                resultSet.getString("MealName"),
                                resultSet.getString("MealCategory"),
                                resultSet.getInt("MealPrice"),
                                resultSet.getString("MealInfo")
                        )
                );
            }

            resultSet.close();
            return mealkits;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    };

  
    @Override
    public Mealkit findById(Long ID) {
        String selectSQL = "SELECT * FROM Mealkit WHERE MealID=?";
        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setLong(1, ID);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                return new Mealkit(
                        resultSet.getLong("MealID"),
                        resultSet.getString("MealName"),
                        resultSet.getString("MealCategory"),
                        resultSet.getInt("MealPrice"),
                        resultSet.getString("MealInfo"));
            }

            resultSet.close();
            return null;

        } catch (SQLException e) {
            e.getMessage();
            return null;
        }
    }

  
    @Override
    public List<Mealkit> findbyCategory(String mealCategory){
        String selectSQL = "SELECT * FROM Mealkit WHERE MealCategory=?";
        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setString(1, mealCategory);
            ResultSet resultSet = statement.executeQuery();

            List<Mealkit> mealkits = new ArrayList<>();

            while(resultSet.next()){
                mealkits.add(
                        new Mealkit(
                            resultSet.getLong("MealID"),
                            resultSet.getString("MealName"),
                            resultSet.getString("MealCategory"),
                            resultSet.getInt("MealPrice"),
                            resultSet.getString("MealInfo")
                        )
                );

            }

            resultSet.close();
            return mealkits;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    };


    @Override
    public List<Mealkit> findbyName(String mealName) {
        String selectSQL = "SELECT * FROM Mealkit WHERE MealName=?";

        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setString(1, mealName);
            ResultSet resultSet = statement.executeQuery();

            List<Mealkit> mealkits = new ArrayList<>();

            while(resultSet.next()){
                mealkits.add(
                        new Mealkit(
                            resultSet.getLong("MealID"),
                            resultSet.getString("MealName"),
                            resultSet.getString("MealCategory"),
                            resultSet.getInt("MealPrice"),
                            resultSet.getString("MealInfo")
                        )
                    );
            }

            resultSet.close();
            return mealkits;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Mealkit> findbyPrice(int mealPrice) {
        String selectSQL = "SELECT * FROM Mealkit WHERE MealPrice=?";

        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setInt(1, mealPrice);
            ResultSet resultSet = statement.executeQuery();

            List<Mealkit> mealkits = new ArrayList<>();

            while(resultSet.next()){
                mealkits.add(
                        new Mealkit(
                            resultSet.getLong("MealID"),
                            resultSet.getString("MealName"),
                            resultSet.getString("MealCategory"),
                            resultSet.getInt("MealPrice"),
                            resultSet.getString("MealInfo")
                        )
                    );
            }

            resultSet.close();
            return mealkits;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void updateAll(MealkitDTO mealkitDTO) {

        try {
            String updateSQL = "UPDATE Mealkit SET  MealName = ?, MealCategory = ?, MealPrice = ?, MealInfo = ? WHERE MealID = ?";

            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

            updateStatement.setString(1, mealkitDTO.getMealName());
            updateStatement.setString(2, mealkitDTO.getMealCategory());
            updateStatement.setInt(3, mealkitDTO.getMealPrice());
            updateStatement.setString(4, mealkitDTO.getMealInfo());
            updateStatement.setLong(5, mealkitDTO.getMealID());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected >0) {
                System.out.println("업데이트되었습니다");
            } else {
                System.out.println("상품을 찾을 수 없습니다");
            }

            updateStatement.close();

        } catch (SQLException e) {
            e.getMessage();
        }

    }


    @Override
    public void updateName(MealkitDTO mealkitDTO) {
        try {
            String updateSQL ="UPDATE Mealkit SET MealName =? WHERE MealID =? ";

            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

            updateStatement.setString(1,mealkitDTO.getMealName());
            updateStatement.setLong(2, mealkitDTO.getMealID());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected >0) {
                System.out.println("업데이트되었습니다");
            } else {
                System.out.println("상품을 찾을 수 없습니다");
            }

            updateStatement.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    };


    @Override
    public void updateCategory(MealkitDTO mealkitDTO){
        try {
            String updateSQL ="UPDATE Mealkit SET MealCategory =? WHERE MealID =? ";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

            updateStatement.setString(1,mealkitDTO.getMealCategory());
            updateStatement.setLong(2, mealkitDTO.getMealID());

            int rowsAffected = updateStatement.executeUpdate();
            if (rowsAffected >0){
                System.out.println("업데이트되었습니다");
            }else {
                System.out.println("상품을 찾을 수 없습니다");
            }
            updateStatement.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    };


    @Override
    public void updatePrice(MealkitDTO mealkitDTO){
        try {
            String updateSQL ="UPDATE Mealkit SET MealPrice =? WHERE MealID =? ";
            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

            updateStatement.setInt(1,mealkitDTO.getMealPrice());
            updateStatement.setLong(2, mealkitDTO.getMealID());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("상품 가격이 업데이트되었습니다.");
            } else {
                System.out.println("상품을 찾을 수 없습니다.");
            }

            updateStatement.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    };


    @Override
    public void updateInfo(MealkitDTO mealkitDTO) {
        try {
            String updateSQL ="UPDATE Mealkit SET MealCategory =? WHERE MealID =? ";

            PreparedStatement updateStatement = connection.prepareStatement(updateSQL);

            updateStatement.setString(1,mealkitDTO.getMealInfo());
            updateStatement.setLong(2, mealkitDTO.getMealID());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected >0) {
                System.out.println("업데이트되었습니다");
            } else {
                System.out.println("상품을 찾을 수 없습니다");
            }

            updateStatement.close();

        } catch (SQLException e) {
            e.getMessage();
        }
    };


    @Override
    public void delete(Long MealID){
        String selectSQL = "DELETE FROM Mealkit WHERE MealID=?";

        try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {

            statement.setLong(1, MealID);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}