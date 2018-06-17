package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.DbConnection;

public class AddBlogController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = null;
		String title = req.getParameter("title");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		Connection con = DbConnection.getConnection();
		HttpSession hs = req.getSession(false);
		PreparedStatement ps = con.prepareStatement("insert into blogpost (title,subject,content,date_of_blog_post,uid) values(?,?,?,?,?)");
		ps.setString(1, title);
		ps.setString(2, subject);
		ps.setString(3, content);
		ps.setString(4, new Date().toString());
		ps.setInt(5,Integer.parseInt((String) hs.getAttribute("uid")));
		
		int r = ps.executeUpdate();
		if(r != 0)
			mav = new ModelAndView("myblog");
		else
			mav = new ModelAndView("blog");
		return mav;
	}
	
	
}
