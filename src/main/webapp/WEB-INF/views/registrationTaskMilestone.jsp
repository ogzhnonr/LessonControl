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
    <li class="active"><a href="newTaskMilestone" ><i class="icon icon-book"></i> <span>Deneme Ekle</span></a> </li>
    <li><a href="listTaskMilestone"><i class="icon icon-list"></i> <span>Sayısal Deneme Listesi</span></a> </li>
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
    <div id="breadcrumb"> <a href="newTaskMilestone" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Deneme Ekle</a></div>
  </div>
<!--End-breadcrumbs-->

  <div class="container-fluid">

	<!-- New Task Milestone -->
	<div>

		<div class="widget-box">
	        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
	          <h5>Çözülen Deneme Ekle</h5>
	        </div>
		 	<form:form method="POST" modelAttribute="taskMilestone" >
				<form:input type="hidden" path="id" id="id"/>
				
				<table class="form-horizontal">
					<tr>
						<td><label style="font-size: 12px;" for="ssoId">Kullanıcı</label></td>
						<td>
								<form:input type="text" path="ssoId" id="ssoId" value="${loggedinuser}" class="form-control input-sm" readonly="true" />
								<div class="has-error">
									<form:errors path="ssoId" class="help-inline"/>
								</div>
							</td>
					</tr>
					
					<tr>
						<td><label style="font-size: 12px;" for="denemeId">Deneme No</label></td>
						<td>
								<form:input type="text" path="denemeId" id="denemeId" value="${lastTaskMilestoneByUserId}" class="form-control input-sm" readonly="true" />
								<div class="has-error">
									<form:errors path="denemeId" class="help-inline"/>
								</div>
							</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="tytTurkce">TYT Türkçe</label>
						</td>
						<td>
							<form:input type="float" path="tytTurkce" id="tytTurkce" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="tytTurkce" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="tytMatematik">TYT Matematik</label>
						</td>
						<td>
							<form:input type="float" path="tytMatematik" id="tytMatematik" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="tytMatematik" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="tytFizik">TYT Fizik</label>
						</td>
						<td>
							<form:input type="float" path="tytFizik" id="tytFizik" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="tytFizik" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="tytKimya">TYT Kimya</label>
						</td>
						<td>
							<form:input type="float" path="tytKimya" id="tytKimya" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="tytKimya" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="tytBiyoloji">TYT Biyoloji</label>
						</td>
						<td>
							<form:input type="float" path="tytBiyoloji" id="tytBiyoloji" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="tytBiyoloji" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="tytTarih">TYT Tarih</label>
						</td>
						<td>
							<form:input type="float" path="tytTarih" id="tytTarih" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="tytTarih" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="tytCografya">TYT Coğrafya</label>
						</td>
						<td>
							<form:input type="float" path="tytCografya" id="tytCografya" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="tytCografya" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="tytFelsefe">TYT Felsefe</label>
						</td>
						<td>
							<form:input type="float" path="tytFelsefe" id="tytFelsefe" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="tytFelsefe" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="tytDin">TYT Din</label>
						</td>
						<td>
							<form:input type="float" path="tytDin" id="tytDin" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="tytDin" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="yksMatematik">YKS Matematik</label>
						</td>
						<td>
							<form:input type="float" path="yksMatematik" id="yksMatematik" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksMatematik" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="yksFizik">YKS Fizik</label>
						</td>
						<td>
							<form:input type="float" path="yksFizik" id="yksFizik" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksFizik" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="yksKimya">YKS Kimya</label>
						</td>
						<td>
							<form:input type="float" path="yksKimya" id="yksKimya" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksKimya" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="yksBiyoloji">YKS Biyoloji</label>
						</td>
						<td>
							<form:input type="float" path="yksBiyoloji" id="yksBiyoloji" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksBiyoloji" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="yksEdebiyat">YKS Edebiyat</label>
						</td>
						<td>
							<form:input type="float" path="yksEdebiyat" id="yksEdebiyat" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksEdebiyat" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="yksCografya1">YKS Coğrafya 1</label>
						</td>
						<td>
							<form:input type="float" path="yksCografya1" id="yksCografya1" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksCografya1" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="yksTarih1">YKS Tarih 1</label>
						</td>
						<td>
							<form:input type="float" path="yksTarih1" id="yksTarih1" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksTarih1" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="yksCografya2">YKS Coğrafya 2</label>
						</td>
						<td>
							<form:input type="float" path="yksCografya2" id="yksCografya2" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksCografya2" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="yksTarih2">YKS Tarih 2</label>
						</td>
						<td>
							<form:input type="float" path="yksTarih2" id="yksTarih2" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksTarih2" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="yksFelsefe">YKS Felsefe</label>
						</td>
						<td>
							<form:input type="float" path="yksFelsefe" id="yksFelsefe" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksFelsefe" class="help-inline"/>
							</div>
						</td>
					</tr>
					
					<tr>
						<td>
							<label style="font-size: 12px;" for="yksDin">YKS Din</label>
						</td>
						<td>
							<form:input type="float" path="yksDin" id="yksDin" onkeypress="return check(this,event);" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksDin" class="help-inline"/>
							</div>
						</td>
					</tr>
				</table>
				
				
				<%-- 
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-12 control-lable" for="yksFelsefe">YKS Felsefe</label>
						<div class="col-md-7">
							<form:input type="float" path="yksFelsefe" id="yksFelsefe" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksFelsefe" class="help-inline"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-12 control-lable" for="yksDin">YKS Din</label>
						<div class="col-md-7">
							<form:input type="float" path="yksDin" id="yksDin" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="yksDin" class="help-inline"/>
							</div>
						</div>
					</div>
				</div> --%>
				
				<div><!--  class="row" -->
					<div class="form-actions floatRight">
						<c:choose>
							<c:when test="${edit}">
								<a href="<c:url value='/listTaskMilestone' />">
									<input type="submit" value="Güncelle" class="btn btn-primary btn-sm"/>
								</a>
								<a href="<c:url value='/listTaskMilestone' />">
									<input type="button" value="İptal" class="btn btn-danger"/>
								</a>
							</c:when>
							<c:otherwise>
								<a href="<c:url value='/listTaskMilestone' />">
									<input type="submit" value="Kaydet" class="btn btn-primary btn-sm"/>
								</a>  
								<a href="<c:url value='/listTaskMilestone' />">
									<input type="button" value="İptal" class="btn btn-danger"/>
								</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</form:form>
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
  
  //replace comma by dot
function check(Sender,e){
	  var key = e.which ? e.which : event.keyCode;
	  if(key == 44){
	     if (document.selection) { //IE
	       var range = document.selection.createRange();
	           range.text = '.';
	     } else if (Sender.selectionStart || Sender.selectionStart == '0') { 
	      var start = Sender.selectionStart;
	      var end   = Sender.selectionEnd;
	      Sender.value = Sender.value.substring(0, start) + '.' +
	           Sender.value.substring(end, Sender.value.length);
	      Sender.selectionStart = start+1;
	      Sender.selectionEnd   = start+1;     
	     } else {
	      Sender.value += '.';
	     }
	     return false;
	   }
	}
</script>
</body>
</html>