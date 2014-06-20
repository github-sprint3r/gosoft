package api.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import api.dao.CarLicenseDAO;
import api.model.Province;

@WebServlet("/carLicenseInit")
public class CarLicenseInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarLicenseDAO carLicenseDAO = new CarLicenseDAO();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			response.setContentType("text/html; charset=utf-8");
			List<Province> provinceList = carLicenseDAO.getProvince();
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(response.getOutputStream(), provinceList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	
}

