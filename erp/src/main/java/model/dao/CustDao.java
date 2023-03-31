package model.dao;

import java.util.ArrayList;

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
	
	public ArrayList<CustDto> allcust(){
		ArrayList<CustDto> list = new ArrayList<>();
		String sql = "select *from cust";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CustDto dto = new CustDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6));
				list.add(dto);
			}
		} catch (Exception e) {System.out.println("allcust 오류 : "+e);}
		return list;
	}
	
	public ArrayList<CustDto> getcust(int custno){
		ArrayList<CustDto> list = new ArrayList<>();
		String sql = "select *from cust where custno = "+custno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CustDto dto = new CustDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6));
				list.add(dto);
			}
		} catch (Exception e) {System.out.println("allcust 오류 : "+e);}
		return list;
	}
	
	public boolean custupdate(CustDto dto) {
		String sql = "update cust set cname =? , custemp =? ,custphone=?,custaddress=? where custno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCname());
			ps.setString(2, dto.getCustemp());
			ps.setString(3, dto.getCustphone());
			ps.setString(4, dto.getCustaddress());
			ps.setInt(5, dto.getCustno());
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("custupdate 오류 : "+e);}
		return false;
	}

}
