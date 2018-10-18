package com.epam.tat.realtor.tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
@Test
public class SLF_test {


    public void s(){
        log.info("======================LOGGER WORKSSSSSSSSSSSSSSSSSSSSSSSSSSSS===========================");
        Assert.assertTrue(true);
    }

//    public static void main(String[] args) {
//        SLF_test slf_test = new SLF_test();
//        slf_test.s();
//    }

}
