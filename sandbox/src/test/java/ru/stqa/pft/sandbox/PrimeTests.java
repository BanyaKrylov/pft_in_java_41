package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ivan8 on 01.06.2017.
 */
public class PrimeTests {

  @Test
  public void testPrimes() {
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test(enabled = false)
  public void testNonPrime() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2 ));
  }

  @Test(enabled = false)
  public void testNonPrimeWhile() {
    Assert.assertFalse(Primes.isPrimeWhile(Integer.MAX_VALUE - 2 ));
  }

  @Test(enabled = false)
  public void testPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }
}