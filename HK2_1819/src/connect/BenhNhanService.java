package connect;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

import model.BenhNhanModel;



public class BenhNhanService extends MySqlService {
	public  void themBenhnhan( String mabenhnhan,String tenbenhnhan,Date ngaysinh,String diachi,String dienthoai, String gioitinh)
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
	
	public String layTenbenhnhantumabenhnhan( String mabenhnhan)
	{
		String tenbn = "";
		try
		{
			String sql = "Select tenbn from benhnhan where mabn = ? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1,mabenhnhan);
			ResultSet result =	pre.executeQuery();
			if(result.next())
			{
				tenbn = result.getString("tenbn");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return tenbn;

	}
	
	public ArrayList<BenhNhanModel> layTenbenhnhantungaykhamvatenbacsi( Date ngaykham, String tenbacsi)
	{
		ArrayList<BenhNhanModel> dsBn = new ArrayList<>();
		try
		{
			String sql = "Select tenbn from benhnhan,khambenh,bacsi where benhnhan.mabn = khambenh.mabn and bacsi.mabs = khambenh.mabs and ngaykham =? and tenbs =? ";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setDate(1,ngaykham);
			pre.setString(2,tenbacsi);
			ResultSet result =	pre.executeQuery();
			if(result.next())
			{
				BenhNhanModel bn= new BenhNhanModel();
				bn.setTenbenhnhan(result.getString("tenbn"));
				dsBn.add(bn);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsBn;

	}
	
	
}
