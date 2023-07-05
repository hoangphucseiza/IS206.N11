package Connect;

import java.sql.PreparedStatement;

public class ChiTietGiaiDauService extends MySqlService {
	public void themCT_GD(int magiai, int madoi)
	{
		try
		{
			String sql = "Insert into ct_gd(mag,mad) values (?,?) ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,magiai);
			pre.setInt(2,madoi);
			pre.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
