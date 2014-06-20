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

import api.dao.PromotionDAO;
import api.model.ModelPromotion;

@WebServlet("/promotionSaveServlet")
public class PromotionSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BufferedReader br = new BufferedReader(new InputStreamReader(
				request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();
		ModelPromotion modelPromotion = mapper.readValue(json, ModelPromotion.class);

		try {
			getSaveData(modelPromotion);
			mapper.writeValue(response.getOutputStream(), modelPromotion);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,e.getMessage());
		}
	}

	public void getSaveData(ModelPromotion modelPromotion) throws Exception {
		modelPromotion.setPromotionDAO(new PromotionDAO());
		modelPromotion.save();
		modelPromotion.setPromotionDAO(null);
		
	}

}
