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
    public List<Group> listAllGroup() {
        List<Group> groupList = new ArrayList<>();

        String sql = "SELECT * FROM `group`";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                groupList.add(new Group(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query problem in the listAllGroup method");
        }

        return groupList;
    }

    @Override
    public List<Food> filteredFood(Integer id) {
        List<Food> foodList = new ArrayList<>();

        String sql = "SELECT * FROM foods WHERE groupId = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                foodList.add(new Food(rs.getInt("id"), rs.getString("name"), rs.getInt("calories"), rs.getInt("groupId")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query problem in the filteredFood method");
        }

        return foodList;
    }

    @Override
    public void addFood(Food food) {

        String sql = "INSERT INTO `foods` (`name`, `calories`, `groupId`) VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, food.getName());
            ps.setInt(2, food.getCalories());
            ps.setInt(3, food.getGroupId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Update problem in the addFood method");
        }

    }
}
