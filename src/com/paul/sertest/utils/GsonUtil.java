package com.paul.sertest.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;

/**
 * Gson工具类
 * @author XY
 *
 */
public class GsonUtil {
	private static Gson gson = new Gson();
	
	/**
	 * 对象序列化为json字符串
	 * @param object
	 * @return
	 */
	public static <T> String objectToJsonStr(T object) {
		return gson.toJson(object);
	}
	
	/**
	 * json字符串解析为List集合
	 * @param args
	 * @return
	 */
	public static <T> List<T> jsonToList(String jsonStr, Type type) {
		return gson.fromJson(jsonStr, type);
	}
	
	/**
	 * json字符串解析为对象
	 * @param jsonStr
	 * @param classOfT
	 * @return
	 */
	public static <T> T jsonStrToObject(String jsonStr, Class<T> classOfT) {
		return gson.fromJson(jsonStr, classOfT);
	}
	
	public static ParameterizedType type(final Class<?> raw, final Type... args) {
		return new ParameterizedType() {
			
			@Override
			public Type getRawType() {
				return raw;
			}
			
			@Override
			public Type getOwnerType() {
				return null;
			}
			
			@Override
			public Type[] getActualTypeArguments() {
				return args;
			}
		};
	}
	
}
