<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" as="style" crossorigin 
    href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.8/dist/web/static/pretendard.css" />
    
    <style type="text/css">
        * {
            font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, "Helvetica Neue", "Segoe UI", "Apple SD Gothic Neo", "Noto Sans KR", "Malgun Gothic", "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", sans-serif;
        }
    </style>
<link href="/resources/img/favicon.ico" rel="icon">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
<link href="/resources/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
<link href="/resources/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/style.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	$(document).ready(function() {
		
		$("tr").click(function() {
	      var ma_id = $(this).find("td:eq(0)").text();
	      var ma_num = $(this).find("td:eq(1)").text();
	      var ma_name = $(this).find("td:eq(2)").text();
			
	      opener.document.getElementById("ma_id").value = ma_id;
	      opener.document.getElementById("ma_num").value = ma_num;
	      opener.document.getElementById("ma_name").value = ma_name;
	      
	      window.close();
	      
		});
	});
</script>

</head>
<body>

	<h3>자재</h3>
	
	<form action="" method="GET">
		<input type="hidden" name="txt" value="ma">
		<input type="hidden" name="ma_num" value="">
		
		<input type="text" placeholder="자재명을 입력하세요." name="ma_name" value="${mvo.ma_name }">
		<input type="submit" value="검색">
	</form>	
	
	<table border="1">
	
		<tr>
			<th>자재 id</th>
			<th>자재 코드</th>
			<th>자재명</th>
		</tr>
		
		<c:forEach items="${popUpMate }" var="vo">
		<tr>
			<td>${vo.ma_id }</td>
			<td>${vo.ma_num }</td>
			<td>${vo.ma_name }</td>
		</tr>
		</c:forEach>
		
	</table>
	
	<br>
	
	<!-- 페이징 버튼 -->
	
	<nav aria-label="Page navigation example">
  		<ul class="pagination justify-content-center pagination-sm">
  		
  			<c:if test="${pm.prev }">
			<li class="page-item">
				<a class="page-link" href="/info/req/addPopup?page=${pm.startPage-1 }&txt=ma&ma_num=${mvo.ma_num}&ma_name=${mvo.ma_name}" aria-label="Previous">
       			<span aria-hidden="true">&laquo;</span>
      			</a>
    		</li>
    		</c:if>
    		
    		<c:forEach begin="${pm.startPage }" end="${pm.endPage }" step="1" var="idx">
    		<li 
    			<c:out value="${pm.pageVO.page == idx ? 'class=page-item active': 'class=page-item'}" />
    		>
    			<a class="page-link" href="/info/req/addPopup?page=${idx}&txt=ma&ma_num=${mvo.ma_num}&ma_name=${mvo.ma_name}">${idx }</a>
    		</li>
    		</c:forEach>
			
			<c:if test="${pm.next && pm.endPage > 0}">
			<li class="page-item">
      			<a class="page-link" href="/info/req/addPopup?page=${pm.endPage+1 }&txt=ma&ma_num=${mvo.ma_num}&ma_name=${mvo.ma_name}" aria-label="Next">
        		<span aria-hidden="true">&raquo;</span>
      			</a>
    		</li>
    		</c:if>
    		
  		</ul>
	</nav>
	
	<!-- 페이징 버튼 -->

</body>
</html>