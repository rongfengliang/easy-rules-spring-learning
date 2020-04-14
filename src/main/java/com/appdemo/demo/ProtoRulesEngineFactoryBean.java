package com.appdemo.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author dalong
 * 原型RulesEngine FactoryBean
 */
public class ProtoRulesEngineFactoryBean implements FactoryBean<RulesEngine> {
    Log log = LogFactory.getLog(MyRulesListener.class);
    public RulesEngine init() {
        log.info("create rule Engine");
        DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.registerRuleListener(new MyRulesListener());
        rulesEngine.registerRulesEngineListener(new MyRuleEngineListener());
        return rulesEngine;
    }

    @Override
    public RulesEngine getObject() throws Exception {
        return this.init();
    }

    @Override
    public Class<?> getObjectType() {
        return RulesEngine.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
