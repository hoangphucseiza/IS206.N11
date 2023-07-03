package UI;


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
import java.util.Vector;
import Connect.DoiBongService;
public class ThemDoiUI extends JFrame {
	JTextField txtMadoi, txtTendoi, txtQuocgia;
	JButton btnThem;
	public ThemDoiUI(String title)
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
						DoiBongService DB = new DoiBongService();
						if(DB.themDoiBong(Integer.parseInt(txtMadoi.getText()), txtTendoi.getText(), txtQuocgia.getText()))
						{
							JOptionPane.showMessageDialog(null,"Thêm đội bóng thành công");
						}else
						{
							JOptionPane.showMessageDialog(null,"Thêm đội bóng không thành công");
						}
						
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
		
		
		JPanel pnMadoi = new JPanel();
		JLabel lblMadoi = new JLabel("Mã đội");
		txtMadoi = new JTextField(25);
		pnMadoi.add(lblMadoi);
		pnMadoi.add(txtMadoi);
		pnCenter.add(pnMadoi);
		
		JPanel pnTendoi = new JPanel();
		JLabel lblTendoi = new JLabel("Tên đội");
		txtTendoi = new JTextField(25);
		pnTendoi.add(lblTendoi);
		pnTendoi.add(txtTendoi);
		pnCenter.add(pnTendoi);
		
		
		JPanel pnQuocgia = new JPanel();
		JLabel lblQuocgia = new JLabel("Quốc gia");
		txtQuocgia = new JTextField(25);
		pnQuocgia.add(lblQuocgia);
		pnQuocgia.add(txtQuocgia);
		pnCenter.add(pnQuocgia);
	
		
		btnThem = new JButton("Thêm");
		pnSouth.add(btnThem);
	}
	public void showWindow()
	{
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	};
}
