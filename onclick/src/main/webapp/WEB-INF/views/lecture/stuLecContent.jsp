<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.onclick.app.domain.*" %>
<%LecVO lv = (LecVO)session.getAttribute("lv"); %>
<%VideoAttenDto vd =(VideoAttenDto)request.getAttribute("vd"); %>
<%ClassVo cv = (ClassVo)request.getAttribute("cv"); %>
<%ArrayList<NoticeVO> alarm =(ArrayList<NoticeVO>)session.getAttribute("alarm");  %>
<%ArrayList<EnrollDTO> stuLecList = (ArrayList<EnrollDTO>)request.getAttribute("stuLecList"); %>  
<%
LocalDate now = LocalDate.now();
LocalDate fin = LocalDate.parse(cv.getCfin(),DateTimeFormatter.ISO_DATE);

if(now.isAfter(fin)) {%>
<script type="text/javascript">
	var result='N';
	var confirm= window.confirm("출석 인정 기간이 지난 영상입니다. 시청 기록은 기록되지 않습니다."
				+"강의를 수강하시겠습니까?");
	if(!confirm){
		location.href="<%=request.getContextPath()%>/stuLecList.do?lidx=<%=lv.getLidx()%>";
	}
</script>
<% }else{%>
<script type="text/javascript">
	var result='Y';
</script>
<%} %>
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
						 <% for(EnrollDTO ed : stuLecList) { %>
						 <li> <a class="nav-link" href="<%=request.getContextPath()%>/lecHome.do?lidx=<%=ed.getLidx()%>"><%=ed.getLname() %></a></li>
	                     <% } %>
                     </ul>
				  </div>	               
	          </div>
            </form>
            <!-- heyri1019 alarm -->
          	<!-- Nav Item - Alerts -->
          	<div class="dropdown">
				<a id="alarm" class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
				    <i class="fas fa-bell fa-fw"></i>
				    <!-- Counter - Alerts -->
				    <span class="badge badge-danger badge-counter">+</span>
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
                                    <a class="nav-link" href="<%=request.getContextPath()%>/stuVideoAttend.do?lidx=<%=lv.getLidx()%>">동영상 강의 출석</a>
                                </nav>
                            	</div>
                           	<a class="nav-link" href="<%=request.getContextPath()%>/stuLecList.do?lidx=<%=lv.getLidx()%>">
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
            <!-- 강의 내용보기(학생) -->
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
								<video  id="myVideo" class="bar" style="width:100%; height:450px;" controlsList="nodownload" controls>
								  <source src="<%=cv.getCfile()%>" type="video/mp4">
								</video>
							 <% } %>
								<br>
								<div class="bd-callout bd-callout-info shadow ">
								  <div class="card-body">
								    <%=cv.getCcontents() %>
								  </div>
								</div>
								<br>
						      <div class="text-center mt-2">
						      	<button type="button" class="btn" style="width:100px;" onclick="location.href='<%=request.getContextPath()%>/stuLecList.do?lidx=<%=lv.getLidx()%>'">강의 목록</button>
						      	 | 
						      	<button type="button" class="btn" data-bs-toggle="collapse" data-bs-target="#videorecord" aria-expanded="false" aria-controls="collapseExample" style="width:100px">시청 기록</button>
								<div class="collapse" id="videorecord">
								  <div class="card card-body">
								    <!-- 재생 상태 -->
									<p>동영상 재생 <span id="videoProgress">0 / 0</span></p>	
								  </div>
								</div>
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
      //동영상 총 시간 출력 
		var video1 = document.getElementById("myVideo");
		var startTime=<%=vd.getVend()%>;
		var endTime;
		var videoFulltime;

   	 	//video data 로딩이 끝나기 않은 상태에서 duration 호출시 Nan값이 나옴 
    	//로딩이 끝난 후 시점에 duration값을 호출하고 싶다면 vdieo에 eventlistener를 이용
		video1.addEventListener('loadedmetadata', function() {
			//이전 시청종료시점부터 
			video1.currentTime=startTime;
			
			//전체 재생 시간 (초 단위 절삭)
		    videoFulltime = Math.floor(video1.duration);
		    console.log(videoFulltime);
		});
		
		//동영상 재생 시간이 바뀌면 호출되는 이벤트
		video1.addEventListener('timeupdate', function(e){
			//현재 재생 시간 (초 단위 절삭)
			var playtime = Math.floor(video1.currentTime);
		//상태 표시
		$("#videoProgress").html(playtime + " / " + videoFulltime);
		}, false);
		
		//동영상 재생되면 호출되는 이벤트
		video1.addEventListener('play', function(e){
			//현재 재생 시간 (초 단위 절삭)
			startTime = Math.floor(video1.currentTime);
			console.log("startTime :" + startTime);
		}, false);

		
		//동영상 정지되면 호출되는 이벤트
		video1.addEventListener('pause', function(e){
			//현재 재생 시간 (초 단위 절삭)
			endTime = Math.floor(video1.currentTime);
			console.log("endTime :" + endTime);	
		
			$.ajax({
        		url:"<%=request.getContextPath()%>/videoEnd.do",
        		type:'post',
        		data:{"vend" : endTime, 
        			"vstart": startTime,
        			"vfull":videoFulltime,
        			"cidx":<%=cv.getCidx()%>,
        			"vpercent":<%=vd.getVpercent()%>,
        			"result":result},
        		success:function(cnt){
        			//alert("성공입니다.");
        		},
        		error:function(){
        			alert("에러입니다.");
        		}
        	});
		
			
		}, false);
		
		 //재생이 종료되었을때 발생하는 이벤트
		video1.addEventListener('ended', function(e){
			alert("강의 수강이 완료되었습니다.");
		}, false);

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
		<style>
		/*영상 조각 방지*/ 
		video::-webkit-media-controls-timeline {
		 display : none;
		 } 
		</style>
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
