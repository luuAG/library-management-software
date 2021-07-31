package finalProject.jpa.entities;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MUON")
@Getter
@Setter
public class Muon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maMuon;
	
	@ManyToOne 
    @JoinColumn(name = "maSach") // thông qua khóa ngoại 
    private Sach sach;

	@ManyToOne 
    @JoinColumn(name = "maDG") // thông qua khóa ngoại 
    private DocGia docGia;
	
	@Temporal(TemporalType.DATE)
	private Date ngayMuon;
	
	@Temporal(TemporalType.DATE)
	private Date ngayTra;
	private boolean traChua;
	
	public Muon(DocGia docGia, Sach sach, Date ngayMuon, Date ngayTra, boolean traChua) {
		super();
		this.sach = sach;
		this.docGia = docGia;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
		this.traChua = traChua;
	}
	
	public Muon() {
		super();
	}
	
//	public int get_maMuon() {
//		return maMuon;
//	}
//	
//	public DocGia get_docGia() {
//		return docGia;
//	}
//	
//	public Sach get_sach() {
//		return sach;
//	}
//	
//	public Date get_ngayMuon() {
//		return ngayMuon;
//	}
//	
//	public Date get_ngayTra() {
//		return ngayTra;
//	}
//	
//	public boolean get_traChua() {
//		return traChua;
//	}
//	
//	public void set_maMuon(int maMuon) {
//		this.maMuon = maMuon;
//	}
//	
//	public void set_docGia(DocGia docGia) {
//		this.docGia = docGia;
//	}
//	
//	public void set_maSach(Sach sach) {
//		this.sach = sach;
//	}
//	
//	public void set_ngayMuon(Date ngayMuon) {
//		this.ngayMuon = ngayMuon;
//	}
//	
//	public void set_ngayTra(Date ngayTra) {
//		this.ngayTra = ngayTra;
//	}
//	
//	public void set_traChua(boolean traChua) {
//		this.traChua = traChua;
//	}
}
