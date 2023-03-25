package model.dao;

public class CompanyDao extends Dao{
	
	// 싱글톤
	private static CompanyDao dao = new CompanyDao();
	private CompanyDao() {}
	public static CompanyDao getInstance() { return dao; }

}
