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
        <title>강의 내용 </title>
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
            <!-- 강의 내용보기(교수님) -->
            <div id="layoutSidenav_content">
	            <h2 class="mt-4 ms-3">강의보기</h2>
                	<ol class="breadcrumb mb-4 ms-4">
                    	<li class="breadcrumb-item active"><%=cv.getCname()%></li>
                	</ol>
            	<main>
					<div class="container-fluid px-4" style="width:90%; height:700px;">
						<div class="row m-0" style="width:100%; height:100%">
						    <div class="col-md-8">
						    <div class="viewinfo" style="width:100%;">
	                   			<div style="padding-right:10px;letter-spacing:-0.5px;">
		                    	<span style="padding-left:3px;"> 작성일 :</span> <%=cv.getCdate() %></div>
	                   			<div style="padding-right:10px;letter-spacing:-0.5px; margin-top:3px;line-height:160%;">
			                    <span style="padding-left:3px;">출결 인정 기간 : </span> <%=cv.getCsta() %> ~ <%=cv.getCfin() %></div>
			                    <div style="padding-right:10px;letter-spacing:-0.5px;">
			                    <span style="padding-left:3px;">다시보기 여부 : </span> 
			                    <span class="rely" style="display : none; color:black;">가능</span> 
			                    <span class="reln" style="display : none; color:black; ">불가능</span> 
			                    </div>	                    
                    		</div>
						      <!-- 동영상 -->
						      <!-- 211110 동영상 넣기 수정중 jhr-->
						      <!-- 다운로드 방지를 위해 controlsList="nodownload" 추가 -->
						      <% if(cv.getCfile() != null){ %>
								<video  id="myVideo" style="width:100%; height:450px;" controlsList="nodownload" controls>
								  <source src="<%=cv.getCfile()%>" type="video/mp4">
								</video>
							  <% }%>
							</iframe>
								<br>
								<div class="bd-callout bd-callout-info shadow ">
								  <div class="card-body">
								    <%=cv.getCcontents() %>
								  </div>
								</div>
								<br>
								<div class="btn-group" role="group" style="float:right;" >
								  <a role="button" class="btn btn-primary" href="<%=request.getContextPath()%>/classUpdate.do?cidx=<%=cv.getCidx()%>">수정</a>
								  <a role="button" class="btn btn-primary" href="<%=request.getContextPath()%>/classDelete.do?cidx=<%=cv.getCidx()%>&lidx=<%=cv.getLidx()%>">삭제</a>
								  <button type="button" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/proLecList.do?lidx=<%=lv.getLidx()%>' ">목록</button>
								</div>
						    </div>
						    <div class="col">
						      	강의자료
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
         <!-- jquery 3.3.1 라이브러리 활용 -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
        var msg = '${deleteNok}';
        if(msg != ""){
        	//강좌 삭제 실패시 알림 
        	alert(msg);
        }
        
     	//다시보기 여부
     	var rel = '<%=cv.getCreyn()%>';
     	$(function(){
	     	if(rel=='Y'){
	     		$('.rely').css("display","inline-block");
	     	}else{
	     		$('.reln').css("display","inline-block");
	     	}
     	 });
        </script>

    </body>
</html>
