  <h1>Agenda de Contatos</h1>
  <p>Este é um projeto de agenda de contatos utilizando JavaWeb e Banco de Dados.</p>
  
  <h2> 🗂️ Índice </h2>
    <li><a href="#funcionalidades">Funcionalidades</a></li>
    <li><a href="#tecnologiasUtilizadas">Tecnologias Utilizadas</a></li>
    <li><a href="#estruturaDoProjeto">Estrutura do Projeto</a></li>
    <li><a href="#configurações">Configurações</a></li>
    <li><a href="#comoExecutar">Como Executar</a></li>
    <li><a href="#observações">Observações</a></li>
    <li><a href="#autor">Autor</a></li>
    <li><a href="#contatos">Contatos</a></li>


  <h2  id="funcionalidades">📑Funcionalidades</h2>
  <ul>
    <li>Listar todos os contatos cadastrados</li>
    <li>Cadastrar um novo contato</li>
    <li>Editar um contato existente</li>
    <li>Excluir um contato</li>
    <li>Gerar relatório em PDF com os contatos cadastrados</li>
  </ul>

  <h2  id="tecnologiasUtilizadas">🖥️Tecnologias Utilizadas</h2>
  <ul>
    <li>Java</li>
    <li>JavaWeb (Servlets)</li>
    <li>JavaScript</li>
    <li>MySQL</li>
    <li>JDBC</li>
    <li>iText PDF</li>
    <li>HTML</li>
    <li>Framework do BootStrap</li>
  </ul>

  <h2  id="estruturaDoProjeto">🗃️Estrutura do Projeto</h2>
      <ul>
        <li><strong>model</strong> - Pacote contendo a classe JavaBeans (modelo de dados) e a classe DAO (acesso ao
            banco de dados)</li>
        <li><strong>controller</strong> - Pacote contendo o servlet ControllerServlet (controlador do sistema)</li>
        <li><strong>webapp</strong> - Pasta contendo os arquivos HTML, JSP e JavaScript.
        </li>
    </ul>
        

<h2 id="configurações">⚙️Configurações</h2>
  <p>Antes de executar o projeto, é necessário realizar as seguintes configurações:</p>
  <ol>
    <li>Configurar o banco de dados MySQL e criar o banco de dados "dbAgendaContatos".</li>
    <li>Modificar as informações de conexão com o banco de dados (URL, usuário e senha) na classe DAO.</li>
    <li>Configurar o servidor de aplicação JavaWeb (por exemplo, Tomcat) para executar o projeto.</li>
  </ol>

  <h2 id="comoExecutar">❓Como Executar</h2>
  <ol>
    <li>Clone ou faça o download do projeto para o seu ambiente de desenvolvimento.</li>
    <li>Importe o projeto para a sua IDE Java (Eclipse, IntelliJ, etc.).</li>
    <li>Realize as configurações necessárias conforme descrito acima.</li>
    <li>Inicie o servidor de aplicação JavaWeb.</li>
    <li>Implante o projeto no servidor.</li>
    <li>Acesse a aplicação pelo navegador utilizando a URL fornecida pelo servidor.</li>
  </ol>

  <h2 id="observações">❗Observações</h2>
  <p>Este projeto é apenas uma demonstração básica de uma agenda de contatos utilizando JavaWeb e Banco de Dados. Para fins de aprendizado e desenvolvimento.</p>
  <p>Na classe "DAO", no "módulo e parâmetros de conexão", deve ser alerada para fazer a conexão com o seu Banco de Dados. Retire as aspas simples(') e coloque a porta do seu usuário; nome do seu Banco de Dados; nome do usuário e a senha do banco. O driver continua o mesmo.</p> 
  <h3>Exemplo: </h3>
  <ul>
    <li>private String url = "jdbc:mysql://127.0.0.1:3306/dbAgendaContatos?useTimezone=true&serverTimezone=UTC";</li>
    <li>private String user = "root";</li>
    <li>private String password = "@mySqlBanco1234";</li>
  </ul>
  <p>Nota que esses são <strong> os meus módulos e parâmetros de conexão. </strong> Estes mudam de acordo com o banco de dados do usuário</p>


  <h2 id="autor">🖐️Autor</h2>
  <p>Luis Gabriel Goés De Santana</p>
  
  <h2 id="contatos">📞Contatos</h2>
  <ul>
    <li>Email: luis.santana.profissional@gmail.com</li>
    <li>LinkedIn: <a href="https://www.linkedin.com/in/luisgabrielsantana/">Luis Gabriel Santana</a></li>
  </ul>


  
