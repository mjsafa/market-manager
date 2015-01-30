package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyDDLRecordServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyDDLRecordServiceClpInvoker {
    private String _methodName78;
    private String[] _methodParameterTypes78;
    private String _methodName79;
    private String[] _methodParameterTypes79;
    private String _methodName82;
    private String[] _methodParameterTypes82;

    public MyDDLRecordServiceClpInvoker() {
        _methodName78 = "getBeanIdentifier";

        _methodParameterTypes78 = new String[] {  };

        _methodName79 = "setBeanIdentifier";

        _methodParameterTypes79 = new String[] { "java.lang.String" };

        _methodName82 = "addRecord";

        _methodParameterTypes82 = new String[] {
                "java.lang.String", "java.lang.String", "java.util.Map",
                "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return MyDDLRecordServiceUtil.getBeanIdentifier();
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            MyDDLRecordServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return MyDDLRecordServiceUtil.addRecord((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.util.Map<java.lang.String, java.io.Serializable>) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        throw new UnsupportedOperationException();
    }
}
