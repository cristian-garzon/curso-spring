package com.cursospring.microservicios.app.users.suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)

@SelectPackages({"com.cursospring.microservicios.app.users.testing"})

@IncludeTags("userTest")

public class testSuite {
}