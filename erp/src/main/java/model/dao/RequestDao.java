package model.dao;

import java.util.ArrayList;

import model.dto.RequestDto;

public class RequestDao extends Dao{
	// 싱글톤
	private static RequestDao dao = new RequestDao();
	private RequestDao() {}
	public static RequestDao getInstance() { return dao; }
	
	public boolean newrequest(RequestDto dto) {
		String sql = "insert into request(enter_date,empno,pno,quantity,custno,comno) values (?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getEnter_date());
			ps.setInt(2, dto.getEmpno());
			// 직원 가져와서 담당자 설정 구현 예정
			ps.setInt(3, dto.getPno());
			ps.setInt(4, dto.getQuantity());
			ps.setInt(5, dto.getCustno());
			ps.setInt(6, dto.getComno());
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("newrequest 오류 : "+e);}
		return false;
	}
	
	public ArrayList<RequestDto> allproduct(){
		ArrayList<RequestDto> list = new ArrayList<>();
		String sql = "select r.*,e.ename,c.cname, p.pname  from request r, emp e, cust c,product p where r.custno=c.custno and r.pno=p.pno;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				//int rno, String enter_date, String delivery_date, int quantity, String empname, String pname
				RequestDto dto = new RequestDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
						rs.getString(9), rs.getString(10),rs.getString(11));
				list.add(dto);
			}
		} catch (Exception e) {System.out.println("allproduct 오류 : "+e);}
		return list;
	}
	

}
