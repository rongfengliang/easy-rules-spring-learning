package com.appdemo.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngineListener;
import org.springframework.stereotype.Component;

@Component
public class MyRuleEngineListener implements RulesEngineListener {
    Log log = LogFactory.getLog(MyRuleEngineListener.class);

    @Override
    public void beforeEvaluate(Rules rules, Facts facts) {
        log.info("-----------------beforeEvaluate-----------------");
        log.info(rules.toString() +" "+facts.toString());
    }

    @Override
    public void afterExecute(Rules rules, Facts facts) {
        log.info("-----------------afterExecute-----------------");
        log.info(rules.toString()+"   "+facts.toString());
    }
}
