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

import connect.BacSiService;
import connect.BenhNhanService;
import connect.KhamBenhService;
import model.BacSiModel;

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


public class DatLichKhamUI extends JFrame {
	JTextField txtMabenhnhan, txtTenbenhnhan, txtNgaykham, txtYeucaukham;
	JComboBox<String> cbxTenbacsi;
	JButton btnDatlichkham;
	ArrayList<BacSiModel> dsTenbacsi;
	public DatLichKhamUI(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	private void addEvents() {
		btnDatlichkham.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						KhamBenhService KBSer = new KhamBenhService();
						KBSer.themLichkham(txtMabenhnhan.getText(),Date.valueOf(txtNgaykham.getText()),txtYeucaukham.getText(), cbxTenbacsi.getSelectedItem().toString());
						txtMabenhnhan.setText("");
						txtNgaykham.setText("");
						txtYeucaukham.setText("");
					}
			
				});
		
		txtMabenhnhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BenhNhanService BNSer = new BenhNhanService();
				String tenbn = BNSer.layTenbenhnhantumabenhnhan(txtMabenhnhan.getText().toString());
				txtTenbenhnhan.setText(tenbn);
				
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
		txtTenbenhnhan.setEditable(false);
		pnTenbenhnhan.add(lblTenbenhnhan);
		pnTenbenhnhan.add(txtTenbenhnhan);
		pnCenter.add(pnTenbenhnhan);
		
		JPanel pnNgaykham = new JPanel();
		JLabel lblNgaykham = new JLabel("Ngày khám");
		txtNgaykham = new JTextField(25);
		pnNgaykham.add(lblNgaykham);
		pnNgaykham.add(txtNgaykham);
		pnCenter.add(pnNgaykham);
		
		JPanel pnYeucaukham = new JPanel();
		JLabel lblYeucaukham = new JLabel("Yêu cầu khám");
		txtYeucaukham = new JTextField(25);
		pnYeucaukham.add(lblYeucaukham);
		pnYeucaukham.add(txtYeucaukham);
		pnCenter.add(pnYeucaukham);
	
		JPanel pnBacsikham = new JPanel();
		JLabel lblBacsikham = new JLabel("Bác sĩ khám");
		cbxTenbacsi = new JComboBox();
		pnYeucaukham.add(lblBacsikham);
		pnYeucaukham.add(cbxTenbacsi);
		pnCenter.add(pnYeucaukham);
		
		BacSiService bsSer = new BacSiService();
		dsTenbacsi = bsSer.layDanhsachbacsi();
		for(BacSiModel bacsi : dsTenbacsi)
		{
			cbxTenbacsi.addItem(bacsi.getTenbacsi());
		}
		
		
		btnDatlichkham = new JButton("Đặt lịch khám");
		pnSouth.add(btnDatlichkham);
	}
	public void showWindow()
	{
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	};
}
