package classfileparser;

import java.io.DataInputStream;
import java.io.IOException;

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
            String attrInfo = info + "Attribute:" + ( i + 1 ) + "$$";
            System.out.println( attrInfo + " Name:" + attributeName + " Length:" + length );
            read( attrInfo, attributeName, length );
        }
    }

    public void read( String info, String attributeName, long length ) throws Exception
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
            int frame_type = ByteReader.read_u1( dis );
            if ( frame_type >= 0 && frame_type <= 63 )
            {
                System.out.println( info + " Stack Frame Type:" + "SAME" );
            }
            else if ( frame_type >= 64 && frame_type <= 127 )
            {
                System.out.println( info + " Stack Frame Type: " + "SAME_LOCALS_1_STACK_ITEM" );
                readVerificationInfoType( info + "SAME_LOCALS_1_STACK_ITEM$$ " );
            }
            else if ( frame_type == 247 )
            {
                System.out.println( info + " Stack Frame Type: " + "SAME_LOCALS_1_STACK_ITEM_EXTENDED" );
                System.out.println( info + " Offset Delta: " + ByteReader.read_u2( dis ) );
                readVerificationInfoType( info + "SAME_LOCALS_1_STACK_ITEM_EXTENDED$$ " );
            }
            else if ( frame_type >= 248 && frame_type <= 250 )
            {
                System.out.println( info + " Stack Frame Type: " + "CHOP" );
                System.out.println( info + " Offset Delta: " + ByteReader.read_u2( dis ) );
            }
            else if ( frame_type == 251 )
            {
                System.out.println( info + " Stack Frame Type: " + "SAME_FRAME_EXTENDED" );
                System.out.println( info + " Offset Delta: " + ByteReader.read_u2( dis ) );
            }
            else if ( frame_type >= 252 && frame_type <= 254 )
            {
                System.out.println( info + " Stack Frame Type: " + "APPEND" );
                System.out.println( info + " Offset Delta: " + ByteReader.read_u2( dis ) );
                for ( int j = 0; j < ( frame_type - 251 ); j++ )
                {
                    readVerificationInfoType( info + "APPEND$$ " );
                }
            }
            else if ( frame_type == 255 )
            {
                System.out.println( info + " Stack Frame Type: " + "FULL_FRAME" );
                System.out.println( info + " Offset Delta: " + ByteReader.read_u2( dis ) );
                int numberOfLocals = ByteReader.read_u2( dis );
                for ( int k = 0; k < numberOfLocals; k++ )
                {
                    readVerificationInfoType( info + "FULL_FRAME Locals$$ " );
                }
                int numberOfStackItems = ByteReader.read_u2( dis );
                for ( int l = 0; l < numberOfStackItems; l++ )
                {
                    readVerificationInfoType( info + "FULL_FRAME Stack$$ " );
                }
            }

        }
    }

    private void readVerificationInfoType( String info ) throws Exception
    {
        int verification_type_info = ByteReader.read_u1( dis );
        switch ( verification_type_info )
        {
            case 0:
                System.out.println( info + " Verification Type Info: " + " ITEM_Top" );
                break;
            case 1:
                System.out.println( info + " Verification Type Info: " + " ITEM_Integer" );
                break;
            case 2:
                System.out.println( info + " Verification Type Info: " + "ITEM_Float" );
                break;
            case 3:
                System.out.println( info + " Verification Type Info: " + " ITEM_Double" );
                break;
            case 4:
                System.out.println( info + " Verification Type Info: " + " ITEM_Long" );
                break;
            case 5:
                System.out.println( info + " Verification Type Info: " + " ITEM_Null" );
                break;
            case 6:
                System.out.println( info + " Verification Type Info: " + " ITEM_UninitializedThis" );
                break;
            case 7:
                System.out.println( info + " Verification Type Info: " + " ITEM_Object:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
                break;
            case 8:
                System.out.println( info + " Verification Type Info: " + " ITEM_Uninitialized" );
                break;
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
            int catchType = ByteReader.read_u2( dis );
            System.out.println( info + "Exception$$ Start_PC:" + ByteReader.read_u2( dis ) + " End_PC:" + ByteReader.read_u2( dis ) + " Handler_PC:" + ByteReader.read_u2( dis ) + " Catch_Type:" + ( ( catchType > 0 ) ? constantPoolLookUp.lookUp( catchType ) : "" ) );
        }
    }

}
