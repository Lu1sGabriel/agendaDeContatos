package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/ControllerServlet", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO daoExtends = new DAO();
	JavaBeans jBnsExtends = new JavaBeans();

	public ControllerServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criação da variável que recebe as requisições.
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {
		case "/main":
			contatos(request, response);
			break;
		case "/insert":
			novoContato(request, response);
			break;
		case "/select":
			editarContatos(request, response);
			break;
		case "/update":
			updateContato(request, response);
			break;
		case "/delete":
			deleteContato(request, response);
			break;
		case "/report":
			gerarRelatorio(request, response);
			break;
		default:
			response.sendRedirect("menu.html");
			break;
		}

	}

	// Método para mandar para mandar para a página de contatos cadastrados.
	// Listar contatos.
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * Criando um objeto que irá receber os dados da classe "JavaBeans". O objeto
		 * "listaDinamica" será usaddo para obter os dados do vetor dinâmico.
		 */
		ArrayList<JavaBeans> listaDinamica = daoExtends.listarContatos();

		// Encaminhar a lista, com os dados do banco de dados. Ao documento "agenda.js".

		// Setar um atributo, do documento ".jsp". Com a lista.
		request.setAttribute("listaDados", listaDinamica);

		// "Despachar" essa lista, ao documento "agenda.jsp":
		RequestDispatcher rD = request.getRequestDispatcher("agenda.jsp");
		/*
		 * RequestDispatcher é uma classe modelo, que trabalha com requisições e
		 * respostas no servelet.
		 */

		// Encaminhar o objeto "listaDados" ao documento "agenda.jsp":
		rD.forward(request, response);

	}

	// Método para para cadastrar um novo contato.
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * Setar as variáveis java beans. O objeto "jBnsExtends" recebe o parâmetro no
		 * forms e armazena na classe "JavaBeans"
		 */
		jBnsExtends.setNome(request.getParameter("cadastroNome"));
		jBnsExtends.setPhone(request.getParameter("cadastroPhone"));
		jBnsExtends.setEmail(request.getParameter("cadastroEmail"));
		// Invocar na classe DAO o método responsável pela inserção de um novo contato
		// no banco de dados.
		daoExtends.inserirContato(jBnsExtends);
		// Redirecionar para o documento (agenda.jsp).
		response.sendRedirect("main");

	}

	// Método para selecionar o contato que será editado.
	protected void editarContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * Criando um variável interna, para receber o parâmetro "ID" do formulário
		 * "agenda.jsp". Através do ID que selecionamos o contato que desejamos editar.
		 */
		String idCode = request.getParameter("idCode");

		// Setar a variável "JavaBeans".

		jBnsExtends.setIdCode(idCode);

		// Executar método "selecionarContato".
		daoExtends.selecionarContato(jBnsExtends);

		// Setar os atributos do formuário, com o conteúdo "JavaBeans".
		request.setAttribute("inputIdCode", jBnsExtends.getIdCode());
		request.setAttribute("cadastroNome", jBnsExtends.getNome());
		request.setAttribute("cadastroPhone", jBnsExtends.getPhone());
		request.setAttribute("cadastroEmail", jBnsExtends.getEmail());

		// Encaminhar os dados que vem da classe "JavaBeans". Ao documento
		// "editar.jsp".
		RequestDispatcher rD = request.getRequestDispatcher("editar.jsp");
		rD.forward(request, response);

	}

	protected void updateContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Setar as variáveis "JavaBeans", para armazenar temporariamente, os dados que
		// o Servlet recebe do formulário "editar.jsp".
		jBnsExtends.setIdCode(request.getParameter("inputIdCode"));
		jBnsExtends.setNome(request.getParameter("cadastroNome"));
		jBnsExtends.setPhone(request.getParameter("cadastroPhone"));
		jBnsExtends.setEmail(request.getParameter("cadastroEmail"));
		daoExtends.updateContato(jBnsExtends);

		// Redirecionar para o documento "agenda.jsp", com as alterações já salvas.
		response.sendRedirect("main");

	}

	// Método para remover um contato.
	protected void deleteContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do "idCode" do contato que será excluido, através do JavaScript
		// "exluir.js";
		String idCode = request.getParameter("idCode");

		// Setar a variável "idCode" na classe "JavaBeans".
		jBnsExtends.setIdCode(idCode);

		// Executar o método "deleteContato", na classe 'DAO'. Passando o objeto
		// "jBnsExtends" como parâmetro.
		daoExtends.deleteContato(jBnsExtends);

		// Redirecionar para o documento "agenda.jsp", com as alterações já salvas.
		response.sendRedirect("main");

	}
	
	// Método para gerar relátorio em PDF.
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();

		// Pode haver excessão, trabalhando com documento PDF.
		try {
			// Tipo de resposta, será um documento em pdf.
			response.setContentType("apllication/pdf");

			// Gerar um nome para o documento.
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");

			// Abrir o documento pdf.
			PdfWriter.getInstance(documento, response.getOutputStream());

			// Abrir o documento, para gerar o contúdo.
			documento.open();
			documento.add(new Paragraph("Lista de contatos:"));
			documento.add(new Paragraph(" "));

			// Criar uma tabela.
			PdfPTable tabela = new PdfPTable(3);
			PdfPCell colunaUm = new PdfPCell(new Paragraph("Nome"));
			PdfPCell colunaDois = new PdfPCell(new Paragraph("Telefone"));
			PdfPCell colunaTres = new PdfPCell(new Paragraph("Email"));
			tabela.addCell(colunaUm);
			tabela.addCell(colunaDois);
			tabela.addCell(colunaTres);

			// Popular a tabela com os contatos.
			ArrayList<JavaBeans> listaContatos = daoExtends.listarContatos();
			for (int i = 0; i < listaContatos.size(); i++) {
				tabela.addCell(listaContatos.get(i).getNome());
				tabela.addCell(listaContatos.get(i).getPhone());
				tabela.addCell(listaContatos.get(i).getEmail());
			}
			documento.add(tabela);
			documento.close();

		} catch (Exception e) {
			e.printStackTrace();
			documento.close();
		}

	}

}
