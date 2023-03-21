package model.dto;

public class ProductDto {
	
	private int pno; 		//상품코드	
	private String pname; 	//상품명	
	private int pprice; 	//단가
	private int comno; 		//회사번호(FK)
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductDto(int pno, String pname, int pprice, int comno) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.pprice = pprice;
		this.comno = comno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getComno() {
		return comno;
	}

	public void setComno(int comno) {
		this.comno = comno;
	}

	@Override
	public String toString() {
		return "ProductDto [pno=" + pno + ", pname=" + pname + ", pprice=" + pprice + ", comno=" + comno + "]";
	}
	
	

}
