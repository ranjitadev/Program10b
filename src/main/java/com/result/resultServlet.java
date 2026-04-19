/*10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5  through JSP 
called index.jsp with client sided validation and submit to the servlet called ResultServlet and process all 
the fields with server sided validation and display all the data along with result ( Pass if all subjects 
greater than 40%) and Average marks through result.jsp with a link to move to the client side*/


package com.result;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ResultServlet")
public class resultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");

        int s1 = Integer.parseInt(request.getParameter("s1"));
        int s2 = Integer.parseInt(request.getParameter("s2"));
        int s3 = Integer.parseInt(request.getParameter("s3"));
        int s4 = Integer.parseInt(request.getParameter("s4"));
        int s5 = Integer.parseInt(request.getParameter("s5"));

        String result;
        double avg;

        // Server-side validation
        if (s1 < 0 || s2 < 0 || s3 < 0 || s4 < 0 || s5 < 0) {
            result = "Invalid Marks!";
            avg = 0;
        } else {
            avg = (s1 + s2 + s3 + s4 + s5) / 5.0;

            if (s1 >= 40 && s2 >= 40 && s3 >= 40 && s4 >= 40 && s5 >= 40) {
                result = "PASS";
            } else {
                result = "FAIL";
            }
        }

        // Set attributes
        request.setAttribute("rollno", rollno);
        request.setAttribute("name", name);
        request.setAttribute("s1", s1);
        request.setAttribute("s2", s2);
        request.setAttribute("s3", s3);
        request.setAttribute("s4", s4);
        request.setAttribute("s5", s5);
        request.setAttribute("average", avg);
        request.setAttribute("result", result);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}