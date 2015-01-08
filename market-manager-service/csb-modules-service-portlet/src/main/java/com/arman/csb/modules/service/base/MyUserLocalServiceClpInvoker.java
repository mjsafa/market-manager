package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.MyUserLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyUserLocalServiceClpInvoker {
    private String _methodName48;
    private String[] _methodParameterTypes48;
    private String _methodName49;
    private String[] _methodParameterTypes49;

    public MyUserLocalServiceClpInvoker() {
        _methodName48 = "getBeanIdentifier";

        _methodParameterTypes48 = new String[] {  };

        _methodName49 = "setBeanIdentifier";

        _methodParameterTypes49 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            return MyUserLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName49.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
            MyUserLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
