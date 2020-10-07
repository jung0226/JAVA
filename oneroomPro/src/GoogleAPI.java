import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GoogleAPI extends JFrame{
	//해당 구글맵 이미지 다운
	public void downloadMap(String location) {
		try {
			String imageURL="http://maps.googleapis.com/maps/api/staticmap?key=AIzaSyCKDr4F0a-1k5yFfVtO6BV22sSngR6nu50&center="+location+"&zoom=17&size=612x612&scale=2&markers=color:red|37.552629,%20126.937680";
			URL url = new URL(imageURL);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(location);
			byte[]b = new byte[2048];//사용자가 원하는 이미지 파일의 맵을 받는다.
			int length;
			while ((length=is.read(b))!=-1) {
				os.write(b,0,length);
			}
			is.close();
			os.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//실제로 받은 이미지 맵을 가져온다. 
	public ImageIcon getMap(String location) {
		return new ImageIcon((new ImageIcon(location)).getImage().getScaledInstance(500,500, java.awt.Image.SCALE_SMOOTH));
	}	
}


