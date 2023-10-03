<%--
  Created by IntelliJ IDEA.
  User: galle
  Date: 27/09/2023
  Time: 8:01 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.Map"%>
<%@ page import="java.util.List" %>
<%
    List<String> errores = (List<String>)request.getAttribute("errores");
%>
<%
    Map<String,String> errorsmap =
            (Map<String,String>)request.getAttribute("errorsmap");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Subject CRUD</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<h3><%= "Formulario notas" %>
</h3>

<form action="grades-form" method="post">
    <div class="row mb-3">
        <label for="grade" class="col-form-label col-sm-2">Nota</label>
        <div class="col-sm-4"><input type="text" name="grade" id="grade" class="form-control"></div>
        <%
            if(errorsmap != null && errorsmap.containsKey("grade")){
                out.println("<div class='row mb-3 alert alert-danger col-sm-4'" +
                        "style='color: red;'>"+ errorsmap.get("grade") + "</div>");
            }
        %>
    </div>
    <div class="row mb-3">
        <label for="corte" class="col-form-label col-sm-2">Corte</label>
        <div class="col-sm-4">
            <select name="corte" id="corte" class="form-select">
                <option value="">-- Seleccionar --</option>
                <option value="1" ${param.pais.equals("1")? "selected":
                        ""}>1</option>
                <option value="2" ${param.pais.equals("2")? "selected":
                        ""}>2</option>
                <option value="3" ${param.pais.equals("3")? "selected":
                        ""}>3</option>
            </select>
        </div>
            <%
            if(errorsmap != null && errorsmap.containsKey("corte")){
                out.println("<small class='alert alert-danger col-sm-4'" +
                "style='color: red;'>"+ errorsmap.get("corte") + "</small>");
            }
            %>
        <div>
            <input type="submit" value="Actualizar" class="btn btn-primary">
        </div>
</form>
<br/>
<h3><%= "Consultar por ID" %>
</h3>
<form action="gradesbyid" method="post">
    <div class="row mb-3">
        <label for="id" class="col-form-label col-sm-2">Id</label>
        <div class="col-sm-4"><input type="text" name="id" id="id" class="form-control"></div>
        <div class="row mb-3">
            <div>
                <input type="submit" value="Buscar" class="btn btn-primary">
            </div>
        </div>
    </div>
</form>
<br/>
<h3><%= "Eliminar por ID" %>
</h3>
<form action="deletegrade" method="post">
    <div class="row mb-3">
        <label for="idd" class="col-form-label col-sm-2">Id para eliminar</label>
        <div class="col-sm-4"><input type="text" name="idd" id="idd" class="form-control"></div>
        <div class="row mb-3">
            <div>
                <input type="submit" value="Eliminar" class="btn btn-primary">
            </div>
        </div>
    </div>
</form>
<br/>
<div>
    <h3><%= "Lista de notas" %>
    </h3>
    <a href="grades-form">Vamos a listar notas</a>
</div>
</body>
</html>
