package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Goods;

public class GoodsDAO {
/**
* テーブルの中から、すべてのレコードを返すメソッド
* @return リスト
*/
	public List<Goods> get() {
		List<Goods> list= new ArrayList<>();
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			//SQL文を定義(goodscodeの昇順)
			String sql = "SELECT * FROM goods ORDER BY goodscode ASC";
			//PreparedStatement
			PreparedStatement pstmt = cn.prepareStatement(sql);
			//SQL文を実行
			ResultSet rs = pstmt.executeQuery();
			// データをリストに格納
		 while (rs.next()) {
             Goods goods = rs2model(rs);
             list.add(goods);
         }
			} catch(SQLException e) {
				e.printStackTrace();
				}
		return list;
	}
	/**
     * テーブルの中から、主キーがidであるレコードを返すメソッド
     * @param id 主キーの値
     * @return レコード
     */
     public Goods get(int id) {
         Goods goods = null;
         DBManager manager = DBManager.getInstance();
         try(Connection cn = manager.getConnection()) {
         //SQL文を定義
         String sql = "SELECT * FROM goods WHERE id = ?";
         //PreparedStatement
         PreparedStatement pstmt = cn.prepareStatement(sql);
         //プレースフォルダに値をセット
         pstmt.setInt(1, id);
         //SQL文を実行
         try (ResultSet rs = pstmt.executeQuery()) {
         //データがあればgoodsインスタンス作成
              if (rs.next()) {
                  goods = rs2model(rs);
              }
         }
         } catch(SQLException e) {
         e.printStackTrace();
         }
         return goods;
     }
	
/**
* ResultSetの行データをモデルの形に変換するメソッド
* @param rs 変換前のデータ
* @return 変換後のデータ
*/
	private Goods rs2model(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
        String code = rs.getString("goodscode");
        String name = rs.getString("goodsname");
        int price = rs.getInt("price");
        int stock = rs.getInt("stock");
        String image = rs.getString("image");
        
    return new Goods(id,code,name,price,stock,image);
    }
	
	public List<Goods> search(String keyword) {
		List<Goods> list=new ArrayList<>();
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM goods WHERE goodsname LIKE ? ORDER BY goodscode ASC";
			PreparedStatement pstmt = cn.prepareStatement(sql);
			//プレースフォルダに値をセット
			 pstmt.setString(1, "%" + keyword + "%");
			//SQL文を実行
			 try (ResultSet rs = pstmt.executeQuery()) {
		            // データをリストに格納
		            while (rs.next()) {
		                Goods goods = rs2model(rs);
		                list.add(goods);
		            }
		        }
			 } catch(SQLException e) {
				 e.printStackTrace();
				 }

		return list;
		}
}