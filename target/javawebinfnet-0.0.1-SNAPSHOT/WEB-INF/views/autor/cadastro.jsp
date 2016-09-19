<%-- 
    Document   : cadastro.jsp
    Created on : 18/09/2016, 23:56:12
    Author     : DesenvolvedorJava
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <title>Autor Cadastro</title>
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
                            <li><a href="livros">Livros</a></li>
                            <li class="active"><a href="autores">Autores</a></li>
                            <li><a href="editoras">Editoras</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="dashboard">Meu Perfil</a></li>
                            <li><a href="deslogar" style="background-color: #FFA500; color: #ffffff">Desconectar</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>

            <div class="col-form-label">

                <form class="form-signin" method="post" action="manterAutor">
                    <h3 class="form-signin-heading">Autor</h3>
                    <input type="text" name="id" value="${autor.id}" hidden>
                    <label for="inputNome" class="input-group">Nome do autor</label>
                    <input type="text" id="inputNome" class="form-control" name="nome" value="${autor.nome}" placeholder="Nome do autor" required autofocus>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Salvar</button>

                </form>
            </div>

        </div>
        
    </body>
</html>
