package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.CustomerServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomerServiceClpInvoker {
    private String _methodName60;
    private String[] _methodParameterTypes60;
    private String _methodName61;
    private String[] _methodParameterTypes61;
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName68;
    private String[] _methodParameterTypes68;
    private String _methodName69;
    private String[] _methodParameterTypes69;
    private String _methodName70;
    private String[] _methodParameterTypes70;
    private String _methodName71;
    private String[] _methodParameterTypes71;
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName73;
    private String[] _methodParameterTypes73;
    private String _methodName74;
    private String[] _methodParameterTypes74;
    private String _methodName75;
    private String[] _methodParameterTypes75;

    public CustomerServiceClpInvoker() {
        _methodName60 = "getBeanIdentifier";

        _methodParameterTypes60 = new String[] {  };

        _methodName61 = "setBeanIdentifier";

        _methodParameterTypes61 = new String[] { "java.lang.String" };

        _methodName66 = "search";

        _methodParameterTypes66 = new String[] {
                "java.lang.String", "int", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName67 = "addCustomer";

        _methodParameterTypes67 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName68 = "getTotal";

        _methodParameterTypes68 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName69 = "getById";

        _methodParameterTypes69 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName70 = "getInvitees";

        _methodParameterTypes70 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName71 = "getStats";

        _methodParameterTypes71 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName72 = "getTotalStats";

        _methodParameterTypes72 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName73 = "updateCustomer";

        _methodParameterTypes73 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName74 = "updateCustomerStatus";

        _methodParameterTypes74 = new String[] {
                "long", "boolean", "com.liferay.portal.service.ServiceContext"
            };

        _methodName75 = "getCustomerActivityJSONObject";

        _methodParameterTypes75 = new String[] {
                "com.arman.csb.modules.model.Customer"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return CustomerServiceUtil.getBeanIdentifier();
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            CustomerServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return CustomerServiceUtil.search((java.lang.String) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            return CustomerServiceUtil.addCustomer((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName68.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
            return CustomerServiceUtil.getTotal((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        if (_methodName69.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
            return CustomerServiceUtil.getById(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return CustomerServiceUtil.getInvitees(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName71.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
            return CustomerServiceUtil.getStats(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return CustomerServiceUtil.getTotalStats((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            return CustomerServiceUtil.updateCustomer((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName74.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
            return CustomerServiceUtil.updateCustomerStatus(((Long) arguments[0]).longValue(),
                ((Boolean) arguments[1]).booleanValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName75.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
            return CustomerServiceUtil.getCustomerActivityJSONObject((com.arman.csb.modules.model.Customer) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
