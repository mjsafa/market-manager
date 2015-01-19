package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyUserServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyUserServiceClpInvoker {
    private String _methodName54;
    private String[] _methodParameterTypes54;
    private String _methodName55;
    private String[] _methodParameterTypes55;
    private String _methodName58;
    private String[] _methodParameterTypes58;
    private String _methodName59;
    private String[] _methodParameterTypes59;
    private String _methodName60;
    private String[] _methodParameterTypes60;
    private String _methodName61;
    private String[] _methodParameterTypes61;
    private String _methodName62;
    private String[] _methodParameterTypes62;

    public MyUserServiceClpInvoker() {
        _methodName54 = "getBeanIdentifier";

        _methodParameterTypes54 = new String[] {  };

        _methodName55 = "setBeanIdentifier";

        _methodParameterTypes55 = new String[] { "java.lang.String" };

        _methodName58 = "newUser";

        _methodParameterTypes58 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName59 = "findUsers";

        _methodParameterTypes59 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName60 = "updateStatus";

        _methodParameterTypes60 = new String[] {
                "java.lang.Long", "boolean",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName61 = "getById";

        _methodParameterTypes61 = new String[] {
                "java.lang.Long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName62 = "agreed";

        _methodParameterTypes62 = new String[] {
                "java.lang.Long", "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            return MyUserServiceUtil.getBeanIdentifier();
        }

        if (_methodName55.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
            MyUserServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName58.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
            return MyUserServiceUtil.newUser((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName59.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
            return MyUserServiceUtil.findUsers((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return MyUserServiceUtil.updateStatus((java.lang.Long) arguments[0],
                ((Boolean) arguments[1]).booleanValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            return MyUserServiceUtil.getById((java.lang.Long) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return MyUserServiceUtil.agreed((java.lang.Long) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
