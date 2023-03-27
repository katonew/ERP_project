package model.dao;

import model.dto.emp.EmpDto;

public class MemberDao extends Dao{

	// 싱글톤
	private static MemberDao dao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() { return dao; }
	
	// 로그인 메소드
	public boolean login(int cloginno,String empid,String emppwd) {
		String sql = "select * from emp where empid = ? and emppwd = ? and comno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, empid);
			ps.setString(2, emppwd);
			ps.setInt(3, 1);
			rs = ps.executeQuery();
			if( rs.next() ) {  return true; } // 만약에 조건에 충족한 레코드가 존재하면 
		}catch (Exception e) {System.out.println(e);} return false;
	}
	
	//회원번호로 회원정보 가져오기
	public EmpDto getEmpInfo(int empno) {
		String sql = "select *from emp where empno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , empno );
			rs = ps.executeQuery();
			if(rs.next()) {
				EmpDto dto = new EmpDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4),rs.getString(5), rs.getString(6), 
						rs.getString(7),false, rs.getString(9), 
						rs.getString(10), rs.getString(11), rs.getString(12), 
						rs.getInt(13), rs.getInt(14), rs.getInt(15));
				return dto;
			}
		} catch (Exception e) {
			System.out.println("getEmpInfo 오류 : " + e);
		}
		return null;
	} // getEmpInfo e
	
	// 회원 아이디로 회원 번호 가져오기
	public int getEmpno(String empid) {
		String sql = "select empno from emp where empid = ? and comno=1";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , empid );
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getEmpno 오류 : " + e);
		}
		return 0;
	} // getEmpInfo e
	
}
