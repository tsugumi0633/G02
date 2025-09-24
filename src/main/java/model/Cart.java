package model;

import java.io.Serializable;

public class Cart implements Serializable{
	private Goods goods;
	private int num;
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Cart() {
		
	}
	public Cart(Goods goods,int num) {
		this.goods = goods;
		this.num = num;
	}

}
