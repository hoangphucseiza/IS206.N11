package Connect;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.GiaiDauModel;
public class TranDauService extends MySqlService {
	public void themTranDau(  Date ngayda, String diadiem, int magiai, int madoinha, int madoikhach, String tiso)
	{
		try
		{
			String sql = "Insert into giaidau(ngayda,diadiem,mag,madn,madk,tiso) values (?,?,?,?,?,?) ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setDate(1,ngayda);
			pre.setString(2,diadiem);
			pre.setInt(3,magiai);
			pre.setInt(4,madoinha);
			pre.setInt(5,madoikhach);
			pre.setString(6,tiso);
			pre.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
	
}
