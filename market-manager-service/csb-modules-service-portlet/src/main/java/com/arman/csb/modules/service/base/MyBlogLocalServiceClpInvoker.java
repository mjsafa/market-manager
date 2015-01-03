package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyBlogLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyBlogLocalServiceClpInvoker {
    private String _methodName54;
    private String[] _methodParameterTypes54;
    private String _methodName55;
    private String[] _methodParameterTypes55;
    private String _methodName58;
    private String[] _methodParameterTypes58;

    public MyBlogLocalServiceClpInvoker() {
        _methodName54 = "getBeanIdentifier";

        _methodParameterTypes54 = new String[] {  };

        _methodName55 = "setBeanIdentifier";

        _methodParameterTypes55 = new String[] { "java.lang.String" };

        _methodName58 = "findGroupEntries";

        _methodParameterTypes58 = new String[] {
                "long", "long", "int", "int", "int", "java.lang.String",
                "java.lang.String", "java.util.Map"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            return MyBlogLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName55.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
            MyBlogLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName58.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
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
