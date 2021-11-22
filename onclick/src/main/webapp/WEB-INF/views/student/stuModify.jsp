<!-- 211027 jhr 작업 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.onclick.app.domain.*" %>    
<% StudentVO sv = (StudentVO)request.getAttribute("sv"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>정보 수정</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="../resources/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="<%=request.getContextPath()%>">
           	<img alt="" src="../resources/assets/img/ex.png" id="logo">
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
						<img alt="" src="../resources/assets/img/user.png">
							홍길동님
						</div>
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Interface</div>
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
                                    <a class="nav-link" href="<%=request.getContextPath()%>/lecture/home.do">강의1</a>
                                    <a class="nav-link" href="layout-static.html">강의1</a>
                                    <a class="nav-link" href="layout-static.html">강의1</a>
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
                        <h1 class="mt-4">Mypage</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">정보 수정</li>
                        </ol>
                        <form name="frm">
                        	<div class="row justify-content-center py-5">
	                        	<!-- 211027 -->
								<div class="row mb-3">
								  <label class="col-sm-2 col-form-label">비밀번호 변경</label>
								  <div class="col-sm-6">
								    <input type="password" class="form-control" name="spwd" value="<%=sv.getSpwd()%>">
								  </div>
								</div>
								<div class="row mb-3">
								  <label class="col-sm-2 col-form-label">비밀번호 확인</label>
								  <div class="col-sm-6">
								    <input type="password" class="form-control" name="spwd2">
								  </div>
								</div>
								<div class="row mb-3">
								  <label class="col-sm-2 col-form-label">이메일</label>
									<div class="col-sm-6">
										<div class="input-group mb-3">
										  <input type="text" class="form-control" value="" name="semail1">
										  <span class="input-group-text">@</span>
										  <input type="text" class="form-control" value="" name="semail2" >
										</div>
									</div>
								</div>
								<div class="row mb-3">
								  <label class="col-sm-2 col-form-label">연락처</label>
								  <div class="col-sm-2">
								    <input type="text" class="form-control" value="" name="sphone1">
								  </div>
								  -
								  <div class="col-sm-2">
								    <input type="text" class="form-control" value="" name="sphone2" >
								  </div>
								  -
								  <div class="col-sm-2">
								    <input type="text" class="form-control" value="" name="sphone3">
								  </div>
								</div>
							</div>
								<button type="button" class="btn btn-primary" onclick="modify(); return false;">수정</button>
								<button type="reset" class="btn btn-primary" >취소</button>
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
        <script src="../resources/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="../resources/assets/demo/chart-area-demo.js"></script>
        <script src="../resources/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="../resources/js/datatables-simple-demo.js"></script>
    	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script type="text/javascript">
        //emil split
        var beforeEmail= "<%=sv.getSemail()%>";
        var afterEmail = beforeEmail.split('@');
        $('input[name=semail1]').attr('value',afterEmail[0]);
        $('input[name=semail2]').attr('value',afterEmail[1]);
        
        //phone split
        var beforePhone= "<%=sv.getSphone()%>";
        var afterPhone = beforePhone.split('-');
        $('input[name=sphone1]').attr('value',afterPhone[0]);
        $('input[name=sphone2]').attr('value',afterPhone[1]);
        $('input[name=sphone3]').attr('value',afterPhone[2]);
        
        function modify(){
        	var fm = document.frm;
        	 if(fm.semail1.value == "" || fm.semail2.value == "" ){
 				fm.semail1.focus();
 				alert("이메일을 입력하세요");
 				return false;
        	 }else if(fm.sphone1.value == "" || fm.sphone2.value == ""){
				fm.pphone1.focus();
				alert("연락처를 입력하세요");
				return false;
			}
			fm.action="<%=request.getContextPath()%>/student/stuModifyAction.do";
			fm.method = "post";
			fm.submit();
			return;
        };
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
