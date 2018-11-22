<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<%@include file="head.jsp" %>
</head>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp"%>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Tasks </span>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>TaskId</th>
						<th>ParentId</th>
						<th>TaskName</th>
						<sec:authorize access="hasRole('ADMIN')">
							<th width="100"></th>
						</sec:authorize>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tasks}" var="task">
						<tr>
							<td>${task.taskId}</td>
							<td>${task.parentId}</td>
							<td>${task.taskName}</td>
							<sec:authorize access="hasRole('ADMIN')">
								<td><a href="<c:url value='/delete-task-${task.taskId}' />"
									class="btn btn-danger custom-width">delete</a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<sec:authorize access="hasRole('ADMIN')">
			<div class="well">
				<a href="<c:url value='/newtask' />">Add New Task</a>
			</div>
		</sec:authorize>
	</div>
</body>

</html>