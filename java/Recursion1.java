/**
 * 
 */
package com.dsa.mtech;

/**
 * @author shivaak on 19-Jan-2019
 *
 */
public class CodingBatRecursion1 {

	/*
	 * 
	 * 
		Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).
	 */
	public int factorial(int n) {
		if(n==0 || n==1) return 1;
		return n * factorial(n-1);
	}


	/*
	 * 
	  We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
	bunnyEars(0) → 0
	bunnyEars(1) → 2
	bunnyEars(2) → 4
	 */
	public int bunnyEars(int bunnies) {
		if(bunnies==1) return 2;
		if(bunnies==0) return 0;
		return 2 + bunnyEars(bunnies-1);
	}

	/*
	 * 
	 * 
	 * The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition.
	 *  The first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of the previous two values.
	 *  so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. 
	 * Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.
	 */
	public int fibonacci(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}


	/*
	 * 
	 * 
	 * We have bunnies standing in a line, numbered 1, 2, ... 
	 * The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, 
	 * because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n 
	 * (without loops or multiplication).
	 */
	public int bunnyEars2(int bunnies) {
		if(bunnies==0) return 0;

		if(bunnies%2==0) 
			return 3 + bunnyEars2(bunnies-1);
		else
			return 2 + bunnyEars2(bunnies-1);
	}


	/*
	 * 
		Given a non-negative int n, return the sum of its digits recursively (no loops). 
		Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
	 */
	public int sumDigits(int n) {
		if(n<=0) return 0;
		return (n%10)+sumDigits(n/10);
	}


	/*
	 * 
	 * Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops). 
	 * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
	 */
	public int count7(int n) {
		if(n<=0) return 0;
		return (n%10==7 ? 1 : 0) + count7(n/10);
	}

	/*
	 * 
	 * 
		Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. 
		Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
	 * 
	 */
	public int count8(int n) {
		if(n<=0)return 0;

		if(n%10==8 && (n/10)%10==8) return 2+ count8(n/10);
		if(n%10==8) return 1+ count8(n/10);

		return count8(n/10);
	}

	/*
	 * 
	 *Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
	 * 
	 */
	public int powerN(int base, int n) {
		if(n==1) return base;
		return base * powerN(base, n-1);
	}


	/*
	 * 
    Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
	countX("xxhixx") → 4
	countX("xhixhix") → 3
	countX("hi") → 0
	 */
	public int countX(String str) {
		if(str.length()==0) return 0;

		return (str.charAt(0) == 'x' ? 1 : 0) + countX(str.substring(1));
	}


	/*
	 * 
	Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
	countHi("xxhixx") → 1
	countHi("xhixhix") → 2
	countHi("hi") → 1
	 */
	public int countHi(String str) {
		if(str.length()<=1)return 0;

		int c = str.substring(0,2).equals("hi") ? 1 : 0;

		if(c==1)
			return c + countHi(str.substring(2));
		else
			return countHi(str.substring(1));
	}


	/*
	 * 
	 * 
		Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.


		changeXY("codex") → "codey"
		changeXY("xxhixx") → "yyhiyy"
		changeXY("xhixhix") → "yhiyhiy"

	 */
	public String changeXY(String str) {
		if(str.length()<=0)return str;
		char c = str.charAt(0);
		if(c=='x')
			return 'y'+ changeXY(str.substring(1));
		else
			return c + changeXY(str.substring(1));
	}


	/*
	 * 
		Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".


		changePi("xpix") → "x3.14x"
		changePi("pipi") → "3.143.14"
		changePi("pip") → "3.14p"
	 * 
	 */
	public String changePi(String str) {
		if(str.length()<=1)return str;
		if(str.substring(0,2).equals("pi"))
			return "3.14" + changePi(str.substring(2));
		return str.substring(0,1) + changePi(str.substring(1));
	}


	/*Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.


	array6([1, 6, 4], 0) → true
	array6([1, 4], 0) → false
	array6([6], 0) → true*/
	public boolean array6(int[] nums, int index) {
		if(index>=nums.length) return false;

		boolean found = (nums[index]==6);

		if(!found)
			return array6(nums,++index);
		else
			return true;
	}

	/*
	 *Given an array of ints, compute recursively the number of times that the value 11 appears in the array. 
	 *We'll use the convention of considering only the part of the array that begins at the given index. 
	 *In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0. 
	 * 
	 */
	public int array11(int[] nums, int index) {
		if(index==nums.length) return 0;
		return (nums[index]==11 ? 1 : 0) + array11(nums, ++index);
	}


	/*
	 * 
	 * Given an array of ints, compute recursively if the array contains somewhere a value followed 
	 * in the array by that value times 10. We'll use the convention of considering only the 
	 * part of the array that begins at the given index. In this way, 
	 * a recursive call can pass index+1 to move down the array.
	 *  The initial call will pass in index as 0.
	 */
	public boolean array220(int[] nums, int index) {
		if(index>=nums.length-1) return false;

		return (nums[index]*10 == nums[index+1]) ? true : array220(nums, index+1);

	}

	/*
	 *
	 * Given a string, compute recursively a new string where all the adjacent chars are 
	 * now separated by a "*".
	 */
	public String allStar(String str) {
		if(str.length()==1 || str.length()==0) return str;
		char c = str.charAt(0);
		return c + "*" + allStar(str.substring(1));
	}


	/*
	 * Given a string, compute recursively a new string where identical chars that are adjacent 
	 * in the original string are separated from each other by a "*".		
		pairStar("hello") → "hel*lo"
		pairStar("xxyy") → "x*xy*y"
		pairStar("aaaa") → "a*a*a*a"
	 * 
	 * 
	 */
	public String pairStar(String str) {
		if(str.length()==1) return str;
		if(str.length()==0) return "";

		if(str.charAt(0)==str.charAt(1)){
			return str.charAt(0) + "*" + pairStar(str.substring(1));
		}

		return str.charAt(0) + pairStar(str.substring(1));
	}

	/*
	 * Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.
		endX("xxre") → "rexx"
		endX("xxhixx") → "hixxxx"
		endX("xhixhix") → "hihixxx"
	 */
	public String endX(String str) {
		if(str.length()==0) return str;
		if(str.charAt(0)=='x') return endX(str.substring(1)) +  str.charAt(0);
		return str.charAt(0) + endX(str.substring(1));
	}

	/*
	 * 
		We'll say that a "pair" in a string is two instances of a char separated by a char. 
		So "AxA" the A's make a pair. Pair's can overlap, 
		so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. 
		Recursively compute the number of pairs in the given string.


		countPairs("axa") → 1
		countPairs("axax") → 2
		countPairs("axbx") → 1
	 * 
	 */
	public int countPairs(String str) {
		if(str.length()<=2) return 0;
		int t = (str.charAt(0)==str.charAt(2)) ? 1 : 0;
		return t + countPairs(str.substring(1));
	}


	/*
	 * 
	 * Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
		countAbc("abc") → 1
		countAbc("abcxxabc") → 2
		countAbc("abaxxaba") → 2
	 */
	public int countAbc(String str) {
		if(str.length()<3) return 0;
		if(str.substring(0,3).equals("abc")) return 1 + countAbc(str.substring(3));
		if(str.substring(0,3).equals("aba")) return 1 + countAbc(str.substring(2));
		return countAbc(str.substring(1));
	}

	/*
	 * 
	 * Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.
		count11("11abc11") → 2
		count11("abc11x11x11") → 3
		count11("111") → 1
	 */
	public int count11(String str) {
		if(str.length()<2) return 0;

		if(str.substring(0,2).equals("11"))
			return 1 + count11(str.substring(2));
		else
			return count11(str.substring(1));
	}

	/*	Given a string, return recursively a "cleaned" string where adjacent chars 
	 * that are the same have been reduced to a single char. So "yyzzza" yields "yza".
			stringClean("yyzzza") → "yza"
			stringClean("abbbcdd") → "abcd"
			stringClean("Hello") → "Helo"
	 */
	public String stringClean(String str) {
		if(str.length()<=1) return str;

		if(str.charAt(0)==str.charAt(1)) 
			return stringClean(str.substring(1));

		return str.charAt(0) + stringClean(str.substring(1));
	}


	/*
	 * 
	 * 
	Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count "hi" that have an 'x' immedately before them.


	countHi2("ahixhi") → 1
	countHi2("ahibhi") → 2
	countHi2("xhixhi") → 0
	 */
	public int countHi2(String str) {
		if(str.length()<2) return 0;

		if(str.substring(0,2).equals("hi")) return 1+ countHi2(str.substring(2));

		if(str.charAt(0)=='x' && str.charAt(1)!='x') return countHi2(str.substring(2));	

		return countHi2(str.substring(1));
	}


	/*
	 * Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)".
		parenBit("xyz(abc)123") → "(abc)"
		parenBit("x(hello)") → "(hello)"
		parenBit("(xy)1") → "(xy)"
	 * 
	 * 
	 */
	public String parenBit(String str) {

		int len = str.length();

		if(str.charAt(0)!='('){

			if(str.charAt(len-1)!=')')
				return parenBit(str.substring(1,len-1));

			return parenBit(str.substring(1,len));
		}

		if(str.charAt(len-1)!=')')
			return parenBit(str.substring(0,len-1));

		return str;
	}


	/*
	 * Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))". Suggestion: check the first and last chars, and then recur on what's inside them.
			nestParen("(())") → true
			nestParen("((()))") → true
			nestParen("(((x))") → false
	 * 
	 * 
	 */
	public boolean nestParen(String str) {
		int len = str.length();

		if(len==0) return true;
		if(len==1) return false;

		if(str.charAt(0)=='(' && str.charAt(len-1)==')')
			return nestParen(str.substring(1,len-1));

		return false;
	}


	/*Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string, without the sub strings overlapping.


	strCount("catcowcat", "cat") → 2
	strCount("catcowcat", "cow") → 1
	strCount("catcowcat", "dog") → 0*/
	public int strCount(String str, String sub) {
		int sublen = sub.length();
		int strlen = str.length();

		if(strlen<sublen)return 0;

		if(str.substring(0,sublen).equals(sub)) return 1 + strCount(str.substring(sublen), sub);

		return strCount(str.substring(1), sub);
	}


	/*
	 * Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative.
		strCopies("catcowcat", "cat", 2) → true
		strCopies("catcowcat", "cow", 2) → false
		strCopies("catcowcat", "cow", 1) → true
	 * 
	 */
	public boolean strCopies(String str, String sub, int n) {
		if(n==0) return true;
		int strlen = str.length();
		int sublen = sub.length();

		if(str.length()<sublen) return false;

		if(str.substring(0,sublen).equals(sub)){
			return strCopies(str.substring(1), sub, --n);
		}else{
			return strCopies(str.substring(1), sub, n);
		}

	}


/*	Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends with sub and return its length.
	
	
	strDist("catcowcat", "cat") → 9
	strDist("catcowcat", "cow") → 3
	strDist("cccatcowcatxx", "cat") → 9*/
	public int strDist(String str, String sub) {
		int strlen = str.length();
		int sublen = sub.length();

		if(strlen < sublen) return 0;

		if(!str.substring(0,sublen).equals(sub)){
			if(str.substring(strlen-sublen).equals(sub)){
				return strDist(str.substring(1),sub);
			}
			return strDist(str.substring(1,strlen),sub);
		}else{
			if(!str.substring(strlen-sublen).equals(sub)){
				return strDist(str.substring(0,strlen-1),sub);
			}
		}

		return strlen;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CodingBatRecursion1 obj = new CodingBatRecursion1();
		System.out.println(obj.strDist("xyx", "y"));

	}

}
