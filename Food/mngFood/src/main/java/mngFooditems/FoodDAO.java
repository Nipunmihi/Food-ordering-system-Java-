package mngFooditems;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {
    private String jdbcURL="jdbc:mysql://localhost:3306/food?useSSL=false";
    private String jdbcusername="root";
    private String jdbcpassword="admin";
    
    private static final String INSERT_FOOD_SQL="INSERT INTO food (name,price,favour) VALUES (?, ?, ?);";
    private static final String SELECT_FOOD_BY_ID="SELECT id,name,price,favour FROM food WHERE id = ?";
    private static final String SELECT_ALL_FOODS="SELECT * FROM food";
    private static final String DELETE_FOOD_SQL="DELETE FROM food WHERE id = ?";
    private static final String UPDATE_FOOD_SQL="UPDATE food SET name = ?, price = ?, favour = ? WHERE id = ?";
    
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcusername,jdbcpassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    // Create or insert food
    public void insertFood(Food food) {
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FOOD_SQL);
            preparedStatement.setString(1, food.getName());
            preparedStatement.setDouble(2, food.getPrice());
            preparedStatement.setString(3, food.getFavour());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Update food
    public void updateFood(Food food) {
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FOOD_SQL);
            preparedStatement.setString(1, food.getName());
            preparedStatement.setDouble(2, food.getPrice());
            preparedStatement.setString(3, food.getFavour());
            preparedStatement.setInt(4, food.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Select food by id
    public Food selectFood(int id) {
        Food food = null;
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FOOD_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                String name=rs.getString("name");
                double price = rs.getDouble("price");
                String favour = rs.getString("favour");
                food = new Food(id, name, price, favour);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return food;
    }
    
    // Select all foods
    public List<Food> selectAllFoods() {
        List<Food> foods = new ArrayList<>();
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FOODS);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                double price = rs.getDouble("price");
                String favour = rs.getString("favour");
                foods.add(new Food(id, name, price, favour));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }
    
    // Delete food
    public boolean deleteFood(int id) {
        boolean rowDeleted;
        try {
            Connection connection=getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_FOOD_SQL);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0 ;
        } catch (SQLException e) {
            rowDeleted = false;
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
