package mpicbg.stitching.testing;

import ij.*;
import ij.plugin.ImageCalculator;
import java.io.File;

import fiji.Debug;


public class SimpleCompare {

	public static void main(String... args) {
		Debug.run("Grid/Collection stitching", "type=[Positions from file] order=[Defined by image metadata] browse=[" + new File("src/main/data/source_datasets/StandardTest/34-592-A1 SHG Annotation#1_C1_TP0_SP0_FW0.ome.tiff").getAbsolutePath() + "] multi_series_file=[" + new File("src/main/data/source_datasets/StandardTest//34-592-A1 SHG Annotation#1_C1_TP0_SP0_FW0.ome.tiff").getAbsolutePath() + "] fusion_method=[Linear Blending] regression_threshold=0.30 max/avg_displacement_threshold=2.50 absolute_displacement_threshold=3.50 increase_overlap=0 computation_parameters=[Save memory (but be slower)] image_output=[Write to disk] output_directory=" + new File("src/main/data/source_datasets/output").getAbsolutePath());
	//TODO : run this on the output image + the corresponding known standard. Test the histogram output - only the "0" bin should have values in it.
ImagePlus imp = IJ.openImage("src/main/data/source_datasets/output");
//ImagePlus imp = IJ.openImage("/Users/mhiner/loci/Stitching_Tests/src/main/blah/output_standards/position_from_metadata_subpixel/img_t1_z1_c1");
//imp = IJ.openImage("/Users/mhiner/loci/Stitching_Tests/src/main/blah/javatest/position_from_metadata_subpixel/img_t1_z1_c1");
IJ.run("Find Commands...", "");
ImageCalculator ic = new ImageCalculator();
ImagePlus imp1 = WindowManager.getImage("img_t1_z1_c1");
ImagePlus imp2 = WindowManager.getImage("img_t1_z1_c1");
ImagePlus imp3 = ic.run("Subtract create", imp1, imp2);
imp3.show();
IJ.run("Find Commands...", "");
IJ.run(imp, "Histogram", "");
	}
}
