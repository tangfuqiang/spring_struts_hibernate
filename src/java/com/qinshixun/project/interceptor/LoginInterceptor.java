package com.qinshixun.project.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        Object object = ServletActionContext.getRequest().getSession().getAttribute("loginCheck");
        if (object!=null){
           return actionInvocation.invoke();
        }else {
            return "login";
        }
    }
}
