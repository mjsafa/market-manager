package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyUserLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyUserLocalServiceClpInvoker {
    private String _methodName60;
    private String[] _methodParameterTypes60;
    private String _methodName61;
    private String[] _methodParameterTypes61;
    private String _methodName64;
    private String[] _methodParameterTypes64;
    private String _methodName65;
    private String[] _methodParameterTypes65;

    public MyUserLocalServiceClpInvoker() {
        _methodName60 = "getBeanIdentifier";

        _methodParameterTypes60 = new String[] {  };

        _methodName61 = "setBeanIdentifier";

        _methodParameterTypes61 = new String[] { "java.lang.String" };

        _methodName64 = "updateUserRoles";

        _methodParameterTypes64 = new String[] {
                "java.lang.Long", "java.util.List",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName65 = "getOperatorRoles";

        _methodParameterTypes65 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return MyUserLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            MyUserLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            MyUserLocalServiceUtil.updateUserRoles((java.lang.Long) arguments[0],
                (java.util.List<java.lang.String>) arguments[1],
                (com.liferay.portal.service.ServiceContext) arguments[2]);

            return null;
        }

        if (_methodName65.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
            return MyUserLocalServiceUtil.getOperatorRoles((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
