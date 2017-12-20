package shippingstore;


import static org.junit.Assert.*;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

/**
 * This class is used to create test cases for all methods created in ShippingStore z
 * 
 * class. 
 * @author Jonathan Gonzalez
 *
 */
public class TestShippingStore {
	public static ShippingStore shippingStore;

	/**
	 * identifies before method that is to be executed 
	 * before each test. It creates a new shippingStore object.
	 * @throws IOException
	 */
	@Before
	public void before() throws IOException { 
		shippingStore = new ShippingStore();
		shippingStore.addOrder("abc12", "Letter", "Catalogs", "Retail", "2.33", "4");
		System.out.println("Set Up Environment");
	}
	
	/**
	 * Test Method used to check reference to the data file.
	 */
	@Test
	public void testGetDataFile() {
		File testFile = shippingStore.getDataFile();
		File dataFile = new File("PackageOrderDB.txt");
		assertEquals("Testing DataFile", testFile, dataFile);
	}

	/**
	 * Test Method used to check contents of list called by showPackageOrders. 
	 * ByteArrayOutputStream is used to read in the output to console from showPackageOrders, 
	 * then compared with test data.
	 */
	@Test
	public void testshowPackageOrders() {
		shippingStore.addOrder("12345", "Letter", "Catalogs", "Retail", "2.33", "4");
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		shippingStore.showPackageOrders();
		
		String string = new String(output.toByteArray());
		assertTrue(string, string.contains(String.format("| %-11s| %-8s| %-14s| %-12s| "
				+ "%-11s| %-7s|","12345", "Letter", "Catalogs", "Retail", "2.33", "4" )));
	}
	
	/**
	 * Test Method used to verify showPackageOrdersRange. 
	 * ByteArrayOutputStream is used to read in the output to console from showPackageOrdersRange, 
	 * then compared with test data.
	 */
	@Test
	public void testshowPackageOrdersRange() {
		shippingStore.addOrder("12345", "Letter", "Catalogs", "Retail", "2.33", "4");
		shippingStore.addOrder("67890", "Letter", "Catalogs", "Retail", "2.54", "4");
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		shippingStore.showPackageOrdersRange((float)2.0, (float)2.4);
		
		String string = new String(output.toByteArray());
		assertTrue(string, string.contains(String.format("| %-11s| %-8s| %-14s| %-12s| "
				+ "%-11s| %-7s|","12345", "Letter", "Catalogs", "Retail", "2.33", "4" )));
	}
	
	/**
	 * Test Method is used to check addOrder method. It adds test
	 * data to List, then uses findPackageOrder to verify that it added pacakge to list.
	 */
	@Test
	public void testaddOrder() {
		shippingStore.addOrder("12345", "Letter", "Catalogs", "Retail", "2.33", "4");
		int search = shippingStore.findPackageOrder("12345");
		assertEquals("Add New Order", 1, search);
	}
	
	@Test
	public void testaddOrderDublicate() {
		shippingStore.addOrder("abc12", "Letter", "Catalogs", "Retail", "2.33", "4");
		int search = shippingStore.findPackageOrder("abc123");
		assertEquals("Add New Order", -1, search);
	}
	
	/**
	 * Test Method testremoveOrder adds test data to list, then calls removeOrder
	 * method to remove test data from list. It then checks out to verify it has been 
	 * removed.
	 */
	@Test
	public void testremoveOrder() {
		shippingStore.addOrder("67890", "Letter", "Catalogs", "Retail", "2.33", "4");
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		shippingStore.removeOrder("67890");
		
		String string = new String(output.toByteArray());
		assertTrue(string, string.contains("removed"));
	}
	
	/**
	 * Test Method is used to verify that once test data has been added
	 * it returns order stored in index given. 
	 */
	@Test
	public void testgetPackageOrder() {
		shippingStore.addOrder("89034", "Letter", "Catalogs", "Retail", "2.33", "4");
		PackageOrder p = shippingStore.getPackageOrder(0);
		assertNotNull("Package Order", p);
	}
	
	/**
	 * Cleans environment after methods have been tested. 
	 */
	@After
	public void clearEnvironMent() {
	shippingStore = null;
	System.out.println("Cleared Environment");
	}
}