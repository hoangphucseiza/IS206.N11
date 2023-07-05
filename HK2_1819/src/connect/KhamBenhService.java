package connect;

import java.security.SecureRandom;
import java.sql.Date;
import java.sql.PreparedStatement;


public class KhamBenhService extends MySqlService {
	public String generateRandomString(int length) {
	    String characters = "KB0123456789";
	    SecureRandom random = new SecureRandom();
	    StringBuilder sb = new StringBuilder(length);

	    for (int i = 0; i < length; i++) {
	        int randomIndex = random.nextInt(characters.length());
	        char randomChar = characters.charAt(randomIndex);
	        sb.append(randomChar);
	    }

	    return sb.toString();
	}
	public  void themLichkham(  String mabenhnhan,Date ngaykham,String yeucaukham,String tenbacsi)
	{	String makhambenh= generateRandomString(3);
		String mabacsi;
		BacSiService bsSer = new BacSiService();
		mabacsi = bsSer.layMabacsituTenbacsi(tenbacsi);
		String ketluan ="";
		String thanhtoan ="";
		try
		{
			String sql = "Insert into khambenh values (?,?,?,?,?,?,?) ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,makhambenh);
			pre.setString(2,mabenhnhan);
			pre.setString(3,mabacsi);
			pre.setDate(4,ngaykham);
			pre.setString(5,yeucaukham);
			pre.setString(6,ketluan);
			pre.setString(7,thanhtoan);
			pre.executeUpdate();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
	
}
