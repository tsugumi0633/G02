package model;

import java.io.Serializable;

public class Goods implements Serializable{
	private int id;
	private String goodsCode; //商品コード
	private String goodsName; //商品名
	private int price; //商品単価
	private int stock; //在庫数
	private String image; //商品画像ファイル名
	
	public Goods() {}

	public Goods(String goodsCode, String goodsName, int price, int stock, String image) {
		super();
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.price = price;
		this.stock = stock;
		this.image = image;
	}
	
	public Goods(int id, String goodsCode, String goodsName, int price, int stock,
			String image) {

			this.id = id;
			this.goodsCode = goodsCode;
			this.goodsName = goodsName;
			this.price = price;
			this.stock = stock;
			this.image = image;
			}
			public int getId() {
			return id;
			}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}