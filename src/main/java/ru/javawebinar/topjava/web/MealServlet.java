package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.util.UserMealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Александр on 2017-04-04.
 */
public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(UserServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("get all");
        request.setAttribute("mealList", UserMealsUtil.getWithExceeded(UserMealsUtil.MEAL_LIST, UserMealsUtil.DEFAULT_CALORIES_PER_DAY));
        request.getRequestDispatcher("/mealList.jsp").forward(request,response);
    }
}
