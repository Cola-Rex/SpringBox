package eurekaServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	EurekaClientConfigBean eurekaClientConfigBean;
	
	/**
	 * 用来打印出当前到底有多少个 eureka-server实例在提供服务
	 * 从而可以直观的判断出 eureka-server的扩容是否已经成功
	 */
	@GetMapping("/eureka-service-info")
	public Object getEurekaServerUrl() {
		return eurekaClientConfigBean.getServiceUrl();
	}
}
