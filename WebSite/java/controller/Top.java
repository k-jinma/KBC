package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;


@WebServlet("/top")
public class Top extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Item[] items = new Item[100];		// 商品リスト※本来はコレクションで管理する

	@Override
	public void init() throws ServletException {
		// 商品の生成　※本来は永続的に管理する
		Item item1 = new Item();
		item1.no = 1;
		item1.img = "item1.jpg";
		item1.name = "裾刺繍　サス付き　ワイドパンツ";
		item1.price = 2400;
		items[0] = item1;

		Item item2 = new Item();
		item2.no = 2;
		item2.img = "item2.jpg";
		item2.name = "ぷっくりフープピアス シルバー";
		item2.price = 1580;
		items[1] = item2;

		// ダミーでいくつか商品を入れてみた
		items[2] = item2;
		items[3] = item2;
		items[4] = item2;
		items[5] = item1;
		items[6] = item1;
		items[7] = item2;
		items[8] = item1;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//商品一覧をセットする
		request.setAttribute("items", items );

		//トップページへ転送する
		ServletContext sc = request.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/top.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字エンコードの設定
		request.setCharacterEncoding("utf-8");

		//検索キーワード　※次回に機能追加？ 本来はPOSTで受け取るべきではない
		String word = request.getParameter("word");
		System.out.println( word );	// 確認用

		//トップページへ転送する
		ServletContext sc = request.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/top.jsp");
		rd.forward(request, response);

	}

}
