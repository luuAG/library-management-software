package finalProject.jpa.window;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelLichSu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableLichSu;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelLichSu() {
		setLayout(null);
		
		tableLichSu = new JTable();
		tableLichSu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		//table.setBounds(10, 10, 825, 303);
		
		JScrollPane scrollPane = new JScrollPane(tableLichSu);
		scrollPane.setBounds(10, 10, 825, 386);
		scrollPane.setLayout(new ScrollPaneLayout());
		add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Tên độc giả");
		model.addColumn("Tên sách");
		model.addColumn("Tác giả");
		model.addColumn("NXB");
		model.addColumn("Ngày mượn");
		model.addColumn("Ngày trả");
		model.addColumn("Tình trạng");
		tableLichSu.setModel(model);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBounds(183, 411, 274, 41);
		add(textField);
		textField.setColumns(10);
		
		JButton btnTraCuu = new JButton("Tra cứu");
		btnTraCuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTraCuu_click(e);
			}
		});
		btnTraCuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTraCuu.setBounds(476, 413, 133, 39);
		add(btnTraCuu);
		tableLichSu.getTableHeader().setBackground(Color.LIGHT_GRAY);
		
		
		

	}
	// ------->    mời anh Tín xơi  ư ư <-------------
	void btnTraCuu_click(ActionEvent e) {
		
	}
}
