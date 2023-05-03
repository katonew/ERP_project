package model.dto.emp;

public class EmpDto {
	
	private int empno;			//사원 번호
    private String ename ;		//사원이름
    private String erank;		//직급
    private String officephone;	//사내전화번호
    private String ssnum ;		//주민번호
    private String address ;	//집주소
    private String mobile ;		//연락처
    private boolean tenure ;	//재직상태
    private String empid;		//아이디
    private String emppwd ;		//비밀번호
    private String enterdate ;	//입사일
    private String outdate ;	//퇴사일
    private int authority;		//권한정보
    private int dno;			//부서번호(FK)
    private int comno;			//회사번호(FK)
    // 추가
    private String dname;		// 부서명
    
    
    public EmpDto() {
		// TODO Auto-generated constructor stub
	}

	public EmpDto(int empno, String ename, String erank, String officephone, String ssnum, String address,
			String mobile, boolean tenure, String empid, String emppwd, String enterdate, String outdate, int authority,
			int dno, int comno) {
		this.empno = empno;
		this.ename = ename;
		this.erank = erank;
		this.officephone = officephone;
		this.ssnum = ssnum;
		this.address = address;
		this.mobile = mobile;
		this.tenure = tenure;
		this.empid = empid;
		this.emppwd = emppwd;
		this.enterdate = enterdate;
		this.outdate = outdate;
		this.authority = authority;
		this.dno = dno;
		this.comno = comno;
	}
	
	// 출력용
	public EmpDto(int empno, String ename, String dname) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.dname = dname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getErank() {
		return erank;
	}

	public void setErank(String erank) {
		this.erank = erank;
	}

	public String getOfficephone() {
		return officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	public String getSsnum() {
		return ssnum;
	}

	public void setSsnum(String ssnum) {
		this.ssnum = ssnum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isTenure() {
		return tenure;
	}

	public void setTenure(boolean tenure) {
		this.tenure = tenure;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmppwd() {
		return emppwd;
	}

	public void setEmppwd(String emppwd) {
		this.emppwd = emppwd;
	}

	public String getEnterdate() {
		return enterdate;
	}

	public void setEnterdate(String enterdate) {
		this.enterdate = enterdate;
	}

	public String getOutdate() {
		return outdate;
	}

	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public int getDno() {
		return dno;
	}

	public void setDno(int dno) {
		this.dno = dno;
	}

	public int getComno() {
		return comno;
	}

	public void setComno(int comno) {
		this.comno = comno;
	}

	@Override
	public String toString() {
		return "EmpDto [empno=" + empno + ", ename=" + ename + ", erank=" + erank + ", officephone=" + officephone
				+ ", ssnum=" + ssnum + ", address=" + address + ", mobile=" + mobile + ", tenure=" + tenure + ", empid="
				+ empid + ", emppwd=" + emppwd + ", enterdate=" + enterdate + ", outdate=" + outdate + ", authority="
				+ authority + ", dno=" + dno + ", comno=" + comno + "]";
	}
    
    
    

}
