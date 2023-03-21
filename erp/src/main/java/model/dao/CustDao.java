package model.dao;

import model.dto.CustDto;

public class CustDao extends Dao{ 
	
	// 싱글톤
	private static CustDao dao = new CustDao();
	private CustDao() {}
	public static CustDao getInstance() { return dao; }
	
	public boolean newcust(CustDto dto) {
		String sql = "insert into cust(cname,custemp,custphone,custaddress,comno) values (?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCname());
			ps.setString(2, dto.getCustemp());
			ps.setString(3, dto.getCustphone());
			ps.setString(4, dto.getCustaddress());
			ps.setInt(5, 1);
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("newcust 오류 : "+e);}
		return false;
	}
	

}
