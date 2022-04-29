package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleGeneratorTest {

    @Ignore
    @Test
    public void whenKeysAreRight() {
        Generator generator = new SimpleGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        map.put("subject", "you");
        String expected = "I am Petr, Who are you?";
        String result = generator.produce(template, map);
        assertThat(result, is(expected));
    }

    @Ignore
    @Test
    public void whenKeyUsingTwice() {
        Generator generator = new SimpleGenerator();
        String template = "I am ${name}, Who are ${subject}? I am ${name}.";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        map.put("subject", "you");
        String expected = "I am Petr, Who are you? I am Petr.";
        String result = generator.produce(template, map);
        assertThat(result, is(expected));
    }
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenOneKeyIsWrong() {
        Generator generator = new SimpleGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        map.put("surname", "Ivanov");
        String result = generator.produce(template, map);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenOneKeyIsExcess() {
        Generator generator = new SimpleGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        map.put("subject", "you");
        map.put("surname", "Ivanov");
        String result = generator.produce(template, map);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenMissingOneKey() {
        Generator generator = new SimpleGenerator();
        String template = "${greeting}. I am ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        map.put("subject", "you");
        String result = generator.produce(template, map);
    }
}
