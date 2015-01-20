package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.PaymentServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PaymentServiceClpInvoker {
    private String _methodName60;
    private String[] _methodParameterTypes60;
    private String _methodName61;
    private String[] _methodParameterTypes61;
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName68;
    private String[] _methodParameterTypes68;
    private String _methodName69;
    private String[] _methodParameterTypes69;
    private String _methodName70;
    private String[] _methodParameterTypes70;

    public PaymentServiceClpInvoker() {
        _methodName60 = "getBeanIdentifier";

        _methodParameterTypes60 = new String[] {  };

        _methodName61 = "setBeanIdentifier";

        _methodParameterTypes61 = new String[] { "java.lang.String" };

        _methodName66 = "addPayment";

        _methodParameterTypes66 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName67 = "totalPayedAmount";

        _methodParameterTypes67 = new String[] {
                "java.lang.Long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName68 = "search";

        _methodParameterTypes68 = new String[] {
                "java.util.Map", "int", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName69 = "getTotalStats";

        _methodParameterTypes69 = new String[] {
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName70 = "getPaymentActivityJSONObject";

        _methodParameterTypes70 = new String[] {
                "com.arman.csb.modules.model.Payment",
                "com.arman.csb.modules.model.Customer"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return PaymentServiceUtil.getBeanIdentifier();
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            PaymentServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return PaymentServiceUtil.addPayment((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            return PaymentServiceUtil.totalPayedAmount((java.lang.Long) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName68.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
            return PaymentServiceUtil.search((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName69.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
            return PaymentServiceUtil.getTotalStats((com.liferay.portal.service.ServiceContext) arguments[0]);
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return PaymentServiceUtil.getPaymentActivityJSONObject((com.arman.csb.modules.model.Payment) arguments[0],
                (com.arman.csb.modules.model.Customer) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
