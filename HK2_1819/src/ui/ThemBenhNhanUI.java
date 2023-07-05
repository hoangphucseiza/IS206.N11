package ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connect.BenhNhanService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;  
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.util.Vector;
public class ThemBenhNhanUI extends JFrame {
	JTextField txtMabenhnhan, txtTenbenhnhan, txtNgaysinh, txtDiachi, txtDienthoai;
	JComboBox cbxGioitinh;
	JButton btnThem;
	public ThemBenhNhanUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	private void addEvents() {
		btnThem.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						BenhNhanService BNSer = new BenhNhanService();
						BNSer.themBenhnhan(txtMabenhnhan.getText(),txtTenbenhnhan.getText(),Date.valueOf(txtNgaysinh.getText()),txtDiachi.getText() , txtDienthoai.getText(), cbxGioitinh.getSelectedItem().toString());
					}
			
				});
		
	}
	private void addControls() {
		Container conn =  getContentPane();
		conn.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JPanel pnCenter = new JPanel();
		JPanel pnSouth = new JPanel();
		conn.add(pnCenter,BorderLayout.CENTER);
		conn.add(pnSouth,BorderLayout.SOUTH);
		
		pnCenter.setLayout(new BoxLayout(pnCenter,BoxLayout.Y_AXIS));
		
		
		JPanel pnMabenhnhan = new JPanel();
		JLabel lblMabenhnhan = new JLabel("Mã bệnh nhân");
		txtMabenhnhan = new JTextField(25);
		pnMabenhnhan.add(lblMabenhnhan);
		pnMabenhnhan.add(txtMabenhnhan);
		pnCenter.add(pnMabenhnhan);
		
		JPanel pnTenbenhnhan = new JPanel();
		JLabel lblTenbenhnhan = new JLabel("Tên bệnh nhân");
		txtTenbenhnhan = new JTextField(25);
		pnTenbenhnhan.add(lblTenbenhnhan);
		pnTenbenhnhan.add(txtTenbenhnhan);
		pnCenter.add(pnTenbenhnhan);
		
		
		JPanel pnNgaysinh = new JPanel();
		JLabel lblNgaysinh = new JLabel("Ngày sinh");
		txtNgaysinh = new JTextField(25);
		pnNgaysinh.add(lblNgaysinh);
		pnNgaysinh.add(txtNgaysinh);
		pnCenter.add(pnNgaysinh);
		
		JPanel pnDiachi = new JPanel();
		JLabel lblDiachi = new JLabel("Địa chỉ");
		txtDiachi = new JTextField(25);
		pnDiachi.add(lblDiachi);
		pnDiachi.add(txtDiachi);
		pnCenter.add(pnDiachi);
	
		
		JPanel pnDienthoai = new JPanel();
		JLabel lblDienthoai = new JLabel("Địện thoại");
		txtDienthoai = new JTextField(25);
		pnDienthoai.add(lblDienthoai);
		pnDienthoai.add(txtDienthoai);
		pnCenter.add(pnDienthoai);
		
		
		JPanel pnGioitinh = new JPanel();
		JLabel lblGioitinh = new JLabel("Giới tính");
		cbxGioitinh = new JComboBox(new String[]{"Nam", "Nữ"});
		pnGioitinh.add(lblGioitinh);
		pnGioitinh.add(cbxGioitinh);
		pnCenter.add(pnGioitinh);
		btnThem = new JButton("Thêm");
		
		
		pnSouth.add(btnThem);
	}
	public void showWindow()
	{
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	};
}
