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

import Connect.DoiBongService;
import Connect.GiaiDauService;
import Model.DoiBongModel;
import Model.GiaiDauModel;
public class ChiTietGiaiDauUI extends JFrame {
	JComboBox cbxTengiai;
	JButton btnThem, btnHuy;
	DefaultTableModel dtmDanhsachdoi, dtmDoithamgia;
	JTable tblDanhsachdoi, tblDoithamgia;
	ArrayList<GiaiDauModel> dsGiai = null;
	ArrayList<DoiBongModel> dsDoi = null;
	public ChiTietGiaiDauUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		hienThitoanbotendoi();
	}
	private void hienThitoanbotendoi() {
		DoiBongService dbService = new DoiBongService();
		dsDoi = dbService.hienThithongtindoibong();
		dtmDanhsachdoi.setRowCount(0);
		for(DoiBongModel db: dsDoi)
		{
			Vector<Object> vec = new Vector<Object>();
			vec.add(db.getMadoi());
			vec.add(db.getTendoi());
			dtmDanhsachdoi.addRow(vec);
		}
	}
	private void addEvents() {
		
		btnThem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
	
		});
		
		tblDanhsachdoi.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent e)
					{
						int row = tblDanhsachdoi.getSelectedRow();
						String madoi = tblDanhsachdoi.getValueAt(row,0).toString();
						String tendoi = tblDanhsachdoi.getValueAt(row,1).toString();
						Vector<Object> vec = new Vector<Object>();
						vec.add(madoi);
						vec.add(tendoi);
						dtmDoithamgia.addRow(vec);
						
							
					}
			
			
				});
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
		
		JLabel lblGiaidau = new JLabel("Tên giải đấu");
		
		cbxTengiai = new JComboBox();
		cbxTengiai.setPreferredSize(new Dimension(100, cbxTengiai.getPreferredSize().height));
		pnNorth.add(lblGiaidau);
		pnNorth.add(cbxTengiai);
		
		pnCenter.setLayout(new BorderLayout());
		JPanel pnPhai = new JPanel();
		JPanel pnTrai = new JPanel();
		pnCenter.add(pnTrai, BorderLayout.WEST);
		pnCenter.add(pnPhai, BorderLayout.EAST);
		pnTrai.setLayout(new BoxLayout(pnTrai, BoxLayout.Y_AXIS));
		pnPhai.setLayout(new BoxLayout(pnPhai, BoxLayout.Y_AXIS));
		
		JLabel lblDanhsachdoi = new JLabel("Danh sách Đội");
		dtmDanhsachdoi = new DefaultTableModel();
		dtmDanhsachdoi.addColumn("Mã đội");
		dtmDanhsachdoi.addColumn("Tên đội");
		tblDanhsachdoi = new JTable(dtmDanhsachdoi);
		JScrollPane scDanhsachdoi = new JScrollPane(tblDanhsachdoi);
		pnTrai.add(lblDanhsachdoi);
		pnTrai.add(scDanhsachdoi);
		
		
		JLabel lblDoithamgia = new JLabel("Danh sách đội tham gia");
		dtmDoithamgia = new DefaultTableModel();
		dtmDoithamgia.addColumn("Mã đội");
		dtmDoithamgia.addColumn("Tên đội");
		tblDoithamgia = new JTable(dtmDoithamgia);
		JScrollPane scDoithamgia = new JScrollPane(tblDoithamgia);
		pnPhai.add(lblDoithamgia);
		pnPhai.add(scDoithamgia);
		
		btnThem = new JButton("Thêm");
		btnHuy = new JButton("Hủy");
		pnSouth.add(btnThem);
		pnSouth.add(btnHuy);
		
		
		GiaiDauService giaiDauservice = new GiaiDauService();
		dsGiai = giaiDauservice.layToanbotengiai();
		for(GiaiDauModel tengiai : dsGiai)
		{
			cbxTengiai.addItem(tengiai);
		}
		
		
	}
	public void showWindow()
	{
		this.setSize(1000, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	};
}
