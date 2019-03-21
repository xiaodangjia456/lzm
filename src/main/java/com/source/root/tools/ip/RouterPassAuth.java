package com.source.root.tools.ip;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class RouterPassAuth extends Authenticator {

	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(IMailConstant.ROUTE_USER,
				IMailConstant.ROUTE_PWD.toCharArray());
	}

}
