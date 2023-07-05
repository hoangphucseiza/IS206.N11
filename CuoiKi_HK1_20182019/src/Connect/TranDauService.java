package Connect;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.GiaiDauModel;
public class TranDauService extends MySqlService {
	public void themTranDau(  int matran, Date ngayda, String diadiem, int magiai, int madoinha, int madoikhach, String tiso)
	{
		try
		{
			String sql = "Insert into giaidau(mat,ngayda,diadiem,mag,madn,madk,tiso) values (?,?,?,?,?,?,?) ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,matran);
			pre.setDate(2,ngayda);
			pre.setString(3,diadiem);
			pre.setInt(4,magiai);
			pre.setInt(5,madoinha);
			pre.setInt(6,madoikhach);
			pre.setString(7,tiso);
			pre.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
