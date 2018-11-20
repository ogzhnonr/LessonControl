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



<!--main-container-part-->
<div id="content">

  <div class="container-fluid">

	<div>

		<div class="widget-box">
			<div class="span6">
				<div class="form-actions">
					<div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
			          <h5>Tanıtım Filmi</h5>
			        </div>
					<div class="widget-box">
						<video width="100%" height="auto" autoplay>
						  <source src="http://derstakipsistemi.com/media/tanitim_videosu.mp4" type="video/mp4">
						</video>
					</div>
				</div>
			</div>
			
			<div class="span6">
				<div class="form-actions">		
					<div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
			          <h5>Yeni Kullanıcı</h5>
			        </div>
				 	<form:form method="POST" modelAttribute="user">
					<form:input type="hidden" path="id" id="id"/>
					
					<table class="form-horizontal">
						<tr>
							<td><label style="font-size: 12px;" for="firstName">Adı</label></td>
							<td>
								<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
								<div class="has-error">
									<form:errors path="firstName" class="help-inline"/>
								</div>
							</td>
						</tr>
						
						<tr>
							<td><label style="font-size: 12px;" for="lastName">Soyadı</label></td>
							<td>
								<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="lastName" class="help-inline"/>
								</div>
							</td>
						</tr>
						
						<tr>
							<td><label style="font-size: 12px;" for="ssoId">Kullanıcı Adı</label></td>
							<td>
								<c:choose>
									<c:when test="${edit}">
										<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" disabled="true"/>
									</c:when>
									<c:otherwise>
										<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" />
										<div class="has-error">
											<form:errors path="ssoId" class="help-inline"/>
										</div>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						
						<tr>
							<td><label style="font-size: 12px;" for="password">Şifre</label></td>
							<td>
								<form:input type="password" path="password" id="password" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="password" class="help-inline"/>
								</div> 
							</td>
						</tr>
						
						<tr>
							<td><label style="font-size: 12px;" for="email">Email</label></td>
							<td>
								<form:input type="text" path="email" id="email" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="email" class="help-inline"/>
								</div>
							</td>
						</tr>
						
						<tr>
							<td><label style="font-size: 12px;" for="userProfiles">Roller</label></td>
							<td>
								<form:select path="userProfiles" items="${generalRoles}" multiple="false" itemValue="id" itemLabel="type" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="userProfiles" class="help-inline"/>
								</div>
							</td>
						</tr>
					</table>
					
					<div><!--  class="row" -->
						<div class="form-actions floatRight">
							<c:choose>
								<c:when test="${edit}">
									<input type="submit" value="Güncelle" class="btn btn-primary btn-sm"/>
									<a href="<c:url value='/login' />">
										<input type="button" value="İptal" class="btn btn-danger"/>
									</a>
								</c:when>
								<c:otherwise>
									<input type="submit" value="Kaydet" class="btn btn-primary btn-sm"/>  
									<a href="<c:url value='/login' />">
										<input type="button" value="İptal" class="btn btn-danger"/>
									</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					
				</form:form>
				</div>
			</div>
			
		</div>
	</div>
	<!-- New Task Milestone -->
   

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

<script src="/static/js/excanvas.min.js"></script> 
<script src="/static/js/jquery.min.js"></script> 
<script src="/static/js/jquery.ui.custom.js"></script> 
<script src="/static/js/bootstrap.min.js"></script> 
<script src="/static/js/jquery.flot.min.js"></script> 
<script src="/static/js/jquery.flot.resize.min.js"></script> 
<script src="/static/js/jquery.peity.min.js"></script> 
<script src="/static/js/fullcalendar.min.js"></script> 
<script src="/static/js/matrix.js"></script> 
<script src="/static/js/matrix.dashboard.js"></script> 
<script src="/static/js/jquery.gritter.min.js"></script> 
<script src="/static/js/matrix.interface.js"></script> 
<script src="/static/js/matrix.chat.js"></script> 
<script src="/static/js/jquery.validate.js"></script> 
<script src="/static/js/matrix.form_validation.js"></script> 
<script src="/static/js/jquery.wizard.js"></script> 
<script src="/static/js/jquery.uniform.js"></script> 
<script src="/static/js/select2.min.js"></script> 
<script src="/static/js/matrix.popover.js"></script> 
<script src="/static/js/jquery.dataTables.min.js"></script> 
<script src="/static/js/matrix.tables.js"></script> 

<script type="text/javascript">
  // This function is called from the pop-up menus to transfer to
  // a different page. Ignore if the value returned is a null string:
  function goPage (newURL) {

      // if url is empty, skip the menu dividers and reset the menu selection to default
      if (newURL != "") {
      
          // if url is "-", it is this page -- reset the menu:
          if (newURL == "-" ) {
              resetMenu();            
          } 
          // else, send page to designated URL            
          else {  
            document.location.href = newURL;
          }
      }
  }

// resets the menu selection upon entry to this page:
function resetMenu() {
   document.gomenu.selector.selectedIndex = 2;
}
</script>
</body>
</html>