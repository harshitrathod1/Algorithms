# Digits
- Num % 10 = remainder, which is exactly last digit of that number
- Num / 10 = trim last digit of your number
- The logarithm function with base 10, denoted as log₁₀(x) or simply log(x), signifies the power to which the base (in this case, 10) must be raised to obtain a given number (x).
- Count of digits = ```((int)Math.log10(num) + 1)```
- All divisors of a Num other than itself are less than `N/2`
- All factors of number can be found under sqrt(N)
- For Ex: num = 36
  - 1 * 36
  - 2 * 18
  - 3 * 12
  - 4 * 9
  - `6 * 6` -> sqrt(36) beyond these factors just repeat itself
  - 9 * 4
  - 12 * 3
  - so on
  ### Euclidean Algorithm
  - GCD/HCF => ```gcd(a,b) = gcd(a-b,a) / gcd(a % b,b)```  ``` where a > b```
  -  Time Complexity for above Algorithm : ``O( log_ϕ( min(a,b) ) )``
  - Base of log is phi, because no of steps this algo takes resembles fibonacci sequence
    and growth rate of fibonacci seq is governed by golden ratio phi```ϕ``` = 1.61.....