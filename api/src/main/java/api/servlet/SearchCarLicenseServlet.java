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

/**
 * Servlet implementation class SearchCarLicenseServlet
 */
@WebServlet("/SearchCarLicense")
public class SearchCarLicenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SearchCarLicenseDAO searchCarLicenseDAO = new SearchCarLicenseDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchCarLicenseServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String json = "";
			if (br != null) {
				json = br.readLine();
			}
			
			System.out.println("json :" + json);

			ObjectMapper mapper = new ObjectMapper();
			SearchCriteria searchCriteria = mapper.readValue(json, SearchCriteria.class);
			
			Transaction transaction = new Transaction();
			 
			mapper.writeValue(response.getOutputStream(), transaction);
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

}
