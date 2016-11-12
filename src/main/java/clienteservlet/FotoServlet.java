package clienteservlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/foto" })
public class FotoServlet extends HttpServlet {

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		resp.setContentType("application/jpg");
		
		File file = new File(req.getServletContext().getRealPath("/resources/images/foto.jpg"));
		
		byte[] arraybyte  = new byte[(int)file.length()];
		
		FileInputStream fileStrem = new FileInputStream(file);
		
		fileStrem.read(arraybyte);
		
		ServletOutputStream s = resp.getOutputStream();
		s.write(arraybyte);
		s.flush();
		s.close();
		
		System.out.println(this.getServletContext().getMimeType(req.getServletContext().getRealPath("/resources/images/foto.jpg")));
		
	}
	
	
}
