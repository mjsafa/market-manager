package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyBlogLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyBlogLocalServiceClpInvoker {
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName34;
    private String[] _methodParameterTypes34;

    public MyBlogLocalServiceClpInvoker() {
        _methodName30 = "getBeanIdentifier";

        _methodParameterTypes30 = new String[] {  };

        _methodName31 = "setBeanIdentifier";

        _methodParameterTypes31 = new String[] { "java.lang.String" };

        _methodName34 = "findGroupEntries";

        _methodParameterTypes34 = new String[] {
                "long", "long", "int", "int", "int", "java.lang.String",
                "java.lang.String", "java.util.Map"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            return MyBlogLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            MyBlogLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName34.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
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
