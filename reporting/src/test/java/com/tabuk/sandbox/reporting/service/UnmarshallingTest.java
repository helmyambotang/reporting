package com.tabuk.sandbox.reporting.service;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.InputSource;

import com.tabuk.sandbox.reporting.bean.NesusClientData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-reporting-castor.xml")
public class UnmarshallingTest {

	@Autowired
	private Unmarshaller unmarshaller;

	@Test
	public void testUnmarshall1() throws FileNotFoundException,
			MarshalException, ValidationException {
		File f = new File("src/test/resources/nessus_report_BHEUU_SF_1.nessus");
		InputStream in = new FileInputStream(f);
		InputSource source = new InputSource(in);
		Object obj = unmarshaller.unmarshal(source);
		assertNotNull(obj);
		assertEquals(obj.getClass(), NesusClientData.class);
	}
	
	@Test
	public void testUnmarshall2() throws FileNotFoundException,
			MarshalException, ValidationException {
		File f = new File("src/test/resources/nessus_report_BHEUU_JBI_SEREMBAN_8.nessus");
		InputStream in = new FileInputStream(f);
		InputSource source = new InputSource(in);
		Object obj = unmarshaller.unmarshal(source);
		assertNotNull(obj);
		assertEquals(obj.getClass(), NesusClientData.class);
		System.out.println(obj);
	}

}
