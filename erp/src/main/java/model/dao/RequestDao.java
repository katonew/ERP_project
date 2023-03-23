package model.dao;

import model.dto.RequestDto;

public class RequestDao extends Dao{
	// 싱글톤
	private static RequestDao dao = new RequestDao();
	private RequestDao() {}
	public static RequestDao getInstance() { return dao; }
	
	public boolean newrequest(RequestDto dto) {
		String sql = "insert into request(enter_date,empno,pno,custno,comno) values (?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getEnter_date());
			ps.setInt(2, 1);
			// 직원 가져와서 담당자 설정 구현 예정
			ps.setInt(3, dto.getPno());
			ps.setInt(4, dto.getCustno());
			ps.setInt(5, 1);
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("newrequest 오류 : "+e);}
		return false;
	}
	

}
