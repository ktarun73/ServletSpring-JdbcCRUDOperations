package com.servlets;

import com.DAO.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateData", value = "/UpdateData")
public class UpdateData extends HttpServlet {
    ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Configs/config.xml");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        int id=Integer.parseInt(request.getParameter("id"));
        int res=studentDao.update(id,request.getParameter("update"),request.getParameter("updated_value"));
        if(res>0){
            out.println("Value Updated<br>" +
                    "New records for id "+id+" are-<br>");
            request.getRequestDispatcher("ShowData").include(request,response);
        }else{
            out.println("<h4>Please try again</h4>");
            request.getRequestDispatcher("update.jsp").include(request,response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
