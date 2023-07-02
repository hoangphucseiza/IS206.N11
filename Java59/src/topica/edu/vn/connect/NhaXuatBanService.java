package topica.edu.vn.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import topica.edu.vn.connect.MySqlService;
import topica.edu.vn.model.NhaXuatBan;

public class NhaXuatBanService extends MySqlService {
	public ArrayList<NhaXuatBan> layToanBoNhaXuatBan()
	{
		ArrayList<NhaXuatBan> dsNxb = new ArrayList<NhaXuatBan>();
		try
		{
			String sql = "select * from nhaxuatban";
			PreparedStatement preStatement = conn.prepareStatement(sql);
			ResultSet result = preStatement.executeQuery();
			while(result.next())
			{
				NhaXuatBan nxb = new NhaXuatBan();
				nxb.setMaNhaXuatBan(result.getString(1));
				nxb.setTenNhaXuatBan(result.getString(2));
				nxb.setDiaChi(result.getString(3));
				nxb.setDienThoai(result.getString(4));
				dsNxb.add(nxb);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsNxb;
	}
	public boolean themNhaXuatBan(String maNhaXuatBan, String tenNhaXuatBan,String diaChi,String dienThoai)
	{
		
		
		try
		{
			String sql ="Insert into nhaxuatban(Manhaxuatban,Tennhaxuatban,diachi,soPhone) values (?,?,?,?)";
			PreparedStatement preStatement = conn.prepareStatement(sql);
			preStatement.setString(1,maNhaXuatBan);
			preStatement.setString (2,tenNhaXuatBan);
			preStatement.setString (3,diaChi);
			preStatement.setString (4,dienThoai);
			int rowsInserted = preStatement.executeUpdate();
			 if (rowsInserted > 0) {
		            return true;
		        }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

}
