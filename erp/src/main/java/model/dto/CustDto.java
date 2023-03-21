package model.dto;

public class CustDto {
	
	private int custno; 			// 거래처고유번호
	private String cname; 			// 거래처명
	private String custemp; 		// 거래처담당자명
	private String custphone; 		// 거래처번호
	private String custaddress; 	// 거래처주소
    private int comno;
    
    public CustDto() {
		// TODO Auto-generated constructor stub
	}

	public CustDto(int custno, String cname, String custemp, String custphone, String custaddress, int comno) {
		super();
		this.custno = custno;
		this.cname = cname;
		this.custemp = custemp;
		this.custphone = custphone;
		this.custaddress = custaddress;
		this.comno = comno;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCustemp() {
		return custemp;
	}

	public void setCustemp(String custemp) {
		this.custemp = custemp;
	}

	public String getCustphone() {
		return custphone;
	}

	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}

	public String getCustaddress() {
		return custaddress;
	}

	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}

	public int getComno() {
		return comno;
	}

	public void setComno(int comno) {
		this.comno = comno;
	}

	@Override
	public String toString() {
		return "CustDto [custno=" + custno + ", cname=" + cname + ", custemp=" + custemp + ", custphone=" + custphone
				+ ", custaddress=" + custaddress + ", comno=" + comno + "]";
	}
    
    

}
