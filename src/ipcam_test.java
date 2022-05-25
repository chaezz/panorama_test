import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class ipcam_test { 

		public static void main(String[] args) throws Exception {
			OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("rtsp://admin:sijung5520@192.168.100.132/profile2/media.smp"); 
		    frameGrabber.setFormat("mjpeg");
		    frameGrabber.start();
		    IplImage iPimg = frameGrabber.grab();
		    CanvasFrame canvasFrame = new CanvasFrame("Camera");
		    canvasFrame.setCanvasSize(iPimg.width(), iPimg.height());
		    
		    while (canvasFrame.isVisible() && (iPimg = frameGrabber.grab()) != null) {
		        canvasFrame.showImage(iPimg);
		    }
		    frameGrabber.stop();
		    canvasFrame.dispose();
		    System.exit(0);
		}
		}