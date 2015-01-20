package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyBlogLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyBlogLocalServiceClpInvoker {
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName70;
    private String[] _methodParameterTypes70;

    public MyBlogLocalServiceClpInvoker() {
        _methodName66 = "getBeanIdentifier";

        _methodParameterTypes66 = new String[] {  };

        _methodName67 = "setBeanIdentifier";

        _methodParameterTypes67 = new String[] { "java.lang.String" };

        _methodName70 = "findGroupEntries";

        _methodParameterTypes70 = new String[] {
                "long", "long", "int", "int", "int", "java.lang.String",
                "java.lang.String", "java.util.Map"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return MyBlogLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            MyBlogLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return MyBlogLocalServiceUtil.findGroupEntries(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue(),
                ((Integer) arguments[4]).intValue(),
                (java.lang.String) arguments[5],
                (java.lang.String) arguments[6],
                (java.util.Map<java.lang.String, java.lang.Object>) arguments[7]);
        }

        throw new UnsupportedOperationException();
    }
}
