package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyDDLRecordServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyDDLRecordServiceClpInvoker {
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName73;
    private String[] _methodParameterTypes73;
    private String _methodName76;
    private String[] _methodParameterTypes76;

    public MyDDLRecordServiceClpInvoker() {
        _methodName72 = "getBeanIdentifier";

        _methodParameterTypes72 = new String[] {  };

        _methodName73 = "setBeanIdentifier";

        _methodParameterTypes73 = new String[] { "java.lang.String" };

        _methodName76 = "addRecord";

        _methodParameterTypes76 = new String[] {
                "java.lang.String", "java.lang.String", "java.util.Map",
                "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return MyDDLRecordServiceUtil.getBeanIdentifier();
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            MyDDLRecordServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return MyDDLRecordServiceUtil.addRecord((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.util.Map<java.lang.String, java.io.Serializable>) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        throw new UnsupportedOperationException();
    }
}
