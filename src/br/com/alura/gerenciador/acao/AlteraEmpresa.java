package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao{

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("Cadastrando nova empresa");
		
		String idEmpresa =  req.getParameter("id");
		Integer id =  Integer.valueOf(idEmpresa);
		String nomeEmpresa = req.getParameter("nome");
		String paramDataEmpresa = req.getParameter("data");
		
		Date dataAbertura = this.converterStringParaData(paramDataEmpresa);
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
	
	public Date converterStringParaData(String dataString) throws ServletException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataAbertura = new Date();
		
		try {
			dataAbertura = sdf.parse(dataString);
		} catch (ParseException e) {		
			//Loggar
			throw new ServletException(e);
		}
		
		return dataAbertura;
	}
}
