<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

</head>

<body>
 
    <c:set var="anno" value="1997"/>
    <c:set var="mees" value="1"/>
    <c:set var="proc" value="2"/> 

    <h1>Data Consultor2</h1>
    <p>Año = <c:out value="${anno}" ></c:out>  Mes : <c:out value="${mees}"></c:out> </p>

    <form action="./listcons" method="POST">
        
        <label > Datos :</label>
        <input type="text" name="anno" value="<c:out value="${anno}" />"/>
        <input type="text" name="mees" value="<c:out value="${mees}" />"/>
        <input type="text" name="proc2" value="<c:out value="${proc}" />"/>
        <input type="submit" value="Buscar">
    </form>
    
    <table>

        <thead>
            <th>Per&iacuteodo</th>
            <th>Receita L&iacutequida</th>
            <th>Custo Fixo</th>
            <th>Comiss&atildeo</th>
            <th>Lucro</th>
        </thead>
        <c:forEach items="${prendas}" var="prenda">

            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            
        </c:forEach>
        <tr>
            <td>SALDO</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </table>
</body>

</html>