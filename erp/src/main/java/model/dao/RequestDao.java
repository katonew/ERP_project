package model.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dto.InfoRequestDto;
import model.dto.RequestDto;

public class RequestDao extends Dao{
	// 싱글톤
	private static RequestDao dao = new RequestDao();
	private RequestDao() {}
	public static RequestDao getInstance() { return dao; }
	
	// 발주 등록 함수
	public boolean newrequest(RequestDto dto) {
		String sql = "insert into request(delivery_date,empno,custno,comno) values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getDelivery_date());
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
		String sql = "select r.*,e.ename,c.cname "
				+ "from request r "
				+ "join cust c on r.custno=c.custno "
				+ "join emp e on r.empno = e.empno order by rno desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				sql = " select i.*,p.pname,p.pprice from info_request i "
						+ "join product p on i.pno=p.pno where i.rno = "+rs.getInt(1);
				ps = con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
				List<InfoRequestDto> plist = new ArrayList<>();
				while(rs2.next()) {
					InfoRequestDto idto = new InfoRequestDto(rs2.getInt(1), rs2.getInt(2), 
							rs2.getInt(3),rs2.getInt(4), rs2.getString(5), rs2.getInt(6));
					plist.add(idto);
					System.out.println("idto : " + idto);
				}
				RequestDto dto = new RequestDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(8), rs.getString(9), rs.getBoolean(4),plist);
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
		String sql = "select r.*,e.ename,c.cname "
				+ "from request r "
				+ "join cust c on r.custno=c.custno "
				+ "join emp e on r.empno = e.empno where rno =" + rno ;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				sql = " select i.*,p.pname,p.pprice from info_request i "
						+ "join product p on i.pno=p.pno where i.rno = "+rno;
				ps = con.prepareStatement(sql);
				ResultSet rs2 = ps.executeQuery();
				List<InfoRequestDto> plist = new ArrayList<>();
				while(rs2.next()) {
					InfoRequestDto idto = new InfoRequestDto(rs2.getInt(1), rs2.getInt(2), 
							rs2.getInt(3),rs2.getInt(4), rs2.getString(5), rs2.getInt(6));
					plist.add(idto);
					System.out.println("idto : " + idto);
				}
				RequestDto dto = new RequestDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(8), rs.getString(9),rs.getBoolean(4), plist);
				System.out.println("dto : " + dto);
				list.add(dto);
			}
		} catch (Exception e) {System.out.println("allproduct 오류 : "+e);}
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
	
	// 발주 상태 변경함수
	public boolean stateUpdate(int rno, boolean state) {
		String sql = "update request set state = ? where rno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setBoolean(1, !state);
			ps.setInt(2, rno);
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("stateUpdate 오류 : "+e);}
				
		return false;
	}
	

}
