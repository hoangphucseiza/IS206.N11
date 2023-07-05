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
	public int layMadoidaututendoi(String tendoi)
	{
		int kq =0;
		try
		{
			String sql = "Select mad from doibong where tendoi = ? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,tendoi);
			ResultSet result = pre.executeQuery();
			kq = result.getInt("mad");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return kq ;
	}
	public ArrayList<DoiBongModel> layToanbotendoibong()
	{
		ArrayList<DoiBongModel> dsDB = new ArrayList<>();
		
		
		try
		{
			String sql = "Select tendoi from doibong ";
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet result = pre.executeQuery();
			while(result.next())
			{
				DoiBongModel DB = new DoiBongModel();
				DB.setTendoi(result.getString(1));
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
