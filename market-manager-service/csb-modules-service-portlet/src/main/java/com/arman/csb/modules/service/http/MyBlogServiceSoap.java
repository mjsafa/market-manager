package com.arman.csb.modules.service.http;

import com.arman.csb.modules.service.MyBlogServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.arman.csb.modules.service.MyBlogServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyBlogServiceHttp
 * @see com.arman.csb.modules.service.MyBlogServiceUtil
 * @generated
 */
public class MyBlogServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(MyBlogServiceSoap.class);

    public static com.liferay.portlet.blogs.model.BlogsEntry getEntry(
        long entryId) throws RemoteException {
        try {
            com.liferay.portlet.blogs.model.BlogsEntry returnValue = MyBlogServiceUtil.getEntry(entryId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
