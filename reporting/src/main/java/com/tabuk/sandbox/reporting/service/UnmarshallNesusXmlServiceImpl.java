package com.tabuk.sandbox.reporting.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import com.tabuk.sandbox.reporting.bean.NesusClientData;

@Service
public class UnmarshallNesusXmlServiceImpl implements UnmarshallNesusXmlService {

	final private Unmarshaller unmarshaller;
	
	@Autowired	
	public UnmarshallNesusXmlServiceImpl(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	@Override
	public NesusClientData parse(final File file) throws FileNotFoundException, MarshalException, ValidationException {
		NesusClientData nesusClientData = null;
		InputStream in = new FileInputStream(file);
		InputSource source = new InputSource(in);
		nesusClientData = (NesusClientData) unmarshaller.unmarshal(source);
		return nesusClientData;
	}

}
