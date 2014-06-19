package api.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import api.dao.CarLicenseDAO;
import api.model.Province;

/**
 * Servlet implementation class CarLicenseInit
 */
@WebServlet("/carLicenseInit")
public class CarLicenseInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarLicenseDAO carLicenseDAO = new CarLicenseDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarLicenseInitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Province> provinceList = getProvince();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), provinceList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private List<Province> getProvince(){
	List<Province> provinceList = new ArrayList<Province>();
	try{
		provinceList = carLicenseDAO.getProvince();

	} catch (Exception ex) {
		System.out.println("ERROR:" + ex.toString());

	}
	
	
//	Province province = new Province();
//	province.setProvinceid(1);
//	province.setProvincename("กรุงเทพมหานคร");
//	provinceList.add(province);
//	
//	province.setProvinceid(14);
//	province.setProvincename("เชียงใหม่");
//	provinceList.add(province);
//	
	return provinceList;
	}
	
}

