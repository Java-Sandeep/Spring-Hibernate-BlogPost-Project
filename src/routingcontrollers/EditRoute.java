package routingcontrollers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.DbConnection;

public class EditRoute implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		Connection con = DbConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from blogpost where id=?");
		ps.setInt(1, Integer.parseInt(request.getParameter("bid")));
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			mav = new ModelAndView("editblog");
			mav.addObject("title",rs.getString(2));
			mav.addObject("subject",rs.getString(3));
			mav.addObject("content",rs.getString(4));
			mav.addObject("bid",rs.getString(1));
		}
		return mav;
	}

}
