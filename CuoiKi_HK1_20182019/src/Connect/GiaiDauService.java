package Connect;

import java.sql.Date;
import java.sql.PreparedStatement;

public class GiaiDauService extends MySqlService {
	public void themGiaidau( int magiai,String tengiai,Date ngaybatdau,Date ngayketthuc)
	{
		try
		{
			String sql = "Insert into giaidau(mag,tengiai,ngaybatdau,ngayketthuc) values (?,?,?,?) ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,magiai);
			pre.setString(2,tengiai);
			pre.setDate(3,ngaybatdau);
			pre.setDate(4,ngayketthuc);
			pre.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
}
