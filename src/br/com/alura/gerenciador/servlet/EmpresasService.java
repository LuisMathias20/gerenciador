package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;


@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Empresa> empresas = new Banco().listarEmpresas();
		
		String valor = req.getHeader("Accept");
		
		if(valor.endsWith("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			
			resp.setContentType("application/json");
			resp.getWriter().print(json);
		} else if (valor.endsWith("xml")){
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			String xml = xstream.toXML(empresas);
			
			resp.setContentType("application/xml");
			resp.getWriter().print(xml);
		} else {
			resp.setContentType("application/json");
			resp.getWriter().print("{'message':'no content'}");
		}

	}
}
