package com.appdemo.demo;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.JsonRuleDefinitionReader;
import org.mvel2.ParserContext;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author dalong
 * 加载rule文件
 */
@Component
public class ConfigRules {
    public Rules fetchConfigRules() throws Exception {
        MVELRuleFactory ruleFactory = new MVELRuleFactory(new JsonRuleDefinitionReader());
        ParserContext context  =new ParserContext();
        context.addImport("UserService", UserService.class);
        Rules jsonRules = ruleFactory.createRules(new FileReader(DemoApplication.class.getClassLoader().getResource("rules-json2.json").getFile()),context);
        return jsonRules;
    }
}
