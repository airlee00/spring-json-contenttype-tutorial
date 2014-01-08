/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.toms.sample.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class JsonTestController {

	@RequestMapping(value = "/nojson.do", produces = "application/json; charset=UTF-8")
	public @ResponseBody
	String noJsonConverter(HttpServletRequest request, HttpServletResponse response,@RequestBody  String data) throws Exception {

		String jsonStr = request.getParameter("data");
		System.out.println("==data==" + data);
		System.out.println("==jsonStr==" + jsonStr);
		System.out.println("==javaBean==" + data);
		return jsonStr;
	}
	/**
	 * 	
	 * @see dispatch-servlet.xml
	 * 
	 * <bean
		class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
      		
        <property name="messageConverters">
			<list>
				<ref bean="jsonConverter" />
			</list>
		</property> 
	</bean>
	 * @param request
	 * @param response
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/withjson.do", produces = "application/json; charset=UTF-8")
	public @ResponseBody
	String withJsonConverter(HttpServletRequest request, HttpServletResponse response,@RequestBody JavaBean data) throws Exception {

		String jsonStr = request.getParameter("data");
		System.out.println("==data==" + data);
		System.out.println("==jsonStr==" + jsonStr);
		System.out.println("==javaBean==" + data);
		return jsonStr;
	}
}
