package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyBlogServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyBlogServiceClpInvoker {
    private String _methodName60;
    private String[] _methodParameterTypes60;
    private String _methodName61;
    private String[] _methodParameterTypes61;
    private String _methodName64;
    private String[] _methodParameterTypes64;
    private String _methodName65;
    private String[] _methodParameterTypes65;

    public MyBlogServiceClpInvoker() {
        _methodName60 = "getBeanIdentifier";

        _methodParameterTypes60 = new String[] {  };

        _methodName61 = "setBeanIdentifier";

        _methodParameterTypes61 = new String[] { "java.lang.String" };

        _methodName64 = "getEntry";

        _methodParameterTypes64 = new String[] { "long" };

        _methodName65 = "getLatestBlogEntries";

        _methodParameterTypes65 = new String[] {
                "java.lang.String", "int", "int", "int", "java.lang.String",
                "java.lang.String", "java.util.Map"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return MyBlogServiceUtil.getBeanIdentifier();
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            MyBlogServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            return MyBlogServiceUtil.getEntry(((Long) arguments[0]).longValue());
        }

        if (_methodName65.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
            return MyBlogServiceUtil.getLatestBlogEntries((java.lang.String) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue(),
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                (java.util.Map<java.lang.String, java.lang.Object>) arguments[6]);
        }

        throw new UnsupportedOperationException();
    }
}
