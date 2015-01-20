package com.arman.csb.modules.service;

import com.arman.csb.modules.model.CustomerClp;
import com.arman.csb.modules.model.InvoiceClp;
import com.arman.csb.modules.model.InvoiceItemClp;
import com.arman.csb.modules.model.PaymentClp;
import com.arman.csb.modules.model.ScoreClp;
import com.arman.csb.modules.model.UserActivityClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "csb-service-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "csb-service-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "csb-modules-service-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(CustomerClp.class.getName())) {
            return translateInputCustomer(oldModel);
        }

        if (oldModelClassName.equals(InvoiceClp.class.getName())) {
            return translateInputInvoice(oldModel);
        }

        if (oldModelClassName.equals(InvoiceItemClp.class.getName())) {
            return translateInputInvoiceItem(oldModel);
        }

        if (oldModelClassName.equals(PaymentClp.class.getName())) {
            return translateInputPayment(oldModel);
        }

        if (oldModelClassName.equals(ScoreClp.class.getName())) {
            return translateInputScore(oldModel);
        }

        if (oldModelClassName.equals(UserActivityClp.class.getName())) {
            return translateInputUserActivity(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputCustomer(BaseModel<?> oldModel) {
        CustomerClp oldClpModel = (CustomerClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCustomerRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputInvoice(BaseModel<?> oldModel) {
        InvoiceClp oldClpModel = (InvoiceClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getInvoiceRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputInvoiceItem(BaseModel<?> oldModel) {
        InvoiceItemClp oldClpModel = (InvoiceItemClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getInvoiceItemRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputPayment(BaseModel<?> oldModel) {
        PaymentClp oldClpModel = (PaymentClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getPaymentRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputScore(BaseModel<?> oldModel) {
        ScoreClp oldClpModel = (ScoreClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getScoreRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputUserActivity(BaseModel<?> oldModel) {
        UserActivityClp oldClpModel = (UserActivityClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getUserActivityRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "com.arman.csb.modules.model.impl.CustomerImpl")) {
            return translateOutputCustomer(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arman.csb.modules.model.impl.InvoiceImpl")) {
            return translateOutputInvoice(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arman.csb.modules.model.impl.InvoiceItemImpl")) {
            return translateOutputInvoiceItem(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arman.csb.modules.model.impl.PaymentImpl")) {
            return translateOutputPayment(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arman.csb.modules.model.impl.ScoreImpl")) {
            return translateOutputScore(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arman.csb.modules.model.impl.UserActivityImpl")) {
            return translateOutputUserActivity(oldModel);
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals("com.arman.csb.modules.NoSuchCustomerException")) {
            return new com.arman.csb.modules.NoSuchCustomerException();
        }

        if (className.equals("com.arman.csb.modules.NoSuchInvoiceException")) {
            return new com.arman.csb.modules.NoSuchInvoiceException();
        }

        if (className.equals("com.arman.csb.modules.NoSuchInvoiceItemException")) {
            return new com.arman.csb.modules.NoSuchInvoiceItemException();
        }

        if (className.equals("com.arman.csb.modules.NoSuchPaymentException")) {
            return new com.arman.csb.modules.NoSuchPaymentException();
        }

        if (className.equals("com.arman.csb.modules.NoSuchScoreException")) {
            return new com.arman.csb.modules.NoSuchScoreException();
        }

        if (className.equals(
                    "com.arman.csb.modules.NoSuchUserActivityException")) {
            return new com.arman.csb.modules.NoSuchUserActivityException();
        }

        return throwable;
    }

    public static Object translateOutputCustomer(BaseModel<?> oldModel) {
        CustomerClp newModel = new CustomerClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCustomerRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputInvoice(BaseModel<?> oldModel) {
        InvoiceClp newModel = new InvoiceClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setInvoiceRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputInvoiceItem(BaseModel<?> oldModel) {
        InvoiceItemClp newModel = new InvoiceItemClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setInvoiceItemRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputPayment(BaseModel<?> oldModel) {
        PaymentClp newModel = new PaymentClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setPaymentRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputScore(BaseModel<?> oldModel) {
        ScoreClp newModel = new ScoreClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setScoreRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputUserActivity(BaseModel<?> oldModel) {
        UserActivityClp newModel = new UserActivityClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setUserActivityRemoteModel(oldModel);

        return newModel;
    }
}
