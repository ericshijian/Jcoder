package cn.com.infcn.pdfconvert;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.nlpcn.jcoder.run.annotation.Execute;
import org.nlpcn.jcoder.server.rpc.client.VFile;
import org.nutz.ioc.loader.annotation.Inject;

public class Testioc {

	static {
		System.out.println("----------compilaaae----------------");
	}

	@Inject
	private Logger log;

	@Execute
	public VFile searchData(VFile file) throws Exception {

		log.info(file);

		file.writeToFile(new File("/Users/sunjian/Desktop/"), "aaa.dic");

		log.info("writetofile");

		return new VFile(new FileInputStream(new File("/Users/sunjian/Desktop/aaa.dic")));

	}

}
