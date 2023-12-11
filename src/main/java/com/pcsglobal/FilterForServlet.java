package com.pcsglobal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, description = "Filter to validate the ID", urlPatterns = { "/filterId" })
public class FilterForServlet implements Filter {
    public FilterForServlet() {
    }

    /* No need 
	public void destroy() {
		// TODO Auto-generated method stub
	}
	*/
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		System.out.println("In Filter"); // just to check if the request url hits the Filter
		PrintWriter out = response.getWriter();
		
		// Here we need the HttpServletRequest for processing a request coming from HTML/JSP form
		HttpServletRequest req = (HttpServletRequest) request;
		
		int aid = Integer.parseInt(req.getParameter("aid"));
		
		// Here we validate for the filter condition - we will not allow to call a servlet or another filter unless id is greater 
		// than or equal to 1
		if (aid > 1)
			// pass the request along the filter chain
			chain.doFilter(request, response);
		else
			{out.print("Invalid Input..."); System.out.println("Invalid Input...");}
	}

	/* No need 
	public void init(FilterConfig fConfig) throws ServletException {
	}
	*/
}
