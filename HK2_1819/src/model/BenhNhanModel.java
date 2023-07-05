package model;

import java.sql.Date;

public class BenhNhanModel {
	private String mabenhnhan;
	private String tenbenhnhan;
	private Date ngaysinh;
	private String diachi;
	private String dienthoai;
	private String gioitinh;
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getMabenhnhan() {
		return mabenhnhan;
	}
	public void setMabenhnhan(String mabenhnhan) {
		this.mabenhnhan = mabenhnhan;
	}
	public String getTenbenhnhan() {
		return tenbenhnhan;
	}
	public void setTenbenhnhan(String tenbenhnhan) {
		this.tenbenhnhan = tenbenhnhan;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getDienthoai() {
		return dienthoai;
	}
	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}
	
	
}
