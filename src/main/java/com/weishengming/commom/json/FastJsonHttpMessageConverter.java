package com.weishengming.commom.json;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
	public final static Charset UTF8 = Charset.forName("UTF-8");
	private Charset charset = UTF8;
	private SerializerFeature[] serializerFeature = new SerializerFeature[0];
	public SerializerFeature[] getSerializerFeature() {
		return serializerFeature;
	}

	public void setSerializerFeature(SerializerFeature[] serializerFeature) {
		this.serializerFeature = serializerFeature;
	}

	public FastJsonHttpMessageConverter() {
		super(new MediaType("application", "json", UTF8), new MediaType("application", "*+json", UTF8));
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		return true;
	}

	public Charset getCharset() {
		return this.charset;
	}

	public void setCharset(Charset charset) {
		this.charset = charset;
	}

	 

	@Override
	protected Object readInternal(Class<? extends Object> clazz,HttpInputMessage inputMessage) throws IOException,HttpMessageNotReadableException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream in = inputMessage.getBody();
		byte[] buf = new byte[1024];
		for (;;) {
			int len = in.read(buf);
			if (len == -1) {
				break;
			}

			if (len > 0) {
				baos.write(buf, 0, len);
			}
		}

		byte[] bytes = baos.toByteArray();
		return JSON.parseObject(bytes, 0, bytes.length, charset.newDecoder(),clazz);
	}

	@Override
	protected void writeInternal(Object obj, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {

		OutputStream out = outputMessage.getBody();
		String text = JSON.toJSONString(obj, serializerFeature);
		byte[] bytes = text.getBytes(charset);
		out.write(bytes);
	}

}
