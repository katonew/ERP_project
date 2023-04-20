package model.dao;

import java.util.ArrayList;

import model.dto.CustDto;
import model.dto.ProductDto;

public class ProductDao extends Dao{
	
	// 싱글톤
	private static ProductDao dao = new ProductDao();
	private ProductDao() {}
	public static ProductDao getInstance() { return dao; }
	
	public boolean newproduct(ProductDto dto) {
		String sql = "insert into product(pname,pprice,comno) values (?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setInt(2, dto.getPprice());
			ps.setInt(3, dto.getComno());
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("newproduct 오류 : "+e);}
		return false;
	}
	
	public ArrayList<ProductDto> allproduct(){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = "select *from product";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDto dto = new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(dto);
			}
		} catch (Exception e) {System.out.println("allcust 오류 : "+e);}
		return list;
	}
	
	public ArrayList<ProductDto> getproduct(int pno){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = "select *from product where pno ="+pno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDto dto = new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(dto);
			}
		} catch (Exception e) {System.out.println("getproduct 오류 : "+e);}
		return list;
	}
	
	public boolean deleteProduct(int pno) {
		String sql = "delete from product where pno = " + pno;
		try {
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("deleteProduct 오류 : "+e);}
		return false;
	}
	
	public boolean pupdate(ProductDto dto) {
		String sql = "update product set pname = ?, pprice = ? where pno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setInt(2, dto.getPprice());
			ps.setInt(3, dto.getPno());
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("pupdate 오류 : "+e);}
		return false;
	}
	public ArrayList<ProductDto> searchproduct(String search){
		ArrayList<ProductDto> result = new ArrayList<>();
		String sql = "select *from product where pname like  ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+search+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDto dto = new ProductDto(rs.getInt(1), rs.getString(2), 
						rs.getInt(3), rs.getInt(4));
				result.add(dto);
			}
		} catch (Exception e) {
			System.out.println("searchproduct 오류 : "+e);
		}
		return result;
	}
	

}
