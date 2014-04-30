package mpicbg.stitching.testing;

import org.junit.Test;


public class StitchingTests {
	
	@Test
	public void testStitching() 
	{
		SimpleCompare simple = new SimpleCompare();  
		simple.testCompare();
		
		SubpixelCompare pixels = new SubpixelCompare();
		pixels.testPixel();
	}
	

}
