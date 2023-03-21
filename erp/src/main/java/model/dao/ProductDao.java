package model.dao;

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
			ps.setInt(3, 1);
			int count = ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("newproduct 오류 : "+e);}
		return false;
	}

}
