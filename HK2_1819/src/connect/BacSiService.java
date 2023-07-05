package connect;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

import model.BacSiModel;



public class BacSiService extends MySqlService {
	public ArrayList<BacSiModel> layDanhsachbacsi()
	{
		ArrayList<BacSiModel> dsBs = new ArrayList<>();
		
		try {
			String sql = "Select * from bacsi";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet result = pre.executeQuery();
			while(result.next())
			{
				BacSiModel BS = new BacSiModel();
				BS.setTenbacsi(result.getString("tenbs"));
				BS.setMabacsi(result.getString("mabs"));
				dsBs.add(BS);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsBs;
		
	}
	public String layMabacsituTenbacsi(String tenbacsi)
	{
		String mabs ="";
		try {
			String sql = "Select mabs from bacsi where tenbs = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,tenbacsi);
			ResultSet result = pre.executeQuery();
			while(result.next())
			{
				mabs = result.getString("mabs");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mabs;
		
	}
}
