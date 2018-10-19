package com.epam.tat.realtor.listeners;

import com.epam.tat.realtor.dataproveder.RealtorDataProvider;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class IAnnotationTransformerListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        if (method.getName().equals("mortgageCalculatorTest")) {
            iTestAnnotation.setDataProviderClass(RealtorDataProvider.class);
            iTestAnnotation.setDataProvider("mortgageData");
        }
    }
}
