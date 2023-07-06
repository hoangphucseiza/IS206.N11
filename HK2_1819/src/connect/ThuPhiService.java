
package connect;

import java.security.SecureRandom;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class ThuPhiService extends MySqlService {
	
	public  void themPhieuthuphi(  String makhambenh,String madichvu,int soluong)
	{	
		int thanhtien=0;
		DichVuService DVSer = new DichVuService();
		thanhtien = DVSer.layDongiatumadichvu(madichvu) * soluong;
		
		try
		{
			String sql = "Insert into thuphi values (?,?,?,?) ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,makhambenh);
			pre.setString(2,madichvu);
			pre.setInt(3,soluong);
			pre.setInt(4,thanhtien);
			pre.executeUpdate();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
	
}
