package gist.controllers;

import gist.beans.Blogger;
import gist.daos.BloggerDao;
import gist.util.OTPGenerator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

public class SmsController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          PrintWriter out = response.getWriter();
      
         response.setContentType("text/html");
        String op =request.getParameter("op");
        if(op!=null && op.equalsIgnoreCase("sendotp")){
            String userid= request.getParameter("userid");
            String mobile = request.getParameter("mobile");
            System.out.println(userid +"," + mobile);
            Blogger blogger = new BloggerDao().findByUserid_mobile(userid,mobile);
            System.out.println("2");
            if(blogger==null)
            {
                System.out.println("3");
                out.println("Detail not matched ...");
                return;
            }
            else {
                System.out.println("4");
                 String message = OTPGenerator.generateOTP(6);
                //mobile = request.getParameter("mobile");
                String sendId = "TXTIND";
                String language = "english";
                String route = "v3";
                String apiKey = "ZpxEJb9kLQ17vmtBGuUoANDyga4KcfPlijVq3FwXsHTdOYzIh5bG7DoyBmnYtlJkWIT8SzaiVFdQjARr";
                String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization=" + apiKey + "&message=" + message + "&language=" + language + "&route=" + route + "&numbers="+mobile;
                System.out.println("2");
                URL url = new URL(myUrl);
                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("User-Agent", "Mozilla/5.0");
                con.setRequestProperty("cache-control", "no-cache");
                System.out.println("3");
                int responseCode = con.getResponseCode(); //200 for success
                System.out.println("4");
                if (responseCode == 200) {
                    //response.sendRedirect("test/smsapi2.jsp?msg=Message sent successfully");
                    out.println("sms sent successfully !");
                } else {
                    //response.sendRedirect("test/smsapi2.jsp?msg=Message is not sent ");
                       out.println("Error ..");
                }


            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String op =request.getParameter("op");
        if(op!=null && op.equalsIgnoreCase("sendmessage")){
             String message = URLEncoder.encode(request.getParameter("message"), "UTF-8");    //Important Step
                String mobile = request.getParameter("mobile");
                String sendId = "TXTIND";
                String language = "english";
                String route = "v3";
                String apiKey = "ZpxEJb9kLQ17vmtBGuUoANDyga4KcfPlijVq3FwXsHTdOYzIh5bG7DoyBmnYtlJkWIT8SzaiVFdQjARr";
                String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization=" + apiKey + "&message=" + message + "&language=" + language + "&route=" + route + "&numbers="+mobile;
                System.out.println("2");
                URL url = new URL(myUrl);
                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("User-Agent", "Mozilla/5.0");
                con.setRequestProperty("cache-control", "no-cache");
                System.out.println("3");
                int responseCode = con.getResponseCode(); //200 for success
                System.out.println("4");
                if (responseCode == 200) {
                    //response.sendRedirect("test/smsapi2.jsp?msg=Message sent successfully");
                    out.println("sms sent successfully !");
                } else {
                    //response.sendRedirect("test/smsapi2.jsp?msg=Message is not sent ");
                       out.println("Error ..");
                }


        }
        
    }

}
