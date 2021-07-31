package finalProject.jpa.window;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel rootPanel;
	private JTable tableMuon;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JTextField txtMaSach;
	private JTextField txtMaMuon;
	private JMenuItem itemMuonTra;
	private JMenuItem itemQuanLySach;
	private JMenuItem itemLichSu;
	private JPanel panelMuon;
	private JPanel panelTra;
	private boolean muontra = false, quanly = false, lichsu = false;
	private boolean muon = true;
	private boolean tra = true;
	private JButton btnChiTiet;
	private JButton btnTaiLai;
	static MainFrame mframe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mframe = new MainFrame();
					mframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 577);
		setTitle("QUẢN LÝ THƯ VIỆN");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(220,30));
		setJMenuBar(menuBar);
		
		itemMuonTra = new JMenuItem("M\u01B0\u1EE3n/Tr\u1EA3");
		itemMuonTra.setBorder(new LineBorder(Color.GREEN));
		itemMuonTra.setBackground(Color.gray);
		itemMuonTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				muontra = true;
				quanly = lichsu = false;
				itemEffect(itemMuonTra, itemQuanLySach, itemLichSu);
				CardLayout cl = (CardLayout)(rootPanel.getLayout());
				cl.show(rootPanel, "MUONTRA");
			}
		});
		itemMuonTra.setHorizontalAlignment(SwingConstants.CENTER);
		itemMuonTra.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(itemMuonTra);
		itemMuonTra.setSelected(true);
		
		itemQuanLySach = new JMenuItem("Qu\u1EA3n l\u00FD s\u00E1ch");
		itemQuanLySach.setBorder(new LineBorder(Color.GREEN));
		itemQuanLySach.setSelected(true);
		itemQuanLySach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quanly = true;
				muontra = lichsu = false;
				itemEffect(itemMuonTra, itemQuanLySach, itemLichSu);
				CardLayout cl = (CardLayout)(rootPanel.getLayout());
				cl.show(rootPanel, "QUANLYSACH");
			}
		});
		itemQuanLySach.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		itemQuanLySach.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(itemQuanLySach);
		
		itemLichSu = new JMenuItem("L\u1ECBch s\u1EED");
		itemLichSu.setBorder(new LineBorder(Color.green));
		itemLichSu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lichsu = true;
				muontra = quanly = false;
				itemEffect(itemMuonTra, itemQuanLySach, itemLichSu);
				CardLayout cl = (CardLayout)(rootPanel.getLayout());
				cl.show(rootPanel, "LICHSU");
			}
		});
		itemLichSu.setSelected(true);
		itemLichSu.setHorizontalAlignment(SwingConstants.CENTER);
		itemLichSu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(itemLichSu);
		rootPanel = new JPanel();
		rootPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPanel);
		rootPanel.setLayout(new CardLayout(0, 0));
		
		JPanel panelMuonTra = new JPanel();
		rootPanel.add(panelMuonTra, "MUONTRA");
		panelMuonTra.setLayout(null);
		
		PanelQuanLySach panelQuanLySach = new PanelQuanLySach();
		rootPanel.add(panelQuanLySach, "QUANLYSACH");
		PanelLichSu panelLichSu = new PanelLichSu();
		rootPanel.add(panelLichSu, "LICHSU");
		
		
		tableMuon = new JTable();
		tableMuon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableMuon.getTableHeader().setBackground(Color.LIGHT_GRAY);
		
		JScrollPane scrollPane = new JScrollPane(tableMuon);
		scrollPane.setBounds(10, 10, 570, 420);
		scrollPane.setLayout(new ScrollPaneLayout());
		panelMuonTra.add(scrollPane);
		
		// ---------------------------
		loadDataTableMuon();
		
		panelMuon = new JPanel();
		TitledBorder tBorder = (new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin m\u01B0\u1EE3n s\u00E1ch",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tBorder.setTitleFont(new Font("Tahoma", Font.BOLD, 16));
		panelMuon.setBorder(tBorder);
		panelMuon.setBounds(590, 114, 249, 231);
		panelMuonTra.add(panelMuon);
		panelMuon.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD t\u00EAn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 40, 61, 17);
		panelMuon.add(lblNewLabel);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(10, 93, 61, 17);
		panelMuon.add(lblaCh);
		
		JLabel lblNewLabel_1_1 = new JLabel("M\u00E3 s\u00E1ch:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 149, 61, 17);
		panelMuon.add(lblNewLabel_1_1);
		
		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHoTen.setBounds(10, 63, 229, 25);
		panelMuon.add(txtHoTen);
		txtHoTen.setColumns(10);
		txtHoTen.setEnabled(false);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(10, 120, 229, 25);
		panelMuon.add(txtDiaChi);
		txtDiaChi.setEnabled(false);
		
		txtMaSach = new JTextField();
		txtMaSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaSach.setColumns(10);
		txtMaSach.setBounds(10, 176, 229, 25);
		panelMuon.add(txtMaSach);
		txtMaSach.setEnabled(false);
		
		panelTra = new JPanel();
		tBorder = new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin tr\u1EA3 s\u00E1ch", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
		tBorder.setTitleFont(new Font("Tahoma", Font.BOLD, 16));
		panelTra.setBorder(tBorder);
		panelTra.setBounds(590, 366, 249, 106);
		panelMuonTra.add(panelTra);
		panelTra.setLayout(null);
		
		JLabel lblMMn = new JLabel("M\u00E3 m\u01B0\u1EE3n:");
		lblMMn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMMn.setBounds(10, 44, 73, 17);
		panelTra.add(lblMMn);
		
		txtMaMuon = new JTextField();
		txtMaMuon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaMuon.setColumns(10);
		txtMaMuon.setBounds(10, 71, 229, 25);
		panelTra.add(txtMaMuon);
		txtMaMuon.setEnabled(false);
		
		JButton btnMuon = new JButton("M\u01B0\u1EE3n");
		btnMuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMuon_click(e);
			}
		});
		btnMuon.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMuon.setBounds(627, 10, 182, 41);
		panelMuonTra.add(btnMuon);
		
		JButton btnTra = new JButton("Tr\u1EA3");
		btnTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTra_click(e);
			}
		});
		btnTra.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTra.setBounds(627, 63, 182, 41);
		panelMuonTra.add(btnTra);
		
		btnChiTiet = new JButton("Chi tiết");
		btnChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameXemChiTietMuonTra();
			}
		});
		btnChiTiet.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChiTiet.setBounds(10, 439, 103, 51);
		panelMuonTra.add(btnChiTiet);
		
		btnTaiLai = new JButton("Tải lại");
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTaiLai_click(e);
			}
		});
		btnTaiLai.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTaiLai.setBounds(123, 440, 103, 51);
		panelMuonTra.add(btnTaiLai);
	}
	// Hiệu ứng click lên item -> đổi màu
	private void itemEffect(JMenuItem item1, JMenuItem item2, JMenuItem item3) {

		if(muontra) {
			item1.setBackground(Color.gray);
			item2.setBackground(Color.WHITE);
			item3.setBackground(Color.WHITE);
		}
		else if (quanly) {
			item1.setBackground(Color.WHITE);
			item2.setBackground(Color.gray);
			item3.setBackground(Color.WHITE);
		}
		else if(lichsu){
			item1.setBackground(Color.WHITE);
			item2.setBackground(Color.WHITE);
			item3.setBackground(Color.gray);
		}			
	}
	
	// -------->------>---------->   Click event btnMuon <-----------<------------<-----------------
	private void btnMuon_click(ActionEvent e) {

		// đổi text khi bấm vào btn và kiểm tra điền thông tin chưa
		if(muon) {
			((JButton)e.getSource()).setText("Lưu mượn");
			txtHoTen.setEnabled(true);
			txtDiaChi.setEnabled(true);
			txtMaSach.setEnabled(true);
			muon = false;
		}
		else {
			// Kiểm tra xem đã điền thông tin chưa
			if(txtHoTen.getText().equals("")||(txtDiaChi.getText().equals("")||txtMaSach.getText().equals("")))
				JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin!", "Chú ý!", JOptionPane.WARNING_MESSAGE);
			else {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn lưu thông tin chứ?", "Chú ý!", JOptionPane.INFORMATION_MESSAGE);
				if (result == JOptionPane.YES_OPTION)
				{
					// ----->----->->--->  CODE CHÈN THÔNG TIN MƯỢN VÀO CSDL  <------<<-----<-------<-----<-----<------<-
					//
					//
					//                     nhớ làm messageBox báo thành công 
					
					
					//--------------------------------------------------------------
					((JButton)e.getSource()).setText("Mượn");
					txtHoTen.setEnabled(false);
					txtDiaChi.setEnabled(false);
					txtMaSach.setEnabled(false);
					muon = true;
					
				}
			}
			
		}		
		
		
	}
	
	// Click event btnTra
	private void btnTra_click(ActionEvent e) {


		// Đổi text khi bấm vào btn và kiểm tra điền thông tin chưa
		if(tra) {
			((JButton)e.getSource()).setText("Lưu trả");
			txtMaMuon.setEnabled(true);
			tra = false;
		}
		else {
			// Kiểm tra xem đã điền thông tin chưa
			if(txtMaMuon.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin!", "Chú ý!", JOptionPane.WARNING_MESSAGE);
			else {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn lưu thông tin chứ?", "Chú ý!", JOptionPane.INFORMATION_MESSAGE);
				if (result == JOptionPane.YES_OPTION)
				{
					// ----->----->->--->  CODE XOÁ THÔNG TIN MƯỢN KHỎI CSDL  <------<<-----<-------<-----<-----<------<-
					//
					//                       nhớ làm messageBox báo thành công 
					//
					//------------------------------------------------------------------------
					((JButton)e.getSource()).setText("Trả");
					txtMaMuon.setEnabled(false);
					tra = true;
				}
				
			}
			
		}
		
	}	
	
	// -------->->    click event btnChiTiet, show thong tin chi tiet tren cai hang dang chon <------<------------<---------------<------
//	private void btnChiTiet_click(ActionEvent e) {
//		
//	}
	
	// click event btnTaiLai 
	private void btnTaiLai_click(ActionEvent e) {
		loadDataTableMuon();
	}

	// -->--------->----->  Code truy vấn dữ liệu cho table mượn, đưa vào model <-----<---------<----------<
	private DefaultTableModel getDataForModelMuon(DefaultTableModel model) {
		// ----->----------->------> tự nghĩ coi trong bảng có gì <------<-------<------------------
		model.addColumn("SOMETHING");
		model.addColumn("SOMETHING2");
		
		// truy vấn here
		
		
		return model;
	}
	
	// load data cho tableMuon
	private void loadDataTableMuon() {
		DefaultTableModel modelMuon = new DefaultTableModel();
		modelMuon = getDataForModelMuon(modelMuon);
		tableMuon.setModel(modelMuon);
	}

}
