package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import database.TietokonepelitDAO;
import database.TietokonepelitJdbcDao;



@WebServlet("/poista-peli")
public class PoistaPeliServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idStr = req.getParameter("peliid");
		int peliId = Integer.parseInt(idStr);
		
		TietokonepelitDAO peliDao = new TietokonepelitJdbcDao();
		
		boolean poistoOnnistui = peliDao.removeGame(peliId);
		
		if (poistoOnnistui) {
			
			resp.sendRedirect("/listaa-pelit");
		} else {
			req.setAttribute("viesti", "Pelin poistossa tapahtui virhe.");
			
			req.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(req, resp);
		}
		
	}

}
