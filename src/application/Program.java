package application;

import java.util.Date;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department dep = new Department(1, "Books");
		
		Seller seller = new Seller(2, "Lucas", "lucas@gmail.com", new Date(), 3000.0, dep);
		
		System.out.println(dep);
		System.out.println(seller);
		
		SellerDao sellerDao = new DaoFactory().createSellerDao();
		System.out.println(sellerDao.findById(3));
	}

}
