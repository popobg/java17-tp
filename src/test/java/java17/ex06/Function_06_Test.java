package java17.ex06;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import java17.data.Person;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {

    // tag::formatAge[]
    // TODO compléter la méthode
    // TODO la méthode retourne une chaîne de caractères de la forme [age=<AGE>] (exemple : [age=12])
    String formatAge(Supplier<Person> supplier) {
        // TODO
        return String.format("[age=%d]", supplier.get().getAge());
    }
    // end::formatAge[]


    @Test
    public void test_supplier_formatAge() throws Exception {
        Person person = new Person("John", "France", 35, "pass");

        // TODO compléter le test unitaire pour qu'il soit passant
        String result = formatAge(() -> person);

        assert result.equals("[age=35]");
    }

}
