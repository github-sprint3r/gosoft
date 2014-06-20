package api.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import api.dao.SearchCarLicenseDAO;
import api.model.SearchCriteria;
import api.model.Transaction;

@WebServlet("/SearchCarLicense")
public class SearchCarLicenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SearchCarLicenseDAO searchCarLicenseDAO = new SearchCarLicenseDAO();

	public SearchCarLicenseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String jsonInputSearchCriteria = "";
			if (bufferedReader != null) {
				jsonInputSearchCriteria = bufferedReader.readLine();
			}
			ObjectMapper mapper = new ObjectMapper();
			SearchCriteria searchCriteria = mapper.readValue(jsonInputSearchCriteria, SearchCriteria.class);
			SearchCarLicenseDAO searchCarLicenseDAO = new SearchCarLicenseDAO();
			Transaction transaction = searchCarLicenseDAO.searchCarLicense(searchCriteria.getCarlicensetxt(), Integer.valueOf(searchCriteria.getProvinceddl())) ;
			response.setContentType("text/json; charset=utf-8");
			mapper.writeValue(response.getOutputStream(), transaction);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
