package JUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.SWEProject.Controller.UserController;
import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.User;

public class UserTesting {
	User user = new User();
	Store store = new Store();
	Product product = new Product();
	UserController usercontroller = new UserController();
	
	@Test
	public void testRegister() {
		
		User TC01User1 = new User();
		TC01User1.setUserName("user");
		TC01User1.setPassword("123");
		//validUsername.getUserName();
		assertEquals("user",TC01User1.getUserName());
	}
	@Test
	public void testRegister1() {
		
		user.setUserName("testregister");
		user.setPassword("123");
	//	user.setOperations(operations);
		User result = usercontroller.login(user);
		assertEquals("testlogin",result);
	}
	@Test
	public void testRegister2() {
		
		user.setUserName("");
		user.setPassword("123");
		User result = usercontroller.login(user);
		assertEquals(null,result);
	}
	@Test
	public void testRegister3() {
		
		user.setUserName("testregister");
		user.setPassword("");
		User result = usercontroller.login(user);
		assertEquals(null,result);
	}
	//////////////////////////////////////////////
	@Test
	public void testLogin1() {
		
		user.setUserName("testlogin");
		user.setPassword("123");
		User result = usercontroller.login(user);
		assertEquals("testlogin",result);
	}
	@Test
	public void testLogin2() {
		
		user.setUserName("");
		user.setPassword("123");
		User result = usercontroller.login(user);
		assertEquals(null,result);
	}
	@Test
	public void testLogin3() {
		
		user.setUserName("");
		user.setPassword("");
		User result = usercontroller.login(user);
		assertEquals(null,result);
	}
    /////////////////////////////////////////////
	@Test
	public void testRequestStore1() {
		store.setName("testrequestStore");
		boolean result = usercontroller.requestStore(store);
		assertEquals(true,result);
	}
	@Test
	public void testRequestStore2() {
		store.setName("");
		boolean result = usercontroller.requestStore(store);
		assertEquals(false,result);
	}
	@Test
	public void testRequestStore3() {
		store.setName("122");
		boolean result = usercontroller.requestStore(store);
		assertEquals(false,result);
	}
	/////////////////////////////////////////////////////
	@Test
	public void testRequestProduct1() { //valid
		product.setName("testrequestStore");
		boolean result = usercontroller.requestProduct(product);
		assertEquals(true,result);
	}
	@Test
	public void testRequestProduct2() {  // invalid bc empty
		product.setName("");
		boolean result = usercontroller.requestProduct(product);
		assertEquals(false,result);
	}
	
	@Test
	public void testRequestProduct3() {  // invalid bc num
		product.setName("123");
		boolean result = usercontroller.requestProduct(product);
		assertEquals(false,result);
	}
	////////////////////////////////////////////////////
//	UserController userc = new UserController();
//	userc.Register(null);
//	assertEquals(null,userc);
//	
}
