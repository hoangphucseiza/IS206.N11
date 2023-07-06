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

	public int layDongiatumadichvu(String madichvu) {
		int dongia =0;
		try {
			String sql = "Select dongia from dichvu where madv = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,madichvu);
			ResultSet result = pre.executeQuery();
			while(result.next())
			{
				dongia = result.getInt("dongia");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return dongia;
	}

	public String laymadichvututendichvu(String tendichvu) {
		
		String madichvu="";
		try {
			String sql = "Select madv from dichvu where tendichvu = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,tendichvu);
			ResultSet result = pre.executeQuery();
			while(result.next())
			{
				madichvu = result.getString("madv");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return madichvu;
	}
}
