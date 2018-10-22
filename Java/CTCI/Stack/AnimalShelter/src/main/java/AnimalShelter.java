import java.util.LinkedList;


public class AnimalShelter {

    LinkedList<Cat> cats;
    LinkedList<Dog> dogs;
    LinkedList<Animal> temp;

    public AnimalShelter() {
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
        temp = new LinkedList<Animal>();
    }

    public void enqueue(Animal animal) {
        LinkedList list;
        if (animal instanceof Dog) {
            list = this.dogs;
        } else {
            list = this.cats;
        }

        while (!list.isEmpty() && ((Animal) list.peek()).age > animal.age) {
            temp.push((Animal) list.pop());
        }
        list.push(animal);

        while (!temp.isEmpty()) {
            list.push(temp.pop());
        }
    }

    public Animal dequeueAny() {
        return (!dogs.isEmpty() && cats.isEmpty()) ? dogs.pop() :
                (dogs.isEmpty() && !cats.isEmpty()) ? cats.pop() :
                        (dogs.peek().age >= cats.peek().age) ? dogs.pop() : cats.pop();
    }

    public Dog dequeueDog() {
        return dogs.pop();
    }

    public Cat dequeueCat() {
        return cats.pop();
    }


    public static class Dog extends AnimalShelter.Animal {
        public Dog(int age) {
            super(age);
        }
    }

    public static class Cat extends AnimalShelter.Animal {
        public Cat(int age) {
            super(age);
        }
    }

    static abstract class Animal {
        public int age;

        public Animal(int age) {
            this.age = age;
        }
    }
}
