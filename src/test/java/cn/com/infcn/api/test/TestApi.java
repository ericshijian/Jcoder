package cn.com.infcn.api.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.nlpcn.jcoder.run.annotation.Execute;
import org.nlpcn.jcoder.util.StaticValue;
import org.nutz.ioc.loader.annotation.Inject;

/**
 * 测试api
 * @author Ansj
 *
 */
public class TestApi {
	
	@Inject
	private Logger log ;
	
	@Inject
	private ExecutorService threadPool ;

	@Execute
	public ExecutorService test() {
		return threadPool;
	}
	
}
