package Connect;

import java.sql.PreparedStatement;

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
}
