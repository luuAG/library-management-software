package finalProject.jpa.entities;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;



@Entity  
@Table(name="DOCGIA")
@Getter
@Setter
public class DocGia {
	@Id  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="maDG")
    private int maDG;  
	@Column(name="tenDG")
    private String tenDG;  
	@Column(name="diaChiDG")
    private String diaChiDG;  
      
    public DocGia(String tenDG, String diaChiDG) {  
        super();  
          
        this.tenDG = tenDG;  
        this.diaChiDG = diaChiDG;  
    }  
  
    public DocGia() {  
        super();  
    }  
    
    @OneToMany(mappedBy = "DocGia")
	private Set<Muon> muons = new HashSet<Muon>(0);
    
//    public Set<Muon> getMuons() {
//		return muons;
//	}
//    
//    public void setMuons(Set<Muon> muons) {
//		this.muons = muons;
//	}
//  
//    public int get_maDG() {  
//        return maDG;  
//    }  
//  
//    public void set_maDG(int maDG) {  
//        this.maDG = maDG;  
//    } 
//  
//    public String get_tenDG() {  
//        return tenDG;  
//    } 
//  
//    public void set_tenDG(String tenDG) {  
//        this.tenDG = tenDG;  
//    }  
//  
//    public String get_diaChiDG() {  
//        return diaChiDG;  
//    }  
//  
//    public void set_diaChiDG(String diaChiDG) {  
//        this.diaChiDG = diaChiDG;  
//    }

}

