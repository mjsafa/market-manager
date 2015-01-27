package com.arman.csb.modules.service.http;

import com.arman.csb.modules.service.CustomerServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.arman.csb.modules.service.CustomerServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.arman.csb.modules.model.CustomerSoap}.
 * If the method in the service utility returns a
 * {@link com.arman.csb.modules.model.Customer}, that is translated to a
 * {@link com.arman.csb.modules.model.CustomerSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
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
 * @see CustomerServiceHttp
 * @see com.arman.csb.modules.model.CustomerSoap
 * @see com.arman.csb.modules.service.CustomerServiceUtil
 * @generated
 */
public class CustomerServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(CustomerServiceSoap.class);

    public static java.lang.String search(java.lang.String filter, int start,
        int maxResult, com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portal.kernel.json.JSONArray returnValue = CustomerServiceUtil.search(filter,
                    start, maxResult, serviceContext);

            return returnValue.toString();
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String getTotal(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portal.kernel.json.JSONObject returnValue = CustomerServiceUtil.getTotal(serviceContext);

            return returnValue.toString();
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String getById(long customerId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portal.kernel.json.JSONObject returnValue = CustomerServiceUtil.getById(customerId,
                    serviceContext);

            return returnValue.toString();
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String getInvitees(long customerId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portal.kernel.json.JSONArray returnValue = CustomerServiceUtil.getInvitees(customerId,
                    serviceContext);

            return returnValue.toString();
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String getStats(long customerId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portal.kernel.json.JSONObject returnValue = CustomerServiceUtil.getStats(customerId,
                    serviceContext);

            return returnValue.toString();
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String getTotalStats(
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portal.kernel.json.JSONObject returnValue = CustomerServiceUtil.getTotalStats(serviceContext);

            return returnValue.toString();
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String updateCustomerStatus(long customerId,
        boolean isActive,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portal.kernel.json.JSONObject returnValue = CustomerServiceUtil.updateCustomerStatus(customerId,
                    isActive, serviceContext);

            return returnValue.toString();
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String getCustomerActivityJSONObject(
        com.arman.csb.modules.model.CustomerSoap customer)
        throws RemoteException {
        try {
            com.liferay.portal.kernel.json.JSONObject returnValue = CustomerServiceUtil.getCustomerActivityJSONObject(com.arman.csb.modules.model.impl.CustomerModelImpl.toModel(
                        customer));

            return returnValue.toString();
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
