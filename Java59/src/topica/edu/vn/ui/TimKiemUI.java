package topica.edu.vn.ui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;  
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

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
		// TODO Auto-generated method stub
		
	}

	private void addControls() {
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNhap = new JLabel("Tìm gì?");
		txtTim = new JTextField(20);
		btnBatDauTim = new JButton("Tìm kiếm");
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
