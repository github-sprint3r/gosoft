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
import api.dao.FeeTypeDAO;
import api.model.ModelPromotion;
import api.model.ModelFeeType;

@WebServlet("/promotionServlet")
public class PromotionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();

		ModelPromotion promotion = mapper.readValue(json, ModelPromotion.class);

		try {
			getPromotionData(promotion);
			mapper.writeValue(response.getOutputStream(), promotion);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,e.getMessage());
		}
	}

	public void getPromotionData(ModelPromotion promotion) throws Exception {

		ModelFeeType modelFeeType = new ModelFeeType();
		modelFeeType.setFeeType(promotion.getFeeType());
		modelFeeType.setFeeTypeDAO(new FeeTypeDAO());
		modelFeeType.inquiry();
		promotion.setStartTime(modelFeeType.getStartTime());
		promotion.setEndTime(modelFeeType.getEndTime());
		promotion.setPromotionDAO(new PromotionDAO());
		promotion.inquiry();
		
		promotion.setPromotionDAO(null);
		
	}

}
