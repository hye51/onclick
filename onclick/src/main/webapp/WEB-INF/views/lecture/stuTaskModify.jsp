<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.onclick.app.domain.*" %>
<%@ page import="java.util.ArrayList" %>
<%ArrayList<EnrollDTO> stuLecList = (ArrayList<EnrollDTO>)request.getAttribute("stuLecList"); %>  
<%TaskVO tv = (TaskVO)session.getAttribute("tv"); %>
<%LecVO lv = (LecVO)session.getAttribute("lv"); %>
<%S_taskDTO std = (S_taskDTO)session.getAttribute("std"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>ONclick Main</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="<%=request.getContextPath() %>/resources/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="<%=request.getContextPath()%>/">
           	<img alt="" src="<%=request.getContextPath() %>/resources/assets/img/ex.png" id="logo">
            | ONclick 
            <span class="fs-6">online non-contact system</span>
            </a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn order-lg-1" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
 			 <div class="row">
	            <div class="dropdown col-md-9">
				 <button class="btn btn-secondary dropdown-toggle" type="button" id="select" data-bs-toggle="dropdown" aria-expanded="false">
				 ?????? ??????
				 </button>   
					 <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						 <% for(EnrollDTO ed : stuLecList) { %>
						 <li> <a class="nav-link" href="<%=request.getContextPath()%>/lecHome.do?lidx=<%=ed.getLidx()%>"><%=ed.getLname() %></a></li>
	                     <% } %>
                     </ul>
				  </div>	               
	          </div>
            </form>
            <!-- heyri1019 alarm -->
          	<!-- Nav Item - Alerts -->
          	<div class="dropdown">
				<a id="alarm" class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
				    <i class="fas fa-bell fa-fw"></i>
				    <!-- Counter - Alerts -->
				    <span class="badge badge-danger badge-counter">+</span>
				</a>
				<!-- Dropdown - Alerts -->
				<ul  class="dropdown-menu" aria-labelledby="dropdownMenuLink">
				<h6 class="dropdown-header">Alerts</h6>
				<!-- ?????? ?????? ?????? -->
					<li id ="alarmList">
					
					</li>	
				</ul>     
			</div>
            <!-- Navbar-->
		      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
				<li class="nav-item">				
					<a class="nav-link" href="<%=request.getContextPath()%>/student/pwdCheck.do">Mypage</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<%=request.getContextPath()%>/siteMap.do">????????????</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<%=request.getContextPath()%>/logout.do">LogOut</a>
				</li>
		      </ul> 			     
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                     <div class="sb-sidenav-menu">
						<div class="nav-link collapsed">
							<a style="color:white; text-decoration:none;" href="<%=request.getContextPath()%>/lecHome.do?lidx=<%=lv.getLidx()%>">
							<%=lv.getLname() %>
							<img alt="" src="<%=request.getContextPath() %>/resources/assets/img/home.png"></a>
						</div>
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading"></div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLecInfo" aria-expanded="false" aria-controls="collapseLecInfo">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	????????????
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLecInfo" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="layout-static.html">???????????????</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/professor/proInfo.do?pidx=<%=lv.getPidx()%>">?????? ?????? ??????</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/stuList.do?lidx=<%=lv.getLidx()%>">?????? ??????</a>
                                </nav>
                            </div>
                          	<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseAttend" aria-expanded="false" aria-controls="collapseAttend">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	????????????
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                                <div class="collapse" id="collapseAttend" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/stuVideoAttend.do?lidx=<%=lv.getLidx()%>">????????? ?????? ??????</a>
                                </nav>
                            	</div>
                           	<a class="nav-link" href="<%=request.getContextPath()%>/stuLecList.do?lidx=<%=lv.getLidx()%>">
                           	<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	?????? ??????
                                <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<a class="nav-link" href="<%=request.getContextPath()%>/taskList.do?lidx=<%=lv.getLidx()%>">
                               <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                               		??????
                               <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<a class="nav-link " href="<%=request.getContextPath()%>/refList.do?lidx=<%=lv.getLidx()%>">
                              <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                              		??????
                              <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                             <a class="nav-link collapsed" href="<%=request.getContextPath()%>/noticeList.do?lidx=<%=lv.getLidx()%>">
                              <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                              		????????????
                              <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
            <!-- ?????? ?????? ??????-->
            <div id="layoutSidenav_content">
	            <h3 class="mt-4 pt-3 ps-5" style="font-weight:bold">?????? ?????? ??????</h3>
                	<ol class="breadcrumb mb-4 ps-5">
                    	<li class="breadcrumb-item active"><%=std.getTsubject()%></li>
                	</ol>
            	<main> 
            		<div class="container-fluid px-4 ">
            		<form name="frm">
						<table class="table mx-auto bg-light" style="width:80%">   
							<thead>    
								<tr>			      
							      	<td colspan="4" scope="row" style="border:0;"><input class="form-control" type="text" name="s_taskSubject" style="border:0; black; width:100%" value="<%=std.getTsubject()%>"></td>
							    </tr>
							</thead>
							<tbody>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">????????????</td>
							      	<td colspan="3" style="border-bottom:0; width:90%">
							      		<%=tv.getTustart().substring(0, 10) %> ~ <%=tv.getTufin().substring(0, 10) %>
									</td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">?????? ??????</td>
							      	<td colspan="3" style="border-bottom:0; width:90%">
							      	<%if(session.getAttribute("fv") == null){ %>
							      		<input class="form-control"  name="s_taskFile" type="file"/> 
							      		<%} else { 
							      			FileVO fv = (FileVO)session.getAttribute("fv"); %>
							      		<input class="form-control" name="s_taskFile" id="stuTaskFile" type="file" disabled/>
							      		<%} %>
							      	</td>
							    </tr>
							    <%if(session.getAttribute("fv") != null) {
							    	FileVO fv = (FileVO)session.getAttribute("fv"); %>
								    <tr class="exFile">
								    	<td scope="row" style="border-bottom:0; text-align:left; width:10%"></td>
								    	<td colspan="2" style="border-bottom:0; width:80%;"><a href="<%=request.getContextPath()%>/taskFileDownload.do?fidx=<%=fv.getFidx()%>"><%=fv.getForiginname() %></a></td>
								    	<td style="border-bottom:0; text-align:right; width:10%"><button type="button" id="stuTaskFileDel" class="btn btn-sm">X</button></td>
								    </tr>
							    <%} %>
							    <tr>
							    	<td colspan="4" style="border-bottom:0"><input type="text" name="s_taskContents" style="width:100%; height:300px; border:0; solid; black" value="<%=std.getTcontents()%>"></td>
							    </tr>
							</tbody>
						</table>
						<div class="form-row text-center mb-2">
							<button type="button" class="btn btn-secondary btn-sm" style="width:80px" onclick="history.back(-1)">??????</button>
							<button type="button" class="btn btn-secondary btn-sm" style="width:80px" onclick="check(); return false;">??????</button>
                    	</div>
                    </form>
                	</div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2021</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath() %>/resources/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath() %>/resources/assets/demo/chart-area-demo.js"></script>
        <script src="<%=request.getContextPath() %>/resources/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath() %>/resources/js/datatables-simple-demo.js"></script>
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script>
        $(function(){
        	
        	
	        $('#stuTaskFileDel').click(function(){
	        	
				<% int fidx = 0;
					if(session.getAttribute("fv") != null){
	        		FileVO fv = (FileVO)session.getAttribute("fv"); 
	        		fidx = fv.getFidx();
	        	}%>
	        	
				var fidx = <%=fidx%>;
				var tidx = <%=std.getTidx()%>;
				
					$.ajax({
						url:'<%=request.getContextPath()%>/stuExFileDelete.do',
						data: {"fidx":fidx,
							   "tidx":tidx},
						dataType:'JSON',
						type:'POST',
						error: function(){
							alert("???????????????."); },
						success:function(data){
							if(data.value == 2) {
								$('.exFile').css("display", "none");
								alert("?????????????????????.");
								$("#stuTaskFile").attr("disabled",false);
							} else {
								alert("????????? ???????????? ???????????????.");
							}
						}
					});
	        	});
	    });
        
			function check() {
			
				var fm= document.frm;
				
				
				fm.action="<%=request.getContextPath()%>/stuTaskModifyAction.do?tidx=<%=std.getTidx()%>";
				fm.method = "post";
				fm.enctype="multipart/form-data";
				fm.submit();
				
			}
		</script>
        <script type="text/javascript">
        //??????????????? ????????? ?????? 
        function checkClass(nidx,sidx,cidx){
        	//?????? ?????????
        	 $.ajax({
	        		url:"<%=request.getContextPath()%>/alarmUpdate.do",
	        		type:'post',
	        		dataType : "json",
	        		data:{"nidx" : nidx},
	        		success:function(cnt){
        				location.href="<%=request.getContextPath()%>/stuLecContent.do?sidx="+sidx+"&cidx="+cidx;
	        		},
	        		error:function(){
	        			alert("???????????????.(update1)");
	        		}
	        	});
        }
     
        function checkTask(nidx,lidx,tuidx){
        	//?????? ?????????
       	 $.ajax({
	        		url:"<%=request.getContextPath()%>/alarmUpdate.do",
	        		type:'post',
	        		dataType : "json",
	        		data:{"nidx" : nidx},
	        		success:function(cnt){
	        			 location.href="<%=request.getContextPath()%>/taskContent.do?tuidx="+tuidx+"&lidx="+lidx;
	        		},
	        		error:function(){
	        			alert("???????????????.(update2)");
	        		}
	        	});
       }
       
       function checkLec(nidx,lnidx){
       		//???????????? ?????????
      	 $.ajax({
	        		url:"<%=request.getContextPath()%>/alarmUpdate.do",
	        		type:'post',
	        		dataType : "json",
	        		data:{"nidx" : nidx},
	        		success:function(cnt){
	        			location.href="<%=request.getContextPath()%>/lecNoticeContent.do?lnidx="+lnidx;
	        		},
	        		error:function(){
	        			alert("???????????????.(update3)");
	        		}
	        	});
      }
      
         $('#alarm').click(function(){
	        var sidx = <%=session.getAttribute("sidx")%>;
	        var str;
			var tstr="";
			
	         $.ajax({
	 			type : "GET",
	 			url : "<%=request.getContextPath() %>/alarmSelect.do",
	 			dataType : "json",
	 			data : { "sidx" : sidx 
	 					},
	 			cache : false,
	 			error : function(){
	 				alert("error ????????? :");
	 			},
	 			success : function(data){
	 						if(data.length == 0){
	 							alert("????????? ???????????? ????????????");
	 						}else {
	 							$.each (data, function (index, nv) {
	 							
	 								if(nv.cidx!=0){
										//????????? ??????
	 								str="<a name='alarmCheck'class='dropdown-item d-flex align-items-center list-group-item-action list-group-item' onclick='checkClass("+nv.nidx+","+nv.sidx+","+nv.cidx+"); return false;'>"
	 										+"<div class='mr-3'>"
	 				                       +"<div class='icon-circle bg-primary'>"
	 				                       +"<i class=''bi bi-camera-reels-fill text-white '></i>"
	 				                       +"<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-camera-reels-fill text-white' viewBox='0 0 16 16'>"
				                    	   +"<path d='M6 3a3 3 0 1 1-6 0 3 3 0 0 1 6 0z'/>"
				                    	   +"<path d='M9 6a3 3 0 1 1 0-6 3 3 0 0 1 0 6z'/>"
				                    	   +"<path d='M9 6h.5a2 2 0 0 1 1.983 1.738l3.11-1.382A1 1 0 0 1 16 7.269v7.462a1 1 0 0 1-1.406.913l-3.111-1.382A2 2 0 0 1 9.5 16H2a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h7z'/>"
				                    	   +"</svg>"
	 				                       +" </div>"
	 			                    	+"</div>"
	 									+"<div>"
	 			                    	+"<div class='small text-gray-500'>??????";
	 			                    	if(nv.ncheck=="N"){
	 			                    		str=str +"<span style='float:right;'>?????????</span>";
	 			                    	}else{
	 			                    		str=str +"<span style='float:right;'>??????</span>";
	 			                    	}
	 			                    	str=str  +"</div>"
	 								    +"<span class='font-weight-bold'>"+nv.ncontents+"</span>"
	 		                    		+"</div>"
	 		                			+"</a>";
	 								tstr = tstr+str;
									}else if(nv.tuidx!=0){
									//????????? ??????
										str="<a name='alarmCheck'class='dropdown-item d-flex align-items-center list-group-item-action list-group-item' onclick='checkTask("+nv.nidx+","+nv.lidx+","+nv.tuidx+"); return false;'>"
											+"<div class='mr-3'>"
		 				                       +" <div class='icon-circle bg-success'>"
		 				                         +"  <i class='fas fa-file-alt text-white'></i>"
		 				                       +" </div>"
		 			                    	+"</div>"
		 									+"<div>"
		 			                    	+"<div class='small text-gray-500'>??????"
		 			                    	if(nv.ncheck=="N"){
		 			                    		str=str +"<span style='float:right;'>?????????</span>";
		 			                    	}else{
		 			                    		str=str +"<span style='float:right;'>??????</span>";
		 			                    	}
		 			                    	str=str  +"</div>"
		 									+"<span class='font-weight-bold'>"+nv.ncontents+"</span>"
		 		                    		+"</div>"
		 		                			+"</a>";
										tstr = tstr+str;
									}else if(nv.lnidx!=0){
									//??????????????? ??????
										str="<a class='alarmCheck dropdown-item d-flex align-items-center list-group-item-action list-group-item' onclick='checkLec("+nv.nidx+","+nv.lnidx+"); return false;' >"
											+"<div class='mr-3'>"
		 				                       +" <div class='icon-circle bg-warning'>"
		 				                         +"  <i class='fas fa-file-alt text-white'></i>"
		 				                       +" </div>"
		 			                    	+"</div>"
		 									+"<div>"
		 			                    	+"<div class='small text-gray-500'>????????????"
		 			                    	if(nv.ncheck=="N"){
		 			                    		str=str +"<span style='float:right;'>?????????</span>";
		 			                    	}else{
		 			                    		str=str +"<span style='float:right;'>??????</span>";
		 			                    	}
		 			                    	str=str  +"</div>"
		 									+"<span class='font-weight-bold'>"+nv.ncontents+"</span>"
		 		                    		+"</div>"
		 		                			+"</a>";
										tstr = tstr+str;
										}
	 								});
	 		
	 								$("#alarmList").html(tstr);	
	 							} 
	 					}
	
	 			});	
         });
        </script>
        <style>
.icon-circle {
    height: 2.5rem;
    width: 2.5rem;
    border-radius: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
}
.bg-primary {
    background-color: #4e73df!important;
}
.bg-success {
    background-color: #1cc88a!important; 
}
.bg-warning {
    background-color: #f6c23e!important;
}
.text-white {
    color: #fff!important;
}
.dropdown-header {
    background-color: #4e73df;
    border: 1px solid #4e73df;
    padding-top: 0.75rem;
    padding-bottom: 0.75rem;
    color: #fff;
}
.dropdown-header {
    font-weight: 800;
    font-size: .65rem;
    color: #b7b9cc;
    text-transform: uppercase!important;
}

.d-flex {
    display: flex!important;
}


        </style>
    </body>
</html>
