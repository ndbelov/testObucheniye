package framework.utils;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class ImageUtils {

    public static boolean compareImages(String imagePathOne, String imagePathTwo, double coefficient) {
        //System.load("/opt/homebrew/Cellar/opencv/4.11.0/lib/libopencv_java490.dylib");
      //  System.out.println(Core.NATIVE_LIBRARY_NAME);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat img1 = Imgcodecs.imread(imagePathOne);
        Mat img2 = Imgcodecs.imread(imagePathTwo);
        Mat img1Gray = new Mat();
        Mat img2Gray = new Mat();
        Imgproc.cvtColor(img1, img1Gray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.cvtColor(img2, img2Gray, Imgproc.COLOR_BGR2GRAY);
        Mat diff = new Mat();
        Core.absdiff(img1Gray, img2Gray, diff);
        Scalar mean = Core.mean(diff);
        var a = (mean.val[0] / 255);
        return 1 - (mean.val[0] / 255) >= coefficient;
    }
}
