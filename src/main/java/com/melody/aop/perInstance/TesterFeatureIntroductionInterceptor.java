package com.melody.aop.perInstance;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @Author melody
 * @Date 2020-03-26
 */
public class TesterFeatureIntroductionInterceptor extends DelegatingIntroductionInterceptor implements ITester {
    private static final long serialVersionUID = 1L;
    private boolean busyAsTester;

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (isBusyAsTester() && StringUtils.contains(mi.getMethod().getName(),"developSoftware")){
            throw new RuntimeException("12313211");
        }
        return super.invoke(mi);
    }

    public boolean isBusyAsTester() {
        return busyAsTester;
    }

    public void setBusyAsTester(boolean busyAsTester) {
        this.busyAsTester = busyAsTester;
    }
}
