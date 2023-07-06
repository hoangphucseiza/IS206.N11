package connect;

import java.security.SecureRandom;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


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
	
	public  String layYeucaukhamtutenbenhnhan( String tenbenhnhan)
	{	
		String yeucaukham = "";
		try
		{
			String sql = "Select yeucaukham from benhnhan, khambenh where benhnhan.mabn = khambenh.mabn and tenbenhnhan =? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,tenbenhnhan);
			ResultSet result = pre.executeQuery();
			while(result.next())
			{
				yeucaukham = result.getString("yeucaukham");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return yeucaukham;

	}
	public  String layMakhambenhtutenbacsivatenbenhnhan( String tenbacsi,String tenbenhnhan)
	{	
		String makhambenh = "";
		try
		{
			String sql = "Select makb from benhnhan, khambenh, bacsi where benhnhan.mabn = khambenh.mabn "
					+ "and khambenh.mabs = bacsi.mabs and tenbacsi =? and tenbenhnhan =? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,tenbacsi);
			pre.setString(2,tenbenhnhan);
			ResultSet result = pre.executeQuery();
			while(result.next())
			{
				makhambenh = result.getString("makb");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return makhambenh;

	}
	public  void capNhatchtietkhambenh( String makhambenh, String ketluan)
	{	
		try
		{
			String sql = "Update khambenh set ketluan= ? where makb= ? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,ketluan);
			pre.setString(1,makhambenh);
			pre.executeUpdate();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
	
}
