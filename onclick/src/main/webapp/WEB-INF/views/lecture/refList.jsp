<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.onclick.app.domain.*" %>
<%@ page import="java.util.ArrayList" %>
<%LecVO lv = (LecVO)session.getAttribute("lv"); %>
<%ArrayList<RefVO> rlist = (ArrayList<RefVO>)request.getAttribute("rlist"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>강의 자료 목록</title>
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
				<a id="alarm" class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
				    <i class="fas fa-bell fa-fw"></i>
				    <!-- Counter - Alerts -->
				    <span class="badge badge-danger badge-counter">3+</span>
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
					<h4 class="mt-4 pt-3 ps-5" style="font-weight:bold">강의자료 목록</h4>
						<div class="card-body mx-auto d-block " style="width:80%">
						<%if(session.getAttribute("sidx") == null && session.getAttribute("pidx") != null) { %> <!-- 교수일 경우 -->
							<button type="button" class="btn btn-secondary mb-2" style="float:right" onclick="location.href='<%=request.getContextPath()%>/refWrite.do?lidx=<%=lv.getLidx()%>'">자료 업로드</button>
						<%} %>	
							<table class="table text-center">
								<thead>
									<tr class="table-secondary">
										<th style="width:10%">No</th>
									    <th style="width:45%">제목</th>
									    <th style="width:30%">작성일</th>
									    <th style="width:15%">첨부파일</th>
									</tr>
								</thead>
								<tbody>
									<%	int i = 1;
										for(RefVO rv : rlist) {%>
										<tr>
											<th scope="row"><%=i++ %></th>
											<td><a style="color:black; text-decoration:none;" href="<%=request.getContextPath()%>/refContent.do?ridx=<%=rv.getRidx()%>"><%=rv.getRname() %></a></td>
											<td><%=rv.getRdate() %></td>
											<%if(rv.getFidx() != 0) {%>
												<td>
													<button class="btn"  onclick="location.href='<%=request.getContextPath()%>/fileDownload.do?fidx=<%=rv.getFidx()%>'">
														<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="fileIcon" viewBox="0 0 16 16" >
														  <path d="M8.5 6.5a.5.5 0 0 0-1 0v3.793L6.354 9.146a.5.5 0 1 0-.708.708l2 2a.5.5 0 0 0 .708 0l2-2a.5.5 0 0 0-.708-.708L8.5 10.293V6.5z"/>
														  <path d="M14 14V4.5L9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2zM9.5 3A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5v2z"/>
														</svg></td>
													</button>
											<%} else { %>
												<td></td>
											<%} %>
										</tr>
									<%} %>
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
        <script src="../app/resources/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="../app/resources/assets/demo/chart-area-demo.js"></script>
        <script src="../app/resources/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="../app/resources/js/datatables-simple-demo.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
         <!-- jquery 3.3.1 라이브러리 활용 -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript">
        var msg = "${msg}";
        
        if(msg) {
    		alert(msg);
    	}
        
        </script>
        <script type="text/javascript">
        //알림클릭시 읽음로 표시 
         $('#alarmCheck').click(function(){
        	 var nidx= $('#nidx').val();
        	 $.ajax({
	        		url:"<%=request.getContextPath()%>/alarmUpdate.do",
	        		type:'post',
	        		data:{"nidx" : nidx},
	        		success:function(cnt){
	        			
	        		},
	        		error:function(){
	        			alert("에러입니다.");
	        		}
	        	});
        });
        
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
 								str="<a id='alarmCheck'class='dropdown-item d-flex align-items-center list-group-item-action list-group-item'  href=<%=request.getContextPath()%>/stuLecContent.do?sidx="+nv.sidx+"&cidx="+nv.cidx+" >"
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
									str="<a id='alarmCheck' class='dropdown-item d-flex align-items-center list-group-item-action list-group-item' >"
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
									str="<a id='alarmCheck' class='dropdown-item d-flex align-items-center list-group-item-action list-group-item' >"
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
