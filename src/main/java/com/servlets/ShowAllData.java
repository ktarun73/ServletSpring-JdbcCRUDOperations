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
import java.util.List;

@WebServlet(name = "ShowAllData", value = "/ShowAllData")
public class ShowAllData extends HttpServlet {


    ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Configs/config.xml");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>All the records of student table</h1>");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        List<Student> students=studentDao.getStudents();
        for (Student student:students){
            out.println(student+"<br>");
            out.println("++++++++++++++++++++++++++++++++++++++++++<br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
