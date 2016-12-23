package com.lg.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * 提供webservice服务的类
 * Created by liuguo on 2016/12/23.
 */
@WebService(name = "Example",targetNamespace = "http://www.wslg.com/wstest",serviceName = "Example")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Example {
    private ArrayList<Person> persons = new ArrayList<Person>();

    @WebMethod(operationName = "toSayHello",action = "sayHello",exclude = false)
    @WebResult(name = "returnWord")
    public String sayHello(@WebParam(name = "userName") String userName){
        return "Hello,"+userName;
    }

    @WebMethod(operationName="sayHello", action="sayHello")
    @WebResult(partName="personList")
    public Person[] sayHello(@WebParam(partName="person", mode= WebParam.Mode.IN)Person person,
                             String userName) throws HelloException {
        if (person == null || person.getName() == null) {
            throw new HelloException("说hello出错，对像为空。。");
        }
        System.out.println(person.getName() + " 对 " + userName + " 说：Hello，我今年" + person.getAge() + "岁");
        persons.add(person);
        return persons.toArray(new Person[0]);
    }
}
