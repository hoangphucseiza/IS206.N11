package Model;

import java.sql.Date;

public class GiaiDauModel {
	private int magiai;
	private String tengiai;
	private Date ngaybatdau;
	private Date ngayketthuc;
	public int getMagiai() {
		return magiai;
	}
	public void setMagiai(int magiai) {
		this.magiai = magiai;
	}
	public String getTengiai() {
		return tengiai;
	}
	public void setTengiai(String tengiai) {
		this.tengiai = tengiai;
	}
	public Date getNgaybatdau() {
		return ngaybatdau;
	}
	public void setNgaybatdau(Date ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}
	public Date getNgayketthuc() {
		return ngayketthuc;
	}
	public void setNgayketthuc(Date ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}
	@Override
	public String toString() {
		return tengiai;
	}
	
	
}
