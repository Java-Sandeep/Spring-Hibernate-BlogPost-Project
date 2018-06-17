package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


import dao.DbConnection;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int id=Integer.parseInt(req.getParameter("bid"));
		Connection con= DbConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from blogpost where id=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		return new ModelAndView("myblog");
	}

}
