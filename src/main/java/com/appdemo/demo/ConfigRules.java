package com.appdemo.demo;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.spel.SpELRuleFactory;
import org.jeasy.rules.support.JsonRuleDefinitionReader;
import org.jeasy.rules.support.RuleDefinitionReader;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.stereotype.Component;
import java.io.FileReader;

/**
 * @author dalong
 * 加载rule文件
 */
@Component
public class ConfigRules {
    public Rules fetchConfigRules() throws Exception {
        BeanResolver beanResolver = new SimpleBeanResovler(SpringBeanUtil.getApplicationContext());
        SpELRuleFactory ruleFactory = new SpELRuleFactory(new JsonRuleDefinitionReader(),beanResolver);
        Rules jsonRules = ruleFactory.createRules(new FileReader(DemoApplication.class.getClassLoader().getResource("rules-json.json").getFile()));
        return jsonRules;
    }
}
