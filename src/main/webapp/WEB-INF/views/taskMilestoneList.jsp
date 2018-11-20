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
    <li class="active"><a href="listTaskMilestone"><i class="icon icon-list"></i> <span>Sayısal Deneme Listesi</span></a> </li>
    <li><a href="listTaskMilestoneEA"><i class="icon icon-list"></i> <span>EA Deneme Listesi</span></a> </li>
    <li><a href="listTaskMilestoneSzl"><i class="icon icon-list"></i> <span>Sözel Deneme Listesi</span></a> </li>
    <li><a href="calculateScore"><i class="icon icon-asterisk"></i> <span>Puan Hesaplama</span></a> </li>
  </ul>
</div>		
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="listTaskMilestone" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Sayısal Deneme Listesi</a></div>
  </div>
<!--End-breadcrumbs-->

  <div class="container-fluid">
	<!-- Task Milestone List -->
	<div class="row-fluid">
      
      <div class="span12">
        
        <div class="widget-box">
          <div class="widget-title">
            <ul class="nav nav-tabs">
              <li class="active"><a data-toggle="tab" href="#tab1">Sayısal Liste</a></li>
            </ul>
          </div>
          <div class="widget-content tab-content">
            <div id="tab1" class="tab-pane active">
              <div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">
						<!-- <span class="lead">List of TaskMilestones </span> -->
					</div>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Kulanıcı</th>
								<th>Deneme No</th>
								<th>Tyt Turkce</th>
								<th>Tyt Matematik</th>
								<th>Tyt Fizik</th>
								<th>Tyt Kimya</th>
								<th>Tyt Biyoloji</th>
								<th>Tyt Tarih</th>
								<th>Tyt Cografya</th>
								<th>Tyt Felsefe</th>
								<th>Tyt Din</th>
								<th>Yks Matematik</th>
								<th>Yks Fizik</th>
								<th>Yks Kimya</th>
								<th>Yks Biyoloji</th>
								<sec:authorize access="hasRole('ADMIN')">
									<th width="100"></th>
								</sec:authorize>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${taskMilestones}" var="taskMilestone">
								<tr>
									<td>${taskMilestone.ssoId}</td>
									<td>${taskMilestone.denemeId}</td>
									<td>${taskMilestone.tytTurkce}</td>
									<td>${taskMilestone.tytMatematik}</td>
									<td>${taskMilestone.tytFizik}</td>
									<td>${taskMilestone.tytKimya}</td>
									<td>${taskMilestone.tytBiyoloji}</td>
									<td>${taskMilestone.tytTarih}</td>
									<td>${taskMilestone.tytCografya}</td>
									<td>${taskMilestone.tytFelsefe}</td>
									<td>${taskMilestone.tytDin}</td>
									<td>${taskMilestone.yksMatematik}</td>
									<td>${taskMilestone.yksFizik}</td>
									<td>${taskMilestone.yksKimya}</td>
									<td>${taskMilestone.yksBiyoloji}</td>
									<td><a href="<c:url value='/delete-taskMilestone-${taskMilestone.denemeId}' />"
										class="btn btn-danger custom-width">Sil</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="well">
					<a href="<c:url value='/newTaskMilestone' />">
						<input type="button" value="Yeni Deneme Ekle" class="btn btn-success"/>
					</a>
				</div>
			
            </div>

          </div>
        </div>
        
        
        
      </div>
    
    </div>
	<!-- Task Milestone List-->
   

    <hr/>
    <div class="row-fluid">
      <div class="span6">
        
        
      </div>
      <div class="span6">
       
        
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