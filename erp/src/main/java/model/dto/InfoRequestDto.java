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

	public InfoRequestDto(int ino, int rno, int pno, int quantity) {
		super();
		this.ino = ino;
		this.rno = rno;
		this.pno = pno;
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "InfoRequestDto [ino=" + ino + ", rno=" + rno + ", pno=" + pno + ", quantity=" + quantity + "]";
	}
	
	
}
