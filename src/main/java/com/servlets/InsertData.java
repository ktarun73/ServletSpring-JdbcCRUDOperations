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

@WebServlet(name = "InsertData", value = "/InsertData")
public class InsertData extends HttpServlet {
    ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Configs/config.xml");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String city=request.getParameter("city");
        Student student=new Student(id,name,city);
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        int res=studentDao.insert(student);
        if(res>0){
            out.println("<h3>Data insert successfully</h3>");
            out.println("<a href='index.jsp'>click here to go to index page</a>");
        }else {
            out.println("<h3>Please Try Again</h3>");
            out.println("<a href='insert.jsp'>click here to try again</a>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
