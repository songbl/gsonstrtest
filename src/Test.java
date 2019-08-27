import bean.ToJsonBeanFour;
import bean.ToJsonBeanOne;
import bean.ToJsonBeanThree;
import bean.ToJsonBeanTwo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    Gson gson = new Gson();
    @org.junit.Test

    //直接讲对象转化为Json字符串
    public void test1(){
        //创建对象
        ToJsonBeanOne toJsonBeanOne = new ToJsonBeanOne(1, "小熊", 21);
        //将对象转换为json数据
        String str =  gson.toJson(toJsonBeanOne);
        System.out.println(str);
        //{"id":1,"name":"小熊","age":21}
    }

    //带对象的实体类
    @org.junit.Test
    public void test2(){
        ToJsonBeanTwo toJsonBeanTwo = new ToJsonBeanTwo("曲师", "计科2",
                new ToJsonBeanOne(1, "小熊", 21));

        String str =  gson.toJson(toJsonBeanTwo);
        System.out.println(str);
        // {"school":"华软","classroom":"软工五班","toJsonBeanOne":{"id":1,"name":"小熊","age":21}}
    }


    //************************ 既带对象又带List数据的多个对象
//    {
//        "number": "1",
//        "toJsonBeanTwo": {//这个属性对应的是一个对象，
//                "school": "华软",
//                "classroom": "软工五班",
//                "toJsonBeanOne": {//属性的名称，该对象被包含在对象里面
//                    "id": 1,
//                    "name": "小熊",
//                    "age": 21
//        }
//    },
//        "books": [  这个List属性里面有多个对象
//        {
//            "bookName": "第1本书",
//                "price": 25
//        },
//        {
//            "bookName": "第2本书",
//                "price": 50
//        }
//    ]
//    }
    @org.junit.Test
    public void test3() {
        ToJsonBeanTwo toJsonBeanTwo = new ToJsonBeanTwo("清华", "软五班",
                new ToJsonBeanOne(1, "小熊", 21));
        List<ToJsonBeanThree.Book> books = new ArrayList<ToJsonBeanThree.Book>();
        for (int i = 1; i < 3; ++i) {
            books.add(new ToJsonBeanThree.Book("第" + i + "本书", 25f * i));
        }
        ToJsonBeanThree toJsonBeanThree = new ToJsonBeanThree("1",
                toJsonBeanTwo, books);

        String str = gson.toJson(toJsonBeanThree);
        System.out.println(str);
    }


    //*****************************属性是数组 => 转化的结果也是数组形式*********************
    // {
    //    "method": "hahha",
    //    "params": [
    //        "one",
    //        "two",
    //        "three"
    //    ]
    //  }

    @org.junit.Test
    public void test4(){
        ToJsonBeanFour jsonBeanFour = new ToJsonBeanFour();
        jsonBeanFour.setMethod("hahha");
        String [] str = new String[3];
        str[0]= "one";
        str[1]= "two";
        str[2]= "three";
        jsonBeanFour.setParams(str);

        String jsonStr = gson.toJson(jsonBeanFour);
        System.out.println(jsonStr);
    }


    //***************** Map<String, String>类型的转换, 键值对形式*********
    // {
    //    "key1": "value1",
    //    "key2": "value2",
    //    "key3": "value3"
    //  }
    @org.junit.Test
    public void test5(){
        Gson gson2 = new GsonBuilder().enableComplexMapKeySerialization().create();
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        String str =  gson2.toJson(map);
        System.out.println(str);
    }


    //********************Map<String, Object>类型的转换
    //  {
    //    "key1": {
    //        "id": 1,
    //        "name": "小熊1",
    //        "age": 21
    //    },
    //    "key2": {
    //        "id": 2,
    //        "name": "小熊2",
    //        "age": 21
    //    },
    //    "key3": {
    //        "id": 3,
    //        "name": "小熊3",
    //        "age": 21
    //    }
    //  }
    @org.junit.Test
    public void test6(){
        Gson gson2 = new GsonBuilder().enableComplexMapKeySerialization().create();
        Map<String, ToJsonBeanOne> map = new HashMap<String, ToJsonBeanOne>();
        map.put("key1", new ToJsonBeanOne(1, "小熊1", 21));
        map.put("key2", new ToJsonBeanOne(2, "小熊2", 21));
        map.put("key3", new ToJsonBeanOne(3, "小熊3", 21));
        String str =  gson2.toJson(map);
        System.out.println(str);
    }
}
