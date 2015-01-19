package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyDDLRecordServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyDDLRecordServiceClpInvoker {
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName70;
    private String[] _methodParameterTypes70;

    public MyDDLRecordServiceClpInvoker() {
        _methodName66 = "getBeanIdentifier";

        _methodParameterTypes66 = new String[] {  };

        _methodName67 = "setBeanIdentifier";

        _methodParameterTypes67 = new String[] { "java.lang.String" };

        _methodName70 = "addRecord";

        _methodParameterTypes70 = new String[] {
                "java.lang.String", "java.lang.String", "java.util.Map",
                "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return MyDDLRecordServiceUtil.getBeanIdentifier();
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            MyDDLRecordServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return MyDDLRecordServiceUtil.addRecord((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.util.Map<java.lang.String, java.io.Serializable>) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        throw new UnsupportedOperationException();
    }
}
