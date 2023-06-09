package com.Servlet;

import com.Servlet.Dao.CourseDao;
import com.Servlet.Models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Student", value = "/in/student/id/*")
public class Student extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String [] url=request.getRequestURI().split("/");

        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("login");
        String courseId=url[5];
        String studentId=user.getUserId();
        CourseDao courseDao=new CourseDao();
        try{
            courseDao.enrollCourseStudent(courseId,studentId);

            response.sendRedirect("/webtech3/in/student");


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
//

    }
}