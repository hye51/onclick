<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.onclick.app.domain.*" %>
<%LecVO lv = (LecVO)session.getAttribute("lv"); %>
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
                           <img src="../resources/assets/img/upload.svg" alt="Bootstrap" width="32" height="32"> 
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
					<a class="nav-link" href="<%=request.getContextPath()%>/professor/pwdCheck.do">Mypage</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<%=request.getContextPath()%>/siteMap.do">사이트맵</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">English</a>
				 </li>
				<li class="nav-item">
					<a class="nav-link" href="<%=request.getContextPath()%>/professor/proLogout.do">LogOut</a>
				</li>
		      </ul> 			     
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                     <div class="sb-sidenav-menu">
						<div class="nav-link collapsed">
						<img alt="" src="../app/resources/assets/img/home.png">
							<%=lv.getLname() %>
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
                           	<a class="nav-link" href="<%=request.getContextPath()%>/lecContent.do">
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
                <h2 class="mt-4 ms-3">업로드</h2>
                	<ol class="breadcrumb mb-4 ms-4">
                    	<li class="breadcrumb-item active">자료 업로드</li>
                	</ol>
            	<main>
					<div class="container-fluid px-4 ">
					<form name="upload">
						<table class="table mx-auto bg-light" style="width:80%">   
							<tbody>
								<tr>
							      	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">강의주차</td>
								      <td colspan="2" style="border-bottom:0; width:50%" >
								      	<select class="form-select" name="cweek">
								      	 <option class="form-select" selected>-- 강의 주차 선택 --</option>
										  <option value="1">1주차</option>
										  <option value="2">2주차</option>
										  <option value="3">3주차</option>
										</select>
								  	</td>		
							    </tr>
							    <tr>
							    	<td class="text-secondary" style="border-bottom:0; text-align:left; width:15%">출석 인정일</td>
							      	<td style="border-bottom:0; width:35%">
							      		<input class="form-control" type="date" name="csta" style="border:0; width:100%" ></td>
									</td>
									<td class="text-secondary" style="border-bottom:0; text-align:left; width:15%">출석 마감일</td>
									<td style="border-bottom:0; width:35%">
							      		<input class="form-control" type="date" name="cfin" style="border:0; width:100%" ></td>
									</td>
							    </tr>
								<tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">강의명</td>
							      	<td colspan="3" style="border-bottom:0; width:90%">
							      		<input class="form-control"  name ="cname" type="text" /> 
									</td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">강의 영상</td>
							      	<td colspan="3" style="border-bottom:0; width:90%">
							      		<input class="form-control"  name ="cfile" type="text" placeholder="업로드할 강의 영상의 링크를 입력해주세요." /> 
									</td>
							    </tr>
							    <tr>
							    	<td colspan="4" style="border-bottom:0"><input type="text" name="ccontents" style="width:100%; height:300px; border:0; solid; black"></td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">알림 전송</td>
							      	<td colspan="3" style="border-bottom:0; width:90%">
							      		<input class="form-check-input" type="radio" name="cnotyn" value="Y" checked>
											<label class="form-check-label">
											발송
											</label>
										<input class="form-check-input" type="radio" name="cnotyn" value="N">
											<label class="form-check-label" >
											미발송
											</label>
									</td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">다시보기</td>
							      	<td colspan="3" style="border-bottom:0; width:90%">
							      		<input class="form-check-input" type="radio" name="creyn" value="Y" checked>
											<label class="form-check-label">
											사용
											</label>
										<input class="form-check-input" type="radio" name="creyn" value="N">
											<label class="form-check-label">
											미사용
											</label>
									</td>
							    </tr>
							</tbody>
						</table>
						<div class="form-row text-center mb-2">
							<button type="button" class="btn btn-secondary btn-sm" style="width:80px">취소</button>
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
        <script type="text/javascript">
        //강의 업로드 작성시 유효성검사
        function check() {
			var fm= document.upload;
			
			if(fm.csta.value == ""){
				fm.csta.focus();
				alert("시작일을 입력하세요");
				return false;
			}else if(fm.cfin.value == ""){
				fm.cfin.focus();
				alert("마감일을 입력하세요");
				return false;
			}else if(fm.cweek.value == ""){
				fm.cweek.focus();
				alert("강의주차를 입력하세요");
				return false;
			}else if(fm.cname.value == ""){
				fm.cname.focus();
				alert("강의명을 입력하세요");
				return false;
			}else if(fm.ccontents.value == ""){
				fm.ccontents.focus();
				alert("강의 내용을 입력하세요");
				return false;
			}
				fm.action="<%=request.getContextPath()%>/lecUploadAction.do?lidx=<%=lv.getLidx()%>";
				fm.method = "post";
				//fm.enctype="multipart/form-data"; 
				fm.submit();
				return;
		}

        </script>
    </body>
</html>
