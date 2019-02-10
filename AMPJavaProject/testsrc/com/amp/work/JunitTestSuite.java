package com.amp.work;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GraphTest.class,
        utilsTest.class
        })
public class JunitTestSuite {
}
