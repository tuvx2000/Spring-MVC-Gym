package com.xuantujava.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IManagementGoogleUserService {
	public HttpServletRequest GoogleSignInAndRegister(HttpServletRequest request, HttpServletResponse response);
}
