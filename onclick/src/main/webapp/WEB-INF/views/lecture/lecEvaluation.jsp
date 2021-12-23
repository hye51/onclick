<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%int vidx = (Integer)request.getAttribute("vidx"); %>
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
             	수강 완료된 강의에 대한 강의 평가를 진행해주세요.<br>
             	강의 평가가 완료되어야 출석으로 인정됩니다.
             	(강의 평가는 수정이 불가합니다.)
            </p>
            <form name="frm">
            <input type="radio" name="vlevel" value="1"> 매우 쉬움 
            <input type="radio" name="vlevel" value="2"> 쉬움 
            <input type="radio" name="vlevel" value="3"> 보통 
            <input type="radio" name="vlevel" value="4"> 어려움  
            <input type="radio" name="vlevel" value="5"> 매우 어려움  
            <input type="textarea" name="vcontents" value="vcontents" placeholder="기타 전달 할 말이 있으면 작성해주세요">
            <br>
            <button type="button" class="btn btn-warning mt-4" style=" padding: 10px 10px;"onclick="check(); return false;">제출</button>
        	</form>
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

<script type="text/javascript">
//강의평가 
function check(){
	var fm =document.frm;
	
	if(fm.vlevel.value==""){
		fm.vlevel.focus();
		alert("강의 평가를 해주세요.");
		return false;
	}else if(fm.vcontents.value==""){
		fm.vcontents.focus();
		alert("강의 평가를 해주세요.");
		return false;
	}
	
	fm.action="<%=request.getContextPath()%>/lecEvaluationAction.do?vidx=<%=vidx%>";
	fm.method="post";
	fm.submit();
 	opener.location.reload();
	return;
	
}

</script>
</html>