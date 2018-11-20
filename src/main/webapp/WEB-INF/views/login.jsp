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
			
			<div class="span3">
				<div class="form-actions">
					<div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
			          <h5>ÖTS Giriş</h5>
			        </div>
					<form action="${loginUrl}" method="post" class="form-horizontal">
								<c:if test="${param.error != null}">
									<div class="alert alert-danger">
										<p>Geçersiz kullanıcı adı ve/veya şifre.</p>
									</div>
								</c:if>
								<c:if test="${param.logout != null}">
									<div class="alert alert-success">
										<p>Çıkış yaptınız.</p>
									</div>
								</c:if>
								<table class="form-horizontal">
									<tr>
										<td>
											<input type="text" class="form-control input-sm" id="username" name="ssoId" placeholder="Kullanıcı Adı" required>
										</td>
									</tr>
									
									<tr>
										<td>
											<input type="password" class="form-control input-sm" id="password" name="password" placeholder="Şifre" required>
										</td>
									</tr>
									
									<tr>
										<td>
											<div class="checkbox">
			                                	<label><input type="checkbox" id="rememberme" name="remember-me"> Beni Hatırla</label>  
			                            	</div>
			                            	<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
										</td>
										<td>
										</td>
									</tr>
									
									<tr>
										<td>
											<div class="form-actions">
												<input type="submit" class="btn btn-block btn-primary btn-default" value="Giriş">
											</div>
										</td>
									</tr>
									
									<tr>
										<td>
											<div class="form-actions">
												<a href="newuseranonymus" ><input class="btn btn-block btn-primary btn-default" value="Yeni Kayıt"></a>
											</div>
										</td>
									</tr>
								</table>
								
								<c:choose>
									<c:when test="${successfullRegistration}">
										<div class="alert alert-success lead">
									    	${success}
										</div>
									</c:when>
									<c:otherwise>
										
									</c:otherwise>
								</c:choose>
								
							</form>
				  
				</div>
			
			</div>
			
			<div class="span6">
			 
				 <div class="span6">
					<div class="form-actions">
						<div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
				          <h5>Tanıtım Filmi</h5>
				        </div>
						<div class="widget-box">
							<video width="100%" height="auto" controls>
							  <source src="http://derstakipsistemi.com/media/tanitim_videosu.mp4" type="video/mp4">
							</video>
						</div>
					</div>
				</div>
			  
			</div>
			
			<div class="span3">
			
			
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