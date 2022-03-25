package lambdatest;

import org.testng.annotations.Test;

public class TestNGAnnotations 
{
	// Test Case 1
	@Test
	public void e() 
	{
		System.out.println("e");
	} 
	
	// Test Case 2
	@Test(priority = -12)
	public void d() 
	{
		System.out.println("d");
	}
	
	@Test(priority = 3)
	public void a() 
	{
		System.out.println("a");
	}
	
	@Test(priority = 4)
	public void c() 
	{
		System.out.println("c");
	}
	
	@Test(priority = 5)
	public void b() 
	{
		System.out.println("b");
	}
}

