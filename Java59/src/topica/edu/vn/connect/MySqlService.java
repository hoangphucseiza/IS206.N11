package topica.edu.vn.connect;
import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.util.Properties;
public class MySqlService {
	protected Connection conn;
	public MySqlService()
	{
		try
		{
			String strlConn ="jdbc:mysql://localhost/csdlquanlysach?useUnicode=true&characterEncoding=utf-8";
			Properties pro = new Properties();
			pro.put("user", "root");
			pro.put("password", "");
			Driver driver = new Driver();
			conn = driver.connect(strlConn, pro);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
