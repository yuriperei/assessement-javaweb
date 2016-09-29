<%-- 
    Document   : cadastrar.jsp
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

        <!--JQuery Datapicker-->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <!-- Bootstrap core CSS -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Bootstrap core JS -->
        <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

        <!-- Custom styles for this template -->
        <link href="resources/css/signin.css" rel="stylesheet">
        <title>Cadastrar Livro</title>
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

            <div class="col-form-label">

                <form class="form-signin" method="post" action="manterLivro">
                    <h3 class="form-signin-heading">Cadastro de Livro</h3>
                    <input type="text" name="id" value="${livro.id}" hidden>
                    <label for="inputNome" class="input-group">Título</label>
                    <input type="text" id="inputNome" class="form-control" name="titulo" value="${livro.titulo}" placeholder="titulo" required autofocus>
                    <label for="inputNome" class="input-group">Data de Lançamento</label>
                    <input id="datepicker" name="lancamento" class="form-control" type="datetime" value="<fmt:formatDate value="${livro.lancamento}" pattern="dd/MM/yyyy"/>" readonly="true"/>
                    <label for="inputNome" class="input-group">Escolha o autor</label>
                    <select class="form-control select"
                            data-placeholder="Selecione o autor" name="autor.id"
                            id="inputNome" required>
                        <c:forEach items="${autores}" var="autor">
                            <c:choose>
                                <c:when test="${autor.id == livro.autor.id}">
                                    <option value="${autor.id}" selected="">${autor.nome}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${autor.id}">${autor.nome}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <label for="inputNome" class="input-group">Escolha a editora</label>
                    <select class="form-control select2"
                            data-placeholder="Selecione a editora" name="editora.id"
                            id="inputPassword" required>
                        <c:forEach items="${editoras}" var="editora">
                            <c:choose>
                                <c:when test="${editora.id == livro.editora.id}">
                                    <option value="${editora.id}" selected="">${editora.nome}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${editora.id}">${editora.nome}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Salvar</button>

                </form>
            </div>

        </div>
        <script>
            $(function () {
                $("#datepicker").datepicker({ dateFormat: 'dd/mm/yy' });
            });
        </script>
    </body>
</html>
