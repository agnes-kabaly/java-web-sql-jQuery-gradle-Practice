package dao;

import model.Food;
import model.Group;

import java.util.List;

public interface Dao {

    List<Food> listAllFood();
    List<Group> listAllGropu();
    List<Food> filteredFood(Integer id);
    void addFood(Food food);

}
