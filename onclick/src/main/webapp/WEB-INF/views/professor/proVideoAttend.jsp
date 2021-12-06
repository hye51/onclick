<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.onclick.app.domain.*" %>
<%@ page import="java.util.ArrayList" %>
<%ArrayList<VideoDTO> vlist = (ArrayList<VideoDTO>)request.getAttribute("vlist");%>
<%ArrayList<ClassVo> clist = (ArrayList<ClassVo>)request.getAttribute("clist"); %>
<%LecVO lv = (LecVO)session.getAttribute("lv"); %>
<%ArrayList<LecVO> alist = (ArrayList<LecVO>)request.getAttribute("alist"); %>
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
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseAttend" aria-expanded="false" aria-controls="collapseAttend">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	출석관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                                <div class="collapse" id="collapseAttend" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/proVideoAttend.do?lidx=<%=lv.getLidx()%>&cweek=0">동영상 강의 출석</a>
                                </nav>
                               	</div>
                           	<a class="nav-link" href="<%=request.getContextPath()%>/proLecList.do?lidx=<%=lv.getLidx()%>">
                           	<div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	강좌 목록
                                <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
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
            
            <div id="layoutSidenav_content">
               <main>
					<h3 class="mt-4 pt-3 ps-5" style="font-weight:bold">동영상 강의 출결 현황</h3>
						<div class="card-body mx-auto d-block " style="width:80%">
						<select id="allWeekSelect" onchange="weekChange(value);" class="form-select mb-2" style="width:15%" aria-label="Default select example">
  							<option selected >주차 선택</option>
						  	<option value="1">1 주차</option>
						    <option value="2">2 주차</option>
						    <option value="3">3 주차</option>
						    <option value="4">4 주차</option>
						    <option value="5">5 주차</option>
						    <option value="6">6 주차</option>
						    <option value="7">7 주차</option>
						    <option value="8">8 주차</option>
						    <option value="9">9 주차</option>
						    <option value="10">10 주차</option>
						    <option value="11">11 주차</option>
						    <option value="12">12 주차</option>
						    <option value="13">13 주차</option>
						    <option value="14">14 주차</option>
						    <option value="15">15 주차</option>
						  </select>
							<table class="table text-center" style="width:100%">
								<thead>
									<tr class="table-secondary">
										<th style="width:15%">학번</th>
										<th style="width:10%">이름</th>
										<%if(clist.size() == 3) {
											for(int i=0; i<=2; i++) {%>
									    	<th style="width:25%"><%=clist.get(i).getCname() %></th>
											<%} 
											}else if(clist.size() == 2) {
												for(int i=0; i<=1; i++) {%>
												<th style="width:25%"><%=clist.get(i).getCname() %></th>
												<%}%>
												<th style="width:25%">-</th> 
											<%} else if(clist.size() == 1) {%>
													<th style="width:25%"><%=clist.get(0).getCname() %></th>
													<th style="width:25%">-</th>
													<th style="width:25%">-</th>
											<%} else {%>
												<th style="width:25%">-</th>
												<th style="width:25%">-</th>
												<th style="width:25%">-</th>
											<%} %>
									</tr>
								</thead>
								<tbody>
								<%for(VideoDTO vdto : vlist) {%>
									<tr>
									    <td style=""><%=vdto.getSidx() %></td>
									    <td style=""><%=vdto.getSname() %></td>
									    <%if(vdto.getVattendence().equals("-")) {%>
									    	<td style="">-<td>
									    <%} else {
									    	if(vdto.getVattendence().equals("Y")) {%>
									    		<td style="color:blue">출석</td>
										    <%} else { %>
										    	<td style="color:red">결석</td>
										    <%} 
										}%>
									    <%if(vdto.getVattendence2().equals("-")) {%>
									    	<td style="">-<td>
									    <%} else {
									    	if(vdto.getVattendence2().equals("Y")) {%>
									    		<td style="color:blue">출석</td>
										    <%} else { %>
										    	<td style="color:red">결석</td>
										    <%} 
										}%>
									    <%if(vdto.getVattendence3().equals("-")) {%>
									    	<td style="">-<td>
									    <%} else {
									    	if(vdto.getVattendence3().equals("Y")) {%>
									    		<td style="color:blue">출석</td>
										    <%} else { %>
										    	<td style="color:red">결석</td>
										    <%} 
										}%>
								<% }%> 
								</tbody>
							</table>
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
        <script type="text/javascript">
        function weekChange(value) {
			var lidx = <%=lv.getLidx()%>;
			//선택한 주차와 강의 고유번호 받아서 페이지 이동
			location = '${pageContext.request.contextPath}/proVideoAttend.do?lidx='+lidx+'&cweek='+value;
		}
        </script>
        
    </body>
</html>
