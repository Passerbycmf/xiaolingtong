package com.interceptor;


import com.bean.Member;
import com.common.SystemConfig;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WxLoginInterceptor extends BaseInterceptor {

	@Override
	public boolean isWxLoginHandler(Object handler) {
		if (!(handler instanceof HandlerMethod)) {
			return false;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		CheckWxLogin loginHandler = handlerMethod.getMethodAnnotation(CheckWxLogin.class);
		if (loginHandler == null) {
			return false;
		}
		//success = loginHandler.success();
		failed = loginHandler.failed();
		return true;
	}



	@Override
	public boolean checkWxLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(SystemConfig.MemberSession);
		if (member==null) {
			String contextPath=request.getContextPath();
			response.sendRedirect(contextPath+failed);
			return false;
		}
		return true;
	}


	@Override
	public boolean isMemberActivityHandler(Object handler) {
		if (!(handler instanceof HandlerMethod)) {
			return false;
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		CheckMemberActivity memberActivityHandler = handlerMethod.getMethodAnnotation(CheckMemberActivity.class);
		if (memberActivityHandler == null) {
			return false;
		}
		//success = loginHandler.success();
		failed = memberActivityHandler.failed();
		return true;
	}

	@Override
	public boolean checkMemberActivity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(SystemConfig.MemberSession);
		if (member==null&&member.getIsactive()==0) {
			String contextPath=request.getContextPath();
			response.sendRedirect(contextPath+failed);
			return false;
		}
		return true;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return super.preHandle(request, response, handler);
	}

}
