<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Login - SB Admin</title>
        <link href="../app/resources/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-light">
         <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark p-3">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-4" href="index.html">학교로고  | ONclick</a>
         </nav>   
      <div id="univPhoto" class="bg-secondary" >
      		<h4 class="text-light">학교사진</h4>
      </div>
      <div id="layoutLogin" class="position-absolute top-50 end-0 translate-middle-y bg-light" >
		<main>
               <div id="layoutLogin_contents" style=" border-radius:0px" >
	               <div class="card  border-0 rounded-0 mt-5 ">
	                   <h3 class="text-center font-weight-light my-3">Login</h3>
	                   <p class="text-center text-dark" style="font-size:small">교수님께서는 재직 중인 개인 사번으로 로그인해주십시오</p>
	                   <div class="card-body" style="">
	                    	<form>
                             	<div class="dropdown mb-2">
	  							<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
	    						선택  
	    						</button>
	  							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							    	<li><a class="dropdown-item" name="student">학생</a></li>
							    	<li><a class="dropdown-item" name="professor">교수</a></li>
							  	</ul>
								</div>
                               <div class="form-floating mb-3">
                                     <input class="form-control" id="inputId" type="text" placeholder="Id"  />
                                     <label for="inputId">학번/사번</label>
                                 </div>
                                 <div class="form-floating mb-3">
                                     <input class="form-control" id="inputPassword" type="password" placeholder="Password" />
                                     <label for="inputPassword">비밀번호</label>
                                 </div>
                                 <div class="form-check mb-3">
                                     <input class="form-check-input" id="inputRememberId" type="checkbox" value="" />
                                     <label class="form-check-label" for="inputRememberId">학번/사번 저장</label>
                                 </div>
                                 <div class="d-flex align-items-center justify-content-end mt-4 mb-0">
                                 <!-- 권한에 따라 로그인 성공시 연결되는 url이 달라야함  -->
                                     <a class="btn btn-primary" href="<%=request.getContextPath()%>/stuDashBoard.do">로그인</a>
                                 </div>
                             </form>
                         </div>
	                         <div class="card-footer text-center py-3" >
	                             <div class="small"><a href="<%=request.getContextPath()%>/join.do">회원가입</a> | <a href="<%=request.getContextPath()%>/find.do">아이디/비밀번호 찾기</a></div>
	                         </div>
	                     </div>
           			</div>
			</main>
       </div>      
         <div id="layoutAuthentication_footer" class="fixed-bottom bg-dark">
                <footer class="py-4 mt-auto bg-dark">
                    <div class="container-fluid px-4 bg-dark">
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath() %>/resources/js/scripts.js"></script>
    </body>
</html>

