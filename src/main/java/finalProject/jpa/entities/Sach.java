package finalProject.jpa.entities;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SACH")
@Getter
@Setter
public class Sach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maSach;
	private String tenTG;
	private String tenNXB;
	private String tenSach;
	private int SLNhap;
	private int SLCon;
	
	public Sach(String tenTG, String tenNXB, String tenSach, int SLNhap, int SLCon) {
		super(); 

		this.tenTG = tenTG;
		this.tenNXB = tenNXB;
		this.tenSach = tenSach;
		this.SLNhap = SLNhap;
		this.SLCon = SLCon;
	}
	
	@OneToMany(mappedBy = "Sach", cascade = CascadeType.ALL)
	private Set<Muon> muons = new HashSet<Muon>(0);
	
	public Set<Muon> getMuons() {
		return muons;
	}
	
	public void setMuons(Set<Muon> muons) {
		this.muons = muons;
	}
	
	public Sach() {
		super();
	}
	
//	public int get_maSach() {
//		return maSach;
//	}
//	
//	public String get_tenTG() {
//		return tenTG;
//	}
//	
//	public String get_tenNXB() {
//		return tenNXB;
//	}
//	
//	public int get_SLNhap() {
//		return SLNhap;
//	}
//	
//	public int get_SLCon() {
//		return SLCon;
//	}
//	
//	public String get_tenSach() {
//		return tenSach;
//	}
//	
//	public void set_maSach(int maSach) {
//		this.maSach = maSach;
//	}
//	
//	public void set_tenTG(String tenTG) {
//		this.tenTG = tenTG;
//	}
//	
//	public void set_tenNXB(String tenNXB) {
//		this.tenNXB = tenNXB;
//	}
//	
//	public void set_tenSach(String tenSach) {
//		this.tenSach = tenSach;
//	}
//	
//	public void set_SLNhap(int SLNhap) {
//		this.SLNhap = SLNhap;
//	}
//	
//	public void set_SLCon(int SLCon) {
//		this.SLCon = SLCon;
//	}
}
