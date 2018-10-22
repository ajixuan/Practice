import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAnimalShelter {

    public AnimalShelter shelter;

    @Before
    public void setup(){
        this.shelter = new AnimalShelter();
    }

    @After
    public void teardown(){
        this.shelter = null;
    }

    @Test
    public void testEnDequeueDog(){
        shelter.enqueue(new AnimalShelter.Dog(1));
        shelter.enqueue(new AnimalShelter.Dog(2));
        shelter.enqueue(new AnimalShelter.Dog(3));
        Assert.assertEquals(3,shelter.dequeueDog().age);
        Assert.assertEquals(2,shelter.dequeueDog().age);
        Assert.assertEquals(1,shelter.dequeueDog().age);

        shelter.enqueue(new AnimalShelter.Dog(3));
        shelter.enqueue(new AnimalShelter.Dog(2));
        shelter.enqueue(new AnimalShelter.Dog(1));
        Assert.assertEquals(3,shelter.dequeueDog().age);
        Assert.assertEquals(2,shelter.dequeueDog().age);
        Assert.assertEquals(1,shelter.dequeueDog().age);
    }

    @Test
    public void testEnDequeueCat(){
        shelter.enqueue(new AnimalShelter.Cat(1));
        shelter.enqueue(new AnimalShelter.Cat(2));
        shelter.enqueue(new AnimalShelter.Cat(3));
        Assert.assertEquals(3,shelter.dequeueCat().age);
        Assert.assertEquals(2,shelter.dequeueCat().age);
        Assert.assertEquals(1,shelter.dequeueCat().age);
    }

    @Test
    public void testDequeueAny(){
        shelter.enqueue(new AnimalShelter.Cat(1));
        shelter.enqueue(new AnimalShelter.Cat(2));
        shelter.enqueue(new AnimalShelter.Cat(3));
        AnimalShelter.Animal animal = shelter.dequeueAny();
        Assert.assertTrue(animal instanceof AnimalShelter.Cat);
        Assert.assertEquals(3,animal.age);

        shelter.enqueue(new AnimalShelter.Dog(1));
        shelter.enqueue(new AnimalShelter.Dog(2));
        shelter.enqueue(new AnimalShelter.Dog(4));
        animal = shelter.dequeueAny();
        Assert.assertTrue(animal instanceof AnimalShelter.Dog);
        Assert.assertEquals(4,animal.age);
        animal = shelter.dequeueAny();
        Assert.assertTrue(animal instanceof AnimalShelter.Dog);
        Assert.assertEquals(2,animal.age);
    }

}
