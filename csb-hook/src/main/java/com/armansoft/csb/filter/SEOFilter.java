package com.armansoft.csb.filter;

import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.UserAgentType;
import net.sf.uadetector.service.UADetectorServiceFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 11/5/14
 * Time: 8:49 PM
 */
public class SEOFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(req);

        UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
        ReadableUserAgent agent = parser.parse(requestWrapper.getHeader("User-Agent"));

        if (agent.getType() == UserAgentType.ROBOT) {
            //servletRequest.getRequestDispatcher("http://google.com").forward(servletRequest, servletResponse);
            ((HttpServletResponse) servletResponse).setContentType("text/html");

            String uri = req.getScheme() + "://" +   // "http" + "://
                    req.getServerName() +       // "myhost"
                    ":" +                           // ":"
                    "3000" +       // "8080"
                    req.getRequestURI() +       // "/people"
                    "?" +                           // "?"
                    req.getQueryString();

            InputStream input = new URL(uri).openStream();
            ServletOutputStream output = servletResponse.getOutputStream();

            byte[] buffer = new byte[10240];

            try {
                for (int length = 0; (length = input.read(buffer)) > 0; ) {
                    output.write(buffer, 0, length);
                }
            } finally {
                try {
                    output.close();
                } catch (IOException ignore) {
                }
                try {
                    input.close();
                } catch (IOException ignore) {
                }
            }


        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
