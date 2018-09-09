package com.alphawang.spring.core.scope.bean;

import com.alphawang.spring.core.jar.SessionHolder;

public class SubSessionHolder extends SessionHolder {
    public void setCartSessionId(String cartSessionId) {
        super.setCartSessionId(cartSessionId);
    }
}
