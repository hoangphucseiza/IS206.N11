package connect;

import java.sql.Date;
import java.sql.PreparedStatement;

public class KhamBenhService extends MySqlService {
	public  void themLichkham( String mabenhnhan,String tenbenhnhan,Date ngaysinh,String diachi,String dienthoai, String gioitinh)
	{
		try
		{
			String sql = "Insert into benhnhan values (?,?,?,?,?,?) ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,mabenhnhan);
			pre.setString(2,tenbenhnhan);
			pre.setDate(3,ngaysinh);
			pre.setString(4,diachi);
			pre.setString(5,dienthoai);
			pre.setString(6,gioitinh);
			pre.executeUpdate();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
}
