package com.model2.mvc.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.util.HttpUtil;


public class ActionServlet extends HttpServlet {
	
	private RequestMapping mapper;

	@Override
	public void init() throws ServletException {
		
		System.out.println("\n* [ ActionServlet : init() ] ");
		
		super.init();
		String resources=getServletConfig().getInitParameter("resources");
		mapper=RequestMapping.getInstance(resources);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("\n* [ ActionServlet : service() ] ");
		
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		
		System.out.println("* service-url : " + url);
		System.out.println("* service-contextPath : " + contextPath);
		System.out.println("service-path : " + path);
		
		try{
			Action action = mapper.getAction(path);
			action.setServletContext(getServletContext());
			
			String resultPage=action.execute(request, response);
			String result=resultPage.substring(resultPage.indexOf(":")+1);
			
			if (resultPage.startsWith("forward:")) {
				System.out.println("* ActionServlet : service()- forward");
				HttpUtil.forward(request, response, result);
				
			} else {
				System.out.println("* ActionServlet : service() - redirect");
				HttpUtil.redirect(response, result);
			}

			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}