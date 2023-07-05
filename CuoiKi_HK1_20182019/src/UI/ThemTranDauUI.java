package UI;
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

import Connect.ChiTietGiaiDauService;
import Connect.DoiBongService;
import Connect.GiaiDauService;
import Model.DoiBongModel;
import Model.GiaiDauModel;
import javax.swing.JFrame;

public class ThemTranDauUI extends JFrame  {
	JTextField txtNgayda, txtDiadiem, txtTiso;
	JComboBox cbxTengiai, cbxChunha, cbxDoikhach;
	JButton btnThem, btnHuy;
	public ThemTranDauUI (String title)
	{
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		btnHuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtNgayda.setText("");
				txtDiadiem.setText("");
				txtTiso.setText("");
			}
			
		});
		
	}

	private void addControls() {
		Container conn =  getContentPane();
		conn.setLayout(new BorderLayout());
		JPanel pnCenter = new JPanel();
		conn.add(pnCenter);
		pnCenter.setLayout( new BoxLayout(pnCenter,BoxLayout.Y_AXIS));
		
		
		JPanel pnTengiaidau = new JPanel();
		JLabel lblTengiai = new JLabel("Tên giải đấu");
		cbxTengiai = new JComboBox();
		pnTengiaidau.add(lblTengiai);
		pnTengiaidau.add(cbxTengiai);
		pnCenter.add(pnTengiaidau);
		
		
		JPanel pnNgaydau = new JPanel();
		JLabel lblNgayda = new JLabel("Ngày đá");
		JLabel lblDiadiem = new JLabel("Địa điểm");
		txtNgayda = new JTextField(25);
		txtDiadiem = new JTextField(25);
		pnNgaydau.add(lblNgayda);
		pnNgaydau.add(txtNgayda);
		pnNgaydau.add(lblDiadiem);
		pnNgaydau.add(txtDiadiem);
		pnCenter.add(pnNgaydau);
		
		JPanel pnChunha = new JPanel();
		JLabel lblChunha = new JLabel("Chủ nhà");
		JLabel lblDoikhach = new JLabel("Đội khách");
		cbxChunha = new JComboBox();
		cbxDoikhach = new JComboBox();
		pnChunha.add(lblChunha);
		pnChunha.add(cbxChunha);
		pnChunha.add(lblDoikhach);
		pnChunha.add(cbxDoikhach);
		pnCenter.add(pnChunha);
		
		
		JPanel pnTiso = new JPanel();
		JLabel lblTiso = new JLabel("Tỉ số");
		txtTiso = new JTextField(25);
		pnTiso.add(lblTiso);
		pnTiso.add(txtTiso);
		pnCenter.add(pnTiso);
		
		JPanel pnButton = new JPanel();
		btnThem = new JButton("Thêm");
		btnHuy = new JButton("Hủy");
		pnButton.add(btnThem);
		pnButton.add(btnHuy);
		pnCenter.add(pnButton);
		
	}
	public void showWindow()
	{
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
