package com.xuantujava.service.impl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.xuantujava.DTO.UserDTO;
import com.xuantujava.constant.SystemConstant;
import com.xuantujava.service.IManagementGoogleUserService;
import com.xuantujava.service.IUserService;

@Service
public class ManagementGoogleUserService implements IManagementGoogleUserService {

	@Autowired
	IUserService userService;

	public HttpServletRequest GoogleSignInAndRegister(HttpServletRequest request, HttpServletResponse response) {

		String userNameX = "", passwordX = "";

		/// example code

		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
				.setAudience(Collections
						.singletonList("841081615376-3hbsvqkqpj1u4p943gpj93v0ki62tmjo.apps.googleusercontent.com"))
				.build();

		GoogleIdToken idToken;
		try {

			idToken = verifier.verify(request.getParameter("IdToken"));

			if (idToken != null) {
				Payload payload = idToken.getPayload();

				// Print user identifier
				String userId = payload.getSubject();

				String email = payload.getEmail();
				String name = (String) payload.get("name");
				// String pictureUrl = (String) payload.get("picture");

				// ... dang ky

				userNameX = email;

				passwordX = userId;

				if (userService.checkUserExisted(userNameX, SystemConstant.ACTIVE_STATUS) == 0) {
					UserDTO userDTO = new UserDTO();
					userDTO.setUserName(email);
					userDTO.setPassword(userId);
					userDTO.setFullName((String) payload.get("name"));

					userService.RegisterNewUser(userDTO);
				}

			} else {
				System.out.println("Invalid ID token.");
			}

		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("j_username", userNameX);
		request.setAttribute("j_password", passwordX);

		return request;

	}

}
