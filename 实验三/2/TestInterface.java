
abstract class SpeakerRunner{
    public abstract void speak();
    public abstract void run();
}

class Dog extends SpeakerRunner{
    public void speak(){
        System.out.println("狗的声音：汪、汪！");
    }
    public void run(){
        System.out.println("狗用四肢跑步");
    }
}
class Person extends SpeakerRunner{
    public void speak(){
        System.out.println("人们见面时经常说：您好！");
    }
    public void run(){
        System.out.println("人用两腿跑步");
    }
}
class Bird extends SpeakerRunner{
    public void speak(){
        System.out.println("鸟的声音：啾啾！");
    }
    public void run(){
        System.out.println("鸟用翅膀飞翔");
    }
} 

public class TestInterface{
    public static void main(String[] args){
        Dog d = new Dog();
        d.speak();d.run();
        Person p = new Person();
        p.speak();p.run();
        Bird b = new Bird();
        b.speak();p.run();
    }
}