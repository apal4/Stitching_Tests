package mpicbg.stitching.testing;

import java.awt.TextField; 
import java.io.File;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

import fiji.Debug;
import ij.IJ;
import ij.ImagePlus;
import ij.plugin.Histogram;
import ij.plugin.ImageCalculator;
import ij.plugin.PlugIn;

public class StitchingWrapper implements PlugIn {

	@Override
	public void run(String arg) {
		IJ.run("Grid/Collection stitching", arg);
		ImagePlus imp = IJ.getImage();
		ImagePlus imp1 = IJ.openImage("src/main/data/source_datasets/output/test.tif");
			
		double calculated = compare(imp, imp1);
		assertEquals(0,calculated,0.0);
		//System.out.print("OK!");
		
		double reverse = compare(imp, imp1);
		//assertEquals(0,reverse,0.0);
		 
		
	}
	public double compare(ImagePlus imp1, ImagePlus imp2)
	{
		ImageCalculator ic = new ImageCalculator();
		ImagePlus imp3 = ic.run("Subtract create", imp1, imp2);
		double show = imp3.getStatistics().max;
		
		return show;
	}

}
