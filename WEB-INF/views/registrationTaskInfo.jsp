<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <li class="active"><a href="newTaskInfo" ><i class="icon icon-book"></i> <span>Ders Ekle</span></a> </li>
    <li><a href="listTaskInfo"><i class="icon icon-list"></i> <span>Çalışılan Ders Listesi</span></a> </li>
    <li><a href="newTaskMilestone" ><i class="icon icon-book"></i> <span>Deneme Ekle</span></a> </li>
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
    <div id="breadcrumb"> <a href="newTaskInfo" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Ders Ekle</a></div>
  </div>
<!--End-breadcrumbs-->

  <div class="container-fluid">

	<!-- New Task Milestone -->
	<div>

		<div class="widget-box">
	        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
	          <h5>Çalışılan Ders Ekleme</h5>
	        </div>
        	
        	<form:form method="POST" modelAttribute="taskInfo" class="form-horizontal">
			 	
			 	<form:input type="hidden" path="taskInfoId" id="taskInfoId"/>
			 	<form:input type="hidden" path="ssoId" id="ssoId" value="${loggedinuser}"/>
				
				<table class="form-horizontal">
						<form:input type="hidden" path="taskId" id="taskId"/>
						<tr>
							<td><label style="font-size: 12px;" for="taskId">Ders Adı</label></td>
							<td>
								<select class="form-control" id="selectTaskListDD"> 
									<option value="-1">-Select-</option>
									<c:forEach items="${taskListDD}" var="tasks">
			                            <option value="${tasks.key}">${tasks.value}</option>
			                        </c:forEach> 
								</select>
								<div class="has-error">
									<form:errors path="taskId" class="help-inline"/>
								</div>
							</td>
						</tr>
						
						<script>
							$("#selectTaskListDD").change(function(){
							    var taskId = $("#selectTaskListDD").val();
							    
							    var fullUrl = window.location.href;
							    var arr = fullUrl.split("/");
							    var domain = arr[2].split(":")[0];
							    
							    if (domain === "localhost" ) {
							    	var urlTaskDetailListDD = "/SpringMVCHibernateWithSpringSecurityExample/taskDetailListDD/";
							    } else
							    {
							    	var urlTaskDetailListDD = "/DTS/taskDetailListDD/";
							    }
							    
							    $.ajax({
							        type: 'GET',
							        url: urlTaskDetailListDD + taskId,
							        success: function(data){
							            var slctTaskDetailDD=$('#selectTaskDetailDD'), option="";
							            slctTaskDetailDD.empty();
							
							            option = option + "<option value='-1'>-Select-</option>";
							            for(var i=0; i<data.length; i++){
							            	option = option + "<option value='"+data[i].taskDetailId + "'>"+data[i].taskDetailName + "</option>";
							            }
							            slctTaskDetailDD.append(option);
							        },
							        error:function(){
							            alert("error : " + i);
							        }
							        
							    });
							    document.getElementById("taskId").value = taskId;
							});
							
						</script>
						
						<form:input type="hidden" path="taskDetailId" id="taskDetailId"/>
						<td>
							<td><label style="font-size: 12px;" for="taskDetailId">Konu Adı</label></td>
							<td>
								<select class="form-control" id="selectTaskDetailDD" >
							       <option value="-1">-Select-</option> 
							    </select>
							    <div class="has-error">
									<form:errors path="taskDetailId" class="help-inline"/>
								</div>
							</td>
						</tr>
						
						<script>
						$("#selectTaskDetailDD").change(function(){
						    var taskDetailId = $("#selectTaskDetailDD").val();
						    document.getElementById("taskDetailId").value = taskDetailId;
						});
						</script>
						
						<tr>
							<td><label style="font-size: 12px;" for="taskSelfStudy">Kendim Konu Çalıştım</label></td>
							<td>
								<%-- <form:input type="boolean" path="taskSelfStudy" id="taskSelfStudy" class="form-control input-sm" /> --%>
								<form:checkbox path="taskSelfStudy" id="taskSelfStudy" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="taskSelfStudy" class="help-inline"/>
								</div>
							</td>
						</tr>
						
						<tr>
							<td><label style="font-size: 12px;" for="taskSelfStudyDesc">Konu Çalıştım Açıklama</label></td>
							<td>
								<form:input type="text" path="taskSelfStudyDesc" id="taskSelfStudyDesc" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="taskSelfStudyDesc" class="help-inline"/>
								</div>
							</td>
						</tr>
						
						<tr>
							<td><label style="font-size: 12px;" for="taskBeenStudied">Konu Anlatıldı</label></td>
							<td>
								<%-- <form:input type="boolean" path="taskBeenStudied" id="taskBeenStudied" class="form-control input-sm" /> --%>
								<form:checkbox path="taskBeenStudied" id="taskBeenStudied" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="taskBeenStudied" class="help-inline"/>
								</div>
							</td>
						</tr>
						
						<tr>
							<td><label style="font-size: 12px;" for="taskBeenStudiedDesc">Konu Anlatıldı Açıklama</label></td>
							<td>
								<form:input type="text" path="taskBeenStudiedDesc" id="taskBeenStudiedDesc" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="taskBeenStudiedDesc" class="help-inline"/>
								</div>
							</td>
						</tr>
						
						<tr>
							<td><label style="font-size: 12px;" for="taskPracticeQuestionNum">Çözülen Soru Sayısı</label></td>
							<td>
								<form:input type="integer" path="taskPracticeQuestionNum" id="taskPracticeQuestionNum" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="taskPracticeQuestionNum" class="help-inline"/>
								</div>
							</td>
						</tr>
						
						<tr>
							<td><label style="font-size: 12px;" for="taskPracticeRightNum">Doğru Sayısı</label></td>
							<td>
								<form:input type="integer" path="taskPracticeRightNum" id="taskPracticeRightNum" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="taskPracticeRightNum" class="help-inline"/>
								</div>
							</td>
						</tr>
						
						<tr>
							<td><label style="font-size: 12px;" for="taskPracticeWrongNum">Yanlış Sayısı</label></td>
							<td>
								<form:input type="integer" path="taskPracticeWrongNum" id="taskPracticeWrongNum" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="taskPracticeWrongNum" class="help-inline"/>
								</div>
							</td>
						</tr>
						
						<tr>
							<td><label style="font-size: 12px;" for="taskPracticeDuration">Test Süresi</label></td>
							<td>
								<form:input type="integer" path="taskPracticeDuration" id="taskPracticeDuration" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="taskPracticeDuration" class="help-inline"/>
								</div>
							</td>
						</tr>
				</table>
				
				<div>
					<div class="form-actions floatRight">
						<c:choose>
							<c:when test="${edit}">
								<input type="submit" value="Güncelle" class="btn btn-primary btn-sm"/>
								<a href="<c:url value='/listTaskInfo' />">
									<input type="button" value="İptal" class="btn btn-danger"/>
								</a>
							</c:when>
							<c:otherwise>
								<input id="nonstikysuccessfulsave" type="submit" value="Kaydet" class="btn btn-primary btn-sm"/>  
								<a href="<c:url value='/listTaskInfo' />">
									<input type="button" value="İptal" class="btn btn-danger"/>
								</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				
			</form:form>
		
		</div>
		
		<div class="widget-box">

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