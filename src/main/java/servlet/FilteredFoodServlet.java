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
import java.util.List;

@WebServlet(urlPatterns = "/filtered")
public class FilteredFoodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        List<Food> foodList;

        Integer actualId = Integer.parseInt(req.getParameter("actId"));

        SQLMethods sqlMethods = new SQLMethods();
        foodList = sqlMethods.filteredFood(actualId);

        Gson gson = new Gson();
        String jsonList = gson.toJson(foodList);

        PrintWriter out = resp.getWriter();
        out.write(jsonList);

    }
}
