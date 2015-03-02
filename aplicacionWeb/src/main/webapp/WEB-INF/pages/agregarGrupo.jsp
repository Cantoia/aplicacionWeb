<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 25/02/2015
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>::. Agregar Grupo</title>
    <!-- Referencias CSS y JS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/bootstrap-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/font-awesome/font-awesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Bootstrap/modificacion.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/agregarUsuario.js"></script>
</head>
<body>
  <jsp:include page="panelUsuario.jsp"></jsp:include>
  <hr>
  <br>
  <br>
  <br>
  <div class="container">
    <div class="row">
      <div class="col-lg-offset-2 col-md-8 col-xs-8">
        <div class="panel panel-default">
          <div class="panel-heading">
            <strong>Datos de Nuevo Grupo</strong>
          </div>
          <div class="panel-body">
            <form:form role="form" id="addGrupoForm" action="${pageContext.request.contextPath}/Grupos/addGrupo.do" method="POST" modelAttribute="NuevoGrupo">
              <div>
                <!-- Id_Grupo // Codigo  -->
                <div class="form-group">
                  <label class="control-label" for="codigoInput">Código</label>
                  <div class="input-group">
                    <form:input path="idGrupo" class="form-control" id="codigoInput"/>
                    <span class="input-group-addon"><span id="iconoCodigo" class="glyphicon glyphicon-asterisk"></span></span>
                  </div>
                  <div class="error-ingreso help-block" id="errorGrupoId">${errorGrupoExist}</div>
                </div>
                <!-- Descripción grupo // Nombre -->
                <div class="form-group">
                  <label class="control-label" for="NameInput">Nombre</label>
                  <div class="input-group">
                    <form:input path="descripcionGrupo" class="form-control" id="NameInput"/>
                    <span class="input-group-addon"><span id="iconoNombre" class="glyphicon glyphicon-asterisk"></span></span>
                  </div>
                </div>
                <!-- estado -->
             <!-- <div class="checkbox">
                  <label>
                    <form path="estadoGrupo" type="checkbox" value="" id="chkEstado"/> va el parche
                    Activo
                  </label>
                </div> -->
               <!-- <button class="btn btn-success center-block" type="button" id="btnRegistrar"><span>Registrar</span><i id="iconoSubmit" class="fa"></i></button>-->
                <input type="submit" name="btnLogin" id="btnLogin" value="Login" class="btn btn-success center-block">
            </form:form>
          </div>
          <div class="panel-footer">
            <strong><span class="glyphicon glyphicon-asterisk"></span> Campos Requeridos</strong>
          </div>
        </div>
      </div>
    </div>
  </div>
  <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
