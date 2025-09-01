
public class Main {
    public static void main(String[] args) {
        StringBasedMusicalInstrument stringInstrument= new Violin();
        stringInstrument.tuneStrings();
        stringInstrument.play();
    }
}

//an abstract class may or may not have abstract methods
abstract class MusicalInstrument // <-- with partial contract
{
    abstract void play(); //partial contract | optional | not mandatory
    //but abstract methods must reside in an abstract class
    //above method is a mandate for its non-abstract immediate children
}
abstract class StringBasedMusicalInstrument extends MusicalInstrument
{ //for abstract child its NOT at all a compulsion to implement the contracts of the abstract parent
    abstract void tuneStrings();
}
//The type Guitar "must" implement the inherited abstract method MusicalInstrument.play()
//The type Guitar must implement the inherited abstract method StringBasedMusicalInstrument.tuneStrings()
class Guitar extends StringBasedMusicalInstrument //non-abstract
{
    void play() { //mandate is fulfilled
        System.out.println("Playing Guitar....");
    }
    void tuneStrings() { //mandate is fulfilled
        System.out.println("Tuning the Strings of a Guitar....");
    }
}

class Violin extends StringBasedMusicalInstrument //non-abstract
{
    void play() { //mandate is fulfilled
        System.out.println("Playing Violin....");
    }
    void tuneStrings() { //mandate is fulfilled
        System.out.println("Tuning the Strings of a Violin....");
    }
}

class Sitar extends StringBasedMusicalInstrument //non-abstract
{
    void play() { //mandate is fulfilled
        System.out.println("Playing Sitar....");
    }
    void tuneStrings() { //mandate is fulfilled
        System.out.println("Tuning the Strings of a Sitar....");
    }
}


class ElectronicGuitar extends Guitar //non-abstract
{
    void play() { //not mandatory | it is overridden and that is optional
        System.out.println("Playing ElectronicGuitar..with presets......");
    }
    void tuneStrings() { //not mandatory | it is overridden and that is optional
        System.out.println("Tuning the Strings of a ElectronicGuitar....");
    }
}

//drum -------------


abstract class DrumBasedInstrument extends MusicalInstrument{

    abstract void basePlayDrum();

    void makeNoise(){
        System.out.println("noise made");
    }

}


class Tambourine extends  DrumBasedInstrument {

    void basePlayDrum() {
        System.out.println("in drums ...basePlayDrum");
    }


    void play() {
        System.out.println("playing drums");
    }
}

class Tabla extends  DrumBasedInstrument {
    void basePlayDrum() {
        System.out.println("in tabla ...basePlayDrum");
    }

    void play() {
        System.out.println("playing tabla");
    }
}



//-----------air

abstract class AirBasedInstrument extends MusicalInstrument{

    abstract void fillAir();
    void makeNoise(){
        System.out.println("noise made");
    }
}


class Flute extends  AirBasedInstrument {

    void fillAir() {
        System.out.println("in drums ...fillAir");
    }

    void play() {
        System.out.println("playing flute");
    }
}


class Saxophone extends  AirBasedInstrument {

    void fillAir() {
        System.out.println("in saxophone ...fillAir");
    }

    void play() {
        System.out.println("playing saxophone");
    }

}








abstract class PerformanceSpaces // <-- with partial contract
{
    abstract void book(); //partial contract | optional | not mandatory
    //but abstract methods must reside in an abstract class
    //above method is a mandate for its non-abstract immediate children
}
abstract class Auditorium extends PerformanceSpaces
{ //for abstract child its NOT at all a compulsion to implement the contracts of the abstract parent
    abstract void countseating();
}
//The type Guitar "must" implement the inherited abstract method MusicalInstrument.play()
//The type Guitar must implement the inherited abstract method StringBasedMusicalInstrument.tuneStrings()
class OperaHouse extends Auditorium //non-abstract
{
    void book() { //mandate is fulfilled
        System.out.println("Booking Audi --- OperaHouse");
    }
    void countseating() { //mandate is fulfilled
        System.out.println("counting");
    }
}

class BlackBoxAudi extends Auditorium //non-abstract
{
    void book() { //mandate is fulfilled
        System.out.println("Booking Audi --- blackboxaudi");
    }

    void countseating() { //mandate is fulfilled
        System.out.println("counting");
    }

}




abstract class Stadium extends PerformanceSpaces
{ //for abstract child its NOT at all a compulsion to implement the contracts of the abstract parent
    abstract void setStage();

}

class sportsArena extends Stadium //non-abstract
{
    void book() { //mandate is fulfilled
        System.out.println("Booking Stadium --- sportsArena");
    }
    void setStage() { //mandate is fulfilled
        System.out.println("settingStage");
    }
}

class cricketStadium extends Stadium //non-abstract
{
    void setStage() { //mandate is fulfilled
        System.out.println("settingStage");
    }

    void book() { //mandate is fulfilled
        System.out.println("Booking Stadium --- cricketStadium");
    }

}




abstract class Cafe extends PerformanceSpaces {
    abstract void prepareBeverages();
}

class JazzCafe extends Cafe {
    void book() {
        System.out.println("Booking Cafe --- JazzCafe");
    }
    void prepareBeverages() {
        System.out.println("Preparing beverages at JazzCafe");
    }
}

class Coffeehouse extends Cafe {
    void book() {
        System.out.println("Booking Cafe --- Coffeehouse");
    }
    void prepareBeverages() {
        System.out.println("Preparing beverages at Coffeehouse");
    }
}




//-----------air









// AirBasedInstrument
// DrumBasedInstrument
// also innovate another sibling for MusicalInstrument

/*
 *
 * 								   Show Requirements
 * 										|
 * 						-------------------------------------
 						|									|
 				MusicalInstrument							Performance Spaces
 						|									|
 			-------------------------			------------------------------------
 			|			|			|			|			|			           |
 			SBMI		ABMI		DBMI     Stadium		Cafe      		Auditorium

*
*
 */









public class InterfaceTest {
    public static void main(String[] args) {

        //higher you go to chase the super class handle
        //lesser the scope of methods

        //lower you go to chase the sub class handle
        //wider the scope of methods

        Bat animal = new Bat();
        animal.eat();
        animal.swim();
        animal.giveBirth();


    }
}

interface Animal {
    void eat();
}
interface Bird extends Animal {
    void fly();
}
interface Mammal extends Animal {
    void giveBirth();
}
interface Fish extends Animal {
    void swim();
}

class Bat implements Bird,Mammal  {
    public void fly() { }
    public void giveBirth() { }
    public void eat() { }

}
class Whale implements Fish,Mammal
{
    public void swim() { }
    public void giveBirth() { }
    public void eat() { }
}

class Horse implements Mammal
{
    public void giveBirth() { }
    public void eat() { }
}


/*

					Animal
						| eat() /sleep() / reproduce() /
		---------------------------------
		|				|			   |
		Bird		 Mammal			  Fish
		|fly()			|giveBirth()	|swim()
	----------	    ---------		-----------
	|		 |*		|		|		|*		 |
 Parrot		 Bat   Human	Horse   Whale   Sword

*/
