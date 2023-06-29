package com.servlets;

import com.DAO.StudentDao;
import com.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowData", value = "/ShowData")
public class ShowData extends HttpServlet {

    ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Configs/config.xml");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        int id=Integer.parseInt(request.getParameter("id"));
        Student student=studentDao.getStudent(id);
        out.println("<h2>Record for student id "+id+"</h2>");
        out.println("<h3>"+student+"</h3>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
