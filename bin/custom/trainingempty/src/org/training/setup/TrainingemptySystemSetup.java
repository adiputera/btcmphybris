/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.training.setup;

import static org.training.constants.TrainingemptyConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import org.training.constants.TrainingemptyConstants;
import org.training.service.TrainingemptyService;


@SystemSetup(extension = TrainingemptyConstants.EXTENSIONNAME)
public class TrainingemptySystemSetup
{
	private final TrainingemptyService trainingemptyService;

	public TrainingemptySystemSetup(final TrainingemptyService trainingemptyService)
	{
		this.trainingemptyService = trainingemptyService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		trainingemptyService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return TrainingemptySystemSetup.class.getResourceAsStream("/trainingempty/sap-hybris-platform.png");
	}
}
