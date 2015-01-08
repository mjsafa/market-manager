package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyUserServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyUserServiceClpInvoker {
    private String _methodName48;
    private String[] _methodParameterTypes48;
    private String _methodName49;
    private String[] _methodParameterTypes49;
    private String _methodName52;
    private String[] _methodParameterTypes52;
    private String _methodName53;
    private String[] _methodParameterTypes53;
    private String _methodName54;
    private String[] _methodParameterTypes54;
    private String _methodName55;
    private String[] _methodParameterTypes55;
    private String _methodName56;
    private String[] _methodParameterTypes56;

    public MyUserServiceClpInvoker() {
        _methodName48 = "getBeanIdentifier";

        _methodParameterTypes48 = new String[] {  };

        _methodName49 = "setBeanIdentifier";

        _methodParameterTypes49 = new String[] { "java.lang.String" };

        _methodName52 = "newUser";

        _methodParameterTypes52 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName53 = "findUsers";

        _methodParameterTypes53 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName54 = "updateStatus";

        _methodParameterTypes54 = new String[] {
                "java.lang.Long", "boolean",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName55 = "getById";

        _methodParameterTypes55 = new String[] {
                "java.lang.Long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName56 = "agreed";

        _methodParameterTypes56 = new String[] {
                "java.lang.Long", "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            return MyUserServiceUtil.getBeanIdentifier();
        }

        if (_methodName49.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
            MyUserServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return MyUserServiceUtil.newUser((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            return MyUserServiceUtil.findUsers((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            return MyUserServiceUtil.updateStatus((java.lang.Long) arguments[0],
                ((Boolean) arguments[1]).booleanValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName55.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
            return MyUserServiceUtil.getById((java.lang.Long) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return MyUserServiceUtil.agreed((java.lang.Long) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
