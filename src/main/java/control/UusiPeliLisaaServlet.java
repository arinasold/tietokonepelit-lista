package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TietokonepelitDAO;
import database.TietokonepelitJdbcDao;
import model.Tietokonepeli;

@WebServlet("/lisaa-peli")

public class UusiPeliLisaaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/pelilisayslomake.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			// Pyydetään lomakkeella syötetyt tiedot request-oliolta
			String pelinNimi = req.getParameter("nimi");
			String hintaStr = req.getParameter("hinta");
			hintaStr = hintaStr.replace(",", ".");
			double hinta = Double.parseDouble(hintaStr);
			
			String julkaisupaiva = req.getParameter("julkaisupaiva");
			String lajityyppi = req.getParameter("lajityyppi");
			String kehittaja = req.getParameter("kehittaja");
			
			// Luodaan uusi peli edellisillä parametreillä
			
			Tietokonepeli peli = new Tietokonepeli(pelinNimi, hinta, julkaisupaiva, lajityyppi, kehittaja);
			
			TietokonepelitDAO peliDao = new TietokonepelitJdbcDao();
			
			boolean lisaysOnnistui = peliDao.addGame(peli);
			if (lisaysOnnistui)
				
				resp.sendRedirect("/listaa-pelit"); 
			else {

				req.setAttribute("viesti", "Pelin lisäyksessä tietokantaan tapahtui virhe.");
				
				req.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(req, resp); // vihertilanteessa kutsutaan tapahtumaraportti-url
			}
			
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();  // tulostetaan Consoleen virhetilanteessa metodikutsupinoa, josta näkee rivinumeron, jossa Exception tapahtuu

			req.setAttribute("viesti", "Syötetyt tiedot eivät olleet kelvolliset.");
		
			req.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(req, resp); // vihertilanteessa kutsutaan tapahtumaraportti-url
		}
	}
}
