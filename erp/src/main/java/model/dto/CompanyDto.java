package model.dto;

public class CompanyDto {
	private int comno; 			//회사고유번호
	private String comname; 	//회사명
    private int cloginno;		//회사 로그인 번호
    
    
    public CompanyDto() {
		// TODO Auto-generated constructor stub
	}


	public CompanyDto(int comno, String comname, int cloginno) {
		super();
		this.comno = comno;
		this.comname = comname;
		this.cloginno = cloginno;
	}


	public int getComno() {
		return comno;
	}


	public void setComno(int comno) {
		this.comno = comno;
	}


	public String getComname() {
		return comname;
	}


	public void setComname(String comname) {
		this.comname = comname;
	}


	public int getCloginno() {
		return cloginno;
	}


	public void setCloginno(int cloginno) {
		this.cloginno = cloginno;
	}


	@Override
	public String toString() {
		return "CompanyDto [comno=" + comno + ", comname=" + comname + ", cloginno=" + cloginno + "]";
	}
    
    
}
