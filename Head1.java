

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
public class Head1
{
private String _fileName = "";
private int _tailSize = 25; // default tailsize

Vector _theList = new Vector(5000,500);
public Head1( String fileName ) { _fileName = fileName; }
public Head1( String fileName, int tailSize )
{
_fileName = fileName; _tailSize = tailSize;
}
public StringBuffer run()
{
StringBuffer output = new StringBuffer("");
String thisLine;

try
{
FileReader fr = new FileReader( _fileName );
BufferedReader myInput = new BufferedReader( fr );

while( ( thisLine = myInput.readLine() ) != null )
{
_theList.add( thisLine );
}

} // end try
catch( IOException e )
{
output.append( "Error reading file: " + e );
}

_theList.trimToSize();

int end = _tailSize;
int start = _theList.size() - _theList.size();
if( start < 0 ) { start = 0; _tailSize = end; }
output.append( "========== Tail [" + _fileName + "]\n" );
output.append( "========== Showing first [" + _tailSize + "] lines\n" );

for( int i = start; i < end; i++ )
{
output.append( (String)_theList.get(i) + "\n" );
}
output.append( "========== END\n" );

return output;
}

public static void main( String args[] )
{
int argsLength = args.length;

if( argsLength == 0 ) System.exit(0);
if( argsLength == 1 )
{
Head1 head1 = new Head1( args[0] );
System.out.println( head1.run().toString() );
}
if( argsLength == 2 )
{
Head1 head1 = new Head1( args[0], new Integer( args[1] ).intValue() );
System.out.println( head1.run().toString() );
}
}
}
