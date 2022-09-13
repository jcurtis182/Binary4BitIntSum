//Joseph Curtis
//CSC-1350, Kundu

import java.util.*;

public class Binary4BitIntExt 
{ int b3, b2, b1, b0;
  public Binary4BitIntExt(int b3, int b2, int b1, int b0)
  { this.b3 = b3;
    this.b2 = b2;
    this.b1 = b1;
    this.b0 = b0;
  }
  public String toString()
  { return (b3 + " " + b2 + " " + b1 + " " + b0);
  }
  public int binaryToDecimal()
  { return (-8 * b3 + 4 * b2 + 2 * b1 + b0);
  }
  public Binary4BitIntExt add(int b3, int b2, int b1, int b0)
  { int carry;
    b0 += this.b0;
    carry = b0 / 2;
    b0 %= 2;
    b1 += carry + this.b1;
    carry = b1 / 2;
    b1 %= 2;
    b2 += carry + this.b2;
    carry = b2 / 2;
    b2 %= 2;
    b3 += carry + this.b3;
    b3 %= 2;
    return (new Binary4BitIntExt(b3, b2, b1, b0));
  }  
  public static Binary4BitIntExt decimalToBinary(int decimalInt)
  { int b3, b2, b1, b0;
    if (decimalInt < 0)
    { b3 = 1;
      decimalInt += 16;
    } 
    else b3 = 0;
    b0 = decimalInt % 2;
    decimalInt /= 2;
    b1 = decimalInt % 2;
    decimalInt /= 2;
    b2 = decimalInt % 2;
    return (new Binary4BitIntExt(b3, b2, b1, b0));
  }
  public static void main(String[] args) 
  { Binary4BitIntExt first, second, sum;
    Scanner scan = new Scanner(System.in);
    for (int i = 1; i <= 5; i++)
    { System.out.print("\nEnter 1st 4-bit integer (>= -8 and <= 7): ");
      first = decimalToBinary(scan.nextInt());
      System.out.println("1st 4-bit integer: " + first.toString() + " = " + 
                         first.binaryToDecimal() + " (in decimal)");
      System.out.print("\nEnter 2nd 4-bit integer (>= -8 and <= 7): ");
      second = decimalToBinary(scan.nextInt());
      System.out.println("2nd 4-bit integer: " + second + " = " + 
                         second.binaryToDecimal() + " (in decimal)");
      sum = first.add(second.b3, second.b2, second.b1, second.b0);
      System.out.println("Sum: " + sum.toString() + " = " + 
                         sum.binaryToDecimal() + " (in decimal)");
    }
  }
}

/* Program Output
Enter 1st 4-bit integer (>= -8 and <= 7): 5
1st 4-bit integer: 0 1 0 1 = 5 (in decimal)

Enter 2nd 4-bit integer (>= -8 and <= 7): 7
2nd 4-bit integer: 0 1 1 1 = 7 (in decimal)
Sum: 1 1 0 0 = -4 (in decimal)

Enter 1st 4-bit integer (>= -8 and <= 7): 5
1st 4-bit integer: 0 1 0 1 = 5 (in decimal)

Enter 2nd 4-bit integer (>= -8 and <= 7): 5
2nd 4-bit integer: 0 1 0 1 = 5 (in decimal)
Sum: 1 0 1 0 = -6 (in decimal)

Enter 1st 4-bit integer (>= -8 and <= 7): 7
1st 4-bit integer: 0 1 1 1 = 7 (in decimal)

Enter 2nd 4-bit integer (>= -8 and <= 7): 7
2nd 4-bit integer: 0 1 1 1 = 7 (in decimal)
Sum: 1 1 1 0 = -2 (in decimal)

Enter 1st 4-bit integer (>= -8 and <= 7): 7
1st 4-bit integer: 0 1 1 1 = 7 (in decimal)

Enter 2nd 4-bit integer (>= -8 and <= 7): 5
2nd 4-bit integer: 0 1 0 1 = 5 (in decimal)
Sum: 1 1 0 0 = -4 (in decimal)

Enter 1st 4-bit integer (>= -8 and <= 7): 5
1st 4-bit integer: 0 1 0 1 = 5 (in decimal)

Enter 2nd 4-bit integer (>= -8 and <= 7): 1
2nd 4-bit integer: 0 0 0 1 = 1 (in decimal)
Sum: 0 1 1 0 = 6 (in decimal)
BUILD SUCCESSFUL (total time: 33 seconds)
*/