package servlet;

import com.google.gson.Gson;
import model.Food;
import util.SQLMethods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/allFood")
public class AllFoodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        List<Food> foodList;

        SQLMethods sqlMethods = new SQLMethods();
        foodList = sqlMethods.listAllFood();

        Gson gson = new Gson();
        String jsonString = gson.toJson(foodList);

        PrintWriter out = resp.getWriter();
        out.write(jsonString);

    }

}
