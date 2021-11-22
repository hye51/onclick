<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.onclick.app.domain.*" %>
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
           	<img alt="" src="../app/resources/assets/img/ex.png" id="logo">
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
					 </ul>
				  </div>	               
	          </div>
            </form>
            <!-- heyri1019 alarm -->
          	<!-- Nav Item - Alerts -->
          	<div class="dropdown">
				<a class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
				    <i class="fas fa-bell fa-fw"></i>
				    <!-- Counter - Alerts -->
				    <span class="badge badge-danger badge-counter">3+</span>
				</a>
				<!-- Dropdown - Alerts -->
				<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
				<h6 class="dropdown-header">Alerts</h6>
				<a class="dropdown-item d-flex align-items-center" href="#">
                    <div class="mr-3">
                        <div class="icon-circle bg-secondary">
                           <img src="<%=request.getContextPath() %>/resources/assets/img/upload.svg" alt="Bootstrap" width="32" height="32"> 
                        </div>
                    </div>
                    <div>
                        <div class="small text-gray-500">December 12, 2019</div>
                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                    </div>
                </a>
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
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                     <div class="sb-sidenav-menu">
						<div class="nav-link collapsed">
							<%=lv.getLname() %>
						<img alt="" src="<%=request.getContextPath() %>/resources/assets/img/home.png">
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
							<% if(session.getAttribute("sidx") != null && session.getAttribute("pidx") == null){ %>
                           	<a class="nav-link" href="<%=request.getContextPath()%>/stuLecList.do?lidx=<%=lv.getLidx()%>">
                           	<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	강좌 목록
                                <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<% } else if(session.getAttribute("pidx") != null && session.getAttribute("sidx") == null){ %>
                           	<a class="nav-link" href="<%=request.getContextPath()%>/proLecList.do?lidx=<%=lv.getLidx()%>">
                           	<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	강좌 목록
                                <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<% }%>
                           	<a class="nav-link" href="<%=request.getContextPath()%>/taskList.do?lidx=<%=lv.getLidx()%>">
                               <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                               		과제
                               <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<a class="nav-link " href="<%=request.getContextPath()%>/refList.do?lidx=<%=lv.getLidx()%>">
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
            <!-- 과제 제출 화면-->
            <div id="layoutSidenav_content">
	            <h2 class="mt-4 ms-3">수정하기</h2>
                	<ol class="breadcrumb mb-4 ms-4">
                    	<li class="breadcrumb-item active"><%=tv.getTuname() %></li>
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
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">제출기간</td>
							      	<td colspan="3" style="border-bottom:0; width:90%">
							      		<%=tv.getTustart().substring(0, 10) %> ~ <%=tv.getTufin().substring(0, 10) %>
									</td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">첨부 파일</td>
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
							<button type="button" class="btn btn-secondary btn-sm" style="width:80px" onclick="history.back(-1)">취소</button>
							<button type="button" class="btn btn-secondary btn-sm" style="width:80px" onclick="check(); return false;">완료</button>
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
							alert("에러입니다."); },
						success:function(data){
							if(data.value == 2) {
								$('.exFile').css("display", "none");
								alert("삭제되었습니다.");
								$("#stuTaskFile").attr("disabled",false);
							} else {
								alert("파일이 삭제되지 않았습니다.");
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
    </body>
</html>
