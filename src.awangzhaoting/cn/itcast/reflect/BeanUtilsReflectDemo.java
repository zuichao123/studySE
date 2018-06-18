package cn.itcast.reflect;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;
/**
 * ����BeanUtils��װ����
 * 
 * @author sunjian
 *
 */
public class BeanUtilsReflectDemo {

	@Test
	public void test() throws Exception {
		Map<String, String> map = new HashMap<>();
		
		map.put("name", "�｡");
		map.put("age", "31");
		map.put("birthday", "1987-12-05");
		
		Person p = new Person();
		
		System.out.println("����BeanUtils��װ����ǰ��"+p);
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.populate(p, map);
		System.out.println("����BeanUtils��װ���ݺ�"+p);
	}

}
