package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JFrame;
import topica.edu.vn.connect.NhaXuatBanService;
import topica.edu.vn.model.NhaXuatBan;
import java.util.Vector;

public class QuanLySachUI extends JFrame {
	JTextField txtManxb, txtTennxb, txtDiachi, txtDienthoai;
	JButton btnVeTruoc,btnVeSau;
	JLabel lblStep;
	JButton btnThem, btnLuu, btnSua, btnXoa;
	JButton btnTimkiem;
	
	ArrayList<NhaXuatBan> dsNXB = null;
	DefaultTableModel dtmNxb;
	JTable tblNxb;
	private int currentRow = -1;
	public QuanLySachUI(String title)
	{
		super(title);
		addControls();
		addEvents();
		hienThiToanBoNhaXuatBan();
	}

	public void hienThiToanBoNhaXuatBan() {
		NhaXuatBanService nxbService = new NhaXuatBanService();
		dsNXB = nxbService.layToanBoNhaXuatBan();
		dtmNxb.setRowCount(0);
		for(NhaXuatBan nxb: dsNXB)
		{
			Vector<Object> vec = new Vector<Object>();
			vec.add(nxb.getMaNhaXuatBan());
			vec.add(nxb.getTenNhaXuatBan());
			vec.add(nxb.getDiaChi());
			vec.add(nxb.getDienThoai());
			dtmNxb.addRow(vec);
		}
		
	}
	public void clearTextFields() {
	    txtManxb.setText("");
	    txtTennxb.setText("");
	    txtDiachi.setText("");
	    txtDienthoai.setText("");
	}
	private void addEvents() {
		btnTimkiem.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						TimKiemUI ui = new TimKiemUI("Tìm kiếm Sách");
						ui.showWindow();
						
					}
			
				});
		
		btnThem.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				NhaXuatBanService nxbservice = new NhaXuatBanService();
			boolean flat =	nxbservice.themNhaXuatBan(txtManxb.getText(),txtTennxb.getText(), txtDiachi.getText(), txtDienthoai.getText());
				if (flat)
				{
					JOptionPane.showMessageDialog(null, "Thêm nhà xuất bản thành công");
					hienThiToanBoNhaXuatBan();
					clearTextFields();
				}else
				{
					JOptionPane.showMessageDialog(null, "Thêm nhà xuất bản thất bại");
				}
			}
		});
		
		btnXoa.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				NhaXuatBanService nxbservice = new NhaXuatBanService();
			boolean flat =	nxbservice.xoaNhaXuatBan(txtManxb.getText());
				if (flat)
				{
					JOptionPane.showMessageDialog(null, "Xóa nhà xuất bản thành công");
					hienThiToanBoNhaXuatBan();
					clearTextFields();
				}else
				{
					JOptionPane.showMessageDialog(null, "Xóa nhà xuất bản thất bại");
				}
			}
		});
		
		btnVeSau.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (currentRow != -1) {
		            int nextRow = Math.min(currentRow + 1, tblNxb.getRowCount() - 1);
		            tblNxb.setRowSelectionInterval(nextRow, nextRow);
		            tblNxb.scrollRectToVisible(tblNxb.getCellRect(nextRow, 0, true));
		        }
		    }
		});
		
		btnSua.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				NhaXuatBanService nxbservice = new NhaXuatBanService();
			boolean flat =	nxbservice.suaNhaXuatBan(txtManxb.getText(),txtTennxb.getText(), txtDiachi.getText(), txtDienthoai.getText());
				if (flat)
				{
					JOptionPane.showMessageDialog(null, "Sửa nhà xuất bản thành công");
					hienThiToanBoNhaXuatBan();
					clearTextFields();
				}else
				{
					JOptionPane.showMessageDialog(null, "Sửa nhà xuất bản thất bại");
				}
			}
		});
		
		tblNxb.addMouseListener(new MouseAdapter()
			{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				currentRow = tblNxb.getSelectedRow();
				int row = tblNxb.getSelectedRow();
				String maNxb = tblNxb.getValueAt(row,0).toString();
				String tenNxb = tblNxb.getValueAt(row,1).toString();
				String diaChi = tblNxb.getValueAt(row,2).toString();
				String dienThoai = tblNxb.getValueAt(row,3).toString();
				txtManxb.setText(maNxb);
				txtTennxb.setText(tenNxb);
				txtDiachi.setText(diaChi);
				txtDienthoai.setText(dienThoai);
			}
			});
		
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
		JLabel lblNxb = new JLabel("THÔNG TIN NHÀ XUẤT BẢN");
		lblNxb.setForeground(Color.RED);
		Font ft = new Font("arial", Font.BOLD,20);
		lblNxb.setFont(ft);
		pnNxb.add(lblNxb);
		pnChiTiet.add(pnNxb);
		
		JPanel pnManxb = new JPanel();
		JLabel lblManxb = new JLabel("Mã NXB: ");
		txtManxb = new JTextField(25);
		pnManxb.add(lblManxb);
		pnManxb.add(txtManxb);
		pnChiTiet.add(pnManxb);
		
		JPanel pnTennxb= new JPanel();
		JLabel lblTennxb = new JLabel("Tên NXB: ");
		txtTennxb = new JTextField(25);
		pnTennxb.add(lblTennxb);
		pnTennxb.add(txtTennxb);
		pnChiTiet.add(pnTennxb);
		
		JPanel pnDiachi= new JPanel();
		JLabel lblDiachi = new JLabel("Địa chỉ: ");
		txtDiachi = new JTextField(25);
		pnDiachi.add(lblDiachi);
		pnDiachi.add(txtDiachi);
		pnChiTiet.add(pnDiachi);
		
		JPanel pnDienthoai= new JPanel();
		JLabel lblDienthoai = new JLabel("Điện thoại: ");
		txtDienthoai = new JTextField(25);
		pnDienthoai.add(lblDienthoai);
		pnDienthoai.add(txtDienthoai);
		pnChiTiet.add(pnDienthoai);
		
		JPanel pnButtonChiTiet = new  JPanel();
		btnVeTruoc = new JButton("Về trước");
		lblStep = new JLabel("1/10");
		btnVeSau = new JButton("Về sau");
		pnButtonChiTiet.add(btnVeTruoc);
		pnButtonChiTiet.add(lblStep);
		pnButtonChiTiet.add(btnVeSau);
		pnChiTiet.add(pnButtonChiTiet);
		
		pnThucHien.setLayout(new BoxLayout(pnThucHien,BoxLayout.Y_AXIS));
		JPanel pnButtonThem = new JPanel();
		btnThem = new JButton("Thêm");
		pnButtonThem.add(btnThem);
		pnThucHien.add(pnButtonThem);
		
		
		JPanel pnButtonLuu = new JPanel();
		btnLuu = new JButton("Lưu");
		pnButtonLuu.add(btnLuu);
		pnThucHien.add(pnButtonLuu);
		
		JPanel pnButtonSua = new JPanel();
		btnSua = new JButton("Sửa");
		pnButtonSua.add(btnSua);
		pnThucHien.add(pnButtonSua);
		
		JPanel pnButtonXoa = new JPanel();
		btnXoa = new JButton("Xóa");
		pnButtonXoa.add(btnXoa);
		pnThucHien.add(pnButtonXoa);
		
		
		pnCenter.setLayout(new BorderLayout());
		dtmNxb = new DefaultTableModel();
		dtmNxb.addColumn("Mã nhà XB");
		dtmNxb.addColumn("Tên nhà XB");
		dtmNxb.addColumn("Địa chỉ");
		dtmNxb.addColumn("Điện thoại");
		tblNxb = new JTable(dtmNxb);
		JScrollPane scTable = new JScrollPane(tblNxb,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scTable,BorderLayout.CENTER);
		
		JPanel pnButtonOfSouth = new JPanel();
		btnTimkiem = new JButton("Tìm kiếmn thông tin sách");
		pnButtonOfSouth.add(btnTimkiem);
		pnSouth.add(pnButtonOfSouth);
		
		TitledBorder borderThongTinChiTiet = new TitledBorder(BorderFactory.createLineBorder(Color.RED),
				"Thông tin chi tiết");
		pnChiTiet.setBorder(borderThongTinChiTiet);
	
		TitledBorder borderThucHien = new TitledBorder(BorderFactory.createLineBorder(Color.BLUE),
				"Thực hiện");
		
		TitledBorder borderDanhSachNxb = new TitledBorder(BorderFactory.createLineBorder(Color.PINK),
				"Danh sách nhà xuất bản");
		pnCenter.setBorder(borderDanhSachNxb);
		
		pnChiTiet.setBorder(borderThongTinChiTiet);
		pnThucHien.setBorder(borderThucHien);
		lblManxb.setPreferredSize(lblDienthoai.getPreferredSize());
		lblTennxb.setPreferredSize(lblDienthoai.getPreferredSize());
		lblDiachi.setPreferredSize(lblDienthoai.getPreferredSize());
		
		btnThem.setIcon(new ImageIcon("D:\\CODE FROJECT\\Code Java Tran Duy Thanh\\Java59\\src\\Icon\\add.png"));
		btnSua.setIcon( new ImageIcon("D:\\CODE FROJECT\\Code Java Tran Duy Thanh\\Java59\\src\\Icon\\edit.png"));
		btnXoa.setIcon( new ImageIcon("D:\\CODE FROJECT\\Code Java Tran Duy Thanh\\Java59\\src\\Icon\\delete.png"));
		btnLuu.setIcon( new ImageIcon("D:\\CODE FROJECT\\Code Java Tran Duy Thanh\\Java59\\src\\Icon\\save.png"));
		btnTimkiem.setIcon( new ImageIcon("D:\\CODE FROJECT\\Code Java Tran Duy Thanh\\Java59\\src\\Icon\\search.png"));
		btnVeTruoc.setIcon( new ImageIcon("D:\\CODE FROJECT\\Code Java Tran Duy Thanh\\Java59\\src\\Icon\\left.png"));
		btnVeSau.setIcon( new ImageIcon("D:\\CODE FROJECT\\Code Java Tran Duy Thanh\\Java59\\src\\Icon\\right.png"));
	}
	public void showWindow()
	{
		this.setSize(500,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
