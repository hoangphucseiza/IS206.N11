package topica.edu.vn.ui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import topica.edu.vn.connect.SachService;
import topica.edu.vn.model.Sach;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;  
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Vector;

public class TimKiemUI extends JFrame {
	JTextField txtTim;
	JButton btnBatDauTim;
	DefaultTableModel dtmSach;
	JTable tblSach;
	public TimKiemUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		btnBatDauTim.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				xuLyTimKiem();
			}

			private void xuLyTimKiem() {
				SachService sservice = new SachService();
				ArrayList<Sach> dsSach = sservice.timSachTheoNhaXuatBan(txtTim.getText());
				dtmSach.setRowCount(0);
				for (Sach s: dsSach)
				{
					Vector<Object> vec = new Vector<Object>();
					vec.add(s.getMaSach());
					vec.add(s.getTenSach());
					vec.add(s.getMaNhaXuatBan());
					vec.add(s.getSoTrang());
					dtmSach.addRow(vec);
					
				}
				
			}
		});
		
	}

	private void addControls() {
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNhap = new JLabel("Nhập tên sách: ");
		txtTim = new JTextField(20);
		btnBatDauTim = new JButton("Tìm Sách");
		pnNorth.add(lblNhap);
		pnNorth.add(txtTim);
		pnNorth.add(btnBatDauTim);
		con.add(pnNorth,BorderLayout.NORTH);
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		dtmSach = new DefaultTableModel();
		dtmSach.addColumn("Mã sách");
		dtmSach.addColumn("Tên sách ");
		dtmSach.addColumn("Nhà xuất bản");
		dtmSach.addColumn("Số trang");
		tblSach = new JTable(dtmSach);
		JScrollPane scTable = new JScrollPane(tblSach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scTable,BorderLayout.CENTER);
		con.add(pnCenter,BorderLayout.CENTER);
		
	}
	public void showWindow()
	{
		this.setSize(600,600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
