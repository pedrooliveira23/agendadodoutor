<%@ page import="br.com.ad.agendadodoutor.models.entities.Usuario" %>
<%@ page import="br.com.ad.agendadodoutor.models.businessobjects.PapelBo" %>
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
        <h1>Usuários</h1>
    </div>
    <div class="row mt-5">
        <div class="col-md-2">
            <div id="sidebar">
                <h5>
                    <small><b>Ações</b></small>
                </h5>
                <form>
                    <ul class="list-unstyled">
                        <ul class="list-unstyled">
                            <li>
                                <button class="btn btn-md btn-link" type="submit" name="acao" value="novo">Novo</button>
                            </li>
                        </ul>
                    </ul>
                </form>
                <form>
                    <h5>
                        <small><b>Pesquisar</b></small>
                    </h5>
                    <ul class="list-unstyled">
                        <li>
                            <input type="text" class="form-control" id="buscar" placeholder="Nome de Usuario..."
                                   name="pesquisar">
                        </li>
                    </ul>
                </form>
            </div>
        </div>
        <div class="col-md-10">
            <form>
                <table class="table table-hover">
                    <thead>
                    <tr class="text-center">
                        <th scope="col">ID</th>
                        <th scope="col">Ações</th>
                        <th scope="col">Nome Completo</th>
                        <th scope="col">Nome de Usuário</th>
                        <th scope="col">E-mail</th>
                        <th scope="col">Papel</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        PapelBo papelBo = new PapelBo();
                        java.util.List<Usuario> lista = (java.util.List<Usuario>) request.getAttribute("listaDeUsuarios");
                        for (Usuario usuario : lista) {
                    %>
                    <tr class="text-center">
                        <th scope="row"><%=usuario.getId()%>
                        </th>
                        <td>
                            <button class="btn btn-sm btn-link" type="submit" name="editarUsuario"
                                    value="<%=usuario.getNomeDeUsuario()%>">Editar
                            </button>
                            <button class="btn btn-sm btn-link" type="submit" name="removerUsuario"
                                    value="<%=usuario.getNomeDeUsuario()%>">Remover
                            </button>
                        </td>
                        <td><%=usuario.getNomeCompleto()%>
                        </td>
                        <td><%=usuario.getNomeDeUsuario()%>
                        </td>
                        <td><%=usuario.getEmail()%>
                        </td>
                        <td><%=papelBo.obtenhaPapelPeloId(usuario.getIdPapel()).getNome()%>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </form>
        </div>
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