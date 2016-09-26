package au.com.equicord.util;

import java.io.FileDescriptor;
import java.io.FileOutputStream;

public class Util {

	// save uploaded file to a defined location on the server
	static public String saveImage(byte[] imageData, String serverLocation) {
		String result = "";
		byte[] tempImageData = cleanHeader(imageData);
		try {
			FileOutputStream fos = new FileOutputStream(serverLocation);
			fos.write(tempImageData);
			FileDescriptor fd = fos.getFD();
			fos.flush();
			fd.sync();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			result = e.toString();
		}
		return result;
	}

	private static byte[] cleanHeader(byte[] imageData) {
		byte[] resultByteArray = new byte[imageData.length - 74];
		int aux = 0;

		for (int i = 74; i < imageData.length; i++) {
			resultByteArray[aux] = imageData[i];
			aux++;

		}

		return resultByteArray;
	}
	 
}
