package com.task.core.interceptor;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liuxue.entity.User;



public class GeneralFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		User user=(User)session.getAttribute("userSession");
		String uri=req.getRequestURI();
		if(user!=null){
			if(uri.endsWith("loginOrReg.jsp")){
				String beforeUri=(String)session.getAttribute("beforeUri");
				if(beforeUri==null){
				    session.setAttribute("beforeUri", "/index.jsp");
				    res.sendRedirect(req.getContextPath()+"/index.jsp");
				}else{
					RequestDispatcher dispatcher = request.getRequestDispatcher(beforeUri);
					dispatcher.forward(request, response);
				}
			}else{
				chain.doFilter(request, response);
			}
		}else if(uri.indexOf("user.jsp")!=-1&&user==null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/loginOrReg.jsp");
			dispatcher.forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
