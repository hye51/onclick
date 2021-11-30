<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
  .top {
position: relative;
display: flex; 
justify-content: space-between;
padding: 0.5rem 1.4rem;
background-color: #fdd000;
vertical-align: middle;
}

 h1.infoTit {
 font-size: 20px; 
 color:#ffffff;
}

main.textBox{
padding-top: 3.4em;
text-align: center;
}

p.textContents{
margin: 1.5em 1.8em;
font-size: 1.1em;
font-weight: 200;
}

</style>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
<title>강의 평가</title>
</head>
<body>
	<div id="popup">
		 <header class="top"> 
            <h1 class="infoTit">강의 평가</h1> 
        </header>
		<main class="textBox">
            <p class="textContents">
             	평가가 완료되었습니다. 
            </p>
            
        </main>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath() %>/resources/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath() %>/resources/assets/demo/chart-area-demo.js"></script>
<script src="<%=request.getContextPath() %>/resources/assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath() %>/resources/js/datatables-simple-demo.js"></script>

</html>