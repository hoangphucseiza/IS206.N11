package Connect;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.GiaiDauModel;

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
	public ArrayList<GiaiDauModel> layToanbotengiai()
	{
		ArrayList<GiaiDauModel> dsGD = new ArrayList<>();
		
		
		try
		{
			String sql = "Select tengiai from giaidau ";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet result = pre.executeQuery();
			while(result.next())
			{
				GiaiDauModel GD = new GiaiDauModel();
				GD.setTengiai(result.getString(1));
				dsGD.add(GD);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsGD;
	}
	
	public int layMagiaidaututengiai(String tengiai)
	{
		int kq =0;
		try
		{
			String sql = "Select mag from giaidau where tengiai = ? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,tengiai);
			ResultSet result = pre.executeQuery();
			
			kq = result.getInt("mag");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return kq ;

	}
}
