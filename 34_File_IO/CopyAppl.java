import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyAppl {
	
	private static final int BUFFER = 16_000_000;
	
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println(
					"You need to specify two paths for the application: the source file and the destination file.");
			return;
		}

		File src = new File(args[0]);
		File dst = new File(args[1]);
		boolean overwrite = args.length > 2 && args[2].equalsIgnoreCase("overwrite");
		
		CopyFile(src, dst, overwrite);

	}

	
	private static void CopyFile(File src, File dst, boolean overwrite) {
		checkPaths(src, dst, overwrite);
		
		InputStream  in  = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dst);
			
			long start = System.currentTimeMillis();
	    	
			byte[] buffer = new byte[BUFFER];//  [16*1024];
			int bytesRead;
			long resBytes = 0;
			
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
				resBytes += bytesRead;
			}
			
			long end = System.currentTimeMillis();
			long duration = end - start;
			
			String bitrate = duration == 0? " --> 0 ":String.format("%.5f", (double) resBytes / duration);
			System.out.printf("File has been copied with bitrate %s  <number bytes per one millisecond>", bitrate);
		} catch (IOException e) {
				System.out.println(e.getMessage());
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	private static void checkPaths(File src, File dst, boolean overwrite) {
		if (!src.exists() || !src.isFile()) {
			throw new IllegalArgumentException("Source must be an existing file!");
		}
		
		if (dst.exists() && dst.isFile() && !overwrite) {
			throw new IllegalArgumentException("Can't overwrite destination file");
		}
		
	}
}
