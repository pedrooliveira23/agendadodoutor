<%@ page import="br.com.ad.agendadodoutor.models.entities.Papel" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Agenda do Doutor</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
</head>
<body>
<%@include file="navbar.jsp" %>

<div class="container mt-3">
    <div class="text-center">
        <h1>Dados do Usuario</h1>
    </div>
    <form class="row mt-5">
        <div class="col-md-12">
            <label>Nome Completo:</label>
            <input type="text" class="form-control" id="nomecompleto" name="nomecompleto" value="<%=request.getAttribute("nomeCompleto")%>" readOnly='true'>

            <label class="mt-2">Nome de Usuário:</label>
            <input type="text" class="form-control" id="nomedeusuario" name="nomedeusuario"
                   value="<%=request.getAttribute("nomeDeUsuario")%>" readOnly='true'>

            <label class="mt-2">E-mail:</label>
            <input type="email" class="form-control" id="email" name="email" value="<%=request.getAttribute("email")%>" readOnly='true'>

            <label class="mt-2">Senha:</label>
            <input type="text" class="form-control" id="senha" name="senha"
                   value="<%=request.getAttribute("senha")%>" readOnly='true'>

            <label class="mt-2">Papel:</label>
            <input type="text" class="form-control" id="papel" name="papel" value="<%=request.getAttribute("papel")%>" readonly="true">
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>

</body>
</html>