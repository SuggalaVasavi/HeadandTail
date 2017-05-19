
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tail{
public static StringBuffer tail(int tailSize,String fileName){
String thisLine;
StringBuffer output = new StringBuffer("");
ArrayList List = new ArrayList();
try{
FileReader filereader = new FileReader( fileName );
BufferedReader br = new BufferedReader( filereader );
while( ( thisLine = br.readLine() ) != null )
{
List.add( thisLine );
}
br.close();
} // end try
catch( IOException e )
{
output.append( "Error reading file: " + e );
}
int end= List.size();
int start = List.size() - tailSize;
if(start<0)
{
start =0;
tailSize= end;
}

for(int i=start; i <end; i++)
{
output.append( List.get(i) + "\n" );
}
return output;
}
public static void main(String args[]){
int argsLength = args.length;

if( argsLength == 0 ) System.out.println("exit");
if( argsLength == 1 ) System.out.println("wrong entry(ex:number filename)");;
if( argsLength == 2 )
{
System.out.println(Tail.tail(Integer.parseInt( args[0] ),args[1] ) );
}
}
}
