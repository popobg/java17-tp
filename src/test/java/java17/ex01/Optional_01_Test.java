package java17.ex01;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.Test;

import java17.data.Data;
import java17.data.Person;

/**
 * Exercice 02 - Filter, Map
 */
public class Optional_01_Test {
	
	class NotPresentException extends RuntimeException {
		
	}

    <T> List<T> customizedFilter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T el : list) {
            if (predicate.test(el)) {
                result.add(el);
            }
        }
        return result;
    }

    Predicate<Person> adult = p -> p.getAge() == 18;

    @Test
    public void test_optional_ifPresent() throws Exception {
    	
    	List<Person> persons = Data.buildPersonList(100);

        // TODO rechercher dans la liste ci-dessus la 1ère personne ayant 18 ans
        // TODO utiliser la méthode "findFirst"
        Optional<Person> optPerson1 = persons.stream().filter(adult).findFirst();

        // Sans findFirst
        Optional<Person> optPerson2 = Optional.ofNullable(customizedFilter(persons, adult).get(0));

        assertThat(optPerson1.isPresent(), is(true));
        assertThat(optPerson2.isPresent(), is(true));
        
        // TODO afficher la personne en question si l'optional contient une personne
        optPerson1.ifPresent(p -> System.out.println(p));
        optPerson2.ifPresent(p -> System.out.println(p));
    }

    Predicate<Person> senior = p -> p.getAge() >= 75;

    @Test(expected=NotPresentException.class)
    public void test_optional_notPresent() throws Exception {
    	List<Person> persons = Data.buildPersonList(50);

        // TODO rechercher dans la liste ci-dessus la 1ère personne ayant 75 ans
        // TODO utiliser la méthode "findFirst"
        Optional<Person> optPerson = persons.stream().filter(senior).findFirst();
        assertThat(optPerson.isPresent(), is(false));
        
        // TODO si la personne n'existe pas, jeter une exception NotPresentException
        // TODO utiliser la méthode "orElseThrow"
        System.out.println(optPerson.orElseThrow(() -> new NotPresentException()));
    }
}
