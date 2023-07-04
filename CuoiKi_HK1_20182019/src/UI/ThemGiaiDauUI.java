package UI;
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
import java.util.Vector;
import Connect.GiaiDauService;

public class ThemGiaiDauUI extends JFrame {
	JTextField txtMagiai, txtTengiai, txtNgaybatdau, txtNgayketthuc;
	JButton btnThem;
	public ThemGiaiDauUI(String title)
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
						GiaiDauService GD = new GiaiDauService();
						GD.themGiaidau(Integer.parseInt(txtMagiai.getText()), txtTengiai.getText(), Date.valueOf(txtNgaybatdau.getText()),Date.valueOf(txtNgayketthuc.getText()));
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
		
		
		JPanel pnMagiai = new JPanel();
		JLabel lblMagiai = new JLabel("Mã giải");
		txtMagiai = new JTextField(25);
		pnMagiai.add(lblMagiai);
		pnMagiai.add(txtMagiai);
		pnCenter.add(pnMagiai);
		
		JPanel pnTengiai = new JPanel();
		JLabel lblTengiai = new JLabel("Tên giải");
		txtTengiai = new JTextField(25);
		pnTengiai.add(lblTengiai);
		pnTengiai.add(txtTengiai);
		pnCenter.add(pnTengiai);
		
		
		JPanel pnNgaybatdau = new JPanel();
		JLabel lblNgaybatdau = new JLabel("Ngày bắt đầu");
		txtNgaybatdau = new JTextField(25);
		pnNgaybatdau.add(lblNgaybatdau);
		pnNgaybatdau.add(txtNgaybatdau);
		pnCenter.add(pnNgaybatdau);
	
		
		JPanel pnNgayketthuc = new JPanel();
		JLabel lblNgayketthuc = new JLabel("Ngày kết thúc");
		txtNgayketthuc = new JTextField(25);
		pnNgayketthuc.add(lblNgayketthuc);
		pnNgayketthuc.add(txtNgayketthuc);
		pnCenter.add(pnNgayketthuc);
		
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
