package finalProject.jpa.window;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import finalProject.jpa.autoComplete.AutoComplete;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelQuanLySach extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTenSach_them;
	private JTextField txtNXB;
	private JTextField txtTacGia;
	private JTextField txtSoLuong_them;
	private JTextField txtMaSach_sua;
	private JTextField txtSoLuong_sua;
	private JTextField txtTacGia_tim;
	private JTextField txtTenSach_tim;
	private JTable tableQuanLySach;

	/**
	 * Create the panel.
	 */
	public PanelQuanLySach() {
		setLayout(null);
		
		JButton btnThemSach = new JButton("Th\u00EAm s\u00E1ch");
		btnThemSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemSach_click(e);
			}
		});
		btnThemSach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemSach.setBounds(10, 303, 134, 52);
		add(btnThemSach);
		
		JButton btnSuaSLSach = new JButton("S\u1EEDa SL s\u00E1ch");
		btnSuaSLSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSuaSLSach_click(e);
			}
		});
		btnSuaSLSach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaSLSach.setBounds(10, 365, 134, 52);
		add(btnSuaSLSach);
		
		JButton btnTraCuuSach = new JButton("Tra c\u1EE9u s\u00E1ch");
		btnTraCuuSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTraCuuSach_click(e);
			}
		});
		btnTraCuuSach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTraCuuSach.setBounds(10, 426, 134, 52);
		add(btnTraCuuSach);
		
		JPanel panelThemSach = new JPanel();
		TitledBorder titledBorder = new TitledBorder(null, "Th\u00F4ng tin s\u00E1ch m\u1EDBi", TitledBorder.CENTER, TitledBorder.TOP, null, null);
		titledBorder.setTitleFont(new Font("Tahoma", Font.BOLD, 16));
		panelThemSach.setBorder(titledBorder);
		panelThemSach.setBounds(146, 293, 364, 192);
		add(panelThemSach);
		panelThemSach.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn s\u00E1ch:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 39, 72, 17);
		panelThemSach.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NXB:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 76, 72, 17);
		panelThemSach.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("T\u00E1c gi\u1EA3:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 113, 72, 17);
		panelThemSach.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(10, 153, 72, 17);
		panelThemSach.add(lblNewLabel_1_1_1_1);
		
		txtTenSach_them = new JTextField();
		txtTenSach_them.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenSach_them.setBounds(97, 36, 244, 27);
		panelThemSach.add(txtTenSach_them);
		txtTenSach_them.setColumns(10);
		
		txtNXB = new JTextField();
		txtNXB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNXB.setColumns(10);
		txtNXB.setBounds(97, 73, 244, 27);
		panelThemSach.add(txtNXB);
		
		txtTacGia = new JTextField();
		txtTacGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(97, 110, 244, 28);
		panelThemSach.add(txtTacGia);
		
		txtSoLuong_them = new JTextField();
		txtSoLuong_them.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoLuong_them.setColumns(10);
		txtSoLuong_them.setBounds(97, 148, 244, 27);
		panelThemSach.add(txtSoLuong_them);
		
		JPanel panelSuaSL = new JPanel();
		titledBorder = new TitledBorder(null, "S\u1EEDa s\u1ED1 l\u01B0\u1EE3ng s\u00E1ch", TitledBorder.CENTER, TitledBorder.TOP, null, null);
		titledBorder.setTitleFont(new Font("Tahoma", Font.BOLD, 16));
		panelSuaSL.setBorder(titledBorder);
		panelSuaSL.setBounds(511, 293, 319, 102);
		add(panelSuaSL);
		panelSuaSL.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("M\u00E3 s\u00E1ch:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 32, 72, 17);
		panelSuaSL.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 67, 72, 17);
		panelSuaSL.add(lblNewLabel_1_3);
		
		txtMaSach_sua = new JTextField();
		txtMaSach_sua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaSach_sua.setColumns(10);
		txtMaSach_sua.setBounds(90, 29, 207, 25);
		panelSuaSL.add(txtMaSach_sua);
		
		txtSoLuong_sua = new JTextField();
		txtSoLuong_sua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoLuong_sua.setColumns(10);
		txtSoLuong_sua.setBounds(90, 61, 207, 25);
		panelSuaSL.add(txtSoLuong_sua);
		
		JPanel panelTraCuu = new JPanel();
		titledBorder = new TitledBorder(null, "Tra c\u1EE9u s\u00E1ch", TitledBorder.CENTER, TitledBorder.TOP, null, null);
		titledBorder.setTitleFont(new Font("Tahoma", Font.BOLD, 16));
		panelTraCuu.setBorder(titledBorder);
		panelTraCuu.setBounds(511, 393, 319, 91);
		add(panelTraCuu);
		panelTraCuu.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tác giả:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 26, 72, 17);
		panelTraCuu.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("T\u00EAn s\u00E1ch:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(10, 59, 72, 17);
		panelTraCuu.add(lblNewLabel_1_4);
		
		txtTacGia_tim = new JTextField();
		txtTacGia_tim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTacGia_tim.setColumns(10);
		txtTacGia_tim.setBounds(92, 21, 207, 25);
		panelTraCuu.add(txtTacGia_tim);
		
		txtTenSach_tim = new JTextField();
		txtTenSach_tim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenSach_tim.setColumns(10);
		txtTenSach_tim.setBounds(92, 56, 207, 25);
		panelTraCuu.add(txtTenSach_tim);
		//--------------------------
		installAutoComplete(txtTenSach_tim);
		
		tableQuanLySach = new JTable();
		tableQuanLySach.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableQuanLySach.getTableHeader().setBackground(Color.LIGHT_GRAY);
		
		JScrollPane scrollPane = new JScrollPane(tableQuanLySach);
		scrollPane.setLayout(new ScrollPaneLayout());
		scrollPane.setBounds(10, 10, 724, 278);
		add(scrollPane);
		//----------
		loadDataTableQLS();
		
		
		JButton btnTaiLai = new JButton("Tải lại");
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTaiLai_click(e);
			}
		});
		btnTaiLai.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTaiLai.setBounds(744, 241, 99, 42);
		add(btnTaiLai);
		
		JButton btnChiTiet = new JButton("Chi tiết");
		btnChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				(new FrameXemChiTietQLS()).setVisible(true);
			}
		});
		btnChiTiet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChiTiet.setBounds(745, 189, 98, 42);
		add(btnChiTiet);

	}
	// -------->    hiện gợi ý, ví dụ tồn tại tên sách "Con vịt", gõ "Co" nó sẽ gợi ý "Con vịt" <--------<-------<----------
	private void installAutoComplete(JTextField txtTenSach_tim) {

		//----->-->---->   Truy vấn ra đống tên sách vào biến này, kiểu String   <----<------<-----------<-----------
		ArrayList<String> keywords = new ArrayList<String>();
		//keywords.add("Con vịt");
		//keywords.add("Đồi núi");
		//keywords.add("Ba Ba");
		
		
		//------------khong can quan tam--------------------------
		final String COMMIT_ACTION = "commit";
		txtTenSach_tim.setFocusTraversalKeysEnabled(false);
		AutoComplete ac = new AutoComplete(txtTenSach_tim, keywords);
		txtTenSach_tim.getDocument().addDocumentListener(ac);
		txtTenSach_tim.getInputMap().put(KeyStroke.getKeyStroke("TAB"), COMMIT_ACTION);
		txtTenSach_tim.getActionMap().put(COMMIT_ACTION, ac.new CommitAction());
	}
	private boolean isNumeric(String strNum) {

	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	// >--->---------->---->    event click btnThemSach	 <----<------<--------<---------<-------<---<----------
	private void btnThemSach_click(ActionEvent e) {


		// Kiem tra xem dien du thong tin chua
		if (txtTenSach_them.getText().equals("") || txtNXB.getText().equals("") || txtTacGia.getText().equals("")
				|| isNumeric(txtSoLuong_them.getText())==false)
			JOptionPane.showMessageDialog(null, "Vui lòng điền đủ và đúng thông tin!", "Chú ý!", JOptionPane.WARNING_MESSAGE);
		else {
			int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn lưu thông tin chứ?", "Chú ý!", JOptionPane.INFORMATION_MESSAGE);
			if (result == JOptionPane.YES_OPTION)
			{
				// ----->----->->--->  CODE CHÈN SÁCH VÀO CSDL  <------<<-----<-------<-----<-----<------<-
				//                nhớ messagebox thông báo thành công
				
				
			}
		}
	}
	
	//>--->---------->---->    event click btnSuaSach	 <----<------<--------<---------<-------<---<----------
	private void btnSuaSLSach_click(ActionEvent e) {


		// Kiem tra xem dien du thong tin chua
		if (txtMaSach_sua.getText().equals("") || isNumeric(txtSoLuong_sua.getText())==false)
			JOptionPane.showMessageDialog(null, "Vui lòng điền đủ và đúng thông tin!", "Chú ý!", JOptionPane.WARNING_MESSAGE);
		else {
			int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn lưu thông tin chứ?", "Chú ý!", JOptionPane.INFORMATION_MESSAGE);
			if (result == JOptionPane.YES_OPTION)
			{
				// --->->--->  CODE SỬA SL SÁCH VÀO CSDL, XOÁ LUÔN NẾU SL=0  <------<<-----<-------<-----<-----<------<-
				//              nhớ messagebox thông báo thành công
			}
		}
	}
	
	// ->------> truy vấn theo mã hoặc tác giả để đưa lên bảng <------<---------<----------
	private void btnTraCuuSach_click(ActionEvent e) {
		if (txtTacGia_tim.getText().equals("") && txtTenSach_tim.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền vào ít nhất 1 trong 2 trường!", "Chú ý!", JOptionPane.OK_OPTION);
		}
		else {
			//----->    code here    <------------
			
			
			
		}
	}
	
	// ----->----> click event btnChiTiet, show thông tin chi tiết trên cái hàng đang chọn <-------<-------<--------
//	private void btnChiTiet_click(ActionEvent e) {
//		
//	}
	
	// click event btnTaiLai 
	private void btnTaiLai_click(ActionEvent e) {
		loadDataTableQLS();
	}

	// ->--------->-------->  truy vấn dữ liệu cho bảng quản lý sách  <---<---------<----------<---------------
	private DefaultTableModel getDataForModelQLS(DefaultTableModel model) {
		model.addColumn("Mã sách");
		model.addColumn("Tên sách");
		model.addColumn("NXB");
		model.addColumn("Tác giả");
		model.addColumn("Ngày nhập");
		model.addColumn("Số lượng còn");
		
		//code here
		//
		//
		return model;
	}

	// load data cho tableQuanLySach
	private void loadDataTableQLS() {
		DefaultTableModel modelQuanLySach = new DefaultTableModel();
		modelQuanLySach = getDataForModelQLS(modelQuanLySach);
		tableQuanLySach.setModel(modelQuanLySach);
	}
}
