package org.ligoj.app.plugin.vm.google;

import org.ligoj.bootstrap.core.curl.CurlProcessor;
import org.ligoj.bootstrap.core.curl.CurlRequest;
import org.ligoj.bootstrap.core.curl.HttpResponseCallback;

import lombok.Setter;

/**
 * vCloud Curl processor.
 */
public class GoogleCurlProcessor extends CurlProcessor {

	/**
	 * Special callback for vCloud login check.
	 */
	public static final HttpResponseCallback LOGIN_CALLBACK = new GoogleLoginHttpResponseCallback();

	/**
	 * Token used to authenticate request
	 */
	@Setter
	protected String token;

	@Override
	protected boolean process(final CurlRequest request) {
		// Add headers for SSO
		request.getHeaders().put("x-vcloud-authorization", token);
		request.getHeaders().put("Accept", "application/*+xml;version=5.1");
		return super.process(request);
	}

}
