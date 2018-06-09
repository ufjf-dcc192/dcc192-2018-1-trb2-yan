<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

<table>
    <th>Id</th>
    <th>Nome</th>
    <c:forEach var="usuario" items="${usuarios}">
        <tr>
            <td>${usuario.getId()}</td>
            <td>${usuario.getNome()}</td>
            <td>
                <form method="post" action="inscricao.html?id=${id}">
                 <input type="hidden" name="idUsuario" value="${usuario.getId()}">
                
                 <input type="submit" value="Adicionar ao evento"/>
                
            </form>
        </td>
    </tr>
</c:forEach>
</table>
    



<%@include file="jspf/rodape.jspf" %>
