package org.ufrog;
import java.io.FileReader;


public class TestReader {
	static public void main(String [] args){
		try {
	      FileReader fr= new FileReader("/var/lib/docker/devicemapper/mnt/7bd968da48088ed58d08a2b981e36968852144bb91c406974cbc1592562ec067/rootfs/data/applogs/search-mobile-web/logs/tracelog.log");
	      int len = fr.read();
	      System.out.println(len);
		} catch (Exception e) {
	      
	      e.printStackTrace();
      }
	}

}
