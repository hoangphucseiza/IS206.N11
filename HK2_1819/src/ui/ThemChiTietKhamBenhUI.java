package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
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

public class ThemChiTietKhamBenhUI extends JFrame {
	JTextField txtNgaykham, txtKetluan, txtYeucaukham;
	JComboBox cbxTenbacsi, cbxTenbenhnhan;
	DefaultTableModel dtmDanhsachdichvu, dtmDanhsachdichvubacsichon;
	JTable tblDanhsachdichvu, tblDanhsachdichvubacsichon;
	JButton  btnThem;
	
	public ThemChiTietKhamBenhUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		
	}
	private void addEvents() {
		// TODO Auto-generated method stub
		
	}
	private void addControls() {
		Container conn = getContentPane();
		conn.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JPanel pnCenter = new JPanel();
		JPanel pnSouth = new JPanel();
		conn.add(pnNorth,BorderLayout.NORTH);
		conn.add(pnCenter,BorderLayout.CENTER);
		conn.add(pnSouth,BorderLayout.SOUTH);
		
		
		pnNorth.setLayout(new BoxLayout(pnNorth,BoxLayout.Y_AXIS));
		JPanel pnDong1 = new JPanel();
		JLabel lblTenbacsi = new JLabel("Bác sĩ khám");
		JLabel lblNgaykham = new JLabel("Ngày khám");
		txtNgaykham = new JTextField(25);
		cbxTenbacsi = new JComboBox();
		pnDong1.add(lblTenbacsi);
		pnDong1.add(cbxTenbacsi);
		pnDong1.add(lblNgaykham);
		pnDong1.add(txtNgaykham);
		pnNorth.add(pnDong1);
		
		JPanel pnDong2 = new JPanel();
		JLabel lblTenbenhnhan = new JLabel("Tên bệnh nhân");
		JLabel lblYeucaukham = new JLabel("Yêu cầu khám");
		txtYeucaukham = new JTextField(25);
		txtYeucaukham.setEditable(false);
		pnDong2.add(lblTenbenhnhan);
		cbxTenbenhnhan = new JComboBox();
		pnDong2.add(cbxTenbenhnhan);
		pnDong2.add(lblYeucaukham);
		pnDong2.add(txtYeucaukham);
		pnNorth.add(pnDong2);
		
		JPanel pnDong3 = new JPanel();
		JLabel lblKetluan = new JLabel("Kết luận");
		txtKetluan =  new JTextField(50);
		pnDong3.add(lblKetluan);
		pnDong3.add(txtKetluan);
		pnNorth.add(pnDong3);
		
		
		pnCenter.setLayout(new BorderLayout());
		JPanel pnPhai = new JPanel();
		JPanel pnTrai = new JPanel();
		pnCenter.add(pnPhai,BorderLayout.EAST);
		pnCenter.add(pnTrai,BorderLayout.WEST);
		pnPhai.setLayout(new BoxLayout(pnPhai,BoxLayout.Y_AXIS));
		pnTrai.setLayout(new BoxLayout(pnTrai,BoxLayout.Y_AXIS));
		
		JLabel lblDanhsachdichvu = new JLabel("Danh sách dịch vụ");
		dtmDanhsachdichvu = new DefaultTableModel();
		dtmDanhsachdichvu.addColumn("Tên dịch vụ");
		tblDanhsachdichvu = new JTable(dtmDanhsachdichvu);
		JScrollPane scDanhsachdichvu = new JScrollPane(tblDanhsachdichvu);
		pnTrai.add(lblDanhsachdichvu);
		pnTrai.add(scDanhsachdichvu);
		
		JLabel lblDanhsachdichvubacsichon = new JLabel("Danh sách dịch vụ bác sĩ chọn");
		dtmDanhsachdichvubacsichon = new DefaultTableModel();
		dtmDanhsachdichvubacsichon.addColumn("Tên dịch vụ");
		dtmDanhsachdichvubacsichon.addColumn("Số lượng");
		tblDanhsachdichvubacsichon = new JTable(dtmDanhsachdichvubacsichon);
		JScrollPane scDanhsachdichvubacsichon = new JScrollPane(tblDanhsachdichvubacsichon);
		pnPhai.add(lblDanhsachdichvubacsichon);
		pnPhai.add(scDanhsachdichvubacsichon);
		
		
		
		
		
		btnThem = new JButton("Thêm");
		pnSouth.add(btnThem);
	}
	public void showWindow()
	{
		this.setSize(1000, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	};
}
