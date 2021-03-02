<#include "security.ftl">

<nav class="navbar navbar-expland-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Sweater</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="Home"></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>
        </ul>
        <div class="navbar-text">${name}</div>
    </div>
</nav>