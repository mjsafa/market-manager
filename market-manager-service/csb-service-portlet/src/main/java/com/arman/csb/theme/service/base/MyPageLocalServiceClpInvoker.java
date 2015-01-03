package com.arman.csb.theme.service.base;

import com.arman.csb.theme.service.MyPageLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyPageLocalServiceClpInvoker {
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;
    private String _methodName32;
    private String[] _methodParameterTypes32;
    private String _methodName33;
    private String[] _methodParameterTypes33;
    private String _methodName34;
    private String[] _methodParameterTypes34;

    public MyPageLocalServiceClpInvoker() {
        _methodName28 = "getBeanIdentifier";

        _methodParameterTypes28 = new String[] {  };

        _methodName29 = "setBeanIdentifier";

        _methodParameterTypes29 = new String[] { "java.lang.String" };

        _methodName32 = "editPageContent";

        _methodParameterTypes32 = new String[] {
                "long", "java.lang.String", "java.lang.String"
            };

        _methodName33 = "renderPageHTML";

        _methodParameterTypes33 = new String[] {
                "long", "com.liferay.portal.theme.ThemeDisplay"
            };

        _methodName34 = "renderAdminHTML";

        _methodParameterTypes34 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return MyPageLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            MyPageLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName32.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
            MyPageLocalServiceUtil.editPageContent(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);

            return null;
        }

        if (_methodName33.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
            return MyPageLocalServiceUtil.renderPageHTML(((Long) arguments[0]).longValue(),
                (com.liferay.portal.theme.ThemeDisplay) arguments[1]);
        }

        if (_methodName34.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
            return MyPageLocalServiceUtil.renderAdminHTML(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
