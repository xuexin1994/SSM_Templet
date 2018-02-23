package com.xin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义日期转换类
 * @author xuexin
 *	S:source表示从页面传进来的日期字符串
 *	T:target表示目标对象类型
 */
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;//转换失败
		}
	}
}
