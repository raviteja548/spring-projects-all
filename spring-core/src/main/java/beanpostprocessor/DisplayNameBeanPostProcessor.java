package beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor,BeanFactoryPostProcessor{

    // methods implemented : BeanPostProcessor
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("In before initialization "+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("In post initialization "+beanName);
        return bean;
    }

    //methods implemented: BeanFactoryPostProcessor
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("In factory bean post processor..");

    }


}
