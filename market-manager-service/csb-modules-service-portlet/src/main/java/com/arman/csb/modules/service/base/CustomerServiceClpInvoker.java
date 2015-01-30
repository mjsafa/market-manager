package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.CustomerServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomerServiceClpInvoker {
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName73;
    private String[] _methodParameterTypes73;
    private String _methodName74;
    private String[] _methodParameterTypes74;
    private String _methodName75;
    private String[] _methodParameterTypes75;
    private String _methodName76;
    private String[] _methodParameterTypes76;
    private String _methodName77;
    private String[] _methodParameterTypes77;
    private String _methodName78;
    private String[] _methodParameterTypes78;
    private String _methodName79;
    private String[] _methodParameterTypes79;
    private String _methodName80;
    private String[] _methodParameterTypes80;
    private String _methodName81;
    private String[] _methodParameterTypes81;

    public CustomerServiceClpInvoker() {
        _methodName66 = "getBeanIdentifier";

        _methodParameterTypes66 = new String[] {  };

        _methodName67 = "setBeanIdentifier";

        _methodParameterTypes67 = new String[] { "java.lang.String" };

        _methodName72 = "search";

        _methodParameterTypes72 = new String[] {
                "java.lang.String", "long", "int", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName73 = "addCustomer";

        _methodParameterTypes73 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName74 = "getTotal";

        _methodParameterTypes74 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName75 = "getById";

        _methodParameterTypes75 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName76 = "getInvitees";

        _methodParameterTypes76 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName77 = "getStats";

        _methodParameterTypes77 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName78 = "getTotalStats";

        _methodParameterTypes78 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName79 = "updateCustomer";

        _methodParameterTypes79 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName80 = "updateCustomerStatus";

        _methodParameterTypes80 = new String[] {
                "long", "boolean", "com.liferay.portal.service.ServiceContext"
            };

        _methodName81 = "getCustomerActivityJSONObject";

        _methodParameterTypes81 = new String[] {
                "com.arman.csb.modules.model.Customer"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return CustomerServiceUtil.getBeanIdentifier();
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            CustomerServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return CustomerServiceUtil.search((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[4]);
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            return CustomerServiceUtil.addCustomer((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName74.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
            return CustomerServiceUtil.getTotal((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        if (_methodName75.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
            return CustomerServiceUtil.getById(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return CustomerServiceUtil.getInvitees(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName77.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
            return CustomerServiceUtil.getStats(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return CustomerServiceUtil.getTotalStats((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            return CustomerServiceUtil.updateCustomer((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName80.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
            return CustomerServiceUtil.updateCustomerStatus(((Long) arguments[0]).longValue(),
                ((Boolean) arguments[1]).booleanValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName81.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
            return CustomerServiceUtil.getCustomerActivityJSONObject((com.arman.csb.modules.model.Customer) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
