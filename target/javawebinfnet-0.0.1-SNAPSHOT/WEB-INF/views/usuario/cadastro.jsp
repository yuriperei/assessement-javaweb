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

        <title>Cadastrar usuário</title>

        <!-- Bootstrap core CSS -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="resources/css/signin.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">

            <form class="form-signin" method="post" action="cadastro">
                <h3 class="form-signin-heading">Cadastro de usuário</h3>
                <label for="inputNome" class="sr-only">Nome</label>
                <input type="text" id="inputNome" class="form-control" name="nome" placeholder="Nome" required autofocus>
                <label for="inputEmail" class="sr-only">E-mail</label>
                <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email" required>
                <label for="inputPassword" class="sr-only">Senha</label>
                <input type="password" id="inputPassword" class="form-control" name="senha" placeholder="Senha" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Cadastrar</button>
                <a href="usuario" class="btn btn-dafault btn-lg btn-block">Efetuar login</a>

                <c:if test="${not empty usuario}">
                    <div class="alert alert-success mensagem">
                        Seja bem vindo(a), <b>${usuario.nome}</b>
                        </br></br>
                        <b>Dados de acesso:</b> </br> E-mail: ${usuario.email}
                    </div>
                </c:if>
                
            </form>


        </div> <!-- /container -->

    </body>
</html>
