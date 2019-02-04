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

<div class="container">
    <h1>Cadastro de Usuários</h1>
    <div class="row">
        <form>
            <div class="col-md">
                <div class="form-group">
                    <label>Nome de Usuário</label>
                    <input type="text" class="form-control" id="nomedeusuario">

                    <label>E-mail</label>
                    <input type="email" class="form-control" id="email">

                    <label>Senha</label>
                    <input type="password" class="form-control" id="senha">

                    <label>Papel</label>
                    <select>
                        <%
                            java.util.List<br.com.ad.agendadodoutor.models.entidades.Papel> lista = (java.util.List<br.com.ad.agendadodoutor.models.entidades.Papel>) session.getAttribute("listaDePapeis");
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
                <div class="row">
                    <div class="col-md">
                        <button class="btn btn-success">Enviar</button>
                    </div>
                    <div class="col-md">
                        <button class="btn btn-warning">Limpar</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
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