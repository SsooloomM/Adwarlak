package JUnitTesting;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.SWEProject.Controller.StoreController;
import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;


public class StoreTesting {
	Store store = new Store();
	Product product = new Product();
	StoreController storecontroller = new StoreController();
	
	
	@Test
	public void testShowStores() {
		
	}
	//////////////////////////////////////////
	@Test
	public void testDeleteProduct1() {  // valid bc mwgood
		product.setName("product");
		boolean result = storecontroller.deleteProduct(product);
		assertEquals(true,result);
	}
	
	@Test
	public void testDeleteProduct2() {  // invalid bc msh mwgood
		product.setName("product1");
		boolean result = storecontroller.deleteProduct(product);
		assertEquals(false,result);
	}
	@Test
	public void testDeleteProduct3() {  // invalid bc num
		product.setName("1");
		boolean result = storecontroller.deleteProduct(product);
		assertEquals(false,result);
	}
	//////////////////////////////////////////
	@Test
	public void testAddOwner() {
		
	}
	
	

}
