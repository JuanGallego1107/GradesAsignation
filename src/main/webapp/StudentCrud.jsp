<%--
  Created by IntelliJ IDEA.
  User: galle
  Date: 26/09/2023
  Time: 5:19 p. m.
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
  <title>Student CRUD</title>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<h3><%= "Formulario estudiantes" %>
</h3>
<form action="student-form" method="post">
  <div class="row mb-3">
    <label for="name" class="col-form-label col-sm-2">Name</label>
    <div class="col-sm-4"><input type="text" name="name" id="name" class="form-control"
    value="${param.name}"></div>
    <%
      if(errorsmap != null && errorsmap.containsKey("name")){
        out.println("<div class='row mb-3 alert alert-danger col-sm-4'" +
                "style='color: red;'>"+ errorsmap.get("name") + "</div>");
      }
    %>
  </div>
  <div class="row mb-3">
    <label for="email" class="col-form-label col-sm-2">Email</label>
    <div class="col-sm-4"><input type="text" name="email" id="email" class="form-control"></div>
    <%
      if(errorsmap != null && errorsmap.containsKey("email")){
        out.println("<div class='row mb-3 alert alert-danger col-sm-4' " +
                "style='color: red;'>"+ errorsmap.get("email") + "</div>");
      }
    %>
  </div>
  <div class="row mb-3">
    <label for="degree" class="col-form-label col-sm-2">Degree</label>
    <div class="col-sm-4">
      <select name="degree" id="degree" class="form-select">
        <option value="">-- Seleccionar --</option>
        <option value="Ingenieria de software" ${param.pais.equals("Ingenieria de software")? "selected":
                ""}>Ingenieria de software</option>
        <option value="Ingenieria Industrial" ${param.pais.equals("Ingenieria Industrial")? "selected":
                ""}>Ingenieria Industrial</option>
        <option value="Enfermeria" ${param.pais.equals("Enfermeria")? "selected":
                ""}>Enfermeria</option>
        <option value="Medicina" ${param.pais.equals("Medicina")? "selected":
                ""}>Medicina</option>
        <option value="Veterinaria" ${param.pais.equals("Veterinaria")? "selected":
                ""}>Veterinaria</option>
        <option value="Turismo" ${param.pais.equals("Turismo")? "selected":
                ""}>Turismo</option>
        <option value="Derecho" ${param.pais.equals("Derecho")? "selected":
                ""}>Derecho</option>
        <option value="Psicologia" ${param.pais.equals("Psicologia")? "selected":
                ""}>Psicologia</option>
        <option value="Ingenieria Civil" ${param.pais.equals("Ingenieria Civil")? "selected":
                ""}>Ingenieria Civil</option>
        <option value="Marketing Digital" ${param.pais.equals("Marketing Digital")? "selected":
                ""}>Marketing Digital</option>
      </select>
    </div>
      <%
        if(errorsmap != null && errorsmap.containsKey("degree")){
          out.println("<small class='alert alert-danger col-sm-4'" +
                  "style='color: red;'>"+ errorsmap.get("degree") + "</small>");
}
%>
  </div>
  <div class="row mb-3">
    <label for="semester" class="col-form-label col-sm-2">Semester</label>
    <div class="col-sm-4">
      <select name="semester" id="semester" class="form-select">
        <option value="">-- Seleccionar --</option>
        <option value="I" ${param.pais.equals("I")? "selected":
                ""}>I</option>
        <option value="II" ${param.pais.equals("II")? "selected":
                ""}>II</option>
        <option value="III" ${param.pais.equals("III")? "selected":
                ""}>III</option>
        <option value="IV" ${param.pais.equals("IV")? "selected":
                ""}>IV</option>
        <option value="V" ${param.pais.equals("V")? "selected":
                ""}>V</option>
        <option value="VI" ${param.pais.equals("VI")? "selected":
                ""}>VI</option>
        <option value="VII" ${param.pais.equals("VII")? "selected":
                ""}>VII</option>
        <option value="VIII" ${param.pais.equals("VIII")? "selected":
                ""}>VIII</option>
        <option value="IX" ${param.pais.equals("IX")? "selected":
                ""}>IX</option>
        <option value="X" ${param.pais.equals("X")? "selected":
                ""}>X</option>
      </select>
    </div>
      <%
if(errorsmap != null && errorsmap.containsKey("semester")){
out.println("<small class='alert alert-danger col-sm-4'" +
 "style='color: red;'>"+ errorsmap.get("semester") + "</small>");
}
%>
  <div class="row mb-3">
    <div>
      <input type="submit" value="Actualizar" class="btn btn-primary">
    </div>
  </div>
</form>
<br/>
<h3><%= "Consultar por ID" %>
</h3>
<form action="byid" method="post">
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
<form action="studentdelete" method="post">
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
  <h3><%= "Lista de estudiantes" %>
  </h3>
  <a href="student-form">Vamos a listar estudiantes</a>
</div>
</body>
</html>
