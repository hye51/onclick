<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.onclick.app.domain.*" %>
<%LecVO lv = (LecVO)session.getAttribute("lv"); %>
<%ProfessorVO pv = (ProfessorVO)session.getAttribute("pv"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>강의 공지사항</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="<%=request.getContextPath()%>/views/index.jsp">ONclick</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
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
          <button type="button"><img alt="" src="<%=request.getContextPath()%>/resources/assets/img/alarm.png"></button>
            <!-- Navbar-->
		      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
				<li class="nav-item">
					<% if(session.getAttribute("sidx") != null && session.getAttribute("pidx") == null){ %>
					<a class="nav-link" href="<%=request.getContextPath()%>/student/pwdCheck.do">Mypage</a>
					<% } else if(session.getAttribute("pidx") != null && session.getAttribute("sidx") == null){ %>
					<a class="nav-link" href="<%=request.getContextPath()%>/professor/pwdCheck.do">Mypage</a>
					<% } %>
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
						<img alt="" src="<%=request.getContextPath()%>/resources/assets/img/home.png">
						</div>
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading"></div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	강의정보
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="<%=request.getContextPath()%>/lecPlan.do">강의계획서</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/professor/proInfo.do?pidx=<%=lv.getPidx()%>">담당 교수 정보</a>
                                    <a class="nav-link" href="<%=request.getContextPath()%>/stuList.do?lidx=<%=lv.getLidx()%>">멤버 목록</a>
                                </nav>
                            </div>
                          	<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	출석 관리
                                <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                	강좌 목록
                                <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                               <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                               		과제
                               <div class="sb-sidenav-collapse-arrow"></div>
                            </a>
                           	<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                              <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                              		자료
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
	            <h3 class="mt-4 pt-3 ps-5" style="font-weight:bold">강의 계획서</h3>
                	<ol class="breadcrumb mb-4 ps-5">
                	</ol>
            	<main>
            	<div id="page-content" class="clearfix">
					<div id="page-content-wrap">
						<div class="page-content-navigation"><ol class=breadcrumb><li class="breadcrumb-home"><a href=""><img src="<%=request.getContextPath()%>/resources/assets/img/home.png"/></a></li>
						<li><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb">
							<a itemprop="url" title="JAVA" href="<%=request.getContextPath()%>/lecHome.do?lidx=<%=lv.getLidx()%>">	<%=lv.getLname() %></span></li>
							</ol></div>	<span class="notifications" id="user-notifications"></span>
							<div role="main"><span id="maincontent"></span><div class="local_ubmessage"><h3>JAVA</h3><div class="well"><div class="course_syllabus"><h3 class="text-center">2021년도 2학기 JAVA</h3>	<div class="syllabus-item-title">기본 정보</div>
	<table class="table table-bordered">
		<colgroup>
			<col class="w150" />
			<col />
			<col class="w150" />
			<col />
		</colgroup>
		<tbody>			
			<tr>
				<th class="text-center">과목명</th>
				<td><%=lv.getLidx() %></td>
				<th class="text-center">과목코드</th>
				<td>0000102790</td>
			</tr>
			<tr>
				<th class="text-center">분반</th>
				<td>1</td>
				<th class="text-center">강좌정보</th>
				<td>전공선택</td>
			</tr>
			<tr>
				<th class="text-center">강의실</th>
				<td>전주:인문대학2호관 313 </td>
				<th class="text-center">강의시간</th>
				<td colspan="3">화 6-B,화 7-A,화 7-B,목 8-A,목 8-B,목 9-A</td>
			</tr>
					
			
		</tbody>
	</table>

	<div class="syllabus-item-title">담당 교수 정보</div>
	<table class="table table-bordered">
		<colgroup>
			<col class="w150" />
			<col />
			<col class="w150" />
			<col />
		</colgroup>
		<tbody>
			<tr>
				<th class="text-center">성명</th>
				<td>홍길동</td>
				<th class="text-center">연구실</th>
				<td></td>
			</tr>									
		</tbody>
	</table>

	<div class="syllabus-item-title">교과목 정보</div>
	<table class="table table-bordered">
		<colgroup>
			<col class="w150" />
			<col />			
		</colgroup>
		<tbody>
			<tr>
				<th class="text-center">과목구분</th>
				<td colspan="5">전공선택</td>
			</tr>
						<tr>	
				<th class="text-center">수업목표</th>
				<td colspan="5">This course primarily aims at providing a broad understanding of the history of Medieval Europe. This course covers the political, religious, cultural and popular history of Europe in making from the 5th century to 15th century AD. Students will be encouraged to reflect on what importance the cultural heritages that Medieval Europe left to us have in the life of modern world where we belong to. </td>
			</tr>
			<tr>	
				<th class="text-center">선수과목</th>
				<td colspan="5">
n/a</td>
			</tr>
			<tr>
				<th class="text-center" rowspan="2">교재</th>
				<th class="text-center">주교재</th>
				<td colspan="4">A Short History of the Middle Ages (Fifth edition)</td>
			</tr>
			<tr>
				<th class="text-center">참고문헌</th>
				<td colspan="4">The Middle Ages: A Very Short Introduction, Miri Rubin, Oxford University Press, 2014<br />
<br />
(A further reading list will be provided in the first week lectures.) </td>
			</tr>						

		</tbody>
	</table>

	
	<div class="syllabus-item-title">평가방법</div>
	<table class="table table-bordered">
		<colgroup>
			<col class="w150" />
			<col />				
		</colgroup>
		<tr>
			<th class="text-center">중간고사</th>
			<td>30%</td>
		</tr>
		<tr>
			<th class="text-center">기말고사</th>
			<td>30%</td>
		</tr>
		<tr>	
			<th class="text-center">출석</th>
			<td>10%</td>
		</tr>
		<tr>
			<th class="text-center">과제물</th>
			<td>20%</td>
		</tr>
		<tr>	
			<th class="text-center">토론</th>
			<td>0%</td>
		</tr>
		<tr>
			<th class="text-center">기타</th>
			<td>기타(For more detailed information on the evaluation of attendance, assignment and exams will be given in the first week lectures. )</td>
		</tr>		
	</table>

	
	<div class="syllabus-item-title">주차별 수업계획</div>
	<table class="table table-bordered">
		<colgroup>
			<col class="w150" />
			<col />			
		</colgroup>
		<tbody>
			<tr>
				<th class="text-center">주</th>				
				<th class="text-center">내용</th>				
			</tr>
						<tr>
				<th class="text-center">1</th>
				<td>- General Introduction / Chronological & Geographical Scopes
 *More detailed information on the evaluation of attendance, assignment and exams will be given in the first week lectures. </td>
			</tr>
						<tr>
				<th class="text-center">2</th>
				<td>The Legacy of the Roman Empire (1)  (9/12 추석)</td>
			</tr>
						<tr>
				<th class="text-center">3</th>
				<td>The Legacy of the Roman Empire (2) / Neighbours - Byzantium</td>
			</tr>
						<tr>
				<th class="text-center">4</th>
				<td>Neighbours - Byzantium & Islam</td>
			</tr>
						<tr>
				<th class="text-center">5</th>
				<td>Neighbours - Islam (10/3 개천절)</td>
			</tr>
						<tr>
				<th class="text-center">6</th>
				<td>The Making of Western Europe c.750-c.900 (1)</td>
			</tr>
						<tr>
				<th class="text-center">7</th>
				<td>The Making of Western Europe c.750-c.900 (2) (10/15 개교기념일)</td>
			</tr>
						<tr>
				<th class="text-center">8</th>
				<td>Formation of Medieval Church</td>
			</tr>
						<tr>
				<th class="text-center">9</th>
				<td>Mid-term Exam </td>
			</tr>
						<tr>
				<th class="text-center">10</th>
				<td>Three Social Classes: those who work, those who fight, those who pray</td>
			</tr>
						<tr>
				<th class="text-center">11</th>
				<td>The Crusades</td>
			</tr>
						<tr>
				<th class="text-center">12</th>
				<td>Medieval Cities and Economy</td>
			</tr>
						<tr>
				<th class="text-center">13</th>
				<td>People outside a society</td>
			</tr>
						<tr>
				<th class="text-center">14</th>
				<td>Medieval Culture and Art</td>
			</tr>
						<tr>
				<th class="text-center">15</th>
				<td>Crisis or Rebirth: Europe in the 14th-15th centuries & Final Exam</td>
			</tr>
						
		</tbody>
	</table>
	</div>


</div></div></div>				            
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
        <script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath()%>/resources/assets/demo/chart-area-demo.js"></script>
        <script src="<%=request.getContextPath()%>/resources/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath()%>/resources/js/datatables-simple-demo.js"></script>
		<script src="https://ieilmsold.jbnu.ac.kr/theme/jquery.php/theme_coursemosv2/jquery.filedownload.js"></script>
		<script type="text/javascript">
		
		$.fileDownload($("#croot").val()+excelUrl, {
			httpMethod: "POST",
		    data: $("#searchMainForm").serialize(),
			successCallback: function(){
				hideLoadingDialog();
				window.parent.postMessage({'from': 'standby','type': 'hide'}, '*');
			},
			failCallback: function(){
				hideLoadingDialog();
				window.parent.postMessage({'from': 'standby','type': 'hide'}, '*');
				alert('파일 생성에 실패 했습니다.\n잠시 후 다시 시도해 주시기 바랍니다. ');
			}
		});
		
		
		
		</script>
    </body>
</html>
