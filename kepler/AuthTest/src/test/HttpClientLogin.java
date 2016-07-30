package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * @author ���� ��chenzenan E-mail:chen.ze.nan@163.com
 * @version ����ʱ�䣺2012-8-10 ����04:35:48 Copyright ? 2012-8-10 Shanghai XXX Co.
 *          Ltd. All right reserved.
 */
public class HttpClientLogin {

	public static void main(String[] args) {
		// ��½ Url
		String loginUrl = "https://passport.csdn.net/account/login";
		// ���½����ʵ� Url
		String dataUrl = "http://my.csdn.net/kukudetian";

		HttpClient httpClient = new HttpClient();

		// ģ���½����ʵ�ʷ�������Ҫ��ѡ�� Post �� Get ����ʽ
		PostMethod postMethod = new PostMethod(loginUrl);

		// ���õ�½ʱҪ�����Ϣ���û���������
		NameValuePair[] data = { new NameValuePair("username", "kukudetian"), new NameValuePair("password", "287935651kutian") };
		postMethod.setRequestBody(data);
		try {
			// ���� HttpClient ���� Cookie,���������һ���Ĳ���
			httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			httpClient.executeMethod(postMethod);
			// ��õ�½��� Cookie
			Cookie[] cookies = httpClient.getState().getCookies();
			StringBuffer tmpcookies = new StringBuffer();
			for (Cookie c : cookies) {
				tmpcookies.append(c.toString() + ";");
			}
			postMethod.releaseConnection();
			// ���е�½��Ĳ���1581,1602,1603,1610,1609,1608,1607,1606,1605,1620,1619,1617,1616,1622,1626,1642,1648,1647,1657
			GetMethod getMethod = new GetMethod(dataUrl);
			// ÿ�η�������Ȩ����ַʱ�����ǰ��� cookie ��Ϊͨ��֤
			getMethod.setRequestHeader("cookie", tmpcookies.toString());
			// �㻹����ͨ�� PostMethod/GetMethod ���ø�������������
			// ���磬referer ���������ģ�UA ���������涼������Լ���˭�����������������
			getMethod.setRequestHeader("Referer", "http://www.cc");
			getMethod.setRequestHeader("User-Agent", "www Spot");
			httpClient.executeMethod(getMethod);
			// ��ӡ���������ݣ�����һ���Ƿ�ɹ�
			InputStream ins = getMethod.getResponseBodyAsStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(ins,"utf-8"));
			
			String line;
			while((line = reader.readLine())!=null){
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
