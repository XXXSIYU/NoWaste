package ncu.im3069.demo.app;
import java.util.Date;
import org.json.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class Member
 * Member類別（class）具有會員所需要之屬性與方法，並且儲存與會員相關之商業判斷邏輯<br>
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class Member {
    
    /** id，會員編號 */
    private int id;
    
    /** phone，會員電子郵件信箱 */
    private String phone;
    
    private String address;
    
    /** name，會員姓名 */
    private String name;
    
    /** password，會員密碼 */
    private String password;

    
    /** seller，會員之組別 */
    private Boolean seller;
    
    private String create_datetime;
    
    /** mh，MemberHelper之物件與Member相關之資料庫方法（Sigleton） */
    private MemberHelper mh =  MemberHelper.getHelper();
    
    
    /**
     * 實例化（Instantiates）一個新的（new）Member物件<br>
     * 採用多載（overload）方法進行，此建構子用於查詢會員資料時，將每一筆資料新增為一個會員物件
     *
     * @param id 會員編號
     * @param phone 會員電子信箱
     * @param password 會員密碼
     * @param name 會員姓名
     * @param login_times 更新時間的分鐘數
     * @param seller the 會員之組別
     */
    public Member(int id, String phone, String password, String name,  Boolean seller, String address, String create_datetime) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.seller = seller;
        this.address = address;
        this.create_datetime = create_datetime;
    }
    
    /**
     * 取得會員之編號
     *
     * @return the id 回傳會員編號
     */
    public int getID() {
        return this.id;
    }

    /**
     * 取得會員之電子郵件信箱
     *
     * @return the phone 回傳會員電子郵件信箱
     */
    public String getphone() {
        return this.phone;
    }
    
    /**
     * 取得會員之姓名
     *
     * @return the name 回傳會員姓名
     */
    public String getName() {
        return this.name;
    }

    /**
     * 取得會員之密碼
     *
     * @return the password 回傳會員密碼
     */
    public String getPassword() {
        return this.password;
    }
    
    public String getAddress() {
        return this.address;
    }
    

    /**
     * 取得會員資料之會員組別
     *
     * @return the seller 回傳會員組別
     */
    public Boolean getseller() {
        return this.seller;
    }
    
    public String getcreate_datetime() {
    	return this.create_datetime;
    }
    
    /**
     * 更新會員資料
     *
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {
        /** 新建一個JSONObject用以儲存更新後之資料 */
        JSONObject data = new JSONObject();
        /** 取得更新資料時間（即現在之時間）之分鐘數 */
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date current = new Date();
        this.create_datetime = sdFormat.format(current);
        /** 計算帳戶所屬之組別 */
        
        
        /** 檢查該名會員是否已經在資料庫 */
        if(this.id != 0) {
            /** 若有則將目前更新後之資料更新至資料庫中 */
            mh.updateLoginTimes(this);
            /** 透過MemberHelper物件，更新目前之會員資料置資料庫中 */
            data = mh.update(this);
        }
        
        return data;
    }
    
    /**
     * 取得該名會員所有資料
     *
     * @return the data 取得該名會員之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該名會員所需之資料全部進行封裝*/ 
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("name", getName());
        jso.put("phone", getphone());
        jso.put("password", getPassword());
        jso.put("seller", getseller());
        jso.put("address", getAddress());
        jso.put("create_datetime", getcreate_datetime());
        
        return jso;
    }


}