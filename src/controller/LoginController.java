package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import beans.User;
import dao.DbConnection;
import dao.HibConnection;

public class LoginController implements Controller{

	public static ModelAndView mav = null;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

//		Session s = HibConnection.getConnection().openSession();
//		Query q = s.createQuery("select firstname,lastname from User where email = '" + email + "' and password = '" + pass + "'");
//		User user = (User)q.uniqueResult();
		
		Connection con = DbConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select firstname, lastname, id from registration form  where email = '" + email + "' and password = '" + pass + "'");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			HttpSession hs = request.getSession(true);
			hs.setAttribute("uid", rs.getString(3));
			mav =  new ModelAndView("myblog");
			mav.addObject("msg", rs.getString(1) + " "+ rs.getString(2));
		}
		else {
			mav =  new ModelAndView("login");
			mav.addObject("f","Please provide valid email or password");
		}
		return mav;
	}

}
