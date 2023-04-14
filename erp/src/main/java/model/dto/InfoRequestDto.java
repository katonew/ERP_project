package model.dto;

public class InfoRequestDto {
	private int ino;// PK
	private int rno;// 발주번호
	private int pno;//상품번호
	private int quantity; //발주수량
	// 추가
	private String pname;	// 상품이름
	private int pprice;		// 상품가격
	
	
	public InfoRequestDto() {}
	
	// 등록용
	public InfoRequestDto(int ino, int rno, int pno, int quantity) {
		super();
		this.ino = ino;
		this.rno = rno;
		this.pno = pno;
		this.quantity = quantity;
	}
	// 출력용 풀생성자
	public InfoRequestDto(int ino, int rno, int pno, int quantity, String pname, int pprice) {
		super();
		this.ino = ino;
		this.rno = rno;
		this.pno = pno;
		this.quantity = quantity;
		this.pname = pname;
		this.pprice = pprice;
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "InfoRequestDto [ino=" + ino + ", rno=" + rno + ", pno=" + pno + ", quantity=" + quantity + ", pname="
				+ pname + ", pprice=" + pprice + "]";
	}
	
	
}
