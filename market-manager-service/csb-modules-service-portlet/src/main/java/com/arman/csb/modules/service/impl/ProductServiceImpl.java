package com.arman.csb.modules.service.impl;

import com.arman.csb.constant.UserActivityConstant;
import com.arman.csb.constants.WorkflowConstants;
import com.arman.csb.modules.model.Product;
import com.arman.csb.modules.model.impl.ProductImpl;
import com.arman.csb.modules.service.ProductLocalServiceUtil;
import com.arman.csb.modules.service.UserActivityLocalServiceUtil;
import com.arman.csb.modules.service.base.ProductServiceBaseImpl;
import com.arman.csb.util.MapUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.*;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the product remote service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.ProductService} interface.
 * <p/>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.ProductServiceBaseImpl
 * @see com.arman.csb.modules.service.ProductServiceUtil
 */
public class ProductServiceImpl extends ProductServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.ProductServiceUtil} to access the product remote service.
     */

    public JSONObject addProduct(Map<String, Object> product, ServiceContext serviceContext) throws SystemException, PortalException {

        User onlineUser = UserLocalServiceUtil.getUser(serviceContext.getUserId());

        Product newProduct = ProductLocalServiceUtil.createProduct(counterLocalService.increment(Product.class.getName()));

        newProduct.setUserName(onlineUser.getFullName());
        newProduct.setUserId(onlineUser.getUserId());
        newProduct.setCompanyId(serviceContext.getCompanyId());
        newProduct.setGroupId(serviceContext.getScopeGroupId());
        newProduct.setStatus(WorkflowConstants.STATUS_ACTIVE);
        newProduct.setCreateDate(new Date());
        newProduct.setModifiedDate(new Date());

        newProduct = getProductData(newProduct, product, serviceContext);

        ProductLocalServiceUtil.addProduct(newProduct);

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_PRODUCT, UserActivityConstant.ACTION_ADD,
                UserActivityConstant.IMPORTANCE_MEDIUM, getJSONObject(newProduct).toString(), serviceContext);

        return getJSONObject(newProduct);
    }

    public JSONObject updateProduct(Map<String, Object> product, ServiceContext serviceContext) throws SystemException, PortalException {
        long productId = MapUtil.getLong(product, "id");
        Product updateProduct = ProductLocalServiceUtil.getProduct(productId);

        updateProduct.setModifiedDate(new Date());
        updateProduct = getProductData(updateProduct, product, serviceContext);

        ProductLocalServiceUtil.updateProduct(updateProduct);

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_PRODUCT,
                UserActivityConstant.ACTION_EDIT, UserActivityConstant.IMPORTANCE_MEDIUM,
                getJSONObject(updateProduct).toString(), serviceContext);

        return getJSONObject(updateProduct);
    }

    public JSONArray search(String filter, int status, int start, int maxResult, ServiceContext serviceContext)
            throws JSONException {

        JSONArray result = JSONFactoryUtil.createJSONArray();

        Session session = productPersistence.openSession();

        String sql = CustomSQLUtil.get("com.arman.csb.modules.service.Product.search");
        sql = sql.replaceAll("##KEYWORD##", "%" + filter + "%");

        SQLQuery queryObject = session.createSQLQuery(sql);

        queryObject.addEntity(ProductImpl.TABLE_NAME, ProductImpl.class);
        queryObject.setFirstResult(start);
        queryObject.setMaxResults(maxResult);

        QueryPos qPos = QueryPos.getInstance(queryObject);
        if(-1 == status) {
            qPos.add(true);
        } else {
            qPos.add(false);
        }

        qPos.add(status);

        List<Product> products = queryObject.list();

        for (Product product : products) {
            result.put(getJSONObject(product));
        }

        return result;
    }

    public JSONObject getById(long productId, ServiceContext serviceContext) throws PortalException, SystemException {
        Product product = ProductLocalServiceUtil.getProduct(productId);

        return getJSONObject(product);
    }

    public JSONObject updateProductStatus(long productId, int status, ServiceContext serviceContext) throws SystemException, PortalException {
        Product product = ProductLocalServiceUtil.getProduct(productId);
        int oldStatus = product.getStatus();

        product.setStatus(status);

        ProductLocalServiceUtil.updateProduct(product);

        JSONObject result = getJSONObject(product);
        result.put("oldStatus", oldStatus);

        UserActivityLocalServiceUtil.addUserActivity(UserActivityConstant.ENTITY_PRODUCT,
                UserActivityConstant.ACTION_CHANGE_STATUS, UserActivityConstant.IMPORTANCE_HIGH,
                result.toString(), serviceContext);

        return result;
    }

    private Product getProductData(Product productObject, Map<String, Object> product, ServiceContext serviceContext) {
        productObject.setName(MapUtil.getString(product, "name"));
        productObject.setCode(MapUtil.getString(product, "code"));
        productObject.setBasePrice(MapUtil.getLong(product, "basePrice"));
        productObject.setScore(MapUtil.getLong(product, "score"));

        return productObject;
    }

    private JSONObject getJSONObject(Product product) throws JSONException {
        JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
        JSONObject result = JSONFactoryUtil.createJSONObject(jsonSerializer.serialize(product));

        return result;
    }

}
