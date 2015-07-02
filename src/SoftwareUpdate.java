import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class SoftwareUpdate {

	public static void copyFile(String filesrc, String filedst) {
		FileChannel src = null, dst = null;

		try {
			src = new FileInputStream(new File(filesrc)).getChannel();
			dst = new FileOutputStream(new File(filedst)).getChannel();
			dst.transferFrom(src, 0, src.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (src != null) {
					src.close();
				}
				if (dst != null) {
					dst.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void delFile(String filename) {
		try {
			File file = new File(filename);
			if (file.exists()) {
				if (file.isFile()) {
					file.delete();
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		String[] sourceFile = new String[6];
		sourceFile[0] = "IP_Server.jar";
		sourceFile[1] = "IP_User.jar";
		sourceFile[2] = "IP_AddressWriter.jar";
		sourceFile[3] = "IP_Configure.jar";
		sourceFile[4] = "IP_RemoteUser.jar";
		sourceFile[5] = "Update.jar";

		String[] destPath = new String[6];
		destPath[0] = "IPServer";
		destPath[1] = "IPUser";
		destPath[2] = "IPAddressWriter";
		destPath[3] = "IPConfigure";
		destPath[4] = "IPRemoteUser";
		destPath[5] = "Update";

		for (int i = 0; i < sourceFile.length; i++) {
			copyFile("..\\" + sourceFile[i], "..\\" + destPath[i] + "\\"
					+ sourceFile[i]);
		}

		for (int i = 0; i < sourceFile.length; i++) {
			delFile("..\\" + sourceFile[i]);
		}

		System.out.println("Éý¼¶Íê³É.");
	}
}