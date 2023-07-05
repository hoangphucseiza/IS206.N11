package Connect;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

import Model.GiaiDauModel;
public class TranDauService extends MySqlService {
	public int generateRandomInt(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min + 1) + min;
	}
	public void themTranDau(  Date ngayda, String diadiem, int magiai, int madoinha, int madoikhach, String tiso)
	{
		try
		{
			int mat = generateRandomInt(1, 10);
			String sql = "Insert into trandau values (?,?,?,?,?,?,?) ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,mat);
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
