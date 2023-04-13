package model.dto;

public class RequestDto {
	
	private int rno ;				// 발주번호
	private String enter_date ;		// 등록일자
	private String delivery_date ;	// 납기일자
	private int empno ;				// 거래담당자(FK)
	private int custno ;			// 거래처번호(FK)    
	private int comno ;				// 회사번호(FK)
	// 추가
	private String empname;	// 거래담당자이름
	private String cname;	// 거래처 이름
	
	public RequestDto() {}
	

	// 등록용 생성자
	public RequestDto(String enter_date, int empno, int custno, int comno) {
		super();
		this.enter_date = enter_date;
		this.empno = empno;
		this.custno = custno;
		this.comno = comno;
	}
	
	// 출력용 생성자
	
	public RequestDto(int rno, String enter_date, String delivery_date, 
			String empname,String cname ) {
		super();
		this.rno = rno;
		this.enter_date = enter_date;
		this.delivery_date = delivery_date;
		this.empname = empname;
		this.cname = cname;
	}
	
	

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getEnter_date() {
		return enter_date;
	}

	public void setEnter_date(String enter_date) {
		this.enter_date = enter_date;
	}

	public String getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}


	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public int getComno() {
		return comno;
	}

	public void setComno(int comno) {
		this.comno = comno;
	}


	@Override
	public String toString() {
		return "RequestDto [rno=" + rno + ", enter_date=" + enter_date + ", delivery_date=" + delivery_date + ", empno="
				+ empno + ", custno=" + custno + ", comno=" + comno + ", empname=" + empname + ", cname=" + cname + "]";
	}

	
	
	
	

}
