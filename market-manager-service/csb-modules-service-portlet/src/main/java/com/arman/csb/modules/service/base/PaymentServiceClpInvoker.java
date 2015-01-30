package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.PaymentServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PaymentServiceClpInvoker {
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName73;
    private String[] _methodParameterTypes73;
    private String _methodName74;
    private String[] _methodParameterTypes74;
    private String _methodName75;
    private String[] _methodParameterTypes75;
    private String _methodName76;
    private String[] _methodParameterTypes76;
    private String _methodName77;
    private String[] _methodParameterTypes77;
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
    private String _methodName83;
    private String[] _methodParameterTypes83;

    public PaymentServiceClpInvoker() {
        _methodName66 = "getBeanIdentifier";

        _methodParameterTypes66 = new String[] {  };

        _methodName67 = "setBeanIdentifier";

        _methodParameterTypes67 = new String[] { "java.lang.String" };

        _methodName72 = "addPayment";

        _methodParameterTypes72 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName73 = "totalPayedAmount";

        _methodParameterTypes73 = new String[] {
                "java.lang.Long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName74 = "search";

        _methodParameterTypes74 = new String[] {
                "java.util.Map", "int", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName75 = "getTotalStats";

        _methodParameterTypes75 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName76 = "isDownloaded";

        _methodParameterTypes76 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName77 = "downloadPayments";

        _methodParameterTypes77 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName78 = "acceptPayments";

        _methodParameterTypes78 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName79 = "cancelDownloadPayments";

        _methodParameterTypes79 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName80 = "rejectPayment";

        _methodParameterTypes80 = new String[] {
                "java.lang.Long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName81 = "deletePayment";

        _methodParameterTypes81 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName82 = "getStats";

        _methodParameterTypes82 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName83 = "getPaymentActivityJSONObject";

        _methodParameterTypes83 = new String[] {
                "com.arman.csb.modules.model.Payment",
                "com.arman.csb.modules.model.Customer"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return PaymentServiceUtil.getBeanIdentifier();
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            PaymentServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return PaymentServiceUtil.addPayment((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            return PaymentServiceUtil.totalPayedAmount((java.lang.Long) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName74.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
            return PaymentServiceUtil.search((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName75.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
            return PaymentServiceUtil.getTotalStats((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return PaymentServiceUtil.isDownloaded((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        if (_methodName77.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
            return PaymentServiceUtil.downloadPayments((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return PaymentServiceUtil.acceptPayments((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            return PaymentServiceUtil.cancelDownloadPayments((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        if (_methodName80.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
            return PaymentServiceUtil.rejectPayment((java.lang.Long) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName81.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
            return PaymentServiceUtil.deletePayment(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return PaymentServiceUtil.getStats(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName83.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
            return PaymentServiceUtil.getPaymentActivityJSONObject((com.arman.csb.modules.model.Payment) arguments[0],
                (com.arman.csb.modules.model.Customer) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
