<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">

	<title>ショッピングサイト</title>

	<!-- Bootstrap CDN -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

	<style>
		.title {
			width: 150px;
			height: 50px;
		}
		.item{
			width: 250px;
			height: 250px;
		}

		.container{
			margin-top: 30px;
		}
		h1 {
			font-size: 24px;
		}

	</style>
</head>
<body>

	<div class="container">
		<form action="top" method="post">
			<div class="row">
				<div class="col-3"><img class="title" src="img/logo.jpg"  /></div>
				<div class="col-5">
					<input class="form-control form-control-sm" type="text" placeholder="なにをお探しですか？" name="word" >
				</div>
				<div class="col-4">
					<input type="submit"  class="btn btn-info"  value="検索">
				</div>
			</div>
		</form>

		<%
			// 検索キーワードを取得
			String word = request.getParameter("word");
			if( word != null ){
				out.println( "検索ワードは『" + word + "』");
			}
			// 商品一覧を取得
			Item[] items = (Item[])request.getAttribute("items");

		%>
		<div class="row">
			<div class="col"><h1>商品一覧</h1></div>
		</div>

		<%
			// 商品があれば（itemsが空でなければ）テーブルを表示する
			if( items != null ){
		%>
			<table>
				<%
					// 商品数をカウントする
					int count = 0;	// 商品数
					while(  items[count] != null ){
						count++;
					}

					int col = 4;	//列数
					int row = count / col + 1;	 //テーブルの行数
					int cell = count % col;	// 余りの列数

					for( int i = 0; i < row; i++ ){		// 行ループ
				%>
					<tr>
					<%
						for( int j = 0; j < col; j++ ){		// 列ループ
						 %>
						 	<%
						 		if( items[ i * col +j ] != null ) {		// 最後の行で表示しない箇所はデータがないので、”ない＝null”を判定
						 	%>
								<td>
									<img class="item" src="img/<%= items[ i * col +j ].img %>"><br>
									<%= items[ i * col +j ].name %>　
									<%= items[ i * col +j ].price %>円
								</td>
							<%
						 		}	//End if
							%>

						<%
							}	// End for
						%>
					</tr>
				<%
					}	// End for
				%>
			</table>

		<%
			}	// End if
		 %>
	</div>

</body>
</html>