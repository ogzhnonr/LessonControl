<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<%@include file="head.jsp" %>
</head>

<body>
 	<div class="generic-container">
		<%@include file="authheader.jsp" %>

		<div class="well lead">Task Detail Registration Form</div>
	 	<form:form method="POST" modelAttribute="taskDetail" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="taskId">Task Id</label>
					<div class="col-md-7">
						<form:input type="integer" path="taskId" id="taskId" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="taskId" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="taskDetailId">Task Detail Id</label>
					<div class="col-md-7">
						<form:input type="integer" path="taskDetailId" id="taskDetailId" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="taskDetailId" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="taskDetailName">Task Detail Name</label>
					<div class="col-md-7">
						<form:input type="text" path="taskDetailName" id="taskDetailName" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="taskDetailName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Güncelle" class="btn btn-primary btn-sm"/>
							<a href="<c:url value='/listTasks' />">
								<input type="button" value="İptal" class="btn btn-danger"/>
							</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Kaydet" class="btn btn-primary btn-sm"/>  
							<a href="<c:url value='/listTasks' />">
								<input type="button" value="İptal" class="btn btn-danger"/>
							</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>