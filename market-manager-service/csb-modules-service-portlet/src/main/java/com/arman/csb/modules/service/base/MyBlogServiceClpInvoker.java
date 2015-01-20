package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyBlogServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyBlogServiceClpInvoker {
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName70;
    private String[] _methodParameterTypes70;
    private String _methodName71;
    private String[] _methodParameterTypes71;

    public MyBlogServiceClpInvoker() {
        _methodName66 = "getBeanIdentifier";

        _methodParameterTypes66 = new String[] {  };

        _methodName67 = "setBeanIdentifier";

        _methodParameterTypes67 = new String[] { "java.lang.String" };

        _methodName70 = "getEntry";

        _methodParameterTypes70 = new String[] { "long" };

        _methodName71 = "getLatestBlogEntries";

        _methodParameterTypes71 = new String[] {
                "java.lang.String", "int", "int", "int", "java.lang.String",
                "java.lang.String", "java.util.Map"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return MyBlogServiceUtil.getBeanIdentifier();
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            MyBlogServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return MyBlogServiceUtil.getEntry(((Long) arguments[0]).longValue());
        }

        if (_methodName71.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
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
