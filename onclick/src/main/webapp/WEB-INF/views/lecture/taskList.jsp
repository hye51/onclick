<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.onclick.app.domain.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%LecVO lv = (LecVO)session.getAttribute("lv");
	session.setAttribute("lidx", lv.getLidx());%>
<%ArrayList<TaskVO> tlist = (ArrayList<TaskVO>)request.getAttribute("tlist");  %>
<%	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	Date today = new Date(); %>
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
        <link href="../app/resources/css/styles.css" rel="stylesheet" />
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
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="강의 이동" aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
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
                           <img src="../app/resources/assets/img/upload.svg" alt="Bootstrap" width="32" height="32"> 
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
		          <a class="nav-link" href="#">Mypage</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">사이트맵</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">English</a>
		        </li>
		      </ul> 			     
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                     <div class="sb-sidenav-menu">
						<div class="nav-link collapsed">
						<%=lv.getLname() %>
						<img alt="" src="../app/resources/assets/img/home.png">
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
                                    <a class="nav-link" href="<%=request.getContextPath()%>/lecture/proInfo.do">담당 교수 정보</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/lecture/stuList.do">멤버 목록</a>
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
                           	<a class="nav-link" href="<%=request.getContextPath()%>/taskList.do?lidx=<%=lv.getLidx()%>">
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
               <main>
					<h4 class="mt-4 pt-3 ps-5" style="font-weight:bold">과제 목록</h4>
					<%if(session.getAttribute("sidx") != null && session.getAttribute("pidx") == null) { %> <!-- 학생 -->
						<div class="card-body mx-auto d-block " style="width:80%">
							<table class="table text-center">
								<thead>
									<tr class="table-secondary">
										<th style="width:10%">No</th>
									    <th style="width:30%">과제제목</th>
									    <th style="width:30%">제출기간</th>
									    <th style="width:10%">제출일</th>
									    <th style="width:10%">제출여부</th>
									    <th style="width:10%">진행상태</th>
									</tr>
								</thead>
								<tbody>
									<% 	ArrayList<S_taskDTO> stlist = (ArrayList<S_taskDTO>)session.getAttribute("stlist");
										int i = 1;
										for(S_taskDTO std : stlist) {%>
										<tr>
											<th scope="row"><%=i++%></th>
											<%if(std.getTufin().compareTo(dateFormat.format(today))<0) {%>
												<td><%=std.getTuname() %></td>
											<%} else { %>
										    	<td><a style="color:black; text-decoration:none;" href="<%=request.getContextPath()%>/taskContent.do?tuidx=<%=std.getTuidx()%>"><%=std.getTuname() %></a></td>
										    <%} %>
										    <td><%=std.getTustart() %> ~ <%=std.getTufin()%></td>
											<%if(std.getTsubyn().equals("Y")) {%> <!-- 제출했을경우 -->
											   	<td><%=std.getTdate().substring(0, 10) %></td>
											    <td style="color:blue"><a href="<%=request.getContextPath()%>/stuTaskContent.do?tidx=<%=std.getTidx()%>">제출</a></td>
											<%} else {%>
											    	<td>-</td>
											    	<td style="color:red">미제출</td>
											<%} %>
										    <%if(std.getTustart().compareTo(dateFormat.format(today))<=0 && std.getTufin().compareTo(dateFormat.format(today))>=0) {%>
										    	<td style="color:blue">진행</td>
										    	<%} else if(std.getTustart().compareTo(dateFormat.format(today))> 0){ %>
										    	<td>-</td>
										    	<%} else {%>
										    	<td style="color:red">종료</td>
										    	<%} %>
									    </tr>
								    <%} %>
								</tbody>
							</table>
                        </div>
					<%} else { %> <!-- 교수 -->
						<div class="card-body mx-auto d-block " style="width:80%">
							<button type="button" class="btn btn-secondary mb-2" style="float:right" onclick="location.href='<%=request.getContextPath()%>/taskWrite.do?lidx=<%=lv.getLidx()%>'">과제 업로드</button>
							<table class="table text-center">
								<thead>
									<tr class="table-secondary">
										<th style="width:10%">No</th>
									    <th style="width:30%">과제제목</th>
									    <th style="width:30%">제출기간</th>
									    <th style="width:10%">작성일</th>
									    <th style="width:10%">진행상태</th>
									    <th style="width:10%">제출목록</th>
									</tr>
								</thead>
								<tbody>
									<% 	int i = 1;
										for(TaskVO tv : tlist) {%>
										<tr>
											<th scope="row"><%=i++%></th>
										    <td><a style="color:black; text-decoration:none;" href="<%=request.getContextPath()%>/taskContent.do?tuidx=<%=tv.getTuidx()%>&lidx=<%=tv.getLidx()%>"><%=tv.getTuname() %></a></td>
										    <td><%=tv.getTustart() %> ~ <%=tv.getTufin() %></td>
										    <td><%=tv.getTudate() %></td>
										    <%if(tv.getTustart().compareTo(dateFormat.format(today))<=0 && tv.getTufin().compareTo(dateFormat.format(today))>=0) {%>
										    	<td style="color:blue">진행</td>
										    <%} else if(tv.getTustart().compareTo(dateFormat.format(today))> 0){ %>
										    	<td>-</td>
										    <%} else {%>
										    	<td style="color:red">종료</td>
										    <%} %>
										    <td><a href="<%=request.getContextPath()%>/taskSubmitList.do?tuidx=<%=tv.getTuidx()%>">제출현황</a></td>
									    </tr>
								    <%} %>
								</tbody>
							</table>
                        </div>
					<%} %>
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
        <script src="../app/resources/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="../app/resources/assets/demo/chart-area-demo.js"></script>
        <script src="../app/resources/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="../app/resources/js/datatables-simple-demo.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script type="text/javascript">
         
        var msg = "${msg}";
        
        if(msg) {
    		alert(msg);
    	}
        
        </script>
    </body>
</html>
