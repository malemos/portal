<form action="<c:url value="/produto/${produto.id}"/>" method="post">
	<fieldset>
		<legend>Editar Produto</legend>
		
		<input type="hidden" name="produto.id" value="${produto.id}">
		<label for="nome">Nome:</label>
		<input type="text" name="produto.nome" value="${produto.nome}" id="nome"/>
			
		<label for="descricao">Descrição:</label>
		<input type="text" style="width: 380px" name="produto.descricao" value="${produto.descricao}" id="descricao"/>
			
		<label for="preco">Preço:</label>
		<input type="text" style="width: 80px" name="produto.preco" value="${produto.preco}" id="preco"/>
			
		<label for="quantidade">Quantidade:</label>
		<input type="text" style="width: 80px" name="produto.quantidade" value="${produto.quantidade}" id="quantidade"/>
		<button type="submit" value="PUT" name="_method">Enviar</button>
	</fieldset>
</form>