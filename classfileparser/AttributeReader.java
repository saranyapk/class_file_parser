package classfileparser;

import java.io.DataInputStream;
import java.io.IOException;

import com.sun.org.apache.bcel.internal.classfile.ConstantLong;

public class AttributeReader
{
    private DataInputStream dis = null;
    private ConstantPoolLookUp constantPoolLookUp = null;

    public void setDis( DataInputStream dis )
    {
        this.dis = dis;
    }

    public void setConstantPoolLookUp( ConstantPoolLookUp constantPoolLookUp )
    {
        this.constantPoolLookUp = constantPoolLookUp;
    }

    public void readAttributes( String info ) throws Exception
    {
        int attributeCount = ByteReader.read_u2( dis );
        for ( int i = 0; i < attributeCount; i++ )
        {
            String attributeName = constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) );
            int length = ByteReader.read_u4( dis );
            String attrInfo = info + "Attribute: " + ( i + 1 ) + "$$";
            System.out.println( attrInfo + " Name:" + attributeName + " Length:" + length );
            read( attrInfo, attributeName );
        }
    }

    public void read( String info, String attributeName ) throws Exception
    {
        if ( Attributes.CODE.equalsIgnoreCase( attributeName ) )
        {
            readCodeAttribute( info );
        }
        else if ( Attributes.CONSTANT_VALUE.equalsIgnoreCase( attributeName ) )
        {
            readConstantValueAttribute( info );
        }
        else if ( Attributes.EXCEPTIONS.equalsIgnoreCase( attributeName ) )
        {
            readExceptionsAttribute( info );
        }
        else if ( Attributes.INNER_CLASS.equalsIgnoreCase( attributeName ) )
        {
            readInnerClassAttribute( info );
        }
        else if ( Attributes.LINE_NUMBER_TABLE.equalsIgnoreCase( attributeName ) )
        {
            readLineNumberTableAttribute( info );
        }
        else if ( Attributes.LOCAL_VARIABLE_TABLE.equalsIgnoreCase( attributeName ) )
        {
            readLocalVariableTableAttribute( info );
        }
        else if ( Attributes.SOURCE_FILE.equalsIgnoreCase( attributeName ) )
        {
            readSourceFileAttribute( info );
        }
        else if ( Attributes.SYNTHETIC.equalsIgnoreCase( attributeName ) )
        {
            readSyntheticAttribute( info );
        }
        else if ( Attributes.SIGNATURE.equalsIgnoreCase( attributeName ) )
        {
            readSignatureAttribute( info );
        }
        else if ( Attributes.STACKMAPTABLE.equalsIgnoreCase( attributeName ) )
        {
            readStackMapTableAttribute( info );
        }
        else
        {
            throw new Exception( "Attribute Impl NOT found:" + attributeName );
        }

    }

    private void readStackMapTableAttribute( String info ) throws Exception
    {
        int numberOfEntries = ByteReader.read_u2( dis );
        for ( int i = 0; i < numberOfEntries; i++ )
        {
            
        }
    }

    private void readSignatureAttribute( String info ) throws IOException, Exception
    {
        System.out.println( info + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );

    }

    private void readSyntheticAttribute( String info )
    {
        //Do nothing because the attritube name will be "synthetic"

    }

    private void readSourceFileAttribute( String info ) throws Exception
    {
        System.out.println( "Source File:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );

    }

    private void readLocalVariableTableAttribute( String info ) throws Exception
    {
        int localVariableTableLength = ByteReader.read_u2( dis );
        for ( int i = 0; i < localVariableTableLength; i++ )
        {
            System.out.println( info + " LocalVariableTableInfo$$ " + "Start PC:" + ByteReader.read_u2( dis ) + " Length:" + ByteReader.read_u2( dis ) + " Name:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) + " Description:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) + " Index:" + ByteReader.read_u2( dis ) );
        }
    }

    private void readLineNumberTableAttribute( String info ) throws IOException
    {
        int lineNumberTableLength = ByteReader.read_u2( dis );
        for ( int i = 0; i < lineNumberTableLength; i++ )
        {
            System.out.println( info + " LineNumberTableInfo$$ " + "Start PC:" + ByteReader.read_u2( dis ) + " Line Number:" + ByteReader.read_u2( dis ) );
        }

    }

    private void readInnerClassAttribute( String info ) throws Exception
    {
        throw new Exception( "Unimplemented Method" );

    }

    private void readExceptionsAttribute( String info ) throws Exception
    {
        int noOfExceptions = ByteReader.read_u2( dis );
        for ( int i = 0; i < noOfExceptions; i++ )
        {
            System.out.println( info + "Exception $$" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
        }

    }

    private void readConstantValueAttribute( String info ) throws IOException, Exception
    {
        System.out.println( "Constant Value:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
    }

    private void readCodeAttribute( String info ) throws Exception
    {
        System.out.println( info + "Max Stack:" + ByteReader.read_u2( dis ) );
        System.out.println( info + "Max Locals:" + ByteReader.read_u2( dis ) );
        int codeLength = ByteReader.read_u4( dis );
        String bytecode = " ";
        for ( int i = 0; i < codeLength; i++ )
        {
            bytecode += Integer.toHexString( ByteReader.read_u1( dis ) );
        }
        System.out.println( info + "Method Byte Code:" + bytecode );
        readException( info );
        readAttributes( info );
    }

    private void readException( String info ) throws Exception
    {
        int exceptionTableLength = ByteReader.read_u2( dis );
        for ( int i = 0; i < exceptionTableLength; i++ )
        {
            System.out.println( info + "Exception$$ Start_PC:" + ByteReader.read_u2( dis ) + " End_PC:" + ByteReader.read_u2( dis ) + " Handler_PC:" + ByteReader.read_u2( dis ) + " Catch_Type:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
        }
    }

}
