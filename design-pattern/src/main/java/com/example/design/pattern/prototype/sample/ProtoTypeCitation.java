package com.example.design.pattern.prototype.sample;

/**
 * @author xizho
 */
public class ProtoTypeCitation implements Cloneable {

    String name;
    String info;
    String college;

    public ProtoTypeCitation(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;

        System.out.println("奖状创建成功！");
    }

    @Override
    protected ProtoTypeCitation clone() throws CloneNotSupportedException {
        System.out.println("奖状拷贝成功！");
        return (ProtoTypeCitation) super.clone();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "ProtoTypeCitation{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", college='" + college + '\'' +
                '}';
    }

    void display() {
        System.out.println(name + info + college);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoTypeCitation p1 = new ProtoTypeCitation("张三", "同学：在本学年第一学期中变现优秀，被评为‘三好学生‘。", "网络教育");
        p1.display();
        ProtoTypeCitation p2 = p1.clone();
        System.out.println("clone时，对象的构造函数是不会执行的");
        p2.setName("王五");
        p2.display();
        System.out.print("p1对象：");
        p1.display();
        System.out.println("浅复制：复制值，所以p2复制了p1的所有变量");
    }

}
