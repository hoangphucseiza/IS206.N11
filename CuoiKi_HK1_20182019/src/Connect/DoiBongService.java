package Connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.DoiBongModel;
import Model.GiaiDauModel;

public class DoiBongService extends MySqlService {
	public boolean themDoiBong(int madoi, String tendoi, String quocgia)
	{
		try
		{
			String sql = "Insert into doibong(mad,tendoi,quocgia) values (?,?,?) ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1,madoi);
			pre.setString(2,tendoi);
			pre.setString(3,quocgia);
			int rowInserted = pre.executeUpdate();
			if(rowInserted >0)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;

	}
	
	public ArrayList<DoiBongModel> hienThithongtindoibong()
	{
		ArrayList<DoiBongModel> dsDB = new ArrayList<>();
		try
		{
			String sql = "Select mad,tendoi from doibong ";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet result = pre.executeQuery();
			while(result.next())
			{
				DoiBongModel DB = new DoiBongModel();
				DB.setMadoi(result.getInt(1));
				DB.setTendoi(result.getString(2));
				dsDB.add(DB);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return dsDB;
	}
}
