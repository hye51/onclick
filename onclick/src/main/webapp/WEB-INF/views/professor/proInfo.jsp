<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.onclick.app.domain.*" %>  
<%@ page import="java.util.ArrayList" %> 
<%ProfessorVO pv = (ProfessorVO)request.getAttribute("pv");%>
<%LecVO lv = (LecVO)session.getAttribute("lv"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>교수정보</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="../resources/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
       <% if(session.getAttribute("sidx") != null && session.getAttribute("pidx") == null){ 
    	ArrayList<EnrollDTO> stuLecList = (ArrayList<EnrollDTO>)request.getAttribute("stuLecList");%>
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
				 강의 이동
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
				<!-- 알림 내용 표시 -->
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
					<a class="nav-link" href="<%=request.getContextPath()%>/siteMap.do">사이트맵</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<%=request.getContextPath()%>/logout.do">LogOut</a>
				</li>
		      </ul> 			     
        </nav>
    <% } else if(session.getAttribute("pidx") != null && session.getAttribute("sidx") == null){ 
    	ArrayList<LecVO> alist = (ArrayList<LecVO>)request.getAttribute("alist"); %>
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
				 강의 이동
				 </button>   
					 <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						 <% for(LecVO lv2 : alist) { %>
						 <li><a class="nav-link" href="<%=request.getContextPath()%>/lecHome.do?lidx=<%=lv2.getLidx()%>"><%=lv2.getLname()%></a></li>
	                     <% } %>
                     </ul>
				  </div>	               
	          </div>
	            </form>
	            <!-- heyri1019 alarm -->
	          	<!-- Nav Item - Alerts -->
	          	
	            <!-- Navbar-->
			      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
					<li class="nav-item">
						<a class="nav-link" href="<%=request.getContextPath()%>/professor/pwdCheck.do">Mypage</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<%=request.getContextPath()%>/siteMap.do">사이트맵</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<%=request.getContextPath()%>/logout.do">LogOut</a>
					</li>
			      </ul> 			     
	        </nav>
    <% } %>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                     <div class="sb-sidenav-menu">
						<div class="nav-link collapsed">
							<%=lv.getLname() %>
						<img alt="" src="<%=request.getContextPath()%>/resources/assets/img/home.png">
						</div>
                                                <div class="nav">
                            <div class="sb-sidenav-menu-heading"></div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLecInfo" aria-expanded="false" aria-controls="collapseLecInfo">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	강의정보
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLecInfo" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="layout-static.html">강의계획서</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/professor/proInfo.do?pidx=<%=lv.getPidx()%>">담당 교수 정보</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/stuList.do?lidx=<%=lv.getLidx()%>">멤버 목록</a>
                                </nav>
                            </div>
                          	<a class="nav-link" href="#" >
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	출석 관리
                                <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<a class="nav-link" href="#">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	강좌 목록
                                <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<a class="nav-link" href="#">
                               <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                               		과제
                               <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<a class="nav-link " href="#">
                              <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                              		자료
                              <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                             <a class="nav-link collapsed" href="<%=request.getContextPath()%>/noticeList.do?lidx=<%=lv.getLidx()%>">
                              <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                              		공지사항
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
            <div id="layoutSidenav_content">
				<div class="card mb-3 mx-auto my-auto" style="width:50%">
				  <div class="row g-0">
				    <div class="col-md-2">
				      <img src="<%=request.getContextPath()%>/resources/assets/img/profess.png" class="img-fluid rounded-start">
				    </div>
				    <div class="col-md-7">
				      <div class="card-body">
				         <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">성함</label>
						<div class="col-sm-10">
						<input type="text" class="form-control form-control-sm" value="<%=pv.getPname() %>">
						</div>
						 <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">연락처</label>
						<div class="col-sm-10">
						  <input type="text" class="form-control form-control-sm" value="<%=pv.getPphone() %>">
						</div>
						 <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">이메일</label>
						<div class="col-sm-10">
						  <input type="text" class="form-control form-control-sm" value="<%=pv.getPemail() %>">
						</div>
						 <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">연구실</label>
						<div class="col-sm-10">
						  <input type="text" class="form-control form-control-sm" value="<%=pv.getPlab() %>" >
						</div>
				      </div>
				    </div>
				</div>
			</div>				
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
        <script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath()%>/resources/assets/demo/chart-area-demo.js"></script>
        <script src="<%=request.getContextPath()%>/resources/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath()%>/resources/js/datatables-simple-demo.js"></script>
        <!-- jquery 3.3.1 라이브러리 활용 -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
        //알림클릭시 읽음로 표시 
        function checkClass(nidx,sidx,cidx){
        	//강의 클릭시
        	 $.ajax({
	        		url:"<%=request.getContextPath()%>/alarmUpdate.do",
	        		type:'post',
	        		dataType : "json",
	        		data:{"nidx" : nidx},
	        		success:function(cnt){
        				location.href="<%=request.getContextPath()%>/stuLecContent.do?sidx="+sidx+"&cidx="+cidx;
	        		},
	        		error:function(){
	        			alert("에러입니다.(update1)");
	        		}
	        	});
        }
     
        function checkTask(nidx,lidx,tuidx){
        	//과제 클릭시
       	 $.ajax({
	        		url:"<%=request.getContextPath()%>/alarmUpdate.do",
	        		type:'post',
	        		dataType : "json",
	        		data:{"nidx" : nidx},
	        		success:function(cnt){
	        			 location.href="<%=request.getContextPath()%>/taskContent.do?tuidx="+tuidx+"&lidx="+lidx;
	        		},
	        		error:function(){
	        			alert("에러입니다.(update2)");
	        		}
	        	});
       }
       
       function checkLec(nidx,lnidx){
       		//공지사항 클릭시
      	 $.ajax({
	        		url:"<%=request.getContextPath()%>/alarmUpdate.do",
	        		type:'post',
	        		dataType : "json",
	        		data:{"nidx" : nidx},
	        		success:function(cnt){
	        			location.href="<%=request.getContextPath()%>/lecNoticeContent.do?lnidx="+lnidx;
	        		},
	        		error:function(){
	        			alert("에러입니다.(update3)");
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
	 				alert("error 입니다 :");
	 			},
	 			success : function(data){
	 						if(data.length == 0){
	 							alert("알림이 존재하지 않습니다");
	 						}else {
	 							$.each (data, function (index, nv) {
	 							
	 								if(nv.cidx!=0){
										//강좌인 경우
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
	 			                    	+"<div class='small text-gray-500'>강좌";
	 			                    	if(nv.ncheck=="N"){
	 			                    		str=str +"<span style='float:right;'>안읽음</span>";
	 			                    	}else{
	 			                    		str=str +"<span style='float:right;'>읽음</span>";
	 			                    	}
	 			                    	str=str  +"</div>"
	 								    +"<span class='font-weight-bold'>"+nv.ncontents+"</span>"
	 		                    		+"</div>"
	 		                			+"</a>";
	 								tstr = tstr+str;
									}else if(nv.tuidx!=0){
									//과제인 경우
										str="<a name='alarmCheck'class='dropdown-item d-flex align-items-center list-group-item-action list-group-item' onclick='checkTask("+nv.nidx+","+nv.lidx+","+nv.tuidx+"); return false;'>"
											+"<div class='mr-3'>"
		 				                       +" <div class='icon-circle bg-success'>"
		 				                         +"  <i class='fas fa-file-alt text-white'></i>"
		 				                       +" </div>"
		 			                    	+"</div>"
		 									+"<div>"
		 			                    	+"<div class='small text-gray-500'>과제"
		 			                    	if(nv.ncheck=="N"){
		 			                    		str=str +"<span style='float:right;'>안읽음</span>";
		 			                    	}else{
		 			                    		str=str +"<span style='float:right;'>읽음</span>";
		 			                    	}
		 			                    	str=str  +"</div>"
		 									+"<span class='font-weight-bold'>"+nv.ncontents+"</span>"
		 		                    		+"</div>"
		 		                			+"</a>";
										tstr = tstr+str;
									}else if(nv.lnidx!=0){
									//공지사항인 경우
										str="<a class='alarmCheck dropdown-item d-flex align-items-center list-group-item-action list-group-item' onclick='checkLec("+nv.nidx+","+nv.lnidx+"); return false;' >"
											+"<div class='mr-3'>"
		 				                       +" <div class='icon-circle bg-warning'>"
		 				                         +"  <i class='fas fa-file-alt text-white'></i>"
		 				                       +" </div>"
		 			                    	+"</div>"
		 									+"<div>"
		 			                    	+"<div class='small text-gray-500'>공지사항"
		 			                    	if(nv.ncheck=="N"){
		 			                    		str=str +"<span style='float:right;'>안읽음</span>";
		 			                    	}else{
		 			                    		str=str +"<span style='float:right;'>읽음</span>";
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
