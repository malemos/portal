<table>
	<thead>
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Preço</th>
			<th>Quantidade</th>
			<th>Comprar</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${produtoList}" var="produto">
			<tr>
				<td>${produto.id}</td>
				<td>${produto.nome}</td>
				<td>${produto.descricao}</td>
				<td>R$ ${produto.preco}</td>
				<td>${produto.quantidade}</td>
				<!-- Adicionando carrinho de compras -->
				<td>
					<form action="<c:url value="/carrinho"/>" method="post">
						<input type="hidden" name="item.produto.id" value="${produto.id}"/>
						<input class="qtde" name="item.quantidade" value="1"/>
						<button type="submit">Comprar</button>
					</form>
				</td>
				<c:if test="${usuarioWeb.logado }">
					<td><a href="<c:url value="/produto/${produto.id}"/>">Editar</a> </td>
					<td>
						<form action="<c:url value="/produto/${produto.id}"/>" method="post">
							<button class="link" name="_method" value="DELETE">Remover</button>
						</form>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>