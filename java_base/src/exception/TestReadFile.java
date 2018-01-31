/**
 * 
 */
package exception;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author aaron
 *
 */
public class TestReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		
		File file = new File("D:\\Android\\platform-tools\\NOTICE.txt");
		try {
			FileInputStream fs = new FileInputStream(file);
			
			int len = 0;
			byte[] buf = new byte[4096];
			
			while((len = fs.read(buf))!=-1){
				System.out.println(new String(buf, 0, len));
			}
			fs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
