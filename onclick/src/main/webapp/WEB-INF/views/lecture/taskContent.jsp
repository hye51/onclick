<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ page import="com.onclick.app.domain.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%LecVO lv = (LecVO)session.getAttribute("lv"); %>
<%TaskVO tv = (TaskVO)session.getAttribute("tv"); %>
<%S_taskDTO std = (S_taskDTO)session.getAttribute("std"); %>
<%int tuidx = tv.getTuidx(); %>
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
            <!--과제 내용보기-->
            <div id="layoutSidenav_content">
	            <h3 class="mt-4 pt-3 ps-5" style="font-weight:bold">과제</h3>
                	<ol class="breadcrumb mb-4 ps-5">
                    	<li class="breadcrumb-item active"><%=tv.getTuname()%></li>
                	</ol>
            	<main>
            		<!-- 학생 과제 내용보기 -->
					<% if(session.getAttribute("sidx") != null && session.getAttribute("pidx") == null) {%>
					<div class="container-fluid px-4 ">
						<table class="table mx-auto bg-light" style="width:80%">   
							<thead>
								<tr>   
			      					<td colspan="4" scope="row" style="border:0; font-weight: 700; width:100%"><%=tv.getTuname()%></td>
			      				</tr>
							</thead>
							<tbody>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">제출기간</td>
							      	<td colspan="3" style="width:45%">
							      		<%=tv.getTustart() %> ~ <%=tv.getTufin() %>
									</td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">작성일</td>
							      	<td style="width:40%">
							      		<%=tv.getTudate() %>
							      	</td>
							      	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">제출여부</td>
							      	<%if(std.getTsubyn().equals("Y")){ %>
								      		<td style="color:blue">제출완료</td>
								    	<%} else { %>
								    		<td style="color:red">미제출</td>
								   		<%} %>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">첨부파일</td>
							    	<% if(session.getAttribute("fv") == null) {%>
							    		<td colspan="3" style="border-bottom:0;"></td>
							    	<%} else { 
							    		FileVO fv = (FileVO)session.getAttribute("fv");%>
							    		<td colspan="3" style="border-bottom:0;"><a href="<%=request.getContextPath()%>/taskFileDownload.do?fidx=<%=fv.getFidx()%>"><%=fv.getForiginname() %></a></td>
							    	<%} %>
							    </tr>
							    <tr>
							    	<td colspan="4" style="border-bottom:0"><input type="text" style="width:100%; height:300px; border:0; solid; black" value="<%=tv.getTucontents()%>" readonly></td>
							    </tr>
							</tbody>
						</table>
						<div class="form-row text-center mb-2">
							<button type="button" class="btn btn-secondary btn-sm" style="width:80px"><a style="color:white; text-decoration:none;" href="<%=request.getContextPath()%>/taskList.do?lidx=<%=tv.getLidx()%>">목록</a></button>
							<%if(std.getTsubyn().equals("Y")){ %>
						      		<button type="button" class="btn btn-secondary btn-sm" style="width:80px"><a style="color:white; text-decoration:none;" href="<%=request.getContextPath()%>/stuTaskContent.do?tidx=<%=std.getTidx()%>">제출보기</a></button>
						    	<%} else { %>
						    		<%if(tv.getTustart().compareTo(dateFormat.format(today))<=0 && tv.getTufin().compareTo(dateFormat.format(today))>=0) {%>
								    	<button type="button" class="btn btn-secondary btn-sm" style="width:80px"><a style="color:white; text-decoration:none;" href="<%=request.getContextPath()%>/stuTaskWrite.do?tuidx=<%=tv.getTuidx()%>">제출</a></button>
								    <%}%>
						   		<%} %>
							
                    	</div>
                	</div>
                	<!-- 교수 과제 내용보기 -->
					<%} else {%>
					<div class="container-fluid px-4 ">
						<table class="table mx-auto bg-light" style="width:80%">   
							<thead>
								<tr>
									<td colspan="3" scope="row" style="border:0; font-weight: 700; width:90%"><%=tv.getTuname()%></td>
						      		<td style="border:0; width:10%; text-align:right">
							      		<div class="dropdown">
											<button class="btn btn-secondary bg-light" style="border: none; background: none; " type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
											    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="gray" class="bi bi-three-dots-vertical mx-auto d-block" viewBox="0 0 16 16">
												  <path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
												</svg>
										  	</button>
												<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
												    <li><a class="dropdown-item" href="<%=request.getContextPath() %>/taskModify.do?tuidx=<%=tv.getTuidx()%>">수정하기</a></li>
												    <li><a class="dropdown-item" onclick="del(${tuidx})">삭제하기</a></li>
											  	</ul>
										</div>
									</td>
								</tr>
							</thead>
							<tbody>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">제출기간</td>
							      	<td colspan="3" >
							      		<%=tv.getTustart() %> ~ <%=tv.getTufin() %>
									</td>
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">작성일</td>
							      	<td colspan="3">
							      		<%=tv.getTudate() %>
							      	</td>	
							    </tr>
							    <tr>
							    	<td scope="row" class="text-secondary" style="border-bottom:0; text-align:left; font-weight: 700; width:10%">첨부파일</td>
							    	<% if(session.getAttribute("fv") == null) {%>
							    		<td colspan="3" style="border-bottom:0;"></td>
							    	<%} else { 
							    		FileVO fv = (FileVO)session.getAttribute("fv");%>
							    		<td colspan="3" style="border-bottom:0;"><a href="<%=request.getContextPath()%>/fileDownload.do?fidx=<%=fv.getFidx()%>"><%=fv.getForiginname() %></a></td>
							    	<%} %>
							    </tr>
							    <tr>
							    	<td colspan="4" style="border-bottom:0"><input type="text" style="width:100%; height:300px; border:0; solid;" value="<%=tv.getTucontents()%>" readonly></td>
							    </tr>
							</tbody>
						</table>
						<div class="form-row text-center mb-2">
							<button type="button" class="btn btn-secondary btn-sm" style="width:80px" onclick="location.href='<%=request.getContextPath()%>/taskList.do?lidx=<%=tv.getLidx()%>'">목록</button>
                    	</div>
                	</div>
			      	<%} %>		    
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2021</div>
                            <div >
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
        	
			function del(tuidx) {
				var value = confirm("삭제하시겠습니까?");
				if (value == true) {
					location = '${pageContext.request.contextPath}/taskDeleteAction.do?tuidx='+tuidx;
				}
			};	
			
		</script>
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