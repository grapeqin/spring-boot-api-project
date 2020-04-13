package com.grapeqin.project.configurer;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 集成通用Mapper
 *
 * @description
 * @author qinzy
 * @date 2020-04-13
 */
@Configuration
public class MyMapperConfig {

	@Bean
	public MapperScannerConfigurer getMapperScannerConfigurer() {
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		msc.setBasePackage("com.grapeqin.project.dao");
		return msc;
	}
}
