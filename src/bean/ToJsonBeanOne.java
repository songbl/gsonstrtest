package bean;

public class ToJsonBeanOne {
    private int id;
    private String name;
    private int age;

    public ToJsonBeanOne(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String resultString = "";
        resultString += "id:" + id + "\nname:" + name + "\nage:" + age + "\n";

        return resultString;
    }
}
