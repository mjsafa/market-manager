package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.ScoreServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ScoreServiceClpInvoker {
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
    private String _methodName71;
    private String[] _methodParameterTypes71;

    public ScoreServiceClpInvoker() {
        _methodName60 = "getBeanIdentifier";

        _methodParameterTypes60 = new String[] {  };

        _methodName61 = "setBeanIdentifier";

        _methodParameterTypes61 = new String[] { "java.lang.String" };

        _methodName66 = "customerScoresByDate";

        _methodParameterTypes66 = new String[] {
                "java.lang.Long", "java.lang.String", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName67 = "scoresByDate";

        _methodParameterTypes67 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName68 = "addScore";

        _methodParameterTypes68 = new String[] {
                "java.lang.Long", "long",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName69 = "customerScores";

        _methodParameterTypes69 = new String[] {
                "java.lang.Long", "int", "int", "java.util.Map",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName70 = "getTotalStats";

        _methodParameterTypes70 = new String[] {  };

        _methodName71 = "getScoreActivityJSONObject";

        _methodParameterTypes71 = new String[] {
                "com.arman.csb.modules.model.Score",
                "com.arman.csb.modules.model.Customer"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return ScoreServiceUtil.getBeanIdentifier();
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            ScoreServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return ScoreServiceUtil.customerScoresByDate((java.lang.Long) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            return ScoreServiceUtil.scoresByDate((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (com.liferay.portal.service.ServiceContext) arguments[3]);
        }

        if (_methodName68.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
            return ScoreServiceUtil.addScore((java.lang.Long) arguments[0],
                ((Long) arguments[1]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        if (_methodName69.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
            return ScoreServiceUtil.customerScores((java.lang.Long) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (java.util.Map<java.lang.String, java.lang.Object>) arguments[3],
                (com.liferay.portal.service.ServiceContext) arguments[4]);
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return ScoreServiceUtil.getTotalStats();
        }

        if (_methodName71.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
            return ScoreServiceUtil.getScoreActivityJSONObject((com.arman.csb.modules.model.Score) arguments[0],
                (com.arman.csb.modules.model.Customer) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
