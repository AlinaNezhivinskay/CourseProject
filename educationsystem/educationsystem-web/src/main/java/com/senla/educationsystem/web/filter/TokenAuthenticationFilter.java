package com.senla.educationsystem.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.educationsystem.web.token.TokenManager;
import com.senla.educationsystem.web.token.TokenRepository;

public class TokenAuthenticationFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String url = ((HttpServletRequest) request).getRequestURL().toString();
		if (url.contains("/registration") || url.contains("/login")) {
			chain.doFilter(request, response);
		} else {
			String token = ((HttpServletRequest) request).getHeader("token");
			HttpServletResponse resp = (HttpServletResponse) response;
			try {
				if (token != null && TokenRepository.getInstance().isTokenExist(token)
						&& TokenManager.validateToken(token)) {
					chain.doFilter(request, response);
				} else {
					resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			} catch (Exception e) {
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
