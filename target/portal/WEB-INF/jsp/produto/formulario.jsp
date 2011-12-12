<form action="<c:url value="/produto/${produto.id}"/>" method="post" id="produtosForm">
	<fieldset>
		<legend>Adiciona Produto</legend>
		<label for="nome">Nome:</label>
		<input type="text" id="nome" name="produto.nome" value="${produto.nome}" class="required" minlength="3"/>
		<label style="display: none;" for="nome" class="error">Valor inválido.</label>
			
		<label for="descricao">Descrição:</label>
		<input type="text" id="descricao" class="required" maxlength="40" style="width: 380px" name="produto.descricao" value="${produto.descricao}"/>
			
		<label for="preco">Preço:</label>
		<input type="text" id="preco" min="0" style="width: 80px" name="produto.preco" value="${produto.preco}"/>
			
		<label for="quantidade">Quantidade:</label>
		<input type="text" id="quantidade" min="0" style="width: 80px" name="produto.quantidade" value="${produto.quantidade}"/>
		<input type="submit" value="Criar"/>
	</fieldset>
</form>

<script type="text/javascript">
	$("form").validate();
</script>