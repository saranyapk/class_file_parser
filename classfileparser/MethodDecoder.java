package classfileparser;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodDecoder
{
    private DataInputStream dis = null;
    private ConstantPoolLookUp constantPoolLookUp = null;
    private int pc;

    public void setDis( DataInputStream dis )
    {
        this.dis = dis;
    }

    public void setConstantPoolLookUp( ConstantPoolLookUp constantPoolLookUp )
    {
        this.constantPoolLookUp = constantPoolLookUp;
    }

    public void readMethodCode() throws Exception
    {
        int codeLength = ByteReader.read_u4( dis );
        for ( pc = 0; pc < codeLength; pc++ )
        {
            lookUpOpcode( ByteReader.read_u1( dis ) );
        }
    }

    private void lookUpOpcode( Integer opcode ) throws IOException, Exception
    {
        if ( opcode.equals( Opcodes.AALOAD ) )
        {
            System.out.println( "\t\t" + pc + " " + "aaload" );
        }
        else if ( opcode.equals( Opcodes.AASTORE ) )
        {
            System.out.println( "\t\t" + pc + " " + "aastore" );
        }
        else if ( opcode.equals( Opcodes.ACONST_NULL ) )
        {
            System.out.println( "\t\t" + pc + " " + "aconst_null" );
        }
        else if ( opcode.equals( Opcodes.ALOAD ) )
        {
            System.out.println( "\t\t" + pc + " " + "aload " + getSimpleIndex() + "in Variable Array" );
        }
        else if ( opcode.equals( Opcodes.aload_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "aload_0" );
        }
        else if ( opcode.equals( Opcodes.aload_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "aload_1" );
        }
        else if ( opcode.equals( Opcodes.aload_2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "aload_2" );
        }
        else if ( opcode.equals( Opcodes.aload_3 ) )
        {
            System.out.println( "\t\t" + pc + " " + "aload_3" );
        }
        else if ( opcode.equals( Opcodes.ASTORE ) )
        {
            System.out.println( "\t\t" + pc + " " + "astore " + getSimpleIndex() + "in Variable Array" );
        }
        else if ( opcode.equals( Opcodes.astore_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "astore_0" );
        }
        else if ( opcode.equals( Opcodes.astore_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "astore_1" );
        }
        else if ( opcode.equals( Opcodes.astore_2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "astore_2" );
        }
        else if ( opcode.equals( Opcodes.astore_3 ) )
        {
            System.out.println( "\t\t" + pc + " " + "astore_3" );
        }
        else if ( opcode.equals( Opcodes.ATHROW ) )
        {
            System.out.println( "\t\t" + pc + " " + "athrow" );
        }
        else if ( opcode.equals( Opcodes.BALOAD ) )
        {
            System.out.println( "\t\t" + pc + " " + "baload" );
        }
        else if ( opcode.equals( Opcodes.BASTORE ) )
        {
            System.out.println( "\t\t" + pc + " " + "bastore" );
        }
        else if ( opcode.equals( Opcodes.BIPUSH ) )
        {
            System.out.println( "\t\t" + pc + " " + "bipush " + ByteReader.read_s1( dis ) );
            pc++;
        }
        else if ( opcode.equals( Opcodes.BREAKPOINT ) )
        {
            System.out.println( "\t\t" + pc + " " + "breakpoint " );
        }
        else if ( opcode.equals( Opcodes.CALOAD ) )
        {
            System.out.println( "\t\t" + pc + " " + "caload" );
        }
        else if ( opcode.equals( Opcodes.CASTORE ) )
        {
            System.out.println( "\t\t" + pc + " " + "castore" );
        }
        else if ( opcode.equals( Opcodes.CHECKCAST ) )
        {
            System.out.println( "\t\t" + pc + " " + "checkcast " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            pc++;
            pc++;
        }
        else if ( opcode.equals( Opcodes.D2F ) )
        {
            System.out.println( "\t\t" + pc + " " + "d2f" );
        }
        else if ( opcode.equals( Opcodes.D2I ) )
        {
            System.out.println( "\t\t" + pc + " " + "d2i" );
        }
        else if ( opcode.equals( Opcodes.D2L ) )
        {
            System.out.println( "\t\t" + pc + " " + "d2l" );
        }
        else if ( opcode.equals( Opcodes.DADD ) )
        {
            System.out.println( "\t\t" + pc + " " + "dadd" );
        }
        else if ( opcode.equals( Opcodes.DALOAD ) )
        {
            System.out.println( "\t\t" + pc + " " + "daload" );
        }
        else if ( opcode.equals( Opcodes.DASTORE ) )
        {
            System.out.println( "\t\t" + pc + " " + "dastore" );
        }
        else if ( opcode.equals( Opcodes.DCMPG ) )
        {
            System.out.println( "\t\t" + pc + " " + "dcmpg" );
        }
        else if ( opcode.equals( Opcodes.DCMPL ) )
        {
            System.out.println( "\t\t" + pc + " " + "dcmpl" );
        }
        else if ( opcode.equals( Opcodes.DCONST_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dconst_0" );
        }
        else if ( opcode.equals( Opcodes.DCONST_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dconst_1" );
        }
        else if ( opcode.equals( Opcodes.DDIV ) )
        {
            System.out.println( "\t\t" + pc + " " + "ddiv" );
        }
        else if ( opcode.equals( Opcodes.DLOAD ) )
        {
            System.out.println( "\t\t" + pc + " " + "dload" + getSimpleIndex() + " in variable array." );
        }
        else if ( opcode.equals( Opcodes.dload_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dload_0" );
        }
        else if ( opcode.equals( Opcodes.dload_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dload_1" );
        }
        else if ( opcode.equals( Opcodes.dload_2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dload_2" );
        }
        else if ( opcode.equals( Opcodes.dload_3 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dload_3" );
        }
        else if ( opcode.equals( Opcodes.DMUL ) )
        {
            System.out.println( "\t\t" + pc + " " + "dmul" );
        }
        else if ( opcode.equals( Opcodes.DNEG ) )
        {
            System.out.println( "\t\t" + pc + " " + "dneg" );
        }
        else if ( opcode.equals( Opcodes.DREM ) )
        {
            System.out.println( "\t\t" + pc + " " + "drem" );
        }
        else if ( opcode.equals( Opcodes.DRETURN ) )
        {
            System.out.println( "\t\t" + pc + " " + "dreturn" );
        }
        else if ( opcode.equals( Opcodes.DSTORE ) )
        {
            System.out.println( "\t\t" + pc + " " + "dstore " + getSimpleIndex() + " in variable array" );
        }
        else if ( opcode.equals( Opcodes.dstore_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dstore_0" );
        }
        else if ( opcode.equals( Opcodes.dstore_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dstore_1" );
        }
        else if ( opcode.equals( Opcodes.dstore_2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dstore_2" );
        }
        else if ( opcode.equals( Opcodes.dstore_3 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dstore_3" );
        }
        else if ( opcode.equals( Opcodes.DSUB ) )
        {
            System.out.println( "\t\t" + pc + " " + "dsub" );
        }
        else if ( opcode.equals( Opcodes.DUP ) )
        {
            System.out.println( "\t\t" + pc + " " + "dup" );
        }
        else if ( opcode.equals( Opcodes.DUP_X1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dup_x1" );
        }
        else if ( opcode.equals( Opcodes.DUP_X2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dup_x2" );
        }
        else if ( opcode.equals( Opcodes.DUP2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dup2" );
        }
        else if ( opcode.equals( Opcodes.DUP2_X1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dup2_x1" );
        }
        else if ( opcode.equals( Opcodes.DUP2_X2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "dup2_x2" );
        }
        else if ( opcode.equals( Opcodes.F2D ) )
        {
            System.out.println( "\t\t" + pc + " " + "f2d" );
        }
        else if ( opcode.equals( Opcodes.F2I ) )
        {
            System.out.println( "\t\t" + pc + " " + "f2i" );
        }
        else if ( opcode.equals( Opcodes.F2L ) )
        {
            System.out.println( "\t\t" + pc + " " + "f2l" );
        }
        else if ( opcode.equals( Opcodes.FADD ) )
        {
            System.out.println( "\t\t" + pc + " " + "fadd" );
        }
        else if ( opcode.equals( Opcodes.FALOAD ) )
        {
            System.out.println( "\t\t" + pc + " " + "faload" );
        }
        else if ( opcode.equals( Opcodes.FASTORE ) )
        {
            System.out.println( "\t\t" + pc + " " + "fastore" );
        }
        else if ( opcode.equals( Opcodes.FCMPG ) )
        {
            System.out.println( "\t\t" + pc + " " + "fcmpg" );
        }
        else if ( opcode.equals( Opcodes.FCMPL ) )
        {
            System.out.println( "\t\t" + pc + " " + "fcmpl" );
        }
        else if ( opcode.equals( Opcodes.FCONST_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fconst_0" );
        }
        else if ( opcode.equals( Opcodes.FCONST_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fconst_1" );
        }
        else if ( opcode.equals( Opcodes.FDIV ) )
        {
            System.out.println( "\t\t" + pc + " " + "fdiv" );
        }
        else if ( opcode.equals( Opcodes.FLOAD ) )
        {
            System.out.println( "\t\t" + pc + " " + "fload " + getSimpleIndex() + " in variable array" );
        }
        else if ( opcode.equals( Opcodes.fload_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fload_0" );
        }
        else if ( opcode.equals( Opcodes.fload_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fload_1" );
        }
        else if ( opcode.equals( Opcodes.fload_2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fload_2" );
        }
        else if ( opcode.equals( Opcodes.fload_3 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fload_3" );
        }
        else if ( opcode.equals( Opcodes.FMUL ) )
        {
            System.out.println( "\t\t" + pc + " " + "fmul" );
        }
        else if ( opcode.equals( Opcodes.FNEG ) )
        {
            System.out.println( "\t\t" + pc + " " + "fneg" );
        }
        else if ( opcode.equals( Opcodes.FREM ) )
        {
            System.out.println( "\t\t" + pc + " " + "frem" );
        }
        else if ( opcode.equals( Opcodes.FRETURN ) )
        {
            System.out.println( "\t\t" + pc + " " + "freturn" );
        }
        else if ( opcode.equals( Opcodes.FSTORE ) )
        {
            System.out.println( "\t\t" + pc + " " + "fstore " + getSimpleIndex() + " in variable array" );
        }
        else if ( opcode.equals( Opcodes.fstore_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fstore_0" );
        }
        else if ( opcode.equals( Opcodes.fstore_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fstore_1" );
        }
        else if ( opcode.equals( Opcodes.fstore_2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fstore_2" );
        }
        else if ( opcode.equals( Opcodes.fstore_3 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fstore_3" );
        }
        else if ( opcode.equals( Opcodes.FSUB ) )
        {
            System.out.println( "\t\t" + pc + " " + "fsub" );
        }
        else if ( opcode.equals( Opcodes.GETFIELD ) )
        {
            System.out.println( "\t\t" + pc + " " + "getfield " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            pc++;
            pc++;
        }
        else if ( opcode.equals( Opcodes.GETSTATIC ) )
        {
            System.out.println( "\t\t" + pc + " " + "getstatic " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            pc++;
            pc++;
        }
        else if ( opcode.equals( Opcodes.GOTO ) )
        {
            System.out.println( "\t\t" + pc + " " + "goto " + ByteReader.read_s2( dis ) );
            pc++;
            pc++;
        }
        else if ( opcode.equals( Opcodes.goto_w ) )
        {
            System.out.println( "\t\t" + pc + " " + "goto_w " + ByteReader.read_s4( dis ) );
            pc++;
            pc++;
            pc++;
            pc++;
        }
        else if ( opcode.equals( Opcodes.I2B ) )
        {
            System.out.println( "\t\t" + pc + " " + "i2b" );
        }
        else if ( opcode.equals( Opcodes.I2C ) )
        {
            System.out.println( "\t\t" + pc + " " + "i2c" );
        }
        else if ( opcode.equals( Opcodes.I2D ) )
        {
            System.out.println( "\t\t" + pc + " " + "i2d" );
        }
        else if ( opcode.equals( Opcodes.I2F ) )
        {
            System.out.println( "\t\t" + pc + " " + "i2f" );
        }
        else if ( opcode.equals( Opcodes.I2L ) )
        {
            System.out.println( "\t\t" + pc + " " + "i2l" );
        }
        else if ( opcode.equals( Opcodes.I2S ) )
        {
            System.out.println( "\t\t" + pc + " " + "i2s" );
        }
        else if ( opcode.equals( Opcodes.IADD ) )
        {
            System.out.println( "\t\t" + pc + " " + "iadd" );
        }
        else if ( opcode.equals( Opcodes.IALOAD ) )
        {
            System.out.println( "\t\t" + pc + " " + "iaload" );
        }
        else if ( opcode.equals( Opcodes.IAND ) )
        {
            System.out.println( "\t\t" + pc + " " + "iand" );
        }
        else if ( opcode.equals( Opcodes.IASTORE ) )
        {
            System.out.println( "\t\t" + pc + " " + "iastore" );
        }
        else if ( opcode.equals( Opcodes.ICONST_M1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "iconst_m1" );
        }
        else if ( opcode.equals( Opcodes.IDIV ) )
        {
            System.out.println( "\t\t" + pc + " " + "idiv" );
        }
        else if ( opcode.equals( Opcodes.IF_ACMPEQ ) )
        {
            System.out.println( "\t\t" + pc + " " + "if_acmpeq " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IF_ACMPNE ) )
        {
            System.out.println( "\t\t" + pc + " " + "if_acmpne " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IF_ICMPEQ ) )
        {
            System.out.println( "\t\t" + pc + " " + "if_icmpeq " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IF_ICMPGE ) )
        {
            System.out.println( "\t\t" + pc + " " + "if_icmpge " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IF_ICMPGT ) )
        {
            System.out.println( "\t\t" + pc + " " + "if_icmpgt " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IF_ICMPLE ) )
        {
            System.out.println( "\t\t" + pc + " " + "if_icmple " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IF_ICMPLT ) )
        {
            System.out.println( "\t\t" + pc + " " + "if_icmplt " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IF_ICMPNE ) )
        {
            System.out.println( "\t\t" + pc + " " + "if_icmpne " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IFNE ) )
        {
            System.out.println( "\t\t" + pc + " " + "ifne " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IFEQ ) )
        {
            System.out.println( "\t\t" + pc + " " + "ifeq " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IFGE ) )
        {
            System.out.println( "\t\t" + pc + " " + "ifge " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IFGT ) )
        {
            System.out.println( "\t\t" + pc + " " + "ifgt " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IFLE ) )
        {
            System.out.println( "\t\t" + pc + " " + "ifle " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IFLT ) )
        {
            System.out.println( "\t\t" + pc + " " + "iflt " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IFNONNULL ) )
        {
            System.out.println( "\t\t" + pc + " " + "ifnotnull " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IFNULL ) )
        {
            System.out.println( "\t\t" + pc + " " + "ifnull " + getBranchInstPC() );
        }
        else if ( opcode.equals( Opcodes.IINC ) )
        {
            System.out.println( "\t\t" + pc + " " + "iinc " + getSimpleIndex() + " in variable array by " + ByteReader.read_s1( dis ) );
            pc++;
        }
        else if ( opcode.equals( Opcodes.ILOAD ) )
        {
            System.out.println( "\t\t" + pc + " " + "iload " + getSimpleIndex() + " in variable array" );
        }
        else if ( opcode.equals( Opcodes.iload_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "iload_0" );
        }
        else if ( opcode.equals( Opcodes.iload_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "iload_1" );
        }
        else if ( opcode.equals( Opcodes.iload_2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "iload_2" );
        }
        else if ( opcode.equals( Opcodes.iload_3 ) )
        {
            System.out.println( "\t\t" + pc + " " + "iload_3" );
        }
        else if ( opcode.equals( Opcodes.IMUL ) )
        {
            System.out.println( "\t\t" + pc + " " + "imul" );
        }
        else if ( opcode.equals( Opcodes.INEG ) )
        {
            System.out.println( "\t\t" + pc + " " + "ineg" );
        }
        else if ( opcode.equals( Opcodes.INSTANCEOF ) )
        {
            System.out.println( "\t\t" + pc + " " + "instanceof " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            pc++;
            pc++;
        }
        else if ( opcode.equals( Opcodes.INVOKEINTERFACE ) )
        {
            System.out.println( "\t\t" + pc + " " + "invokeinterface " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) + " Count:" + ByteReader.read_u1( dis ) + " " + ByteReader.read_u1( dis ) );
            pc++;
            pc++;
            pc++;
            pc++;
        }
        else if ( opcode.equals( Opcodes.INVOKEDYNAMIC ) )
        {
            System.out.println( "\t\t" + pc + " " + "invokedynamic " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) + " Count:" + ByteReader.read_u1( dis ) + " " + ByteReader.read_u1( dis ) );
            pc++;
            pc++;
            pc++;
            pc++;
        }
        else if ( opcode.equals( Opcodes.INVOKESPECIAL ) )
        {
            System.out.println( "\t\t" + pc + " " + "invokespecial " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            pc++;
            pc++;
        }
        else if ( opcode.equals( Opcodes.INVOKESTATIC ) )
        {
            System.out.println( "\t\t" + pc + " " + "invokestatic " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            pc++;
            pc++;
        }
        else if ( opcode.equals( Opcodes.INVOKEVIRTUAL ) )
        {
            System.out.println( "\t\t" + pc + " " + "invokevirtual " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            pc++;
            pc++;
        }

        else if ( opcode.equals( Opcodes.ISTORE ) )
        {
            System.out.println( "\t\t" + pc + " " + "istore " + constantPoolLookUp.lookUp( getSimpleIndex() ) );
        }
        else if ( opcode.equals( Opcodes.istore_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "istore_0" );
        }
        else if ( opcode.equals( Opcodes.istore_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "istore_1" );
        }
        else if ( opcode.equals( Opcodes.istore_2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "istore_2" );
        }
        else if ( opcode.equals( Opcodes.istore_3 ) )
        {
            System.out.println( "\t\t" + pc + " " + "istore_3" );
        }
        else if ( opcode.equals( Opcodes.LSTORE ) )
        {
            System.out.println( "\t\t" + pc + " " + "lstore " + getSimpleIndex() + " in variable array" );
        }
        else if ( opcode.equals( Opcodes.lstore_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "lstore_0" );
        }
        else if ( opcode.equals( Opcodes.lstore_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "lstore_1" );
        }
        else if ( opcode.equals( Opcodes.lstore_2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "lstore_2" );
        }
        else if ( opcode.equals( Opcodes.lstore_3 ) )
        {
            System.out.println( "\t\t" + pc + " " + "lstore_3" );
        }
        else if ( opcode.equals( Opcodes.RETURN ) )
        {
            System.out.println( "\t\t" + pc + " " + "return" );
        }
        else if ( opcode.equals( Opcodes.NEW ) )
        {
            System.out.println( "\t\t" + pc + " " + "new " + constantPoolLookUp.lookUp( ByteReader.read_u2( dis ) ) );
            pc++;
            pc++;
        }
        else if ( opcode.equals( Opcodes.MONITORENTER ) )
        {
            System.out.println( "\t\t" + pc + " " + "monitorenter " );
        }
        else if ( opcode.equals( Opcodes.MONITOREXIT ) )
        {
            System.out.println( "\t\t" + pc + " " + "monitorexit " );
        }
        else if ( opcode.equals( Opcodes.FCONST_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fconst_0" );
        }
        else if ( opcode.equals( Opcodes.FCONST_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fconst_1" );
        }
        else if ( opcode.equals( Opcodes.FCONST_2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "fconst_2" );
        }
        else if ( opcode.equals( Opcodes.POP ) )
        {
            System.out.println( "\t\t" + pc + " " + "pop" );
        }
        else if ( opcode.equals( Opcodes.POP2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "pop2" );
        }

        else if ( opcode.equals( Opcodes.ICONST_0 ) )
        {
            System.out.println( "\t\t" + pc + " " + "iconst_0" );
        }
        else if ( opcode.equals( Opcodes.ICONST_1 ) )
        {
            System.out.println( "\t\t" + pc + " " + "iconst_1" );
        }
        else if ( opcode.equals( Opcodes.ICONST_2 ) )
        {
            System.out.println( "\t\t" + pc + " " + "iconst_2" );
        }
        else if ( opcode.equals( Opcodes.ICONST_3 ) )
        {
            System.out.println( "\t\t" + pc + " " + "iconst_3" );
        }
        else if ( opcode.equals( Opcodes.ICONST_4 ) )
        {
            System.out.println( "\t\t" + pc + " " + "iconst_4" );
        }
        else if ( opcode.equals( Opcodes.ICONST_5 ) )
        {
            System.out.println( "\t\t" + pc + " " + "iconst_5" );
        }
        else if ( opcode.equals( Opcodes.ARETURN ) )
        {
            System.out.println( "\t\t" + pc + " " + "areturn" );
        }
        else if ( opcode.equals( Opcodes.ARRAYLENGTH ) )
        {
            System.out.println( "\t\t" + pc + " " + "arraylength" );
        }
        else if ( opcode.equals( Opcodes.ANEWARRAY ) )
        {
            System.out.println( "\t\t" + pc + " " + "anewarray " + constantPoolLookUp.lookUp( getDoubleIndex() ) );
        }
        else if ( opcode.equals( Opcodes.LDC ) )
        {
            System.out.println( "\t\t" + pc + " " + "ldc " + constantPoolLookUp.lookUp( ByteReader.read_u1( dis ) ) );
            pc++;
        }
        else if ( opcode.equals( Opcodes.LDC_W ) )
        {
            System.out.println( "\t\t" + pc + " " + "ldc_w " + constantPoolLookUp.lookUp( getConstantPoolIndex() ) );
        }
        else if ( opcode.equals( Opcodes.LDC2_W ) )
        {
            System.out.println( "\t\t" + pc + " " + "ldc2_w " + constantPoolLookUp.lookUp( getConstantPoolIndex() ) );
        }
        else if ( opcode.equals( Opcodes.PUTSTATIC ) )
        {
            System.out.println( "\t\t" + pc + " " + "putstatic " + constantPoolLookUp.lookUp( getDoubleIndex() ) );
        }
        else if ( opcode.equals( Opcodes.PUTFIELD ) )
        {
            System.out.println( "\t\t" + pc + " " + "putfield " + constantPoolLookUp.lookUp( getDoubleIndex() ) );
        }
        else
        {
            System.out.println( "Unimplemented OP_CODE:" + opcode );
        }
    }

    private Integer getIndexWithFourBytes() throws IOException
    {
        int indexbyte1 = ByteReader.read_u1( dis ) & 0xFF;
        pc++;
        int indexbyte2 = ByteReader.read_u1( dis ) & 0xFF;
        pc++;
        int indexbyte3 = ByteReader.read_u1( dis ) & 0xFF;
        pc++;
        int indexbyte4 = ByteReader.read_u1( dis ) & 0xFF;
        pc++;

        return ( indexbyte1 << 24 ) | ( indexbyte2 << 16 ) | ( indexbyte3 << 8 ) | indexbyte4;
    }

    private int getSimpleIndex() throws IOException
    {
        pc++;
        return ByteReader.read_u1( dis );
    }

    private int getConstantPoolIndex() throws IOException
    {
        pc++;
        pc++;
        return ByteReader.read_u2( dis );
    }

    private int getDoubleIndex() throws IOException
    {
        int indexbyte1 = ByteReader.read_u1( dis ) & 0xFF;
        pc++;
        int indexbyte2 = ByteReader.read_u1( dis ) & 0xFF;
        pc++;
        return indexbyte1 << 8 | indexbyte2;
    }

    private int getBranchInstPC() throws IOException
    {
        pc++;
        pc++;
        return ByteReader.read_s2( dis );
    }
}
