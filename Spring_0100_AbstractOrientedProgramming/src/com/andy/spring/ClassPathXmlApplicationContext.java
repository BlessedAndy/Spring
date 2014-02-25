package com.andy.spring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.andy.xmlutil.Sample1;

public class ClassPathXmlApplicationContext implements BeanFactory {

	private Map<String, Object> beans = new HashMap<String, Object>();

	public ClassPathXmlApplicationContext() throws Exception {
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(this.getClass().getClassLoader()
				.getResourceAsStream("test.xml")); // 构造文档对象
		Element root = doc.getRootElement(); // 获取根元素
		List list = root.getChildren("bean");// 取名字为bean的所有元素
		for (int i = 0; i < list.size(); i++) {
			Element element = (Element) list.get(i);
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");
			System.out.println(id + ":" + clazz);
			Object o = Class.forName(clazz).newInstance();
			beans.put(id, o);

			for (Element propertyElement : (List<Element>) element.getChildren("property")) {
				String name = propertyElement.getAttributeValue("name"); // userDAO
				String bean = propertyElement.getAttributeValue("bean"); // u
				Object beanObject = beans.get(bean);// UserDAOImpl instance

				String methodName = "set" + name.substring(0, 1).toUpperCase()
						+ name.substring(1);
				System.out.println("method name = " + methodName);

				Method m = o.getClass().getMethod(methodName,
						beanObject.getClass().getInterfaces()[0]);
				m.invoke(o, beanObject);
			}
		}
	}

	@Override
	public Object getBean(String name) {
		// TODO Auto-generated method stub
		return beans.get(name);
	}

}
