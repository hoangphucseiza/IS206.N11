package connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BacSiModel;
import model.DichVuModel;

public class DichVuService extends MySqlService {
	public ArrayList<DichVuModel> layDanhsachDichvu()
	{
		ArrayList<DichVuModel> dsDv = new ArrayList<>();
		
		try {
			String sql = "Select * from dichvu";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet result = pre.executeQuery();
			while(result.next())
			{
				DichVuModel DV = new DichVuModel();
				DV.setTendichvu(result.getString("tendv"));
				dsDv.add(DV);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dsDv;
	}
}
