package Test;
import UI.ChiTietGiaiDauUI;
import UI.ThemDoiUI;
import UI.ThemGiaiDauUI;
public class Test {

	public static void main(String[] args) {
		/*ThemDoiUI TD = new ThemDoiUI("Thêm Đội");
		TD.showWindow();
		
		ThemGiaiDauUI TGD = new ThemGiaiDauUI("Thêm giải đấu");
		TGD.showWindow();*/

		ChiTietGiaiDauUI CTGD = new ChiTietGiaiDauUI("Chi tiết giải đấu");
		CTGD.showWindow();
	}

}
