package com.helloWorld.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
@Component
public class JsonStringPaser {
	private ObjectMapper mapper = new ObjectMapper();
	public<T> T parser(String source,java.lang.Class<T> valueType) throws Exception
	{	
			return mapper.readValue(source, valueType);
	}
	

}
