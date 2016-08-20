package org.nlpcn.jcoder.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;
import org.nlpcn.commons.lang.util.StringUtil;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.json.JsonLoader;
import org.nutz.lang.Mirror;

/**
 * Test your task
 * 
 * @author Ansj
 *
 */
public class Testing {

	/**
	 * instan task by ioc
	 * 
	 * @param c
	 * @return class c instance
	 * @throws Exception
	 */
	public static <T> T instance(Class<T> c, String iocPath) throws Exception {
		Ioc ioc = new NutIoc(new JsonLoader(iocPath));

		Mirror<?> mirror = Mirror.me(c);
		T obj = c.newInstance();

		for (Field field : mirror.getFields()) {
			Inject inject = field.getAnnotation(Inject.class);
			if (inject != null) {
				if (field.getType().equals(Logger.class)) {
					mirror.setValue(obj, field, Logger.getLogger(c));
				} else {
					mirror.setValue(obj, field, ioc.get(field.getType(), StringUtil.isBlank(inject.value()) ? field.getName() : inject.value()));
				}
			}
		}

		return obj;
	}

	public static <T> T instance(Class<T> c) throws Exception {
		return instance(c, "resource/ioc.js");
	}

	public static String remote(Class<?> c, String methodName , Object... params){
		
	}

}
