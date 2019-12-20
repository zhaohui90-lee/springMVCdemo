package com.melody.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author 40431
 */
@Aspect
public class EncoreableIntroducer {
    /**
     *  + ：表示其子类实现
     *
     */
    @DeclareParents(value = "com.melody.pojo.concert.Performance+",
                    defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
