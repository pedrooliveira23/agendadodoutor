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
        <h1>Cadastro de Usuários</h1>
    </div>
    <form class="row mt-5">
        <div class="col-md-1">
            <div id="sidebar">
                <h5>
                    <small><b>Ações</b></small>
                </h5>
                <ul class="list-unstyled">
                    <button class="btn btn-md btn-link" type="submit" name="acao" value="salvar">Salvar</button>
                    <button class="btn btn-md btn-link" type="submit" name="acao" value="limpar">Limpar</button>
                    <button class="btn btn-md btn-link" type="submit" name="acao" value="voltar">Voltar</button>
                </ul>
            </div>
        </div>
        <div class="col-md-2"></div>
        <div class="col-md-5">
            <label>Nome de Usuário:</label>
            <input type="text" class="form-control" id="nomedeusuario" name="nomedeusuario">

            <label class="mt-2">E-mail:</label>
            <input type="email" class="form-control" id="email" name="email">

            <label class="mt-2">Senha:</label>
            <input type="password" class="form-control" id="senha" name="senha">

            <label class="mt-2">Papel:</label>
            <select name="papel">
                <%
                    java.util.List<br.com.ad.agendadodoutor.models.entities.Papel> lista = (java.util.List<br.com.ad.agendadodoutor.models.entities.Papel>) session.getAttribute("listaDePapeis");
                    for (int i = 0; i < lista.size(); i++) {
                %>
                <option>
                    <%=lista.get(i).getNome()%>
                </option>
                <%
                    }
                %>
            </select>
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