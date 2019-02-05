<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-end">
    <a class="navbar-brand" href="#">EA</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarAdministracao" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Administração
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="./listagemdeusuarios">Usuários</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarUsuario" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <%=session.getAttribute("nomeDeUsuario")%>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="./logout">Sair</a>
                </div>
            </li>
        </ul>
    </div>
</nav>