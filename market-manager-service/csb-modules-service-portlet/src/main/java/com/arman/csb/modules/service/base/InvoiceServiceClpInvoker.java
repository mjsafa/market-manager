package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.InvoiceServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class InvoiceServiceClpInvoker {
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName73;
    private String[] _methodParameterTypes73;
    private String _methodName78;
    private String[] _methodParameterTypes78;
    private String _methodName79;
    private String[] _methodParameterTypes79;
    private String _methodName80;
    private String[] _methodParameterTypes80;
    private String _methodName81;
    private String[] _methodParameterTypes81;
    private String _methodName82;
    private String[] _methodParameterTypes82;

    public InvoiceServiceClpInvoker() {
        _methodName72 = "getBeanIdentifier";

        _methodParameterTypes72 = new String[] {  };

        _methodName73 = "setBeanIdentifier";

        _methodParameterTypes73 = new String[] { "java.lang.String" };

        _methodName78 = "addInvoice";

        _methodParameterTypes78 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName79 = "updateInvoice";

        _methodParameterTypes79 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName80 = "search";

        _methodParameterTypes80 = new String[] {
                "java.lang.String", "java.lang.String", "long", "java.util.Date",
                "java.util.Date", "int", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName81 = "getById";

        _methodParameterTypes81 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName82 = "updateInvoiceStatus";

        _methodParameterTypes82 = new String[] {
                "long", "int", "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return InvoiceServiceUtil.getBeanIdentifier();
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            InvoiceServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return InvoiceServiceUtil.addInvoice((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            return InvoiceServiceUtil.updateInvoice((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName80.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
            return InvoiceServiceUtil.search((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                ((Long) arguments[2]).longValue(),
                (java.util.Date) arguments[3], (java.util.Date) arguments[4],
                ((Integer) arguments[5]).intValue(),
                ((Integer) arguments[6]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[7]);
        }

        if (_methodName81.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
            return InvoiceServiceUtil.getById(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return InvoiceServiceUtil.updateInvoiceStatus(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        throw new UnsupportedOperationException();
    }
}
