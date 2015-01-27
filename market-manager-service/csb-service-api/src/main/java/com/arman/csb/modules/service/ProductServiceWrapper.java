package com.arman.csb.modules.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductService
 * @generated
 */
public class ProductServiceWrapper implements ProductService,
    ServiceWrapper<ProductService> {
    private ProductService _productService;

    public ProductServiceWrapper(ProductService productService) {
        _productService = productService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _productService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _productService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _productService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject addProduct(
        java.util.Map<java.lang.String, java.lang.Object> product,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _productService.addProduct(product, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject updateProduct(
        java.util.Map<java.lang.String, java.lang.Object> product,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _productService.updateProduct(product, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONArray search(
        java.lang.String filter, int start, int maxResult,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.json.JSONException {
        return _productService.search(filter, start, maxResult, serviceContext);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject getById(long productId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _productService.getById(productId, serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ProductService getWrappedProductService() {
        return _productService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedProductService(ProductService productService) {
        _productService = productService;
    }

    @Override
    public ProductService getWrappedService() {
        return _productService;
    }

    @Override
    public void setWrappedService(ProductService productService) {
        _productService = productService;
    }
}
