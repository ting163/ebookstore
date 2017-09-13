package com.li.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountUser implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		// httpSessionEvent�¼����������װ���¼�Դ
		HttpSession session = arg0.getSession();
		long count = 1L;
		// �����ݴ����application��
		ServletContext application = session.getServletContext();
		synchronized (application) {
			Object obj = application.getAttribute("counter");
			if (obj != null && obj instanceof Long) {
				count++;
			}
			application.setAttribute("counter", count);
		}
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// httpSessionEvent�¼����������װ���¼�Դ
		HttpSession session = arg0.getSession();
		long count = 1L;
		// �����ݴ����application��
		ServletContext application = session.getServletContext();
		synchronized (application) {
			Object obj = application.getAttribute("counter");
			if (obj != null && obj instanceof Long) {
				count--;
			}
			application.setAttribute("counter", count);
		}
	}
}