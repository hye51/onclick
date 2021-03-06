<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.onclick.app.domain.*" %>
<%@ page import="java.util.ArrayList" %>
<%ArrayList<LecVO> alist = (ArrayList<LecVO>)request.getAttribute("alist"); %>
<%LecVO lv = (LecVO)session.getAttribute("lv"); %>
<%ClassVo cv = (ClassVo)request.getAttribute("cv"); %>
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
                <h2 class="mt-4 ms-3">강의 수정</h2>
                	<ol class="breadcrumb mb-4 ms-4">
                    	<li class="breadcrumb-item active">강의 수정</li>
                	</ol>
            	<main>
					<div class="container-fluid px-4 ">
					<form name="upload">
						<table class="table mx-auto bg-light" style="width:80%">   
							<tbody>
								<tr>
							      	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">강의주차</td>
								      <td colspan="2" style="border-bottom:0; width:50%" >
								      	<select class="form-select" name="cweek" id="cweek">
								      	 <option class="form-select">-- 강의 주차 선택 --</option>
										  <% for(int i=1;i<16;i++) { %>
										  <option value="<%=i %>"><%=i %>주차</option>
										  <% } %>
										</select>
								  	</td>		
							    </tr>
							    <tr>
							    	<td class="text-secondary" style="border-bottom:0; text-align:left; width:15%">출석 인정일</td>
							      	<td style="border-bottom:0; width:35%">
							      		<input class="form-control" type="date" name="csta" value="<%=cv.getCsta() %>" style="border:0; width:100%" ></td>
									</td>
									<td class="text-secondary" style="border-bottom:0; text-align:left; width:15%">출석 마감일</td>
									<td style="border-bottom:0; width:35%">
							      		<input class="form-control" type="date" name="cfin" value="<%=cv.getCfin() %>" style="border:0; width:100%" ></td>
									</td>
							    </tr>
								<tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">강의명</td>
							      	<td colspan="3" style="border-bottom:0; width:90%">
							      		<input class="form-control"  name ="cname" type="text" value="<%=cv.getCname()%>"/> 
									</td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">강의 영상</td>
							      	<td colspan="3" style="border-bottom:0; width:90%">
							      		<input class="form-control"  name ="cfile" type="text" value="<% if(cv.getCfile() != null ){ out.print(cv.getCfile());}%>" placeholder="업로드할 강의 영상의 링크를 입력해주세요." /> 
									</td>
							    </tr>
							    <tr>
							    	<td colspan="4" style="border-bottom:0"><input type="text" name="ccontents" value="<%=cv.getCcontents()%>" style="width:100%; height:300px; border:0; solid; black"></td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; width:10%">알림 전송</td>
							      	<td colspan="3" style="border-bottom:0; width:90%">
							      		<input class="form-check-input" type="radio" name="cnotyn" value="Y" >
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
							      		<input class="form-check-input" type="radio" name="creyn" value="Y" >
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
				fm.action="<%=request.getContextPath()%>/classUpdateAction.do?cidx=<%=cv.getCidx()%>&lidx=<%=cv.getLidx()%>";
				fm.method = "post";
				//fm.enctype="multipart/form-data"; 
				fm.submit();
				return;
		}
        
        //selected value 
        	var dbCweek= <%=cv.getCweek()%>;
        	var cweek = document.getElementById("cweek");

        	for(var cnt = 0 ; cnt < cweek.options.length; cnt++){
        	  if( dbCweek == cweek.options[cnt].value)
        		  cweek.options[cnt].selected = 1;
        	}
        	
        //notyn checked value
        	var dbNotyn='<%=cv.getCnotyn()%>';
        	var notyn = document.getElementsByName("cnotyn");

        	for(var i=0; i < notyn.length; i++) { 
        		if( notyn[i].value == dbNotyn)
        			notyn[i].checked = true;
        	}

		//reyn checked value
        	var dbReyn='<%=cv.getCnotyn()%>';
        	var reyn = document.getElementsByName("creyn");

        	for(var i=0; i < reyn.length; i++) { 
        		if( reyn[i].value == dbReyn)
        			reyn[i].checked = true;
        	}
     
        
        </script>
    </body>
</html>
