package com.appdemo.demo;


import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.spel.SpELRule;
import org.jeasy.rules.support.JsonRuleDefinitionReader;
import org.mvel2.ParserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.BeanResolver;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@RestController
public class UserApi {

    @Autowired
    RulesEngine myEngine;

    @Autowired
    ConfigRules configRules;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public  Object info(@RequestBody User user) throws Exception {
        Rules rules = configRules.fetchConfigRules();
        SpELRule spELRule = new SpELRule();
        // setting an condition to be evaluated
        BeanResolver beanResolver = new SimpleBeanResovler(SpringBeanUtil.getApplicationContext());
        spELRule.description("bean demo");
        spELRule.priority(20);
        spELRule.when("#user.age < 38");
        spELRule.then("@myService.setInfo(#user)",beanResolver);
        Facts facts = new Facts();
        // 生成一个唯一id，方便基于数据id规则流程查询
        user.setUniqueId(UUID.randomUUID().toString());
        MyRule<User> rule = new MyRule<User>();
       // rules.register(spELRule);
        rules.register(rule);
        facts.put("user",user);
        //  默认模式
        // myEngine.fire(rules,facts);
        // 应该使用原型模式
        SpringBeanUtil.getBean("myEngine",RulesEngine.class).fire(rules,facts);
        if(rule.isExecuted()){
            User userResult=  rule.getResult();
            System.out.println("result from final ruls"+userResult.toString());
            return userResult;
        }
        else  {
            return  null;
        }
    }
}

