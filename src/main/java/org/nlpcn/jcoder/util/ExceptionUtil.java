package org.nlpcn.jcoder.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 打印异常
 * 
 * @author ansj
 * 
 */
public class ExceptionUtil {

	private static final Logger LOG = Logger.getLogger(ExceptionUtil.class);

	/**
	 * 将堆栈异常转换为string
	 * 
	 * @param e
	 * @return
	 */
	public static String printStackTrace(Throwable e) {
		try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
			// 将出错的栈信息输出到printWriter中
			e.printStackTrace(pw);
			pw.flush();
			sw.flush();
			return sw.toString();
		} catch (IOException e1) {
			LOG.info(e1);
			return e.getMessage();
		}
	}

	/**
	 * 将堆栈异常转换为string,转为一行
	 * 
	 * @param e
	 * @return
	 */
	public static String printStackTraceWithOutLine(Throwable e) {
		try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
			// 将出错的栈信息输出到printWriter中
			e.printStackTrace(pw);
			pw.flush();
			sw.flush();
			return sw.toString().replace("\n", "\t");
		} catch (IOException e1) {
			LOG.info(e1);
			return e.getMessage();
		}
	}

	/**
	 * 检查当前抛出异常是否是interruptException
	 * 
	 * @param e
	 * @return
	 */
	public static boolean checkInterruptException(Exception e) {

		boolean interrupt = false;

		if (e instanceof InterruptedException) {
			interrupt = true;
		}

		if (e.toString().toLowerCase().contains("interrupt")) {
			interrupt = true;
		}

		Throwable cause = e;
		do {
			if (cause instanceof InterruptedException) {
				interrupt = true;
				break;
			}
		} while ((cause = cause.getCause()) != null);

		return interrupt;
	}
}
