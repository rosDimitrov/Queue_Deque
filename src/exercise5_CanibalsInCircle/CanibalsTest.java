package exercise5_CanibalsInCircle;

public class CanibalsTest {

	public static void main(String[] args) {

		Circle circle = new Circle();

		Person first = new Person("first");
		Person second = new Person("second");
		Person third = new Person("third");

		circle.addPerson(first);
		circle.addPerson(second);
		circle.addPerson(third);
		System.out.println(circle.printPersons());
		circle.removeFirst();
		System.out.println(circle.printPersons());
		circle.removeNext(2);
		System.out.println(circle.printPersons());

	}
}
