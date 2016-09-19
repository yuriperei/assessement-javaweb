<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Painel</title>

        <!-- Bootstrap core CSS -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Bootstrap core JS -->
        <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

        <!-- Custom styles for this template -->
        <link href="resources/css/signin.css" rel="stylesheet">
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
                            <li><a href="autores">Autores</a></li>
                            <li><a href="editoras">Editoras</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="active"><a href="dashboard">Meu Perfil</a></li>
                            <li><a href="deslogar" style="background-color: #FFA500; color: #ffffff">Desconectar</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>

            <div class="col-form-label">

                <form class="form-signin" method="post" action="alterarUsuario">
                    <h3 class="form-signin-heading">Usuário</h3> 
                    <label for="inputNome" class="sr-only">Nome</label>
                    <input type="text" id="inputNome" class="form-control" name="nome" placeholder="Nome" value="${usuario.nome}" required autofocus>
                    <label for="inputEmail" class="sr-only">E-mail</label>
                    <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email" value="${usuario.email}" required>
                    <label for="inputPassword" class="sr-only">Senha</label>
                    <input type="password" id="inputPassword" class="form-control" name="senha" placeholder="Informe caso queira alterar a senha">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Salvar</button>
                    <a href="#" class="btn btn-dafault btn-lg btn-block">Quero apagar minha conta!</a>
                    <c:if test="${not empty mensagem}">
                        <div class="alert alert-success mensagem">
                            <b>${usuario.nome}</b>, seus dados foram alterados com sucesso!
                        </div>
                    </c:if>

                </form>
            </div>


            </div> <!-- /container -->

        </div> <!-- /container -->

    </body>
</html>
