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

        <title>Login</title>

        <!-- Bootstrap core CSS -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="resources/css/signin.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">

            <form class="form-signin" method="post" action="login">
                <h3 class="form-signin-heading">Login</h3>
                <label for="inputEmail" class="sr-only">E-mail</label>
                <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email" required autofocus>
                <label for="inputPassword" class="sr-only">Senha</label>
                <input type="password" id="inputPassword" class="form-control" name="senha" placeholder="Senha" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Acessar painel</button>
                <a href="cadastro" class="btn btn-dafault btn-lg btn-block">Quero fazer o meu cadastro</a>


                <c:if test="${not empty erro}">
                    <div class="alert alert-success mensagem">
                        ${erro}
                    </div>
                </c:if>

            </form>
        </div> <!-- /container -->

    </body>
</html>
