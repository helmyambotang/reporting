package com.tabuk.sandbox.reporting.service;

import java.io.File;
import java.io.FileNotFoundException;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

import com.tabuk.sandbox.reporting.bean.NesusClientData;

public interface UnmarshallNesusXmlService {

	NesusClientData parse(final File input) throws FileNotFoundException, MarshalException, ValidationException;
}
