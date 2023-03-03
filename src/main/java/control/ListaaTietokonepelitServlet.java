package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TietokonepelitDAO;
import database.TietokonepelitJdbcDao;
import model.Tietokonepeli;


@WebServlet("/listaa-pelit")  // url-nimi
public class ListaaTietokonepelitServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TietokonepelitDAO tietokonepeliDao = new TietokonepelitJdbcDao(); // haetaan peli tietokannasta
		List<Tietokonepeli> tietokonepelit = tietokonepeliDao.findAll(); // haetaan kaikki pelit tietokannasta

		req.setAttribute("tietokonepelit", tietokonepelit);

		req.getRequestDispatcher("/WEB-INF/pelilista.jsp").forward(req, resp); // kutsutaan pelilistan.jsp:tä 
	}

}
