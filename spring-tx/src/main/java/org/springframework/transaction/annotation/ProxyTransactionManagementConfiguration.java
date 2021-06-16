/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.transaction.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.transaction.config.TransactionManagementConfigUtils;
import org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * {@code @Configuration} class that registers the Spring infrastructure beans
 * necessary to enable proxy-based annotation-driven transaction management.
 *
 * @author Chris Beams
 * @author Sebastien Deleuze
 * @since 3.1
 * @see EnableTransactionManagement
 * @see TransactionManagementConfigurationSelector
 */
@Configuration(proxyBeanMethods = false)
public class ProxyTransactionManagementConfiguration extends AbstractTransactionManagementConfiguration {

	/**
	 *
	 * 给容器中注册事务增强器
	 * 1)、事务增强器要用事务注解的信息，AnnotationTransactionAttributeSource解析事务注解
	 * 2)、事务拦截器:
	 * 		TransactionInterceptor;保存了事务属性信息，事务管理器;
	 * 		它是一个 MethodInterceptor;
	 * 		在目标方法执行的时候;
	 * 			执行拦截器链:
	 * 			事务拦截器:
	 * 				1)、先获取事务相关的属性
	 * 				2)、再获取PlatformTransactionManager，如果事先没有添加指定任
	 * 				何transactionManager最终会从容器中按照类型获取一个PlatformTransactionManager;
	 * 				3)、执行目标方法
	 * 					如果异常，获取到事务管理器，利用事务管理回滚操作;
	 * 					如果正常，利用事务管理器，提交事务
	 */

	@Bean(name = TransactionManagementConfigUtils.TRANSACTION_ADVISOR_BEAN_NAME)
	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	public BeanFactoryTransactionAttributeSourceAdvisor transactionAdvisor(
			TransactionAttributeSource transactionAttributeSource,
			TransactionInterceptor transactionInterceptor) {
		BeanFactoryTransactionAttributeSourceAdvisor advisor = new BeanFactoryTransactionAttributeSourceAdvisor();


		//1)、事务增强器要用事务注解的信息，利用AnnotationTransactionAttributeSource解析事务注解
		advisor.setTransactionAttributeSource(transactionAttributeSource);

		//2)、事务拦截器:
		advisor.setAdvice(transactionInterceptor);


		if (this.enableTx != null) {
			advisor.setOrder(this.enableTx.<Integer>getNumber("order"));
		}
		return advisor;
	}

	@Bean
	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	public TransactionAttributeSource transactionAttributeSource() {
		return new AnnotationTransactionAttributeSource();
	}

	@Bean
	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	public TransactionInterceptor transactionInterceptor(
			TransactionAttributeSource transactionAttributeSource) {
		TransactionInterceptor interceptor = new TransactionInterceptor();


		/**
		 * TransactionInterceptor;保存了事务属性信息，事务管理器;
		 *
		 * TransactionInterceptor看类图， 发现它是一个 MethodInterceptor;
		 */

		interceptor.setTransactionAttributeSource(transactionAttributeSource);
		if (this.txManager != null) {
			interceptor.setTransactionManager(this.txManager);
		}
		return interceptor;
	}

}
