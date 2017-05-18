

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Head
{
private String fileeName = "";
private int taillSize = 25; // default tailsize

ArrayList theList = new ArrayList();
public Head( String fileName ) { fileeName = fileName; }
public Head( String fileName, int tailSize )
{
fileeName = fileName; taillSize = tailSize;
}
public StringBuffer run()
{
StringBuffer output = new StringBuffer("");
String thisLine;

try
{
FileReader fr = new FileReader( fileeName );
BufferedReader myInput = new BufferedReader( fr );

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

int end = taillSize;
output.append( "========== Tail [" + fileeName + "]\n" );
output.append( "========== Showing first [" + taillSize + "] lines\n" );

for( int i = start; i < end; i++ )
{
output.append( (String)theList.get(i) + "\n" );
}
output.append( "========== END\n" );

return output;
}

public static void main( String args[] )
{
int argsLength = args.length;

if( argsLength == 0 ) System.out.println("empty");
if( argsLength == 1 )
{
Head head = new Head( args[0] );
System.out.println( head.run().toString() );
}
if( argsLength == 2 )
{
Head head = new Head( args[0], new Integer( args[1] ).intValue() );
System.out.println( head.run().toString() );
}
}
}
