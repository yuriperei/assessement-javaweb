<%-- 
    Document   : index.jsp
    Created on : 18/09/2016, 23:55:30
    Author     : Yuri Pereira <yuri.souza@al.infnet.edu.br>
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

        <!-- Bootstrap core CSS -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Bootstrap core JS -->
        <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

        <!-- Custom styles for this template -->
        <link href="resources/css/signin.css" rel="stylesheet">
        <title>Livros</title>
    </head>
    <body>

        <div class="container">

            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">

                        <span class="navbar-brand" style="background-color: #428bca; color: #ffffff">Olá, <b>${usuario.nome}</b></span>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="livros">Livros</a></li>
                            <li><a href="autores">Autores</a></li>
                            <li><a href="editoras">Editoras</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="dashboard">Meu Perfil</a></li>
                            <li><a href="deslogar" style="background-color: #FFA500; color: #ffffff">Desconectar</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>

            <table class="table table-reflow">
                <thead>
                    <tr>
                        <th>Título</th>
                        <th>Lançamento</th>
                        <th>Autor</th>
                        <th>Editora</th>
                        <th><a href="cadastroLivro" class="btn btn-primary pull-right">Cadastrar Novo</a></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${livros}" var="livro">
                        <tr>
                            <td>${livro.titulo}</td>
                            <td><fmt:formatDate value="${livro.lancamento}"/></td>
                            <td>${livro.autor.nome}</td>                            
                            <td>${livro.editora.nome}</td>
                            <td>
                                <div class="btn-group" role="group" aria-label="...">
                                    <a href="visualizarLivro?id=${livro.id}" class="btn btn-default">Visualizar</a>
                                    <a href="alterarLivro?id=${livro.id}" class="btn btn-info">Alterar</a>
                                    <a href="excluirLivro?id=${livro.id}" class="btn btn-danger">Excluir</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
