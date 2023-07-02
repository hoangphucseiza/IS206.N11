package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class QuanLySachUI extends JFrame {
	JTextField txtManxb, txtTennxb, txtDiachi, txtDienthoai;
	JButton btnVeTruoc,btnVeSau;
	JLabel lblStep;
	public QuanLySachUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		
	}

	private void addControls() {
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JPanel pnCenter = new JPanel();
		JPanel pnSouth = new JPanel();
		con.add(pnNorth,BorderLayout.NORTH);
		con.add(pnCenter,BorderLayout.CENTER);
		con.add(pnSouth,BorderLayout.SOUTH);
		
		pnNorth.setLayout(new BorderLayout());
		JPanel pnChiTiet = new JPanel();
		pnNorth.add(pnChiTiet,BorderLayout.WEST);
		JPanel pnThucHien = new JPanel();
		pnNorth.add(pnThucHien,BorderLayout.CENTER);
		
		
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet,BoxLayout.Y_AXIS));
		JPanel pnNxb = new JPanel();
		JLabel lblNxb = new JLabel("Thông tin nhà xuất bản");
		pnNxb.add(lblNxb);
		pnChiTiet.add(pnNxb);
		
		JPanel pnManxb = new JPanel();
		JLabel lblManxb = new JLabel("Mã Nxb: ");
		txtManxb = new JTextField(20);
		pnManxb.add(lblManxb);
		pnManxb.add(txtManxb);
		pnChiTiet.add(pnManxb);
		
		JPanel pnTennxb= new JPanel();
		JLabel lblTennxb = new JLabel("Tên nhà xuất bản: ");
		txtTennxb = new JTextField(20);
		pnTennxb.add(lblTennxb);
		pnTennxb.add(txtTennxb);
		pnChiTiet.add(pnTennxb);
		
		JPanel pnDiachi= new JPanel();
		JLabel lblDiachi = new JLabel("Địa chỉ: ");
		txtDiachi = new JTextField(20);
		pnDiachi.add(lblDiachi);
		pnDiachi.add(txtDiachi);
		pnChiTiet.add(pnDiachi);
		
		JPanel pnDienthoai= new JPanel();
		JLabel lblDienthoai = new JLabel("Điện thoại: ");
		txtDienthoai = new JTextField(20);
		pnDienthoai.add(lblDienthoai);
		pnDienthoai.add(txtDienthoai);
		pnChiTiet.add(pnDienthoai);
	}
	public void showWindow()
	{
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
