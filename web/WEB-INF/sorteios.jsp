<%@page import="br.ufjf.dcc192.Participante"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

                
<table>
    <th>codigo do evento</th>
    <th>titulo do evento</th>
    <th>pre�o minimo do evento</th>
    <th>data do evento</th>
    <th>data do sorteio</th>
        <c:forEach var="evento" items="${eventos}">
        <tr>
            <td>${evento.getId()}</td>
            <td>${evento.getTitulo()}</td>
            <td>${evento.getMinimo()}</td>
            <td>${evento.getDataSorteio()}</td>
            <td>${evento.getDataEvento()}</td>

           
                <c:if test="${!evento.isSorteia()}">
                    <td>
                        <form method="get" action="inscricao.html">
                            <input type="hidden" name="id" value="${evento.getId()}">
                            <input type="hidden" name="idUser" value="${idUser}">
                            <input type="submit" value="ADICIONAR"/>
                        </form>            
                    </td>
                </c:if>

            
            <c:if test="${evento.isSorteia()}">
                <td>
                    <form method="get" action="inscritos.html">
                        <input type="hidden" name="id" value="${evento.getId()}">
                        <input type="hidden" name="idUser" value="${idUser}">
                        
                        <input type="submit" value="SORTEIO"/>
                    </form>            
                </td>
            </c:if>
        </tr>
    </c:forEach>
</table>




<%@include file="jspf/rodape.jspf" %>
