package bean;

public class ToJsonBeanTwo {
    private String school;
    private String classroom;
    private ToJsonBeanOne toJsonBeanOne;

    public ToJsonBeanTwo(String school, String classroom,
                         ToJsonBeanOne toJsonBeanOne) {
        super();
        this.school = school;
        this.classroom = classroom;
        this.toJsonBeanOne = toJsonBeanOne;
    }

    public String getSchool() {
        return school;
    }

    public String getClassroom() {
        return classroom;
    }

    public ToJsonBeanOne getToJsonBeanOne() {
        return toJsonBeanOne;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setToJsonBeanOne(ToJsonBeanOne toJsonBeanOne) {
        this.toJsonBeanOne = toJsonBeanOne;
    }

    @Override
    public String toString() {
        String resultString = "";
        resultString += "school:" + school + "\nclassroom:" + classroom
                + "\ntoJsonBeanOne:\nid:" + toJsonBeanOne.getId() + "\nname:"
                + toJsonBeanOne.getName() + "\nage:" + toJsonBeanOne.getAge()
                + "\n";
        return resultString;
    }
}
