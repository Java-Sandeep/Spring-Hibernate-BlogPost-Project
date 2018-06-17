package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


import dao.DbConnection;

public class RegisterController implements Controller{
	public static ModelAndView mav = null;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String pass = request.getParameter("password");
		String cpass = request.getParameter("cpassword");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");


		if(pass.equals(cpass)) {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into registration (firstname, lastname, password, mobile, email) values(?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, pass);
			ps.setString(4, mobile);
			ps.setString(5, email);

			int row = ps.executeUpdate();
			if(row != 0) {
				mav =  new ModelAndView("login");
				mav.addObject("s", "Your registration success");
			}
			else {
				mav =  new ModelAndView("registration");
				mav.addObject("fname",fname);
				mav.addObject("lname",lname);
				mav.addObject("email",email);
				mav.addObject("mobile",mobile);
				mav.addObject("f", "registration Fail");
			}
		}
		else {
			mav =  new ModelAndView("registration");
			mav.addObject("f", "Please provide valid password and confirm password");
			mav.addObject("fname",fname);
			mav.addObject("lname",lname);
			mav.addObject("email",email);
			mav.addObject("mobile",mobile);
		}
		return mav;
	}	
}
