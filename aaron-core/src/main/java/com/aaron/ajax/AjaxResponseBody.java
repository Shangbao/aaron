package com.aaron.ajax;

import com.aaron.constant.Constant;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by pzw on 2/2/2016.
 */
public class AjaxResponseBody {

    private ResponseStatus responseStatus;
    private String returnMsg;
    private Map<String, Object> responseData;

    public AjaxResponseBody() {
        this(ResponseStatus.SUCCESS, Constant.OPERATE_SUCCESS);
    }

    public AjaxResponseBody(String returnMsg) {
        this(ResponseStatus.SUCCESS, returnMsg);
    }

    public AjaxResponseBody(ResponseStatus responseStatus, String returnMsg) {
        this.responseStatus = responseStatus;
        this.returnMsg = returnMsg;
        this.responseData = new HashMap<>();
    }

    public AjaxResponseBody(String attributeName, Object attributeValue) {
        this();
        this.addAttribute(attributeName, attributeValue);
    }

    public AjaxResponseBody addAttribute(String attributeName, Object attributeValue) {
        this.getResponseData().put(attributeName,attributeValue);
        return this;
    }

    public static AjaxResponseBody getOperateResultInstance(boolean result) {
        return result ? new AjaxResponseBody(ResponseStatus.SUCCESS, Constant.OPERATE_SUCCESS) :
                new AjaxResponseBody(ResponseStatus.ERROR,Constant.OPERATE_ERROR);
    }

    public AjaxResponseBody(BindingResult result) {
        this.responseStatus = ResponseStatus.ERROR;
        this.responseData = new HashMap<String, Object>();
        this.returnMsg = "";

        ObjectError objectError;
        for(Iterator i$ = result.getAllErrors().iterator(); i$.hasNext(); this.returnMsg = this.returnMsg + objectError.getDefaultMessage()) {
            objectError = (ObjectError)i$.next();
        }

    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public Map<String, Object> getResponseData() {
        return responseData;
    }

    public void setResponseData(Map<String, Object> responseData) {
        this.responseData = responseData;
    }

    public boolean isSuccess() {
        return responseStatus == ResponseStatus.SUCCESS;
    }

    public boolean isError() {
        return responseStatus == ResponseStatus.ERROR;
    }

    public boolean isWaring() {
        return responseStatus == ResponseStatus.WARING;
    }
}
