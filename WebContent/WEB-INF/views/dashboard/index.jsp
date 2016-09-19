<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
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

        <!-- Custom styles for this template -->
        <link href="resources/css/signin.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">

            <div class="col-sm-6 center">
                <div class="alert alert-info mensagem">
                    <h4>Seja bem vindo(a), <b>${usuario.nome}</b></h4>
                </div>
                <a href="deslogar" class="btn btn-primary btn-lg btn-block">Descontar</a>
            </div>
        </div> <!-- /container -->

    </body>
</html>
