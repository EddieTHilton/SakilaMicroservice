package com.tsi.eddie.t.hilton.springtest;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        tags = "not @ignore",
        features = "src/test/resources/Cucumber",
        glue = "com.tsi.eddie.t.hilton.springtest")  // pretty is  just for looks
                                // features is where cucumber can find the features files
                                    //this is Cucumber folder's Pathfrom Context Root
                                //glue is the package link
public class runCucumberTest {
}
