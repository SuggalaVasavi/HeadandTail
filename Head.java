import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Head
{
public static StringBuffer head(int headSize,String fileName)
{
StringBuffer output = new StringBuffer("");
String thisLine;
ArrayList theList = new ArrayList();
try
{
FileReader filereader = new FileReader( fileName );
BufferedReader myInput = new BufferedReader( filereader );

while( ( thisLine = myInput.readLine() ) != null )
{
theList.add( thisLine );
}

} // end try
catch( IOException e )
{
output.append( "Error reading file: " + e );
}

theList.trimToSize();

int end = headSize;

output.append( "========== Head [" + fileName + "]\n" );
output.append( "========== Showing first [" + headSize + "] lines\n" );

for( int i = 0; i < end; i++ )
{
output.append( (String)theList.get(i) + "\n" );
}
output.append( "========== END\n" );

return output;
}

public static void main( String args[] )
{
int argsLength = args.length;

if( argsLength == 0 ) System.out.println("exit");
if( argsLength == 1 )
{
	System.out.println("please enter n for number of lines to execute and file name");

}
if( argsLength == 2 )
{
	System.out.println(Head.head(new Integer( args[0] ).intValue(),args[1] ) );

}
}
}
