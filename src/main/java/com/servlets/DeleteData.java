package com.servlets;

import com.DAO.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteData", value = "/DeleteData")
public class DeleteData extends HttpServlet {
    ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Configs/config.xml");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        int id=Integer.parseInt(request.getParameter("id"));
        out.println("<h2>Data deleted for" +
                " id "+id +
                "</h2>");
        int res=studentDao.delete(id);
        if(res>0){
            out.println("Data deleted successfully<br>");
            out.println("<a href='index.jsp'>Go to index page</a>");
        }else{
            out.println("please try again");
            request.getRequestDispatcher("delete.jsp").include(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
