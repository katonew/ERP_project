package model.dao;

import java.sql.Statement;
import java.util.ArrayList;

import model.dto.RequestDto;

public class RequestDao extends Dao{
	// 싱글톤
	private static RequestDao dao = new RequestDao();
	private RequestDao() {}
	public static RequestDao getInstance() { return dao; }
	
	// 발주 등록 함수
	public boolean newrequest(RequestDto dto) {
		String sql = "insert into request(enter_date,empno,custno,comno) values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getEnter_date());
			ps.setInt(2, dto.getEmpno());
			// 직원 가져와서 담당자 설정 구현 예정
			ps.setInt(3, dto.getCustno());
			ps.setInt(4, dto.getComno());
			int count = ps.executeUpdate();
			int rno = 0;
			if(count==1) {
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					System.out.println("rs :" + rs);
			        rno = rs.getInt(1);
			        System.out.println("rno : " + rno);
			    }
			}
			System.out.println("products : " + dto.getProducts());
			System.out.println("products.size() : " + dto.getProducts().size());
			for(int i=0;i<dto.getProducts().size();i++) {
				sql = "insert into Info_Request(rno,pno,quantity) values (?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, rno);
				ps.setInt(2, dto.getProducts().get(i).getPno());
				ps.setInt(3, dto.getProducts().get(i).getQuantity());
				count = ps.executeUpdate();
			}
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("newrequest 오류 : "+e);}
		return false;
	}
	// 모든 발주 가져오기
	public ArrayList<RequestDto> allrequest(){
		ArrayList<RequestDto> list = new ArrayList<>();
		String sql = "select r.*,e.ename,c.cname,p.pname,p.pprice from request r join cust c on r.custno=c.custno join product p on r.pno=p.pno join emp e on r.empno = e.empno";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				//rno, enter_date,  delivery_date, quantity, empname, cname,  pname
				RequestDto dto = new RequestDto();
				System.out.println("dto : " + dto);
				list.add(dto);
			}
		} catch (Exception e) {System.out.println("allproduct 오류 : "+e);}
		return list;
	}
	
	// 발주 삭제 함수
	public boolean requestDelete(int rno) {
		System.out.println("rno :" + rno);
		String sql = "delete from request where rno = " + rno ;
		try {
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("requestDelete 오류 : "+e);}
		return false;
	}
	
	// 발주번호로 발주 정보 가져오기
	public ArrayList<RequestDto> getRequest(int rno){
		ArrayList<RequestDto> list = new ArrayList<>();
		String sql = "select r.*,e.ename,c.cname,p.pname,p.pprice  from request r "
				+ "join cust c on r.custno=c.custno "
				+ "join product p on r.pno=p.pno "
				+ "join emp e on r.empno = e.empno "
				+ "where r.rno = ? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, rno);
			rs = ps.executeQuery();
			while(rs.next()) {
				//rno, enter_date,  delivery_date, quantity, empname, cname,  pname
				RequestDto dto = new RequestDto();
				System.out.println("dto :" + dto);
				list.add(dto);
			}
		} catch (Exception e) {System.out.println("getRequest 오류 : "+e);}
		return list;
	}
	
	// 발주 수정
	public boolean requestUpdate(int rno,int custno, int pno, int quantity) {
		String sql = "update request set custno=?, pno = ?, quantity = ? where rno = ? " ;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, custno);
			ps.setInt(2, pno);
			ps.setInt(3, quantity);
			ps.setInt(4, rno);
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("requestUpdate 오류 : "+e);}
		return false;
	}
	

}
