<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<%@include file="head.jsp" %>

 <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  <script type="text/javascript">
        function setDatePickerDefaults() {
        	$.datepicker.regional['tr'] = {
       	   	    closeText: 'Seç', // set a close button text
       	   	    currentText: 'Bu Ay', // set this month text
       	   	    monthNames: ['Ocak','Şubat','Mart','Nisan','Mayıs','Haziran','Temmuz','Ağustos','Eylül','Ekim','Kasım','Aralık'], // set month names
       	   	    monthNamesShort: ['Oca','Şub','Mar','Nis','May','Haz','Tem','Ağu','Eyl','Eki','Kas','Ara'], // set short month names
       	   	    dayNames: ['Pazartesi','Salı&#236','Çarşamba&#236','Perşembe&#236','Cuma&#236','Cumartesi&#236','Pazar'], // set days names
       	   	    dayNamesShort: ['Ptesi','Salı','Çarş','Perş','Cuma','Ctesi','Paz'], // set short day names
       	   	    dayNamesMin: ['Pzt','Sal','Çar','Per','Cum','Cmt','Paz'], // set more short days names
       	   	    dateFormat: 'dd/mm/yy' // set format date
       	   	};

       	   	$.datepicker.setDefaults($.datepicker.regional['tr']);
        }
        window.onload = setDatePickerDefaults;
        </script>
  <script>
  
  var monthNamesDisplay = ['Ocak','Şubat','Mart','Nisan','Mayıs','Haziran','Temmuz','Ağustos','Eylül','Ekim','Kasım','Aralık'];
  
 $(function() {

   	$( "#datepicker" ).datepicker( {
        onSelect: function(dateText, inst) { 
            var date = $(this).datepicker('getDate');
            
            /* $("#daySpanText").text($("#datepicker").datepicker('getDate').getDate());
           	$("#monthSpanText").text(monthNamesDisplay[$("#datepicker").datepicker('getDate').getMonth()]); */
           	$("#monthDaySpanText").text($("#datepicker").datepicker('getDate').getDate() +" "+ monthNamesDisplay[$("#datepicker").datepicker('getDate').getMonth()]);
           	$("#yearSpanText").text($("#datepicker").datepicker('getDate').getFullYear());
           	
           	
           	/* Task List */
           	/* var fullUrl = window.location.href;
		    var arr = fullUrl.split("/");
		    var domain = arr[2].split(":")[0];
		    
		    if (domain === "localhost" ) {
		    	var urltaskPlanList = "/SpringMVCHibernateWithSpringSecurityExample/taskPlanListJoined/";
		    } else
		    {
		    	var urltaskPlanList = "/taskPlanListJoined/";
		    }
		    
		    alert("here");
		    //{startDate}-{endDate}
		    alert(date);
		    //var searchDates = $("#datepicker").val();
		    var searchDates = date;
		    alert(searchDates);
		    
		    $.ajax({
		        type: 'GET',
		        url: urltaskPlanList + searchDates +"-"+ searchDates,
		        success: function(data){
		            
		            ///////////////////taskPlanList yazıldı controller da 
		            var planList=$('#divPlanList'), plan="";
		            planList.empty();
		
		            for(var i=0; i<data.length; i++)
		            {
		            	plan = plan + "<tr>";
		            	plan = plan + "<div class=\"user-thumb\"> <img width=\"40\" height=\"40\" alt=\"User\" src=\"img/demo/av1.jpg\"> </div>";
		            	plan = plan + "<div class=\"article-post\">";
			            plan = plan + "<div class=\"fr\">"; // alt satırda onclick parametresi var 
			            plan = plan + "<input type=\"button\" value=\"Detay\" onclick=\"setDetailValues(" + ${taskInfo[2]} + ")\" class=\"btn btn-primary btn-mini\"/>";
			            plan = plan + "<input type=\"button\" value=\"Bitti\" class=\"btn btn-success btn-mini\"/>";
			            plan = plan + "</div>";
			            plan = plan + "<span style=\"font-weight: bold;\" class=\"user-info\" id=" + ${taskInfo[0]} - ${taskInfo[1]} + "> " + ${taskInfo[0]} - ${taskInfo[1]} + " </span>";
			            plan = plan + "<br><br><br>";
			            plan = plan + "<p>" + Bşl Tarih - Btş Tarih + "</span>";
			            plan = plan + "<p>" + "Açıklama" + "</p>";
			            plan = plan + "<p hidden>" + "Detay Açıklama" + "</p>";
			            plan = plan + "<p hidden>" + "Statü" + "</p>";
			            plan = plan + "<input id=" + ${taskInfo[2]} + " type=\"hidden\" value=" + Başlangıç-Tarih_Bitiş-Tarih_Test-Açıklama_Test-Detay-Açıklama + "></input>";
			            plan = plan + "</div>"; 
			            plan = plan + "oguzhan";
			            plan = plan + "</tr>";
		            }
		            planList.append(plan);
		        },
		        error:function(){
		            alert("error : " + i);
		        }
		        
		    });  */
           	/* Task List End */
            
        }
    });
   	
 });
 
 $(document).ready(function() {
	 $("#startDate").datepicker({
		 onSelect: function(dateText, inst) {
			 var startDate = $(this).datepicker('getDate'); 
			 /* document.getElementById("startDate").value = startDate.getDate() +"/"+ startDate.getMonth() +"/"+ startDate.getFullYear(); */
			 document.getElementById("startDate").value = startDate;//.format('dd/mm/yyyy');
		 }
	 });
 });
 
 $(document).ready(function() {
	 $("#endDate").datepicker({
		 onSelect: function(dateText, inst) {
			 var endDate = $(this).datepicker('getDate');
			 /* document.getElementById("endDate").value = endDate.getDate() +"/"+ endDate.getMonth() +"/"+ endDate.getFullYear(); */
			 document.getElementById("endDate").value = endDate;//.format('dd/mm/yyyy');
		 }
	 });
 });

 $(document).ready(function() {
		/* $("#daySpanText").text((new Date()).getDate());
		$("#monthSpanText").text(monthNamesDisplay[(new Date()).getMonth()]); */
		$("#monthDaySpanText").text((new Date()).getDate() +" "+ monthNamesDisplay[(new Date()).getMonth()]);
		$("#yearSpanText").text((new Date()).getFullYear());
	 });


 $(document).ready(function() {
    var startDate;
    var endDate;

    var selectCurrentWeek = function() {
        window.setTimeout(function () {
            $('.weekPicker').find('.ui-datepicker-current-day a').addClass('ui-state-active')
        }, 1);
    }

    $('.weekPicker').datepicker( {
        showOtherMonths: true,
        selectOtherMonths: true,
        onSelect: function(dateText, inst) { 
            var date = $(this).datepicker('getDate');
            startDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay());
            endDate = new Date(date.getFullYear(), date.getMonth(), date.getDate() - date.getDay() + 6);
            var dateFormat = inst.settings.dateFormat || $.datepicker._defaults.dateFormat;
			/* document.getElementById("weekPickerId").value = $.datepicker.formatDate( dateFormat, startDate, inst.settings ) +' - '+ $.datepicker.formatDate( dateFormat, endDate, inst.settings ); */
			document.getElementById("weekPickerId").value = startDate.getDate() + ' ' + monthNamesDisplay[startDate.getMonth()] +' - '+ endDate.getDate() + ' ' + monthNamesDisplay[endDate.getMonth()]; 
			
			$("#monthDaySpanText").text(startDate.getDate() + ' ' + monthNamesDisplay[startDate.getMonth()] +' - '+ endDate.getDate() + ' ' + monthNamesDisplay[endDate.getMonth()] );
           	$("#yearSpanText").text(date.getFullYear());
			
            selectCurrentWeek();
        },
        beforeShowDay: function(date) {
            var cssClass = '';
            if(date >= startDate && date <= endDate)
                cssClass = 'ui-datepicker-current-day';
            return [true, cssClass];
        },
        onChangeMonthYear: function(year, month, inst) {
            selectCurrentWeek();
        }
    });

    $('.weekPicker .ui-datepicker-calendar tr').live('mousemove', function() { $(this).find('td a').addClass('ui-state-hover'); });
    $('.weekPicker .ui-datepicker-calendar tr').live('mouseleave', function() { $(this).find('td a').removeClass('ui-state-hover'); });
});


$(document).ready(function()
	{   
	    $(".monthPicker").datepicker({
	        dateFormat: 'MM yy',
	        changeMonth: true,
	        changeYear: true,
	        showButtonPanel: true,
	
	        onClose: function(dateText, inst) {
	            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
	            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
	            $(this).val($.datepicker.formatDate('MM yy', new Date(year, month, 1)));
	            
	            $("#monthDaySpanText").text(monthNamesDisplay[month]);
	           	$("#yearSpanText").text(year);
	        }
	    });
	
	    $(".monthPicker").focus(function () {
	        $(".ui-datepicker-calendar").hide();
	        $("#ui-datepicker-div").position({
	            my: "center top",
	            at: "center bottom",
	            of: $(this)
	        });
	    });
	}); 


</script>


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
    <li class="active"><a href="taskPlan"><i class="icon icon-asterisk"></i> <span>Planım</span></a> </li>
    <li><a href="calculateScore"><i class="icon icon-asterisk"></i> <span>Puan Hesaplama</span></a> </li>
  </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="dashboard" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Ana Sayfa</a></div>
  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
  <div class="container-fluid">
  
  	<div class="row-fluid">
      <div class="span3">
      	
      	<label>Günlük Plan: </label>
		<input type="text" id="datepicker" />
	
	    <label>Haftalık Plan:</label> 
	    <input type="text" class="weekPicker" id="weekPickerId" />
	    <!-- <div class="weekPicker"></div> -->
	   
		<label>Aylık Plan: </label>
		<input type="text" class="monthPicker" /> 
		
      </div>
      <div class="span9">
	      <div class="span6">
	      
	      	<div class="widget-content">
	            <ul class="quick-actions">
	              <li class="bg_lb"> 
	              <!-- <h2 style="color: white;"><span id="monthSpanText">  </span> <span id="  ">  </span> <span id="daySpanText">  </span></h2> --> 
	              <!-- <h1 style="color: white;"><span id="daySpanText">  </span></h1>  -->
	              <h2 style="color: white;"> <span id="monthDaySpanText"> </span> </h2>
	              <h2 style="color: white;"><span id="yearSpanText">  </span></h2> 
	              </li>
	            </ul>
	        </div>
	        
	        <div class="widget-box">
	          <div class="widget-title"> <span class="icon"> <i class="icon-file"></i> </span>
	            <h5>Plan</h5>
	          </div>
	        <!-- günlük haftalık aylık plan için tablo -->
	        <div class="widget-title">
	            <ul class="nav nav-tabs">
	              <li class="active"><a data-toggle="tab" href="#tab1">PLAN - Tarih eklenecek</a></li>
	            </ul>
	          </div>
	          <div class="widget-content tab-content">
	            <div id="tab1" class="tab-pane active">
	              <div class="panel panel-default">
						<!-- Default panel contents -->
						<div class="panel-heading">
							<!-- <span class="lead">List of TaskInfos </span> -->
						</div>
						
						<table class="table table-hover">
						<tbody>
							<!-- <div id="divPlanList"></div> -->
						
							<c:forEach items="${taskPlanListJoined}" var="taskInfo">
								<tr>
									<div class="user-thumb"> <img width="40" height="40" alt="User" src="img/demo/av1.jpg"> </div>
					                <div class="article-post">
					                  <div class="fr">
					                  	  <!-- setDetailValues parametresi findAllTaskPlanJoined dan gelen id --> 
						                  <input type="button" value="Detay" onclick="setDetailValues(${taskInfo[2]})" class="btn btn-primary btn-mini"/>
						                  <input type="button" value="Bitti" class="btn btn-success btn-mini"/>
						                  <!-- <a class="btn btn-primary btn-mini" href="#">Güncelle</a>
						                  <a class="btn btn-success btn-mini" href="#">Bitti</a> -->
					                  </div>  
					                  <span style="font-weight: bold;" class="user-info" id="${taskInfo[0]} - ${taskInfo[1]}"> ${taskInfo[0]} - ${taskInfo[1]} </span> 
					                  <br><br><br>
					                  <p>Bşl Tarih - Btş Tarih</span>
					                  <p>Açıklama</p>
					                  <p hidden>Detay Açıklama</p>
					                  <p hidden>Statü</p>
					                  <input id="${taskInfo[2]}" type="hidden" value="Başlangıç-Tarih_Bitiş-Tarih_Test-Açıklama_Test-Detay-Açıklama"></input>
					                </div>
								</tr>
							</c:forEach>
							
						</tbody>
					</table>
					</div>
					<div class="well">
						<a href="<c:url value='/taskPlan' />">
							<input type="button" value="Yeni Plan Ekle" class="btn btn-success"/>
						</a>
					</div>
				
	            </div>
	
	          </div>
	          <!-- günlük haftalık aylık plan için tablo -->
	        </div>
	      
	      </div>
	      <div class="span6">
	      
	      	<div class="widget-box">
	          <div class="widget-title"> <span class="icon"> <i class="icon-file"></i> </span>
	            <h5>Detay</h5>
	          </div>
	          
	          <form:form method="POST" modelAttribute="taskPlan" class="form-horizontal">
	          
		          <div class="widget-content nopadding">
		            <ul class="recent-posts">
		              <li>
		                <div class="user-thumb"> <img width="40" height="40" alt="User" src="img/demo/av1.jpg"> </div>
		                <div class="article-post">
		                  <div class="fr">
			                  <input style="display:inline-block"  type="button" value="Güncelle" onclick="setValuesUpdatable()" id="selectedEditable" class="btn btn-primary btn-mini"/>
			                  <input style="display:none"  type="submit" value="Güncelle" id="selectedUpdate" class="btn btn-primary btn-mini"/>
			                  <input type="button" value="Bitti" id="SelectedComplete" class="btn btn-success btn-mini"/>
			                  <!-- <a class="btn btn-primary btn-mini" href="#">Güncelle</a>
			                  <a class="btn btn-success btn-mini" href="#">Bitti</a> -->
		                  </div>
		                  <!-- <span path="taskId" id="taskId" value="2" style="font-weight: bold;" class="user-info" ></span> - 
		                  <span path="taskDetailId" id="taskDetailId" value="2" style="font-weight: bold;" class="user-info"></span> -->
		                  <%-- <form:label path="taskId" id="taskId" value="2" style="font-weight: bold;" class="user-info"/> - 
		                  <form:label path="taskDetailId" id="taskDetailId" value="2" style="font-weight: bold;" class="user-info"/> --%>
		                  <form:input style="width:20%;" readonly="true" type="text" path="taskId" id="taskId" value="2" class="form-control input-sm" /> - 
		                  <form:input style="width:20%;" readonly="true" type="text" path="taskDetailId" id="taskDetailId" value="2" class="form-control input-sm" />
		                  <br><br><br>
		                  
		                  <!-- Values as Inputs Start -->
		                  <div id="divForSubmit" style="display: none;">
			                  <span class="user-info">Başlangış Bitiş Tarihleri</span>
			                  <br>
			                  <form:input style="width:40%;" type="text" path="startDate" id="startDate" class="form-control input-sm" /> - 
			                  <form:input style="width:40%;" type="text" path="endDate" id="endDate" class="form-control input-sm" />
			                  <br>
			                  <span class="user-info">Açıklama</span>
			                  <br>
			                  <form:textarea path="description" id="description" rows="3" cols="12" class="form-control input-sm" />
			                  <br>
			                  <span class="user-info">Detay Bilgiler</span>
			                  <br>
			                  <form:textarea path="descriptionDetail" id="descriptionDetail" rows="3" cols="12" class="form-control input-sm" />
			                  <br>
			                  <span class="user-info">Statüsü</span>
			                  <br>
			                  <form:select path="status" id="status">
			                  	<%-- <form:option selected="selected" value="0">Seçiniz</form:option> --%>
		                  		<form:option value="1">Tamamlandı</form:option>
				                <form:option value="2">Tamamlanmadı</form:option>
			                  </form:select>
		                  </div>
		                  <!-- Values as Inputs End -->
		                  
		                  <!-- Values as Labels Start -->
		                  <div id="divForDisplay" style="display: block;">
			                  <p id="startAndEndDateText"> Bşl Tarih - Btş Tarih </p>
			                  <p id="descriptionText">Açıklama</p>
			                  <p id="descriptionDetailText">Detay Açıklama</p>
			                  <p id="statusText">Statü</p>
		                  </div> 
		                  <!-- Values as Labels End -->
		                  
		                  <form:input type="hidden" path="id" id="id" value="1"/>
		                  <form:input type="hidden" path="ssoId" id="ssoId" value="${loggedinuser}"/>
		                  <form:input type="hidden" path="taskSelfStudy" id="taskSelfStudy" value="false"/>
		                  <form:input type="hidden" path="taskBeenStudied" id="taskBeenStudied" value="false"/>
		                  
		                </div>
		              </li>
		            </ul>
		          </div>
	          </form:form>
	          
	        </div>
	      
	      </div>
      	
	      	
        
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
  
  function setDetailValues(id){
	  
	  var array = document.getElementById(id).value.split("_");
	  
	  document.getElementById("divForDisplay").style.display="block";
	  document.getElementById("divForSubmit").style.display="none";
	  
	  document.getElementById('selectedEditable').style.display="inline-block";
	  document.getElementById('selectedUpdate').style.display="none";
	  /*TODO:ogz Hardcoded testlerden sonra id set edilecek */
	  /* document.getElementById('selectedId').innetHTML = id; */
	  document.getElementById("startAndEndDateText").innerHTML = array[0] + " - " + array[1];
	  document.getElementById("descriptionText").innerHTML = array[2];
	  document.getElementById("descriptionDetailText").innerHTML = array[3];
	  
  }
  
  function setValuesUpdatable()
  {
	  document.getElementById("divForDisplay").style.display="none";
	  document.getElementById("divForSubmit").style.display="block";
	  
	  document.getElementById('selectedEditable').style.display="none";
	  document.getElementById('selectedUpdate').style.display="inline-block";
	  /* document.getElementById("startDate").valueAsDate = new Date();
	  document.getElementById("endDate").valueAsDate = new Date(); */
	  document.getElementById("description").value = "Description Test";
	  document.getElementById("descriptionDetail").value = "Description Detail Test";
  
  }
  
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
  
$(function() {

	  // page is now ready, initialize the calendar...

	  $('#calendar').fullCalendar({
	    // put your options and callbacks here
	  })

	});
</script>
</body>
</html>