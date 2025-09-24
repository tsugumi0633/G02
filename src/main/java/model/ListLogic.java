package model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dao.GoodsDAO;
import jakarta.servlet.ServletContext;

public class ListLogic {
	public List<Goods> get(ServletContext app) {
		List<Goods> list = new ArrayList<>();
		String filePath = "/WEB-INF/goods.txt";
		 try (InputStream is = app.getResourceAsStream(filePath);
	             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
	             
	            String rec;
	            while ((rec = br.readLine()) != null) {
	                String[] data = rec.split(",");
	                if (data.length >= 5) { 
	                	Goods goods = new Goods();
	                	goods.setGoodsCode(data[0]); // 商品コード
	                    goods.setGoodsName(data[1]); // 商品名
	                    goods.setPrice(Integer.parseInt(data[2])); // 商品単価
	                    goods.setStock(Integer.parseInt(data[3])); // 在庫数
	                    goods.setImage(data[4]); // 商品画像ファイル名
	                    list.add(goods);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return list;
		}
	
	public List<Goods> search(ServletContext app,String keyword) {
		List<Goods> list = get(app); //商品一覧リストを取得
		List<Goods> newlist = new ArrayList<>(); //リターンするリスト
		
		// listの商品名にkeywordを含む商品をnewlistに追加する
		//拡張for文、containsメソッドを使用
		for(Goods goods : list) {
			if (goods.getGoodsName().contains(keyword)) {
				newlist.add(goods);
			}
		}
		return newlist;
		}
    /**
     * DBからすべての商品リストを取得するメソッド
     * @return データベースから取得した商品リスト
     */
	
	public List<Goods> get() {
        GoodsDAO dao = new GoodsDAO();
        List<Goods> goodsList = dao.get();
        
        return goodsList;
    }
	
	public Goods get(int id) {
        GoodsDAO dao = new GoodsDAO();
        Goods goods = dao.get(id);
        
        return goods;
    }
	
	public List<Goods> search(String keyword) {
		GoodsDAO dao = new GoodsDAO();
		List<Goods> goodsList = dao.search(keyword);
    
		return goodsList;
	}
}
