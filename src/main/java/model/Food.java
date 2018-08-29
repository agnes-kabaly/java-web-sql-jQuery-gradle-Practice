package model;

public class Food {

    private Integer id;
    private String name;
    private Integer calories;
    private Integer groupId;

    public Food(Integer id, String name, Integer calories, Integer groupId) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.groupId = groupId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCalories() {
        return calories;
    }

    public Integer getGroupId() {
        return groupId;
    }

}
