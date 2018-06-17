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

public class EditController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = null;
		String title = req.getParameter("title");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		int id = Integer.parseInt(req.getParameter("bid"));
		
		Connection con = DbConnection.getConnection();
		HttpSession hs = req.getSession(false);
		PreparedStatement ps = con.prepareStatement("update blogpost set title = ?, subject = ?,content = ? where id = ?");
		ps.setString(1, title);
		ps.setString(2, subject);
		ps.setString(3, content);
		ps.setInt(4, id);
		
		
		int r = ps.executeUpdate();
		if(r != 0)
			mav = new ModelAndView("myblog");
		else
			mav = new ModelAndView("editblog");
		return mav;
	}

}
