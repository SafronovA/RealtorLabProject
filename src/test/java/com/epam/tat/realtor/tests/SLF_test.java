package com.epam.tat.realtor.tests;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SLF_test {

    public void s(){
        log.info("LOGGER WORKSSSSSSSSSSSSSSSSSSSSSSSSSSSS");


    }

    public static void main(String[] args) {
//        Logger LOG = LoggerFactory.getLogger(SLF_test.class);
//        LOG.info("fsfsfs");
        SLF_test slf_test = new SLF_test();
        slf_test.s();


    }

}
