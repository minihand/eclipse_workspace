import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class DownloadFile {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws Exception {
		getContext1("http://apache.opencas.org//commons/logging/binaries/commons-logging-1.2-bin.zip","C:\\commons-logging-1.2-bin1.zip");

	}
	public static void getContext1(String urlStr, String outPath) {// ���������Դ��д��ָ���ļ�
		InputStream in = null;
		OutputStream out = null;
		try {
			HttpURLConnection myurlcon = getConnection(urlStr);
			in = myurlcon.getInputStream();
			//------------���ͷ�����
//			ImageIO.write(ImageIO.read(in), "jpg", new File(outPath));
			//------------��ͳI/O����ͼƬ
			if (outPath == null) {
				out = System.out;
			} else {
				out = new FileOutputStream(outPath);
			}
			// �������out�������ָ��λ��
			byte[] buffer = new byte[1024];
			int bytes_read;
			while ((bytes_read = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytes_read);
			}
			//------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (Exception e) {
			}
		}
	}
	private static HttpURLConnection myurlcon = null;

	/**
	 * ��ȡ�������ӣ��˴�HttpURLConnection��URLConnectionЧ����һ����
	 * @param newUrl
	 * @return
	 */
	public static HttpURLConnection getConnection(String newUrl){
		try {
			myurlcon = (HttpURLConnection)(new URL(newUrl)).openConnection();
//			myurlcon.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myurlcon;
	}

}
