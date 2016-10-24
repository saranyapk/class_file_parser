package classfileparser;

import java.io.*;

public class ClassFileParser
{

    public static DataInputStream dis = null;
    public static final String TAG_SEPARATOR = "#";

    private static ConstantPoolLookUp constantPoolLookUp = new ConstantPoolLookUp();
    private static AttributeReader attributeReader = new AttributeReader();
    private static ConstantPoolReader constantPoolReader = new ConstantPoolReader();

    private static String filePath = "";

    public static void main( String[] args ) throws Exception
    {
        try
        {
           
            filePath = args[0];
            
            if( !validateFile() )
            {
        	return;
            }
            
            dis = new DataInputStream( new FileInputStream( new File( filePath ) ) );

            attributeReader.setDis( dis );
            attributeReader.setConstantPoolLookUp( constantPoolLookUp );

            constantPoolReader.setDis( dis );
            constantPoolReader.setConstantPoolLookUp( constantPoolLookUp );

            System.out.println( "Magic Number:" + Integer.toHexString( ByteReader.read_u4( dis ) ) );

            System.out.println( "Minor Version:" + ByteReader.read_u2( dis ) );

            System.out.println( "Major Version:" + ByteReader.read_u2( dis ) );

            constantPoolReader.readConstantPool();

            System.out.println( "Class Access Info:" + readAccessFlag() );

            readThisClass();

            readSuperClass();

            readInterfaces();

            readFields();

            readMethods();

            attributeReader.readAttributes();

        }
        catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }

    }
    
    private static boolean validateFile()
    {
	if(!filePath.toUpperCase().endsWith(".CLASS"))
	{
	    System.out.println("Please input a .class file to this parser.");
	    
	    return false;
	}
	
	return true;
    }

    @SuppressWarnings("unused")
    private static void readCompleteClass() throws IOException
    {
        FileInputStream fis = new FileInputStream( new File( filePath ) );

        byte[] b = new byte[10];

        while ( fis.read( b ) != -1 )
        {
            for ( byte bt : b )
            {
                System.out.print( (char)bt );
            }
        }

        fis.close();
    }

    private static void readFields() throws Exception
    {
        int fieldCount = ByteReader.read_u2( dis );
        System.out.println( "Fields:" );
        for ( int i = 0; i < fieldCount; i++ )
        {
            System.out.println( readAccessFlag() + " " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) + " " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            attributeReader.readAttributes();
            System.out.println( "\n" );
        }

    }

    private static void readMethods() throws Exception
    {
        int methodCount = ByteReader.read_u2( dis );
        System.out.println( "Methods:" );
        for ( int i = 0; i < methodCount; i++ )
        {
            System.out.println( readAccessFlag() + " " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) + " " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            attributeReader.readAttributes();
            System.out.println( "\n" );
        }

    }

    private static void readInterfaces() throws Exception
    {
        int interfacesCount = ByteReader.read_u2( dis );
        StringBuilder interfaces = new StringBuilder( "" );
        for ( int i = 0; i < interfacesCount; i++ )
        {
        	interfaces.append(" " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
        }
        System.out.println( "Interfaces Name:" + interfaces.toString() );
    }

    private static void readSuperClass() throws Exception
    {
        int superClass = ByteReader.read_u2( dis );

        System.out.println( "Super Name: " + constantPoolLookUp.lookUp( superClass ) );
    }

    private static void readThisClass() throws Exception
    {
        int thisClass = ByteReader.read_u2( dis );

        System.out.println( "Class Name: " + constantPoolLookUp.lookUp( thisClass ) );
    }

    public static String readAccessFlag() throws IOException
    {
        int accessFlag = ByteReader.read_u2( dis );

        String accessInfo = "";

        if ( ( accessFlag & AccessFlag.ACC_PUBLIC ) != 0 )
        {
            accessInfo += " public ";
        }
        if ( ( accessFlag & AccessFlag.ACC_ABSTRACT ) != 0 )
        {
            accessInfo += " abstract ";
        }
        if ( ( accessFlag & AccessFlag.ACC_FINAL ) != 0 )
        {
            accessInfo += " final ";
        }
        if ( ( accessFlag & AccessFlag.ACC_INTERFACE ) != 0 )
        {
            accessInfo += " interface ";
        }
        if ( ( accessFlag & AccessFlag.ACC_SUPER ) != 0 )
        {
            accessInfo += " Invoke Special ";
        }
        if ( ( accessFlag & AccessFlag.ACC_PRIVATE ) != 0 )
        {
            accessInfo += " private ";
        }
        if ( ( accessFlag & AccessFlag.ACC_PROTECTED ) != 0 )
        {
            accessInfo += " protected ";
        }
        if ( ( accessFlag & AccessFlag.ACC_VOLATILE ) != 0 )
        {
            accessInfo += " volatile ";
        }
        if ( ( accessFlag & AccessFlag.ACC_TRANSIENT ) != 0 )
        {
            accessInfo += " transient ";
        }

        return accessInfo;
    }

}
