package com.appdemo.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class DemoApplication {
	Log log = LogFactory.getLog(MyRulesListener.class);
	@Bean(name = "myEngine")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public RulesEngine myEngine(MyRulesListener myRulesListener,MyRuleEngineListener myRuleEngineListener) {
		log.info("create rule Engine");
		DefaultRulesEngine rulesEngine = new DefaultRulesEngine();
		rulesEngine.registerRuleListener(myRulesListener);
		rulesEngine.registerRulesEngineListener(myRuleEngineListener);
		return rulesEngine;
	}
	@Bean("myEngine2")
	ProtoRulesEngineFactoryBean rulesEngineFactoryBean()
	{
		return new ProtoRulesEngineFactoryBean();
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
