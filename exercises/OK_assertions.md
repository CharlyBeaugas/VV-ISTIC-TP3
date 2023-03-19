# On assertions

Answer the following questions:

1. The following assertion fails assertTrue(3 * .4 == 1.2). Explain why and describe how this type of check should be done.

2. What is the difference between assertEquals and assertSame? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that fail is useful to mark code that should not be executed because an exception was expected before. Find other uses for fail. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the @Test annotation, while in JUnit 5 there is a special assertion method assertThrows. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. This assertion fails because it doesn't respect the contract of assertTrue() (the argument is supposed to be a boolean condition, in the example: an expression is given - the + operator makes it so).
   This type of check should be done using assertEquals and the result of 3 * .4 should be computed and stored as a double before being tested.

2. AssertEquals() checks that its parameters have the same value, assertSame() checks that both its parameters are the same reference.

3. A fail can be used in a catch, so that if the tested code throws an exception, the test fails :
```JAVA
   @Test
   public void testFail()
   {
      try
      {
         //do something that should not throw exception
         assert(...)
      }
      catch(MyException e)
      {
         fail("Exception thrown : "+e.getMessage());
      }
   }
```

4. It allows to do something after the exception was thrown and not just stop the test.