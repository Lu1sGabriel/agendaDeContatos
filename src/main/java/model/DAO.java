package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	// Módulo de conexão
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbAgendaContatos?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "@mySqlBanco1234";

	// Método de conexão
	private Connection conectar() {
		// Criação de um objeto, para estabelecer uma cessão com o banco de dados.
		Connection con = null;
		try {
			// Vai ler o driver do banco de dados.
			Class.forName(driver);
			// Gerenciar o driver.
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// CRUD create
	// Criação de um método sem retorno, que irá receber como parâmetro, os dados
	// armazenados na classe "JavaBeans".
	public void inserirContato(JavaBeans jBnsContatos) {
		// Código para inserir os contatos que estão armazenados em "JavaBeans", no
		// banco de dados.
		String crudCreate = "insert into tabelaContatos (nome, phone, email) values (?,?,?)";
		// As interrogações, são parâmetros que serão substituido nas variáveis da
		// classe "JavaBeans".

		try {
			// Abrir conexão com o banco.
			Connection con = conectar();
			// Preparar a QUERY para a inserção no banco de dados e a criação de um objeto
			// que usará a conexão do banco de dados.
			PreparedStatement pSt = con.prepareStatement(crudCreate);

			// Substituii os parâmetro (?,?,?) pelo conteúdo das variáveis "JavaBeans".
			pSt.setString(1, jBnsContatos.getNome());
			pSt.setString(2, jBnsContatos.getPhone());
			pSt.setString(3, jBnsContatos.getEmail());

			// Executar a QUERY para inserir os dados no banco de dados.
			pSt.executeUpdate();

			// Encerrar a conexão com o banco de dados.
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// CRUD read.

	/*
	 * Método que será responsável pela listagem de todos os contatos de forma
	 * dinâmica no banco de dados.
	 */
	public ArrayList<JavaBeans> listarContatos() {
		ArrayList<JavaBeans> jBnsContatos = new ArrayList<>();
		String crudRead = "select * from tabelaContatos order by nome";
		try {
			Connection con = conectar();

			/*
			 * Preparar a QUERY para o Java executar o comando "crudRead" no servidor de
			 * banco de dados:
			 */
			PreparedStatement pSt = con.prepareStatement(crudRead);

			/*
			 * Usa-se o "ResultSet" para armazenar temporariamente, o retorno do banco de
			 * dados em um objeto.
			 */
			ResultSet rS = pSt.executeQuery();
			/*
			 * No caso, o objeto "rS" irá armazenar temporariamente todos os contatos //
			 * criados no banco de dados.
			 */

			/*
			 * Laço abaixo(while), será executado enquanto houver contatos. Esse método
			 * ".next", é usado para recuperar todos os contatos do banco de dados. Como não
			 * sabemos quantos contatos existem no banco de dados, se utiliza o método
			 * ".next" para executar o laço de repetição até não houver mais contatos, para
			 * serem armezandos.
			 */
			while (rS.next()) {

				/*
				 * Criar váriáveis de apoio. Que irão receber os dados que estão chegando do
				 * banco:
				 */
				String bDadosIdCode = rS.getString("idCode");
				String bDadosNome = rS.getString("nome");
				String bDadosPhone = rS.getString("phone");
				String bDadosEmail = rS.getString("email");

				/*
				 * Armazenar tudo que está chegando no banco de dados, com as variáves de apoio,
				 * no vetor dinâmico(ArrayList):
				 */
				jBnsContatos.add(new JavaBeans(bDadosIdCode, bDadosNome, bDadosPhone, bDadosEmail));
			}

			/*
			 * Quando não estiver mais contatos para ser inserido no vertor dinâmico.
			 * Encerra-se a conexão com o banco:
			 */
			con.close();
			return jBnsContatos;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// CRUD update.
	// Método para selecionar o contato.
	public void selecionarContato(JavaBeans jBnsContatos) {
		String readIdCode = "select * from tabelaContatos where idCode = ?";
		try {
			Connection con = conectar();
			PreparedStatement pSt = con.prepareStatement(readIdCode);

			// Substituindo, a interrogação(?) pelo idCode.
			pSt.setString(1, jBnsContatos.getIdCode());

			// Trazer as informações do contato que será editado e que está no banco.
			// Para exibir no formulário de edição.
			ResultSet rS = pSt.executeQuery();

			// Setar as variáveis "JavaBeans".
			while (rS.next()) {
				jBnsContatos.setIdCode(rS.getString("idCode"));
				jBnsContatos.setNome(rS.getString("nome"));
				jBnsContatos.setPhone(rS.getString("phone"));
				jBnsContatos.setEmail(rS.getString("email"));
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Método para salvar o contato editado, e mandar para o banco de dados.
	public void updateContato(JavaBeans jBnsContatos) {
		String crudUpdate = "update tabelaContatos set nome = ?, phone = ?, email = ? where idCode = ?";

		try {
			Connection con = conectar();
			PreparedStatement pSt = con.prepareStatement(crudUpdate);
			pSt.setString(1, jBnsContatos.getNome());
			pSt.setString(2, jBnsContatos.getPhone());
			pSt.setString(3, jBnsContatos.getEmail());
			pSt.setString(4, jBnsContatos.getIdCode());
			pSt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CRUD delete.
	public void deleteContato(JavaBeans jBnsContatos) {
		String crudDelete = "delete from tabelaContatos where idCode = ?";

		try {
			Connection con = conectar();
			PreparedStatement pSt = con.prepareStatement(crudDelete);
			pSt.setString(1, jBnsContatos.getIdCode());
			pSt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
