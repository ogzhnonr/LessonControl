<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="authbar">
		<span> <a href="<c:url value='/edit-user-${loggedinuser}' />" class="btn btn-success custom-width"><strong>${loggedinuser}</strong></a> </span> <span class="floatRight"><a href="<c:url value="/logout" />"><strong>Çıkış</strong></a></span>
	</div>
