<%--
  Created by IntelliJ IDEA.
  User: galle
  Date: 27/09/2023
  Time: 8:01 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grades CRUD</title>
</head>
<body>
<h3><%= "Formulario notas" %>
</h3>

<form action="grades-form" method="post">
    <div class="row mb-3">
        <label for="idf" class="col-form-label col-sm-2">Id</label>
        <div class="col-sm-4"><input type="text" name="idf" id="idf" class="form-control"></div>
    </div>
    <div class="row mb-3">
        <label for="grade" class="col-form-label col-sm-2">Nota</label>
        <div class="col-sm-4"><input type="text" name="grade" id="grade" class="form-control"></div>
    </div>
    <div class="row mb-3">
        <label for="corte" class="col-form-label col-sm-2">Corte</label>
        <div class="col-sm-4"><input type="text" name="corte" id="corte" class="form-control"></div>
    </div>
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
