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

@WebServlet("/muokkaa-peli")

public class MuokkaaPeliServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		


     
  
		req.getRequestDispatcher("/WEB-INF/pelimuokkauslomake.jsp").forward(req, resp);
		
   
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int peliId = Integer.parseInt(req.getParameter("id")); // selaimelta tullutta tietoa käsitellään Servlet-luokan metodissa
            String nimi = req.getParameter("nimi");
            double hinta = Double.parseDouble(req.getParameter("hinta"));
            String julkaisupaiva = req.getParameter("julkaisupaiva");
            String lajityyppi = req.getParameter("lajityyppi");
            String kehittaja = req.getParameter("kehittaja");
          
            
            
            Tietokonepeli peli = new Tietokonepeli(peliId, nimi, hinta, julkaisupaiva, lajityyppi, kehittaja);
            TietokonepelitDAO peliDao = new TietokonepelitJdbcDao();
            boolean muutosOnnistui = peliDao.updateGame(peli);
            if (muutosOnnistui)
				
				resp.sendRedirect("/listaa-pelit"); 
			else {

				req.setAttribute("viesti", "Pelin muutoksessa tietokannassa tapahtui virhe.");
				
				req.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(req, resp);
			}
            
        }
        catch(NumberFormatException e) {
             
			e.printStackTrace();  // tulostetaan Consoleen virhetilanteessa metodikutsupinoa, josta näkee rivinumeron, jossa Exception tapahtuu

			req.setAttribute("viesti", "Syötetyt tiedot eivät olleet kelvolliset.");
		
			req.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(req, resp);
        }
    }
}