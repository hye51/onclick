<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.onclick.app.domain.*" %>
<%ArrayList<EnrollDTO> stuLecList = (ArrayList<EnrollDTO>)request.getAttribute("stuLecList"); %>
<%ArrayList<TaskVO> stuTaskList = (ArrayList<TaskVO>)request.getAttribute("stuTaskList"); %>
<%ArrayList<NoticeVO> alarm =(ArrayList<NoticeVO>)session.getAttribute("alarm");  %>
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
				 강의 이동
				 </button>
					 <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
					 <% for(EnrollDTO ed : stuLecList) { %>
					  <li><a class="dropdown-item" href="<%=request.getContextPath()%>/lecHome.do?lidx=<%=ed.getLidx()%>"><%=ed.getLname() %></a></li>					 
					  <% } %>
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
				<!-- 알림 내용 표시 -->
				<%for(NoticeVO nv : alarm){ %>
						<%if(nv.getCidx()!=0){ %>
						<a class="dropdown-item d-flex align-items-center list-group-item-action list-group-item" href="#">
							<div class="mr-3">
		                        <div class="icon-circle bg-primary">
		                        	<i class="bi bi-camera-reels-fill text-white "></i>
		                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-camera-reels-fill text-white" viewBox="0 0 16 16">
									<path d="M6 3a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
									<path d="M9 6a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
									<path d="M9 6h.5a2 2 0 0 1 1.983 1.738l3.11-1.382A1 1 0 0 1 16 7.269v7.462a1 1 0 0 1-1.406.913l-3.111-1.382A2 2 0 0 1 9.5 16H2a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h7z"/>
									</svg>
		                        </div>
	                    	</div>
						<div>
                        <div class="small text-gray-500">강좌
                        	<%if(nv.getNcheck().equals("N")){ %>
                        	 <span style="float:right;">안읽음</span>
                        	 <%} %>
                         </div>
                    	<% }else if(nv.getLnidx()!=0){%>
                    	<a class="dropdown-item d-flex align-items-center list-group-item-action list-group-item" href="#">
	                    	<div class="mr-3">
		                        <div class="icon-circle bg-success">
		                              <i class="fas fa-file-alt text-white"></i>
	                        	</div>
	                    	</div>
						<div>
                    	 <div class="small text-gray-500">공지사항
                    	 	<%if(nv.getNcheck().equals("N")){ %>
                        	 <span style="float:right;">안읽음</span>
                        	 <%} %>
                    	  </div>
                    	<% }else if(nv.getTuidx()!=0){%>
                    	<a class="dropdown-item d-flex align-items-center list-group-item-action list-group-item" href="#">
	                    	<div class="mr-3">
		                        <div class="icon-circle bg-warning">
		                           <i class="fas fa-file-alt text-white"></i>
		                        </div>
	                    	</div>
						<div>
                    	<div class="small text-gray-500">과제
                    	 <%if(nv.getNcheck().equals("N")){ %>
                        	 <span style="float:right;">안읽음</span></div>
                        	 <%} %>
                    	<% }%>
                        <span class="font-weight-bold"><%=nv.getNcontents() %></span>
                    </div>
                </a>
                <%} %>
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
						<img alt="" src="<%=request.getContextPath() %>/resources/assets/img/user.png">
							홍길동님
						</div>
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading"></div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                MyPage
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/student/pwdCheck.do">정보 수정</a>
                                </nav>
                            </div>
                          	<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLec" aria-expanded="false" aria-controls="collapseLec">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	강의 목록
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLec" aria-labelledby="headingTh" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                     	<% for(EnrollDTO ed : stuLecList) { %>
	                                    <a class="nav-link" href="<%=request.getContextPath()%>/lecHome.do?lidx=<%=ed.getLidx()%>"><%=ed.getLname() %></a>
                                    <% } %>
                                </nav>
                            </div>
                             <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Zoom 다운로드
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTh" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
 									다운로드 링크
                                    </a>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Dashboard</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">강의목록</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                            <table class="text-center">
                                       	<% for(EnrollDTO ed : stuLecList) { %>
											<tr>
											<td><a style="color:white; text-decoration:none;" href="<%=request.getContextPath()%>/lecHome.do?lidx=<%=ed.getLidx()%>"><%=ed.getLname() %></td>
											</tr>
										<% } %>
                                       </table>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">과제</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <table class="text-center">
                                        <% for(TaskVO tv : stuTaskList) { %>
											<tr>
											<td style=" text-align:left"><a style="color:white; text-decoration:none;" href="<%=request.getContextPath()%>/taskContent.do?lidx=<%=tv.getLidx() %>&tuidx=<%=tv.getTuidx()%>"><%=tv.getTuname()%></td>
											</tr>
										<% } %>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">최근 수강중인 강의</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body">마감 예정인 강의</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card text-dark text-black mb-4">
                                    <div class="card-body">추가</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-black stretched-link" href="#">View Details</a>
                                        <div class="small text-black"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>  
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
        <script type="text/javascript">
        
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
