package Model;

import java.sql.Date;

public class TranDauModel {
	private int matran;
	private Date ngayda;
	private String diadiem;
	private int magiai;
	private int madoinha;
	private int madoikhach;
	private String tiso;
	public int getMatran() {
		return matran;
	}
	public void setMatran(int matran) {
		this.matran = matran;
	}
	public Date getNgayda() {
		return ngayda;
	}
	public void setNgayda(Date ngayda) {
		this.ngayda = ngayda;
	}
	public String getDiadiem() {
		return diadiem;
	}
	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}
	public int getMagiai() {
		return magiai;
	}
	public void setMagiai(int magiai) {
		this.magiai = magiai;
	}
	public int getMadoinha() {
		return madoinha;
	}
	public void setMadoinha(int madoinha) {
		this.madoinha = madoinha;
	}
	public int getMadoikhach() {
		return madoikhach;
	}
	public void setMadoikhach(int madoikhach) {
		this.madoikhach = madoikhach;
	}
	public String getTiso() {
		return tiso;
	}
	public void setTiso(String tiso) {
		this.tiso = tiso;
	}
	
}
