package com.example.rpc.server.api;

import java.io.Serializable;

public class RpcRequest implements Serializable {
    private static final long serialVersionUID = -6851129942168833854L;

    private String version;
    private String className;
    private String methodName;
    private Object[] params;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
