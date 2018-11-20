<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<%@include file="head.jsp" %>
</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="">VERILH Öğrenci Takip Sistemi</a></h1>
</div>
<!--close-Header-part--> 


<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    
  </ul>
</div>
<!--close-top-Header-menu-->

<!-- loged in user info -->
<div id="loggedin-user">
    <%@include file="authheader.jsp"%>   
</div>
<!-- close loged in user info -->
<!--sidebar-menu-->
<div id="sidebar">
<!-- <a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a> -->
  <ul>
    <li><a href="dashboard" ><i class="icon icon-home"></i> <span>Ana Sayfa</span></a> </li>
    <li><a href="newTaskInfo" ><i class="icon icon-book"></i> <span>Ders Ekle</span></a> </li>
    <li><a href="listTaskInfo"><i class="icon icon-list"></i> <span>Çalışılan Ders Listesi</span></a> </li>
    <li><a href="newTaskMilestone" ><i class="icon icon-book"></i> <span>Deneme Ekle</span></a> </li>
    <li><a href="listTaskMilestone"><i class="icon icon-list"></i> <span>Sayısal Deneme Listesi</span></a> </li>
    <li><a href="listTaskMilestoneEA"><i class="icon icon-list"></i> <span>EA Deneme Listesi</span></a> </li>
    <li><a href="listTaskMilestoneSzl"><i class="icon icon-list"></i> <span>Sözel Deneme Listesi</span></a> </li>
    <li class="active"><a href="calculateScore"><i class="icon icon-asterisk"></i> <span>Puan Hesaplama</span></a> </li>
    
  </ul>
</div>		
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="calculateScore" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Puan Hesaplama</a></div>
  </div>
<!--End-breadcrumbs-->

  <div class="container-fluid">
	
    <div class="row-fluid">
      <div class="span3">
        
       <iframe src="https://www.tahminhesap.com/Sitene_Ekle/yks-kutusu/index.html" style="width:100%;max-width:300px;height:365px;display:block;margin:2px auto;padding:0px; border:0px; overflow:hidden;"></iframe>
        
      </div>
      <div class="span3">
       
        
      </div>
    </div>
  </div>
</div>

<!--end-main-container-part-->

<!--Footer-part-->

<div class="row-fluid">
  <div id="footer" class="span12"> 2018 &copy; VERILH. Brought to you by <a href="http://http://derstakipsistemi.com">Öğrenci Ders Takip Sistemi</a> </div>
</div>

<!--end-Footer-part-->

<script src="/static/js/jquery.min.js"></script> 
<script src="/static/js/jquery.ui.custom.js"></script> 
<script src="/static/js/bootstrap.min.js"></script> 
<script src="/static/js/matrix.js"></script> 

</body>
</html>