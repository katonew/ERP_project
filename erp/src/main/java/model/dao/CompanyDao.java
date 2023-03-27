package model.dao;

public class CompanyDao extends Dao{
	
	// 싱글톤
	private static CompanyDao dao = new CompanyDao();
	private CompanyDao() {}
	public static CompanyDao getInstance() { return dao; }
	
	// 회사 로그인 번호로 회사 번호 가져오기
	public int getcomno(int cloginno) {
		String sql = "select comno from company where cloginno = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , cloginno );
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getcomno 오류 : " + e);
		}
		return 0;
	}
}
