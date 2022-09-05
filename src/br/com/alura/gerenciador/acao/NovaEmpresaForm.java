package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresaForm implements Acao{

	public String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		return "forward:formNovaEmpresa.jsp";
	}

}
