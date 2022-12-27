package ncu.im3069.demo.app;

import org.json.*;

import java.util.*;

public class TempFood {

    /** id，會員編號 */
    private int id;

    /** id，會員編號 */
    private String name;

    private String address;
    
    private int food_seller_id;
    /** id，會員編號 */
    private double price;

    /** id，會員編號 */
    private String image;

    /** id，會員編號 */
	private String describe;
	
	private int stock;
	
	private boolean if_raw;
	
	private Date exp;


    /**
     * 實例化（Instantiates）一個新的（new）Product 物件<br>
     * 採用多載（overload）方法進行，此建構子用於新增產品時
     *
     * @param name 產品名稱
     * @param price 產品價格
     * @param image 產品圖片
     */
	public TempFood(int id, String name, double price, String image, String address, Date exp, boolean if_raw, int food_seller_id, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.exp = exp;
		this.if_raw = if_raw;
		this.address = address;
		this.food_seller_id = food_seller_id;
		this.stock = stock;
	}

    /**
     * 實例化（Instantiates）一個新的（new）Product 物件<br>
     * 採用多載（overload）方法進行，此建構子用於修改產品時
     *
     * @param id 產品編號
     * @param name 產品名稱
     * @param price 產品價格
     * @param image 產品圖片
     * @param describe 產品敘述
     */
	public TempFood(int id, String name, double price, String image, String address, String describe, Date exp, boolean if_raw, int food_seller_id, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.describe = describe;
		this.exp = exp;
		this.if_raw = if_raw;
		this.address = address;
		this.food_seller_id = food_seller_id;
		this.stock = stock;
	}

    /**
     * 取得產品編號
     *
     * @return int 回傳產品編號
     */
	public int getID() {
		return this.id;
	}

    /**
     * 取得產品名稱
     *
     * @return String 回傳產品名稱
     */
	public String getName() {
		return this.name;
	}

    /**
     * 取得產品價格
     *
     * @return double 回傳產品價格
     */
	public double getPrice() {
		return this.price;
	}

    /**
     * 取得產品圖片
     *
     * @return String 回傳產品圖片
     */
	public String getImage() {
		return this.image;
	}

    /**
     * 取得產品敘述
     *
     * @return String 回傳產品敘述
     */
	public int getFood_seller_id() {
		return this.food_seller_id;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public Date getExp() {
		return this.exp;
	}

	public boolean getIf_raw() {
		return this.if_raw;
	}
	
	public String getDescribe() {
		return this.describe;
	}


    /**
     * 取得產品資訊
     *
     * @return JSONObject 回傳產品資訊
     */
	public JSONObject getData() {
        /** 透過JSONObject將該項產品所需之資料全部進行封裝*/
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("name", getName());
        jso.put("price", getPrice());
        jso.put("image", getImage());
        jso.put("address", getAddress());
        jso.put("stock", getStock());
        jso.put("if_raw", getIf_raw());
        jso.put("exp", getExp());
        jso.put("food_seller_id", getFood_seller_id());
        jso.put("describe", getDescribe());

        return jso;
    }
}