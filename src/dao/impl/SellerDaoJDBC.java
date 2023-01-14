package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.SellerDao;
import db.DB;
import db.DbException;
import entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn = null;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller seller) {
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement(
						"INSERT INTO seller "
						+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
						+ "VALUES "
						+ "(?, ?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				
				st.setString(1, seller.getName());
				st.setString(2, seller.getEmail());
				st.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
				st.setDouble(4, seller.getBaseSalary());
				st.setInt(5, seller.getDepartment().getId());
				
				int rowsAffected = st.executeUpdate();
				
				if (rowsAffected > 0) {
					ResultSet rs = st.getGeneratedKeys();
					if (rs.next()) {
						int id = rs.getInt(1);
						seller.setId(id);
					}
					DB.closeResultset(rs);
				}
				else {
					throw new DbException("Unexpected error! No rows affected!");
				}
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		
	}

	@Override
	public void update(Seller seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
