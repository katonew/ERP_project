package model.dto;

public class MemberDto {
	
	private int empno ;				// 사원 번호
	private String ename;			// 사원이름
	private String erank  ;			// 직급
	private String officephone ;	// 사내전화번호
	private String ssnum ;			// 주민번호
	private String address ;		// 집주소
	private String mobile ;			// 연락처
	private boolean tenure ;		// 재직상태
    private String empid ;			// 아이디
    private String emppwd;			// 비밀번호
    private String enterdate ;		// 입사일
    private String outdate ;		// 퇴사일
    private int authority ;			// 권한정보
    
    public MemberDto() {}

	public MemberDto(int empno, String ename, String erank, String officephone, String ssnum, String address,
			String mobile, boolean tenure, String empid, String emppwd, String enterdate, String outdate,
			int authority) {
		super();
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
	}
	// 등록용 생성자
	public MemberDto(String ename, String erank, String officephone, String ssnum, String address, String mobile,
			String empid, String emppwd, String enterdate, int authority) {
		super();
		this.ename = ename;
		this.erank = erank;
		this.officephone = officephone;
		this.ssnum = ssnum;
		this.address = address;
		this.mobile = mobile;
		this.empid = empid;
		this.emppwd = emppwd;
		this.enterdate = enterdate;
		this.authority = authority;
	}
    
    

}
