package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyUserLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyUserLocalServiceClpInvoker {
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName70;
    private String[] _methodParameterTypes70;
    private String _methodName71;
    private String[] _methodParameterTypes71;

    public MyUserLocalServiceClpInvoker() {
        _methodName66 = "getBeanIdentifier";

        _methodParameterTypes66 = new String[] {  };

        _methodName67 = "setBeanIdentifier";

        _methodParameterTypes67 = new String[] { "java.lang.String" };

        _methodName70 = "updateUserRoles";

        _methodParameterTypes70 = new String[] {
                "java.lang.Long", "java.util.List",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName71 = "getOperatorRoles";

        _methodParameterTypes71 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return MyUserLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            MyUserLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            MyUserLocalServiceUtil.updateUserRoles((java.lang.Long) arguments[0],
                (java.util.List<java.lang.String>) arguments[1],
                (com.liferay.portal.service.ServiceContext) arguments[2]);

            return null;
        }

        if (_methodName71.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
            return MyUserLocalServiceUtil.getOperatorRoles((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
