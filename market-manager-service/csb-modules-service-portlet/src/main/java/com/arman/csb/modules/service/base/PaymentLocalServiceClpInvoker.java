package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.PaymentLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PaymentLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName92;
    private String[] _methodParameterTypes92;
    private String _methodName93;
    private String[] _methodParameterTypes93;
    private String _methodName98;
    private String[] _methodParameterTypes98;
    private String _methodName99;
    private String[] _methodParameterTypes99;
    private String _methodName100;
    private String[] _methodParameterTypes100;
    private String _methodName101;
    private String[] _methodParameterTypes101;
    private String _methodName102;
    private String[] _methodParameterTypes102;
    private String _methodName103;
    private String[] _methodParameterTypes103;
    private String _methodName104;
    private String[] _methodParameterTypes104;
    private String _methodName105;
    private String[] _methodParameterTypes105;
    private String _methodName106;
    private String[] _methodParameterTypes106;
    private String _methodName107;
    private String[] _methodParameterTypes107;
    private String _methodName108;
    private String[] _methodParameterTypes108;
    private String _methodName109;
    private String[] _methodParameterTypes109;
    private String _methodName110;
    private String[] _methodParameterTypes110;
    private String _methodName111;
    private String[] _methodParameterTypes111;
    private String _methodName112;
    private String[] _methodParameterTypes112;

    public PaymentLocalServiceClpInvoker() {
        _methodName0 = "addPayment";

        _methodParameterTypes0 = new String[] {
                "com.arman.csb.modules.model.Payment"
            };

        _methodName1 = "createPayment";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deletePayment";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deletePayment";

        _methodParameterTypes3 = new String[] {
                "com.arman.csb.modules.model.Payment"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchPayment";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "fetchPaymentByUuidAndCompanyId";

        _methodParameterTypes11 = new String[] { "java.lang.String", "long" };

        _methodName12 = "fetchPaymentByUuidAndGroupId";

        _methodParameterTypes12 = new String[] { "java.lang.String", "long" };

        _methodName13 = "getPayment";

        _methodParameterTypes13 = new String[] { "long" };

        _methodName14 = "getPersistedModel";

        _methodParameterTypes14 = new String[] { "java.io.Serializable" };

        _methodName15 = "getPaymentByUuidAndCompanyId";

        _methodParameterTypes15 = new String[] { "java.lang.String", "long" };

        _methodName16 = "getPaymentByUuidAndGroupId";

        _methodParameterTypes16 = new String[] { "java.lang.String", "long" };

        _methodName17 = "getPayments";

        _methodParameterTypes17 = new String[] { "int", "int" };

        _methodName18 = "getPaymentsCount";

        _methodParameterTypes18 = new String[] {  };

        _methodName19 = "updatePayment";

        _methodParameterTypes19 = new String[] {
                "com.arman.csb.modules.model.Payment"
            };

        _methodName92 = "getBeanIdentifier";

        _methodParameterTypes92 = new String[] {  };

        _methodName93 = "setBeanIdentifier";

        _methodParameterTypes93 = new String[] { "java.lang.String" };

        _methodName98 = "addPayment";

        _methodParameterTypes98 = new String[] {
                "long", "java.lang.Long", "java.util.Date", "int",
                "java.lang.Long", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName99 = "totalPayedAmount";

        _methodParameterTypes99 = new String[] { "java.lang.Long" };

        _methodName100 = "find";

        _methodParameterTypes100 = new String[] {
                "java.lang.Long", "java.util.Date", "java.util.Date", "long",
                "long", "int", "int", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName101 = "findCount";

        _methodParameterTypes101 = new String[] {
                "java.lang.Long", "java.util.Date", "java.util.Date", "long",
                "long", "int", "com.liferay.portal.service.ServiceContext"
            };

        _methodName102 = "totalPaymentAmount";

        _methodParameterTypes102 = new String[] {
                "java.lang.Long", "java.util.Date", "java.util.Date"
            };

        _methodName103 = "findByStatus";

        _methodParameterTypes103 = new String[] { "int" };

        _methodName104 = "findByGroupAndStatus";

        _methodParameterTypes104 = new String[] { "long", "int" };

        _methodName105 = "updateStatus";

        _methodParameterTypes105 = new String[] {
                "com.arman.csb.modules.model.Payment", "int"
            };

        _methodName106 = "deletePayment";

        _methodParameterTypes106 = new String[] { "long" };

        _methodName107 = "sumPayedOrPending";

        _methodParameterTypes107 = new String[] { "java.lang.Long" };

        _methodName108 = "getExcelDocument";

        _methodParameterTypes108 = new String[] { "java.util.List" };

        _methodName109 = "calculateMoneyInRials";

        _methodParameterTypes109 = new String[] {
                "com.arman.csb.modules.model.Payment"
            };

        _methodName110 = "calculateMoneyInRials";

        _methodParameterTypes110 = new String[] { "java.util.List" };

        _methodName111 = "subtractCommissionScore";

        _methodParameterTypes111 = new String[] {
                "com.arman.csb.modules.model.Payment"
            };

        _methodName112 = "subtractCommissionScore";

        _methodParameterTypes112 = new String[] { "java.util.List" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return PaymentLocalServiceUtil.addPayment((com.arman.csb.modules.model.Payment) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return PaymentLocalServiceUtil.createPayment(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return PaymentLocalServiceUtil.deletePayment(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return PaymentLocalServiceUtil.deletePayment((com.arman.csb.modules.model.Payment) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return PaymentLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return PaymentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return PaymentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return PaymentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return PaymentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return PaymentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return PaymentLocalServiceUtil.fetchPayment(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return PaymentLocalServiceUtil.fetchPaymentByUuidAndCompanyId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return PaymentLocalServiceUtil.fetchPaymentByUuidAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return PaymentLocalServiceUtil.getPayment(((Long) arguments[0]).longValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return PaymentLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return PaymentLocalServiceUtil.getPaymentByUuidAndCompanyId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName16.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
            return PaymentLocalServiceUtil.getPaymentByUuidAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName17.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
            return PaymentLocalServiceUtil.getPayments(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            return PaymentLocalServiceUtil.getPaymentsCount();
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            return PaymentLocalServiceUtil.updatePayment((com.arman.csb.modules.model.Payment) arguments[0]);
        }

        if (_methodName92.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
            return PaymentLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName93.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
            PaymentLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName98.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
            return PaymentLocalServiceUtil.addPayment(((Long) arguments[0]).longValue(),
                (java.lang.Long) arguments[1], (java.util.Date) arguments[2],
                ((Integer) arguments[3]).intValue(),
                (java.lang.Long) arguments[4], (java.lang.String) arguments[5],
                (com.liferay.portal.service.ServiceContext) arguments[6]);
        }

        if (_methodName99.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
            return PaymentLocalServiceUtil.totalPayedAmount((java.lang.Long) arguments[0]);
        }

        if (_methodName100.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
            return PaymentLocalServiceUtil.find((java.lang.Long) arguments[0],
                (java.util.Date) arguments[1], (java.util.Date) arguments[2],
                ((Long) arguments[3]).longValue(),
                ((Long) arguments[4]).longValue(),
                ((Integer) arguments[5]).intValue(),
                ((Integer) arguments[6]).intValue(),
                ((Integer) arguments[7]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[8]);
        }

        if (_methodName101.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
            return PaymentLocalServiceUtil.findCount((java.lang.Long) arguments[0],
                (java.util.Date) arguments[1], (java.util.Date) arguments[2],
                ((Long) arguments[3]).longValue(),
                ((Long) arguments[4]).longValue(),
                ((Integer) arguments[5]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[6]);
        }

        if (_methodName102.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
            return PaymentLocalServiceUtil.totalPaymentAmount((java.lang.Long) arguments[0],
                (java.util.Date) arguments[1], (java.util.Date) arguments[2]);
        }

        if (_methodName103.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
            return PaymentLocalServiceUtil.findByStatus(((Integer) arguments[0]).intValue());
        }

        if (_methodName104.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
            return PaymentLocalServiceUtil.findByGroupAndStatus(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName105.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
            return PaymentLocalServiceUtil.updateStatus((com.arman.csb.modules.model.Payment) arguments[0],
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName106.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
            return PaymentLocalServiceUtil.deletePayment(((Long) arguments[0]).longValue());
        }

        if (_methodName107.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
            return PaymentLocalServiceUtil.sumPayedOrPending((java.lang.Long) arguments[0]);
        }

        if (_methodName108.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
            return PaymentLocalServiceUtil.getExcelDocument((java.util.List<com.arman.csb.modules.model.Payment>) arguments[0]);
        }

        if (_methodName109.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
            return PaymentLocalServiceUtil.calculateMoneyInRials((com.arman.csb.modules.model.Payment) arguments[0]);
        }

        if (_methodName110.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
            return PaymentLocalServiceUtil.calculateMoneyInRials((java.util.List<com.arman.csb.modules.model.Payment>) arguments[0]);
        }

        if (_methodName111.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
            PaymentLocalServiceUtil.subtractCommissionScore((com.arman.csb.modules.model.Payment) arguments[0]);

            return null;
        }

        if (_methodName112.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
            PaymentLocalServiceUtil.subtractCommissionScore((java.util.List<com.arman.csb.modules.model.Payment>) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
