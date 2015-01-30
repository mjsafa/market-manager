package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.ScoreServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ScoreServiceClpInvoker {
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

    public ScoreServiceClpInvoker() {
        _methodName66 = "getBeanIdentifier";

        _methodParameterTypes66 = new String[] {  };

        _methodName67 = "setBeanIdentifier";

        _methodParameterTypes67 = new String[] { "java.lang.String" };

        _methodName72 = "customerScoresByDate";

        _methodParameterTypes72 = new String[] {
                "java.lang.Long", "java.lang.String", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName73 = "scoresByDate";

        _methodParameterTypes73 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName74 = "addScore";

        _methodParameterTypes74 = new String[] {
                "java.lang.Long", "long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName75 = "customerScores";

        _methodParameterTypes75 = new String[] {
                "java.lang.Long", "int", "int", "java.util.Map",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName76 = "getTotalStats";

        _methodParameterTypes76 = new String[] {  };

        _methodName77 = "getScoreActivityJSONObject";

        _methodParameterTypes77 = new String[] {
                "com.arman.csb.modules.model.Score",
                "com.arman.csb.modules.model.Customer"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return ScoreServiceUtil.getBeanIdentifier();
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            ScoreServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return ScoreServiceUtil.customerScoresByDate((java.lang.Long) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            return ScoreServiceUtil.scoresByDate((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName74.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
            return ScoreServiceUtil.addScore((java.lang.Long) arguments[0],
                ((Long) arguments[1]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName75.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
            return ScoreServiceUtil.customerScores((java.lang.Long) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (java.util.Map<java.lang.String, java.lang.Object>) arguments[3],
                (com.liferay.portal.service.ServiceContext) arguments[4]);
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return ScoreServiceUtil.getTotalStats();
        }

        if (_methodName77.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
            return ScoreServiceUtil.getScoreActivityJSONObject((com.arman.csb.modules.model.Score) arguments[0],
                (com.arman.csb.modules.model.Customer) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
