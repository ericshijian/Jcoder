package org.nlpcn.jcoder.job;

import org.apache.log4j.Logger;
import org.nlpcn.jcoder.service.TaskService;
import org.nlpcn.jcoder.util.StaticValue;

/**
 * 定期检查集群运行情况。只有master可以
 *
 * @author ansj
 */
public class CheckTaskJob implements Runnable {

	private static final Logger LOG = Logger.getLogger(CheckTaskJob.class);

	@Override
	public void run() {

		TaskService taskService = StaticValue.getBean(TaskService.class, "taskService");

		while (true) {
			try {
				Thread.sleep(60000L);
				LOG.info("begin checkTaskJob");
				taskService.checkAllTask();
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(e);
			}
		}
	}
}
