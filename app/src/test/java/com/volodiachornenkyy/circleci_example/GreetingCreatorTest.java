package com.volodiachornenkyy.circleci_example;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class GreetingCreatorTest {

    private GreetingCreator greetingCreator;

    private boolean isContextNull;
    private String paramName;
    private String expectedGreeting;

    public GreetingCreatorTest(String paramName, String expectedGreeting, boolean isContextNull) {
        this.paramName = paramName;
        this.expectedGreeting = expectedGreeting;
        this.isContextNull = isContextNull;
    }

    @Parameterized.Parameters(name = "name = {0}, greeting = {1}, isContextNull = {2}")
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {null, null, true},
                {null, null, false},
                {"", null, true},
                {"", "Hello ", false},
                {"name", null, true},
                {"name", "Hello name", false},
        });
    }

    @Before
    public void init() {
        greetingCreator = new GreetingCreator();
    }

    @Test
    public void get_isCorrect() {
        Context context = prepareContext();
        assertEquals(expectedGreeting, greetingCreator.get(context, paramName));
    }

    private Context prepareContext() {
        Context context;
        if (isContextNull) {
            context = null;
        } else {
            context = mock(Context.class);
            when(context.getString(anyInt())).thenReturn("Hello %s");
        }
        return context;
    }
}