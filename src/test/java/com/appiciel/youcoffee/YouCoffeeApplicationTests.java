package com.appiciel.youcoffee;

import com.appiciel.youcoffee.service.CoffeeServiceTest;
import com.appiciel.youcoffee.service.GrainServiceTest;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
@Suite
@SelectClasses( {CoffeeServiceTest.class, GrainServiceTest.class} )
class YouCoffeeApplicationTests {

}
