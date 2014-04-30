package mpicbg.stitching.testing;

import ij.*;
import ij.plugin.ImageCalculator;

import java.awt.TextField;
import java.io.File;
import java.lang.reflect.Field;

import org.junit.Test;

import fiji.Debug;


public class SimpleCompare {


	public void testCompare() {
		String path = new File("src/main/data/source_datasets/StandardTest/34-592-A1 SHG Annotation#1_C1_TP0_SP0_FW0.ome.tiff").getAbsolutePath();
		String outDir = new File("src/main/data/source_datasets/output").getAbsolutePath();
		String compare = new File("src/main/data/source_datasets/StandardTest/34-592-A1 SHG Annotation#1_C1_TP0_SP0_FW0.ome.tiff").getAbsolutePath();
		String cOut = new File("src/main/data/source_datasets/outputs").getAbsolutePath();
		Object stitching = Debug.runPlugIn("mpicbg.stitching.testing.StitchingWrapper", 
			"type=[Positions from file] " +
			"order=[Defined by image metadata] " +
			"browse=[" + path  + "] " +
			"multi_series_file=[" + path  + "] " +
			"fusion_method=[Linear Blending] " +
			"regression_threshold=0.30 " +
			"max/avg_displacement_threshold=2.50 " +
			"absolute_displacement_threshold=3.50 " +
			"increase_overlap=0 " +
			"computation_parameters=[Save memory (but be slower)] " +
			"image_output=[Fuse and display] " +
			"output_directory=" +outDir, false );
		
		/*Object stitch2 = Debug.runPlugIn("mpicbg.stitching.testing.StitchingWrapper", 
				"type=[Positions from file] " +
				"order=[Defined by image metadata] " +
				"browse=[" + compare  + "] " +
				"multi_series_file=[" + compare  + "] " +
				"fusion_method=[Linear Blending] " +
				"regression_threshold=0.30 " +
				"max/avg_displacement_threshold=2.50 " +
				"absolute_displacement_threshold=3.50 " +
				"increase_overlap=0 " +
				"computation_parameters=[Save memory (but be slower)] " +
				"image_output=[Fuse and display] " +
				"output_directory=" +cOut, false );
				*/
	//ImagePlus imp = IJ.getImage();
	//TODO : run this on the output image + the corresponding known standard. Test the histogram output - only the "0" bin should have values in it.
//ImagePlus imp = IJ.openImage("src/main/data/source_datasets/output");
//ImagePlus imp = IJ.openImage("/Users/mhiner/loci/Stitching_Tests/src/main/blah/output_standards/position_from_metadata_subpixel/img_t1_z1_c1");
//imp = IJ.openImage("/Users/mhiner/loci/Stitching_Tests/src/main/blah/javatest/position_from_metadata_subpixel/img_t1_z1_c1");
//IJ.run("Find Commands...", "");
//ImageCalculator ic = new ImageCalculator();
//ImagePlus imp1 = WindowManager.getImage("img_t1_z1_c1");
//ImagePlus imp2 = WindowManager.getImage("img_t1_z1_c1");
//ImagePlus imp3 = ic.run("Subtract create", imp1, imp2);
//imp3.show();
//IJ.run("Find Commands...", "");
//Object histogram = IJ.runPlugIn(imp, "Histogram", "");
		//Field f = histogram.getClass().getDeclaredField("maxField"); //NoSuchFieldException
		//f.setAccessible(true);
		//TextField iWantThis = (TextField) f.get(histogram); //
	}
}
