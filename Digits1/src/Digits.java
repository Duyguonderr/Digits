import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digits Library Menu: ");
        System.out.println("Choose action to perform: ");
        int number = input.nextInt();
        switch (number) {
            case 1:
                System.out.println("Enter a number : ");
                int n = input.nextInt();
                System.out.println("least significant digit is: " + digitZero(n));
                break;
            case 2:
                System.out.println("Enter a number ");
                n = input.nextInt();
                System.out.println("Enter a digit: ");
                int i = input.nextInt();
                System.out.println("the ith digit of n is: " + digitAt(n, i));
                break;
            case 3:
                System.out.println("Enter a number:");
                n = input.nextInt();
                System.out.println("Enter a limit: ");
                int limit = input.nextInt();
                System.out.println("the sum of the digits that bigger than limit: " + digitSumLargerThan(n, limit));
                break;
            case 4:
                System.out.println("Enter a number: ");
                n = input.nextInt();
                System.out.println("Enter a digit: ");
                int digit = input.nextInt();
                System.out.println("the method should return: " + digitCount(n, digit));
                break;
            case 5:
                System.out.println("Enter a number: ");
                n = input.nextInt();
                System.out.println("Enter a digit: ");
                i = input.nextInt();
                System.out.println("remove the ith digit from n: " + digitRemoveAt(n, i));
                break;
            case 6:
                System.out.println("Enter a number: ");
                n = input.nextInt();
                System.out.println("Enter a digit:");
                digit = input.nextInt();
                System.out.println("remove the integer's digits as same as the digit:  " + digitRemoveAll(n, digit));
                break;
            case 7:
                System.out.println("Enter a number: ");
                int k = input.nextInt();
                System.out.println(randomNumber(k));
                break;
            case 8:
                System.out.println("Enter a number:");
                n = input.nextInt();
                System.out.println("the reverse of the number is: " + reverse(n));
                break;
            case 9:
                n = input.nextInt();
                if (isPalindrome(n))
                    System.out.println("yes");
                else
                    System.out.println("no");

                break;
            case 10:
                String str = input.nextLine();
                System.out.println("enter a string: ");
                System.out.println(" " + charDigitSum(str));
                break;
            case 11:
                System.out.println("OK,goodbye");

        }

    }

    public static int digitZero(int n) {
        return n % 10;
    }

    public static int digitAt(int n, int i) {
        return (int) (n / Math.pow(10, i) % 10);
    }

    public static int digitSumLargerThan(int n, int limit) {
        int sumOfDigits = 0;
        while (n > 0) {
            int remainder = n % 10;
            n = n / 10;
            if (remainder > limit) {
                sumOfDigits += remainder;
            }
        }
        return sumOfDigits;
    }

    public static int digitCount(int n, int digit) {
        int count = 0;
        while (n > 0) {
            int remainder = n % 10;
            n = n / 10;
            if (remainder == digit) {
                count++;
            }
        }
        return count;
    }

    public static int digitRemoveAt(int n, int i) {
        int count = 0;
        int sum = 0;
        boolean isRemoved = false;
        int exponent;
        while (n != 0) {
            int digit = n % 10;
            n = (n) / 10;
            if (i == count) {
                isRemoved = true;
            } else {
                if (isRemoved) {
                    exponent = count - 1;
                    System.out.println(sum);
                } else {
                    exponent = count;
                }
                sum = sum + digit * (int) Math.pow(10, exponent);
            }
            count++;
        }
        return sum;
    }

    public static int digitRemoveAll(int n, int digit) {
        int count = 0;
        int sum = 0;
        boolean isRemoved = false;
        int exponent;
        int removedCount = 0;
        while (n != 0) {
            int mod = n % 10;
            n = (n) / 10;
            if (mod == digit) {
                isRemoved = true;
                removedCount++;
            } else {
                if (isRemoved) {
                    exponent = count - removedCount;
                } else {
                    exponent = count;
                }
                sum = sum + mod * (int) Math.pow(10, exponent);
            }
            count++;
        }
        return sum;
    }

    public static int randomNumber(int k) {
        int[] intArray = new int[k];
        int min = 0, max = 9;
        int index = 0;
        int randomNumber = 0;
        while (index < k) {
            int randomInt = (int) (Math.random() * ((max - min) + 1)) + min;
            while (isDigitExist(intArray, randomInt, index)) {
                randomInt = (int) (Math.random() * ((max - min) + 1)) + min;
            }
            intArray[index] = randomInt;
            randomNumber = randomNumber + (randomInt * (int) Math.pow(10, index));
            index++;
        }
        return randomNumber;
    }

    public static boolean isDigitExist(int[] array, int randomNumber, int k) {
        int index = 0;
        while (index < k) {
            if (array[index] == randomNumber) {
                return true;
            }
            index++;
        }
        return false;
    }

    public static int reverse(int n) {
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n = n / 10;
        }

        return reverse;
    }

    public static boolean isPalindrome(int n) {
        int palindromeNum = n;
        int reversed = 0;
        while (palindromeNum != 0) {
            int mod = palindromeNum % 10;
            reversed = reversed * 10 + mod;
            palindromeNum = palindromeNum / 10;
        }
        if(n == reversed){
            return true;
        }
        return false;
    }
    public static int charDigitSum (String str){
        int i = 0, sum = 0, j;
        while (i < str.length()) {

            j = str.charAt(i);
            i++;
            sum = sum + j;
            }
            return sum;
        }
    }
