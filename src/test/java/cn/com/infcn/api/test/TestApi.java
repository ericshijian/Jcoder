package cn.com.infcn.api.test;

import org.nlpcn.jcoder.run.annotation.Execute;

/**
 * 测试api
 * @author Ansj
 *
 */
public class TestApi {

	@Execute(rpc = false)
	public String test(String name) {
		return name;
	}
	
}
