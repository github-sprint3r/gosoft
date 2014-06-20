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

import api.dao.FeeDAO;
import api.model.ModelFee;

@WebServlet("/feeSaveServlet")
public class FeeSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();

		ModelFee fee = mapper.readValue(json, ModelFee.class);

		try {
			getSaveData(fee);
			mapper.writeValue(response.getOutputStream(), fee);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,e.getMessage());
		}
	}

	public void getSaveData(ModelFee fee) throws Exception {
		fee.setFeeDAO(new FeeDAO());
		fee.save();
		fee.setFeeDAO(null);
		
	}

}
