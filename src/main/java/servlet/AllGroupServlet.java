package servlet;

import com.google.gson.Gson;
import model.Group;
import util.SQLMethods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/allGroup")
public class AllGroupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        List<Group> groupList;

        SQLMethods sqlMethods = new SQLMethods();
        groupList = sqlMethods.listAllGroup();

        Gson gson = new Gson();
        String jsonGroup = gson.toJson(groupList);

        PrintWriter out = resp.getWriter();
        out.write(jsonGroup);

    }

}
