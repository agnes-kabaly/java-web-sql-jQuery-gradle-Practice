package util;

import dao.Dao;
import model.Food;
import model.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLMethods implements Dao {

    Connection connection = ConnectionUtil.getConnection(ConnectionUtil.DatabaseName.BFA);

    @Override
    public List<Food> listAllFood() {
        List<Food> foodList = new ArrayList<>();

        String sql = "SELECT * FROM foods";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                foodList.add(new Food(rs.getInt("id"), rs.getString("name"), rs.getInt("calories"), rs.getInt("groupId")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query problem in the listAllFood method");
        }

        return foodList;
    }

    @Override
    public List<Group> listAllGropu() {
        return null;
    }

    @Override
    public List<Food> filteredFood(Integer id) {
        return null;
    }

    @Override
    public void addFood(Food food) {

    }
}
