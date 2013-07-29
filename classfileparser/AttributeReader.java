package classfileparser;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Formatter;

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

    public void readAttributes() throws Exception
    {
        int attributeCount = ByteReader.read_u2( dis );
        for ( int i = 0; i < attributeCount; i++ )
        {
            String attributeName = constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) );
            int length = ByteReader.read_u4( dis );
            System.out.println( "\t" + attributeName + " " + length );
            read( attributeName, length );
        }
    }

    public void read( String attributeName, long length ) throws Exception
    {
        if ( Attributes.CODE.equalsIgnoreCase( attributeName ) )
        {
            readCodeAttribute();
        }
        else if ( Attributes.CONSTANT_VALUE.equalsIgnoreCase( attributeName ) )
        {
            readConstantValueAttribute();
        }
        else if ( Attributes.EXCEPTIONS.equalsIgnoreCase( attributeName ) )
        {
            readExceptionsAttribute();
        }
        else if ( Attributes.INNER_CLASS.equalsIgnoreCase( attributeName ) )
        {
            readInnerClassAttribute();
        }
        else if ( Attributes.LINE_NUMBER_TABLE.equalsIgnoreCase( attributeName ) )
        {
            readLineNumberTableAttribute();
        }
        else if ( Attributes.LOCAL_VARIABLE_TABLE.equalsIgnoreCase( attributeName ) )
        {
            readLocalVariableTableAttribute();
        }
        else if ( Attributes.LOCAL_VARIABLE_TYPE_TABLE.equalsIgnoreCase( attributeName ) )
        {
            readLocalVariableTypeTableAttribute();
        }
        else if ( Attributes.SOURCE_FILE.equalsIgnoreCase( attributeName ) )
        {
            readSourceFileAttribute();
        }
        else if ( Attributes.SYNTHETIC.equalsIgnoreCase( attributeName ) )
        {
            readSyntheticAttribute();
        }
        else if ( Attributes.SIGNATURE.equalsIgnoreCase( attributeName ) )
        {
            readSignatureAttribute();
        }
        else if ( Attributes.STACKMAPTABLE.equalsIgnoreCase( attributeName ) )
        {
            readStackMapTableAttribute();
        }
        else
        {
            throw new Exception( "Attribute Impl NOT found:" + attributeName );
        }

    }

    private void readLocalVariableTypeTableAttribute() throws Exception
    {
        int localVariableTypeTableLength = ByteReader.read_u2( dis );
        if ( localVariableTypeTableLength > 0 )
        {
            Formatter formatter = new Formatter();
            System.out.println( "\t\t" + formatter.format( "%-10s %-10s %-30s %-50s %-10s", "Start_PC", "Length", "Name", "Signature", "Index" ) );

        }
        for ( int i = 0; i < localVariableTypeTableLength; i++ )
        {
            Formatter formatter = new Formatter();
            System.out.println( "\t\t" + formatter.format( "%-10s %-10s %-30s %-50s %-10s", ByteReader.read_u2( dis ), ByteReader.read_u2( dis ), constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ), constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ), ByteReader.read_u2( dis ) ) );
        }

    }

    private void readStackMapTableAttribute() throws Exception
    {
        int numberOfEntries = ByteReader.read_u2( dis );
        for ( int i = 0; i < numberOfEntries; i++ )
        {
            int frame_type = ByteReader.read_u1( dis );
            if ( frame_type >= 0 && frame_type <= 63 )
            {
                System.out.println( "\t\tFrame Type:" + "SAME" );
            }
            else if ( frame_type >= 64 && frame_type <= 127 )
            {
                System.out.println( "\t\tFrame Type:" + "SAME_LOCALS_1_STACK_ITEM" );
                readVerificationInfoType();
            }
            else if ( frame_type == 247 )
            {
                System.out.println( "\t\tFrame Type:" + "SAME_LOCALS_1_STACK_ITEM_EXTENDED" );
                System.out.println( "\t\tOffset Delta: " + ByteReader.read_u2( dis ) );
                readVerificationInfoType();
            }
            else if ( frame_type >= 248 && frame_type <= 250 )
            {
                System.out.println( "\t\tFrame Type:" + "CHOP" );
                System.out.println( "\t\tOffset Delta: " + ByteReader.read_u2( dis ) );
            }
            else if ( frame_type == 251 )
            {
                System.out.println( "\t\tFrame Type:" + "SAME_FRAME_EXTENDED" );
                System.out.println( "\t\tOffset Delta: " + ByteReader.read_u2( dis ) );
            }
            else if ( frame_type >= 252 && frame_type <= 254 )
            {
                System.out.println( "\t\tFrame Type:" + "APPEND" );
                System.out.println( "\t\tOffset Delta: " + ByteReader.read_u2( dis ) );
                for ( int j = 0; j < ( frame_type - 251 ); j++ )
                {
                    readVerificationInfoType();
                }
            }
            else if ( frame_type == 255 )
            {
                System.out.println( "\t\tFrame Type:" + "FULL_FRAME" );
                System.out.println( "\t\tOffset Delta: " + ByteReader.read_u2( dis ) );
                int numberOfLocals = ByteReader.read_u2( dis );
                System.out.println( "\t\tlocals[" );
                for ( int k = 0; k < numberOfLocals; k++ )
                {
                    readVerificationInfoType();
                }
                System.out.println( "\t\t]" );
                System.out.println( "\t\tstacks[" );
                int numberOfStackItems = ByteReader.read_u2( dis );
                for ( int l = 0; l < numberOfStackItems; l++ )
                {
                    readVerificationInfoType();
                }
                System.out.println( "\t\t]" );
            }

        }
    }

    private void readVerificationInfoType() throws Exception
    {
        int verification_type_info = ByteReader.read_u1( dis );
        switch ( verification_type_info )
        {
            case 0:
                System.out.println( "\t\tVerification_Type_Info:" + " ITEM_Top" );
                break;
            case 1:
                System.out.println( "\t\tVerification_Type_Info:" + " ITEM_Integer" );
                break;
            case 2:
                System.out.println( "\t\tVerification_Type_Info:" + "ITEM_Float" );
                break;
            case 3:
                System.out.println( "\t\tVerification_Type_Info:" + " ITEM_Double" );
                break;
            case 4:
                System.out.println( "\t\tVerification_Type_Info:" + " ITEM_Long" );
                break;
            case 5:
                System.out.println( "\t\tVerification_Type_Info:" + " ITEM_Null" );
                break;
            case 6:
                System.out.println( "\t\tVerification_Type_Info:" + " ITEM_UninitializedThis" );
                break;
            case 7:
                System.out.println( "\t\tVerification_Type_Info:" + " ITEM_Object:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
                break;
            case 8:
                System.out.println( "\t\tVerification_Type_Info:" + " ITEM_Uninitialized" );
                break;
        }
    }

    private void readSignatureAttribute() throws IOException, Exception
    {
        System.out.println( "\t" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );

    }

    private void readSyntheticAttribute()
    {
        //Do nothing because the attritube name will be "synthetic"

    }

    private void readSourceFileAttribute() throws Exception
    {
        System.out.println( "Source File:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );

    }

    private void readLocalVariableTableAttribute() throws Exception
    {
        int localVariableTableLength = ByteReader.read_u2( dis );
        if ( localVariableTableLength > 0 )
        {
            Formatter formatter = new Formatter();
            System.out.println( "\t\t" + formatter.format( "%-10s %-10s %-30s %-50s %-10s", "Start_PC", "Length", "Name", "Description", "Index" ) );

        }
        for ( int i = 0; i < localVariableTableLength; i++ )
        {
            Formatter formatter = new Formatter();
            System.out.println( "\t\t" + formatter.format( "%-10s %-10s %-30s %-50s %-10s", ByteReader.read_u2( dis ), ByteReader.read_u2( dis ), constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ), constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ), ByteReader.read_u2( dis ) ) );
        }
    }

    private void readLineNumberTableAttribute() throws IOException
    {
        int lineNumberTableLength = ByteReader.read_u2( dis );
        if ( lineNumberTableLength > 0 )
        {
            Formatter formatter = new Formatter();
            System.out.println( "\t\t" + formatter.format( "%-10s %-10s", "Start_PC", "LineNumber" ) );

        }
        for ( int i = 0; i < lineNumberTableLength; i++ )
        {
            Formatter formatter = new Formatter();
            System.out.println( "\t\t" + formatter.format( "%-10s %-10s", ByteReader.read_u2( dis ), ByteReader.read_u2( dis ) ) );
        }

    }

    private void readInnerClassAttribute() throws Exception
    {
        throw new Exception( "Unimplemented Method" );

    }

    private void readExceptionsAttribute() throws Exception
    {
        int noOfExceptions = ByteReader.read_u2( dis );
        System.out.println( "\t\tExceptions" );
        for ( int i = 0; i < noOfExceptions; i++ )
        {
            System.out.println( "\t\t" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
        }

    }

    private void readConstantValueAttribute() throws IOException, Exception
    {
        System.out.println( "Constant Value:" + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
    }

    private void readCodeAttribute() throws Exception
    {
        System.out.println( "\t\tMax Stack:" + ByteReader.read_u2( dis ) );
        System.out.println( "\t\tMax Locals:" + ByteReader.read_u2( dis ) );
        int codeLength = ByteReader.read_u4( dis );
        String bytecode = " ";
        for ( int i = 0; i < codeLength; i++ )
        {
            bytecode += Integer.toHexString( ByteReader.read_u1( dis ) );
        }
        System.out.println( "\t\tMethod Byte Code:" + bytecode );
        readException();
        readAttributes();
    }

    private void readException() throws Exception
    {
        int exceptionTableLength = ByteReader.read_u2( dis );
        System.out.println( "\t\tException:" );
        if ( exceptionTableLength > 0 )
        {
            Formatter formatter = new Formatter();
            System.out.println( "\t\t" + formatter.format( "%-10s %-10s %-10s %-10s", "Start_PC", "End_PC", "Handler_PC", "Catch_Type" ) );

        }
        for ( int i = 0; i < exceptionTableLength; i++ )
        {
            int catchType = ByteReader.read_u2( dis );
            Formatter formatter = new Formatter();
            System.out.println( "\t\t" + formatter.format( "%-10s %-10s %-10s %-10s", ByteReader.read_u2( dis ), ByteReader.read_u2( dis ), ByteReader.read_u2( dis ), ( ( catchType > 0 ) ? constantPoolLookUp.lookUp( catchType ) : "any" ) ) );
        }
    }

}
