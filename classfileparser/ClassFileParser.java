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
            //readCompleteClass();

            filePath = args[0];

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

            attributeReader.readAttributes( "Class$$" );

        }
        catch ( FileNotFoundException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch ( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
        String fieldInfo = "";
        for ( int i = 0; i < fieldCount; i++ )
        {
            fieldInfo = "Field:" + ( i + 1 ) + "$$ ";
            System.out.println( fieldInfo + "Access Modifier:" + readAccessFlag() );
            System.out.println( fieldInfo + "Name:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            System.out.println( fieldInfo + "Description:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            attributeReader.readAttributes( fieldInfo );
        }

    }

    private static void readMethods() throws Exception
    {
        int methodCount = ByteReader.read_u2( dis );
        System.out.println( "Methods:" );
        String methodInfo = "";
        for ( int i = 0; i < methodCount; i++ )
        {
            methodInfo = "Method:" + ( i + 1 ) + "$$ ";
            System.out.println( methodInfo + "Access Modifier:" + readAccessFlag() );
            System.out.println( methodInfo + "Name:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            System.out.println( methodInfo + "Description:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );

            attributeReader.readAttributes( methodInfo );

        }

    }

    private static void readInterfaces() throws Exception
    {
        int interfacesCount = ByteReader.read_u2( dis );
        String interfaces = "";
        for ( int i = 0; i < interfacesCount; i++ )
        {
            interfaces += " " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) );
        }
        System.out.println( "Interfaces Name:" + interfaces );
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

    private static String readAccessFlag() throws IOException
    {
        int accessFlag = ByteReader.read_u2( dis );

        String accessInfo = "";

        if ( ( accessFlag & AccessFlag.ACC_PUBLIC ) != 0 )
        {
            accessInfo += " Public ";
        }
        if ( ( accessFlag & AccessFlag.ACC_ABSTRACT ) != 0 )
        {
            accessInfo += " Abstract ";
        }
        if ( ( accessFlag & AccessFlag.ACC_FINAL ) != 0 )
        {
            accessInfo += " Final ";
        }
        if ( ( accessFlag & AccessFlag.ACC_INTERFACE ) != 0 )
        {
            accessInfo += " Interface ";
        }
        if ( ( accessFlag & AccessFlag.ACC_SUPER ) != 0 )
        {
            accessInfo += " Invoke Special ";
        }
        if ( ( accessFlag & AccessFlag.ACC_PRIVATE ) != 0 )
        {
            accessInfo += " Private ";
        }
        if ( ( accessFlag & AccessFlag.ACC_PROTECTED ) != 0 )
        {
            accessInfo += " Protected ";
        }
        if ( ( accessFlag & AccessFlag.ACC_VOLATILE ) != 0 )
        {
            accessInfo += " Volatile ";
        }
        if ( ( accessFlag & AccessFlag.ACC_TRANSIENT ) != 0 )
        {
            accessInfo += " Transient ";
        }

        return accessInfo;
    }

}
