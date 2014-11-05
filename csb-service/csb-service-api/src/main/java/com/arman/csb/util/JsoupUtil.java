package com.arman.csb.util;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 8/26/14
 * Time: 11:44 AM
 */
public class JsoupUtil {

    public static void replaceTag(Element element, String newTag, String innerHtml) {
        element.tagName(newTag);
        element.html(innerHtml);
    }

    /**
     * copy the second head into the first one
     *
     * @param firstHead
     * @param secondHead
     *
     * @return merged head element
     */
    public static Element mergeHeads(Element firstHead, Element secondHead) {
        List<Element> secondHeadElements = secondHead.getAllElements();
        for (Element secondHeadElement : secondHeadElements) {
            firstHead.appendChild(secondHeadElement);
        }

        return firstHead;
    }

    public static void prependValueToProperty(Elements parentElement, String selector, String attributeName, String prependValue, boolean removeSlash){
        Elements elements = parentElement.select(selector);
        for (Element element : elements) {
            String attrValue = element.attr(attributeName);

            //remove slash from beggining
            if(removeSlash){
                if(attrValue.startsWith("/")){
                    attrValue = attrValue.substring(1);
                }
            }

            if(!attrValue.startsWith("<%")){
                attrValue  = prependValue + attrValue;

                //do not change absolute paths
                if(!attrValue.contains("://") ){
                    element.attr(attributeName, attrValue);
                }
            }
        }
    }

}
