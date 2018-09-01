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

@WebServlet(urlPatterns = "/addFood")
public class AddFoodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String json = req.getParameter("json");

        Gson gson = new Gson();
        Food food = gson.fromJson(json, Food.class);

        SQLMethods sqlMethods = new SQLMethods();
        sqlMethods.addFood(food);

        PrintWriter out = resp.getWriter();
        out.write(json);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
