<form action="<c:url value="/login"/>" method="POST">
    <fieldset>
        <legend>Efetue o login</legend>
        <label for="login">Login:</label>
        <input id="login" type="text" name="usuario.login"/>
        <label for="senha">Senha:</label>
        <input id="senha" type="password" name="usuario.senha"/>
        <button type="submit">Login</button>
    </fieldset>
</form>
