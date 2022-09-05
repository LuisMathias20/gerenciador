package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao{

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("listando empresas");
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.listarEmpresas();
		
		req.setAttribute("empresas", lista);
		
		return "forward:listaEmpresas.jsp";
	}
}
