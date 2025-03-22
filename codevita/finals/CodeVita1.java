import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class CodeVita1 {

public static void main(String[] args) throws IOException {
System.setIn(new FileInputStream("codeVita1.txt"));
Scanner scanner = new Scanner(System.in);
int n = scanner.nextInt();
String[] subStrings = new String[n];
for(int i=0;i<n;i++) {
   subStrings[i] = scanner.next();
}

String mainString = scanner.next();

System.out.println(findMaxNo(mainString,subStrings,0));


}


static int findMaxNo(String mainString,String[] subStrings,int count){
int maxCount = count;
int size = subStrings.length;
String newString = mainString;
for(int i=0;i<size;i++) {
  int index = mainString.indexOf(subStrings[i]);
  if(index != -1) {
   newString = mainString.substring(0,index) + mainString.substring(index+subStrings[i].length());
   maxCount = Math.max(maxCount,findMaxNo(newString, subStrings, count+1));

  }
}
return maxCount;

    
}
 
}


