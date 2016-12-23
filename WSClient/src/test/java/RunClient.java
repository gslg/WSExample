import com.lg.ws.example.client.Example;
import com.lg.ws.example.client.Example_Service;
import com.lg.ws.example.client.Person;
import com.lg.ws.example.client.PersonArray;

/**
 * 使用jdk自带的工具生成客户端代码:
 *
 * wsimport -d ./bin -s ./src -encoding utf-8  -p  com.lg.ws.example.client http://localhost:8080/hello?wsdl
 *
 * 	-d 生成客户端执行类的class文件的存放目录
 *	-s 生成客户端执行类的源文件的存放目录
 *	-p 定义生成类的包名
 *
 * Created by liuguo on 2016/12/23.
 */
public class RunClient {
    public static void main(String[] args) throws Exception{
        Example_Service service = new Example_Service();

        Example server = service.getExamplePort();

        System.out.println("toSayHello:"+ server.toSayHello("liuguo"));

        Person person = new Person();
        person.setName("luobing");
        person.setAge(24);

        PersonArray personArray =  server.sayHello(person,"a bing");
        for(Person person1 : personArray.getItem()){

            System.out.println(person1.getName());
        }
    }
}
