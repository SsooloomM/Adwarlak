package JUnitTesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.SWEProject.Controller.AdminController;
import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;

public class AdminTesting {

	Product product = new Product();
	Store store = new Store();
	AdminController admincontroller = new AdminController();
	//BrandController = new BrandController();
		
	@Test
	public void testAddProduct1() {
		
		product.setName("testproduct");
		product.setId(2);
		product.setLower(1);
		product.setUpper(20);
		product.setCategory("categoryTestaddproduct");
		product.setOnsystem(false);
		product.setType("type");
		
		//AdminController TC01Admin = new AdminController();
		Product result = admincontroller.addProduct(product);
		assertEquals("testproduct",result);
		

//		
//		Product outproduct=TC01Admin.approveProduct(1);
//		assertEquals(1,outproduct);
//		
//		
//		Product addproductTest=TC01Admin.addProduct(Product p);
//		assertEquals(p , addproductTest);
//		
		
		
	//	ProductController TC01Product = new ProductController();
	//	shopOwnerController TC01Shopowner= new shopOwnerController();
	//	Statistics TC01Statistics = new Statistics();
	//	StoreController T01Store=new StoreController();
//		UserController TC01User = new UserController();
//		User validUsername = new User();
//		User validPassword = new User();
//		
//		TC01Admin.approveStore(1);
//		assertEquals(1,TC01Admin);
//		
//		
		
	}
	////////////////////////////////////////////////////////////
	@Test
	   public void testApproveProduct1() { // valid
		Product output= admincontroller.approveProduct(1);
		assertEquals(1,output);
	}
	
	@Test
	   public void testApproveProduct2() { //invalid big number id
		Product output= admincontroller.approveProduct(1000000000);
		assertEquals(1,output);
	}
	
	@Test
	   public void testApproveProduct3() { // invalid this id not exist
		Product output= admincontroller.approveProduct(100);
		assertEquals(1,output);
	}
	
	////////////////////////////////////////////////////////
	@Test
	public void testApproveStore1() {
		Store output= admincontroller.approveStore(1);
		assertEquals(1,output);
		
	}
	
	@Test
	public void testApproveStore2() {  // invalid big id
		Store output= admincontroller.approveStore(100000000);
		assertEquals(1,output);
		
	}
	@Test
	public void testApproveStore3() {  // invalid id not exist
		Store output= admincontroller.approveStore(10);
		assertEquals(1,output);
		
	}
	
}
