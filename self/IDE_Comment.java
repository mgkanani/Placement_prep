import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IDE_Comment {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        StringBuilder br = new StringBuilder(200*50);
        String line;
        String[] s1,s2;
        int i1,i2;
        while(sc.hasNext()){
            line = sc.nextLine();
            i1 = line.indexOf("//");
            i2 = line.indexOf("/*");
            if(i1>=0){
                br.append(line.substring(i1).trim()+"\n");
            }else if(i2>=0){
                if(line.indexOf("*/")>=0){
                    br.append(line.substring(i2,line.indexOf("*/")+2).trim()+"\n");
                }else{
                    br.append(line.substring(i2).trim()+"\n");
                    while(sc.hasNext()){
                        line = sc.nextLine().trim();
                        i2 = line.indexOf("*/");
                        if(i2>=0){
                            String t1 = line.substring(0,i2+2).trim();
                            br.append(t1);
                            line = line.substring(i2+2);
                            i1 = line.indexOf("//");
                            if(i1>=0){
                                br.append(line.substring(i1).trim());
                            }
                            br.append("\n");
                            break;
                        }else{
                            br.append(line+"\n");
                        }
                    }
                }
            }
        }
        System.out.print(br);
    }
}

/*

Building a Smart IDE: Identifying comments

Problem Statement

Jack wants to build an IDE on his own. Help him build a feature which identifies the comments, in the source code of computer programs. Assume, that the programs are written either in C, C++ or Java. The commenting conventions are displayed here, for your convenience. At this point of time you only need to handle simple and common kinds of comments. You don't need to handle nested comments, or multi-line comments inside single comments or single-comments inside multi-line comments.

Your task is to write a program, which accepts as input, a C or C++ or Java program and outputs only the comments from those programs. Your program will be tested on source codes of not more than 200 lines.

Comments in C, C++ and Java programs

Single Line Comments:

// this is a single line comment
x = 1; // a single line comment after code

Please note that in the real world, some C compilers do not necessarily support the above kind of comment(s) but for the purpose of this problem let's just assume that the compiler which will be used here will accept these kind of comments.

Precautions
Do not add any leading or trailing spaces. Remove any leading white space before comments, including from all lines of a multi-line comment. Do not alter the line structure of multi-line comments except to remove leading whitespace. i.e. Do not collapse them into one line.
*/