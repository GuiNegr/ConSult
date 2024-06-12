## #IDEIA 
	Ideia do projeto será criar uma plataforma para utilização de funcionarios em hospitais, aonde podem consultar: pacientes, consultas e medicos.
		Projeto feito e utilizado em JAVA com MySql.

## **#FERRAMENTAS**
	Utilizarei a bibliotecas padrões do JAVA.
	MySQL
	JDBC

## **#CARACTERISTICAS_DO_PROJETO**
	Projeto feito utilizando o Modelo MVC




# **TaskList**

- [x] Criação Model(PACIENTE,MEDICO,CONSULTAS)
- [x] Classe de conexão ao BD
- [x] Criação das entidades
- [x] Login
- [x] Create Pacientes
- [x] Read Pacientes(vai selecionar apenas por nome)
- [x] Delete Pacientes
- [x] Update Pacientes
- [x] Create Medico(CRM DO MEDICO VAI SER O ID)
- [x] Read Medicos(VAI SER TODOS OS MEDICOS DO SISTEMA)
- [x] Delete Medicos
- [x] Update Medicos
- [x] Create consulta
- [x] Read consulta
- [x] Delete consulta
- [x] Update Consulta
- [x] Interface Grafica - Login
- [x] aperfeiçoamento do login
- [x] inteface Grafica - User
- [x] View medico
- [x] view de cadastro
- [ ] view consulta
- [ ] Crianção do site para marcação de consulta
- [ ] Criação do crud de exames
- [ ] Criação do view do crud de exames
- [ ] Finalização




# Anotações
	-para criar consultas necessita de um cast para date e time sql.

	-funcionalidade de delete é algo banal para nossa regra de negocios. Não será utilizada na versão final.
	- Login 
	Adicionar um identificador para saber qual é o tipo do usuario logado.

	-Componentes da tela
	Telas
	-Login
		Adicionar um identificador para saber qual é o tipo do usuario logado.
	-User -Inicial
		BorderLayout para colocar o componente de pesquisa.
	-Medicos

# Tipos de usuarios

-User 
	-Cadastro de paciente.
	-PESQUISAR PACIENTE
	-AGENDAR CONSULTA
	-AGENDAR EXAME // funcionalidade não aplicada


-Medico
	-agendamento de exame
	-agendamento de consulta
	-pesquisar paciente
	-ver historico de paciente
