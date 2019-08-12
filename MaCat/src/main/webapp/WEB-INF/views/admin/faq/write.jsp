<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>공지사항 작성</title>
		<style type="text/css">
			#bbs {width:750px; margin:0 auto;}
			#bbs table {width:750px; margin:0 auto; margin-top:20px; border:1px solid black; border-collapse:collapse; font-size:14px;}
			#bbs table caption {font-size:20px; font-weight:bold; margin-bottom:10px;}
			#bbs table th {text-align:center; border:1px solid black; padding:4px 10px;}
			#bbs table td {text-align:left; border:1px solid black; padding:4px 10px;}
			.no {width:15%}
			.subject {width:30%}
			.writer {width:20%}
			.reg {width:20%}
			.hit {width:15%}
			.title{background:lightsteelblue}
			.odd {background:silver}
			.uploadImg {margin-top: 5px; margin-right: 5px;}
		</style>
		<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	    <script src="resources/js/admin/notices/write.js"></script>
	</head>
	
	<body>
		<div id="bbs" >
		<form action="nots_write_ok.mcat" method="post" encType="multipart/form-data">
			<table summary="공지사항 작성">
				<caption>공지사항 작성</caption>
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name="not_sj" size="85"/></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="not_cn" cols="87" rows="8"></textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="img" id="imgUpload" multiple/></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="작성완료"/>
							<input type="reset" value="초기화"/>
							<input type="button" value="목록" id="list"/>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="uploadImg"><img src=""></div>
		</form>
		</div>
	</body>
</html>

