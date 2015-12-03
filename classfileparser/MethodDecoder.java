package classfileparser;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodDecoder
{
    private DataInputStream dis = null;
    private ConstantPoolLookUp constantPoolLookUp = null;
    private int pc;

    public void setDis(DataInputStream dis)
    {
	this.dis = dis;
    }

    public void setConstantPoolLookUp(ConstantPoolLookUp constantPoolLookUp)
    {
	this.constantPoolLookUp = constantPoolLookUp;
    }

    public void readMethodCode() throws Exception
    {
	int codeLength = ByteReader.read_u4(dis);
	for (pc = 0; pc < codeLength; pc++)
	{
	    lookUpOpcode(ByteReader.read_u1(dis));
	}
    }

    private void lookUpOpcode(Integer opcode) throws IOException, Exception
    {
	switch (opcode)
	{
	case Opcodes.NOP:

	    System.out.println("\t\t" + pc + " " + "nop");
	    break;

	case Opcodes.AALOAD:

	    System.out.println("\t\t" + pc + " " + "aaload");
	    break;

	case Opcodes.AASTORE:

	    System.out.println("\t\t" + pc + " " + "aastore");
	    break;

	case Opcodes.ACONST_NULL:

	    System.out.println("\t\t" + pc + " " + "aconst_null");
	    break;

	case Opcodes.ALOAD:

	    System.out.println("\t\t" + pc + " " + "aload " + getSimpleIndex() + "in Variable Array");
	    break;

	case Opcodes.aload_0:

	    System.out.println("\t\t" + pc + " " + "aload_0");
	    break;

	case Opcodes.aload_1:

	    System.out.println("\t\t" + pc + " " + "aload_1");
	    break;

	case Opcodes.aload_2:

	    System.out.println("\t\t" + pc + " " + "aload_2");
	    break;

	case Opcodes.aload_3:

	    System.out.println("\t\t" + pc + " " + "aload_3");
	    break;

	case Opcodes.ANEWARRAY:

	    System.out.println("\t\t" + pc + " " + "anewarray " + constantPoolLookUp.lookUp(getDoubleIndex()));
	    break;

	case Opcodes.ARETURN:

	    System.out.println("\t\t" + pc + " " + "areturn");
	    break;

	case Opcodes.ARRAYLENGTH:

	    System.out.println("\t\t" + pc + " " + "arraylength");
	    break;

	case Opcodes.ASTORE:

	    System.out.println("\t\t" + pc + " " + "astore " + getSimpleIndex() + "in Variable Array");
	    break;

	case Opcodes.astore_0:

	    System.out.println("\t\t" + pc + " " + "astore_0");
	    break;

	case Opcodes.astore_1:

	    System.out.println("\t\t" + pc + " " + "astore_1");
	    break;

	case Opcodes.astore_2:

	    System.out.println("\t\t" + pc + " " + "astore_2");
	    break;

	case Opcodes.astore_3:

	    System.out.println("\t\t" + pc + " " + "astore_3");
	    break;

	case Opcodes.ATHROW:

	    System.out.println("\t\t" + pc + " " + "athrow");
	    break;

	case Opcodes.BALOAD:

	    System.out.println("\t\t" + pc + " " + "baload");
	    break;

	case Opcodes.BASTORE:

	    System.out.println("\t\t" + pc + " " + "bastore");
	    break;

	case Opcodes.BIPUSH:

	    System.out.println("\t\t" + pc + " " + "bipush " + ByteReader.read_s1(dis));
	    pc++;
	    break;

	case Opcodes.BREAKPOINT:

	    System.out.println("\t\t" + pc + " " + "breakpoint ");
	    break;

	case Opcodes.CALOAD:

	    System.out.println("\t\t" + pc + " " + "caload");
	    break;

	case Opcodes.CASTORE:

	    System.out.println("\t\t" + pc + " " + "castore");
	    break;

	case Opcodes.CHECKCAST:

	    System.out.println("\t\t" + pc + " " + "checkcast " + constantPoolLookUp.lookUp(ByteReader.read_u2(dis)));
	    pc++;
	    pc++;
	    break;

	case Opcodes.D2F:

	    System.out.println("\t\t" + pc + " " + "d2f");
	    break;

	case Opcodes.D2I:

	    System.out.println("\t\t" + pc + " " + "d2i");
	    break;

	case Opcodes.D2L:

	    System.out.println("\t\t" + pc + " " + "d2l");
	    break;

	case Opcodes.DADD:

	    System.out.println("\t\t" + pc + " " + "dadd");
	    break;

	case Opcodes.DALOAD:

	    System.out.println("\t\t" + pc + " " + "daload");
	    break;

	case Opcodes.DASTORE:

	    System.out.println("\t\t" + pc + " " + "dastore");
	    break;

	case Opcodes.DCMPG:

	    System.out.println("\t\t" + pc + " " + "dcmpg");
	    break;

	case Opcodes.DCMPL:

	    System.out.println("\t\t" + pc + " " + "dcmpl");
	    break;

	case Opcodes.DCONST_0:

	    System.out.println("\t\t" + pc + " " + "dconst_0");
	    break;

	case Opcodes.DCONST_1:

	    System.out.println("\t\t" + pc + " " + "dconst_1");
	    break;

	case Opcodes.DDIV:

	    System.out.println("\t\t" + pc + " " + "ddiv");
	    break;

	case Opcodes.DLOAD:

	    System.out.println("\t\t" + pc + " " + "dload" + getSimpleIndex() + " in variable array.");
	    break;

	case Opcodes.dload_0:

	    System.out.println("\t\t" + pc + " " + "dload_0");
	    break;

	case Opcodes.dload_1:

	    System.out.println("\t\t" + pc + " " + "dload_1");
	    break;

	case Opcodes.dload_2:

	    System.out.println("\t\t" + pc + " " + "dload_2");
	    break;

	case Opcodes.dload_3:

	    System.out.println("\t\t" + pc + " " + "dload_3");
	    break;

	case Opcodes.DMUL:

	    System.out.println("\t\t" + pc + " " + "dmul");
	    break;

	case Opcodes.DNEG:

	    System.out.println("\t\t" + pc + " " + "dneg");
	    break;

	case Opcodes.DREM:

	    System.out.println("\t\t" + pc + " " + "drem");
	    break;

	case Opcodes.DRETURN:

	    System.out.println("\t\t" + pc + " " + "dreturn");
	    break;

	case Opcodes.DSTORE:

	    System.out.println("\t\t" + pc + " " + "dstore " + getSimpleIndex() + " in variable array");
	    break;

	case Opcodes.dstore_0:

	    System.out.println("\t\t" + pc + " " + "dstore_0");
	    break;

	case Opcodes.dstore_1:

	    System.out.println("\t\t" + pc + " " + "dstore_1");
	    break;

	case Opcodes.dstore_2:

	    System.out.println("\t\t" + pc + " " + "dstore_2");
	    break;

	case Opcodes.dstore_3:

	    System.out.println("\t\t" + pc + " " + "dstore_3");
	    break;

	case Opcodes.DSUB:

	    System.out.println("\t\t" + pc + " " + "dsub");
	    break;

	case Opcodes.DUP:

	    System.out.println("\t\t" + pc + " " + "dup");
	    break;

	case Opcodes.DUP_X1:

	    System.out.println("\t\t" + pc + " " + "dup_x1");
	    break;

	case Opcodes.DUP_X2:

	    System.out.println("\t\t" + pc + " " + "dup_x2");
	    break;
	case Opcodes.DUP2:

	    System.out.println("\t\t" + pc + " " + "dup2");
	    break;
	case Opcodes.DUP2_X1:

	    System.out.println("\t\t" + pc + " " + "dup2_x1");
	    break;
	case Opcodes.DUP2_X2:

	    System.out.println("\t\t" + pc + " " + "dup2_x2");
	    break;
	case Opcodes.F2D:

	    System.out.println("\t\t" + pc + " " + "f2d");
	    break;
	case Opcodes.F2I:

	    System.out.println("\t\t" + pc + " " + "f2i");
	    break;
	case Opcodes.F2L:

	    System.out.println("\t\t" + pc + " " + "f2l");
	    break;
	case Opcodes.FADD:

	    System.out.println("\t\t" + pc + " " + "fadd");
	    break;
	case Opcodes.FALOAD:

	    System.out.println("\t\t" + pc + " " + "faload");
	    break;
	case Opcodes.FASTORE:

	    System.out.println("\t\t" + pc + " " + "fastore");
	    break;
	case Opcodes.FCMPG:

	    System.out.println("\t\t" + pc + " " + "fcmpg");
	    break;
	case Opcodes.FCMPL:

	    System.out.println("\t\t" + pc + " " + "fcmpl");
	    break;
	case Opcodes.FCONST_0:

	    System.out.println("\t\t" + pc + " " + "fconst_0");
	    break;
	case Opcodes.FCONST_1:

	    System.out.println("\t\t" + pc + " " + "fconst_1");
	    break;
	case Opcodes.FDIV:

	    System.out.println("\t\t" + pc + " " + "fdiv");
	    break;
	case Opcodes.FLOAD:

	    System.out.println("\t\t" + pc + " " + "fload " + getSimpleIndex() + " in variable array");
	    break;
	case Opcodes.fload_0:

	    System.out.println("\t\t" + pc + " " + "fload_0");
	    break;
	case Opcodes.fload_1:

	    System.out.println("\t\t" + pc + " " + "fload_1");
	    break;
	case Opcodes.fload_2:

	    System.out.println("\t\t" + pc + " " + "fload_2");
	    break;
	case Opcodes.fload_3:

	    System.out.println("\t\t" + pc + " " + "fload_3");
	    break;
	case Opcodes.FMUL:

	    System.out.println("\t\t" + pc + " " + "fmul");
	    break;
	case Opcodes.FNEG:

	    System.out.println("\t\t" + pc + " " + "fneg");
	    break;
	case Opcodes.FREM:

	    System.out.println("\t\t" + pc + " " + "frem");
	    break;
	case Opcodes.FRETURN:

	    System.out.println("\t\t" + pc + " " + "freturn");
	    break;

	case Opcodes.FSTORE:

	    System.out.println("\t\t" + pc + " " + "fstore " + getSimpleIndex() + " in variable array");
	    break;

	case Opcodes.fstore_0:

	    System.out.println("\t\t" + pc + " " + "fstore_0");
	    break;
	case Opcodes.fstore_1:

	    System.out.println("\t\t" + pc + " " + "fstore_1");
	    break;
	case Opcodes.fstore_2:

	    System.out.println("\t\t" + pc + " " + "fstore_2");
	    break;
	case Opcodes.fstore_3:

	    System.out.println("\t\t" + pc + " " + "fstore_3");
	    break;
	case Opcodes.FSUB:

	    System.out.println("\t\t" + pc + " " + "fsub");
	    break;
	case Opcodes.GETFIELD:

	    System.out.println("\t\t" + pc + " " + "getfield " + constantPoolLookUp.lookUp(ByteReader.read_u2(dis)));
	    pc++;
	    pc++;
	    break;
	case Opcodes.GETSTATIC:

	    System.out.println("\t\t" + pc + " " + "getstatic " + constantPoolLookUp.lookUp(ByteReader.read_u2(dis)));
	    pc++;
	    pc++;
	    break;
	case Opcodes.GOTO:

	    int pcL = pc;

	    System.out.println("\t\t" + pc + " " + "goto " + (pcL + ByteReader.read_u2(dis)));
	    pc++;
	    pc++;
	    break;
	case Opcodes.goto_w:

	    pcL = pc;

	    System.out.println("\t\t" + pc + " " + "goto_w " + (pcL + ByteReader.read_s4(dis)));
	    pc++;
	    pc++;
	    pc++;
	    pc++;
	    break;
	case Opcodes.I2B:

	    System.out.println("\t\t" + pc + " " + "i2b");
	    break;
	case Opcodes.I2C:

	    System.out.println("\t\t" + pc + " " + "i2c");
	    break;
	case Opcodes.I2D:

	    System.out.println("\t\t" + pc + " " + "i2d");
	    break;
	case Opcodes.I2F:

	    System.out.println("\t\t" + pc + " " + "i2f");
	    break;
	case Opcodes.I2L:

	    System.out.println("\t\t" + pc + " " + "i2l");
	    break;
	case Opcodes.I2S:

	    System.out.println("\t\t" + pc + " " + "i2s");
	    break;
	case Opcodes.IADD:

	    System.out.println("\t\t" + pc + " " + "iadd");
	    break;
	case Opcodes.IALOAD:

	    System.out.println("\t\t" + pc + " " + "iaload");
	    break;

	case Opcodes.IAND:

	    System.out.println("\t\t" + pc + " " + "iand");
	    break;
	case Opcodes.IASTORE:

	    System.out.println("\t\t" + pc + " " + "iastore");
	    break;
	case Opcodes.ICONST_M1:

	    System.out.println("\t\t" + pc + " " + "iconst_m1");
	    break;
	case Opcodes.ICONST_0:

	    System.out.println("\t\t" + pc + " " + "iconst_0");
	    break;
	case Opcodes.ICONST_1:

	    System.out.println("\t\t" + pc + " " + "iconst_1");
	    break;
	case Opcodes.ICONST_2:

	    System.out.println("\t\t" + pc + " " + "iconst_2");
	    break;
	case Opcodes.ICONST_3:

	    System.out.println("\t\t" + pc + " " + "iconst_3");
	    break;
	case Opcodes.ICONST_4:

	    System.out.println("\t\t" + pc + " " + "iconst_4");
	    break;
	case Opcodes.ICONST_5:

	    System.out.println("\t\t" + pc + " " + "iconst_5");
	    break;
	case Opcodes.IDIV:

	    System.out.println("\t\t" + pc + " " + "idiv");
	    break;
	case Opcodes.IF_ACMPEQ:

	    System.out.println("\t\t" + pc + " " + "if_acmpeq " + getBranchInstPC());
	    break;
	case Opcodes.IF_ACMPNE:

	    System.out.println("\t\t" + pc + " " + "if_acmpne " + getBranchInstPC());
	    break;
	case Opcodes.IF_ICMPEQ:

	    System.out.println("\t\t" + pc + " " + "if_icmpeq " + getBranchInstPC());
	    break;
	case Opcodes.IF_ICMPGE:

	    System.out.println("\t\t" + pc + " " + "if_icmpge " + getBranchInstPC());
	    break;
	case Opcodes.IF_ICMPGT:

	    System.out.println("\t\t" + pc + " " + "if_icmpgt " + getBranchInstPC());
	    break;
	case Opcodes.IF_ICMPLE:

	    System.out.println("\t\t" + pc + " " + "if_icmple " + getBranchInstPC());
	    break;
	case Opcodes.IF_ICMPLT:

	    System.out.println("\t\t" + pc + " " + "if_icmplt " + getBranchInstPC());
	    break;
	case Opcodes.IF_ICMPNE:

	    System.out.println("\t\t" + pc + " " + "if_icmpne " + getBranchInstPC());
	    break;
	case Opcodes.IFNE:

	    System.out.println("\t\t" + pc + " " + "ifne " + getBranchInstPC());
	    break;
	case Opcodes.IFEQ:

	    System.out.println("\t\t" + pc + " " + "ifeq " + getBranchInstPC());
	    break;
	case Opcodes.IFGE:

	    System.out.println("\t\t" + pc + " " + "ifge " + getBranchInstPC());
	    break;
	case Opcodes.IFGT:

	    System.out.println("\t\t" + pc + " " + "ifgt " + getBranchInstPC());
	    break;
	case Opcodes.IFLE:

	    System.out.println("\t\t" + pc + " " + "ifle " + getBranchInstPC());
	    break;
	case Opcodes.IFLT:

	    System.out.println("\t\t" + pc + " " + "iflt " + getBranchInstPC());
	    break;
	case Opcodes.IFNONNULL:

	    System.out.println("\t\t" + pc + " " + "ifnotnull " + getBranchInstPC());
	    break;
	case Opcodes.IFNULL:

	    System.out.println("\t\t" + pc + " " + "ifnull " + getBranchInstPC());
	    break;
	case Opcodes.IINC:

	    System.out.println("\t\t" + pc + " " + "iinc " + getSimpleIndex() + " in variable array by " + ByteReader.read_s1(dis));
	    pc++;
	    break;
	case Opcodes.ILOAD:

	    System.out.println("\t\t" + pc + " " + "iload " + getSimpleIndex() + " in variable array");
	    break;
	case Opcodes.iload_0:

	    System.out.println("\t\t" + pc + " " + "iload_0");
	    break;
	case Opcodes.iload_1:

	    System.out.println("\t\t" + pc + " " + "iload_1");
	    break;
	case Opcodes.iload_2:

	    System.out.println("\t\t" + pc + " " + "iload_2");
	    break;
	case Opcodes.iload_3:

	    System.out.println("\t\t" + pc + " " + "iload_3");
	    break;
	case Opcodes.IMUL:

	    System.out.println("\t\t" + pc + " " + "imul");
	    break;
	case Opcodes.INEG:

	    System.out.println("\t\t" + pc + " " + "ineg");
	    break;
	case Opcodes.INSTANCEOF:

	    System.out.println("\t\t" + pc + " " + "instanceof " + constantPoolLookUp.lookUp(ByteReader.read_u2(dis)));
	    pc++;
	    pc++;
	    break;
	case Opcodes.INVOKEDYNAMIC:

	    System.out.println("\t\t" + pc + " " + "invokedynamic " + constantPoolLookUp.lookUp(ByteReader.read_u2(dis)) + " Count:" + ByteReader.read_u1(dis) + " " + ByteReader.read_u1(dis));
	    pc++;
	    pc++;
	    pc++;
	    pc++;
	    break;
	case Opcodes.INVOKEINTERFACE:

	    System.out.println("\t\t" + pc + " " + "invokeinterface " + constantPoolLookUp.lookUp(ByteReader.read_u2(dis)) + " Count:" + ByteReader.read_u1(dis) + " " + ByteReader.read_u1(dis));
	    pc++;
	    pc++;
	    pc++;
	    pc++;
	    break;

	case Opcodes.INVOKESPECIAL:

	    System.out.println("\t\t" + pc + " " + "invokespecial " + constantPoolLookUp.lookUp(ByteReader.read_u2(dis)));
	    pc++;
	    pc++;
	    break;
	case Opcodes.INVOKESTATIC:

	    System.out.println("\t\t" + pc + " " + "invokestatic " + constantPoolLookUp.lookUp(ByteReader.read_u2(dis)));
	    pc++;
	    pc++;
	    break;
	case Opcodes.INVOKEVIRTUAL:

	    System.out.println("\t\t" + pc + " " + "invokevirtual " + constantPoolLookUp.lookUp(ByteReader.read_u2(dis)));
	    pc++;
	    pc++;
	    break;
	case Opcodes.IOR:

	    System.out.println("\t\t" + pc + " " + "ior");
	    break;
	case Opcodes.IREM:

	    System.out.println("\t\t" + pc + " " + "irem");
	    break;
	case Opcodes.IRETURN:

	    System.out.println("\t\t" + pc + " " + "ireturn");
	    break;
	case Opcodes.ISHL:

	    System.out.println("\t\t" + pc + " " + "ishl");
	    break;
	case Opcodes.ISHR:

	    System.out.println("\t\t" + pc + " " + "ishr");
	    break;
	case Opcodes.ISTORE:

	    System.out.println("\t\t" + pc + " " + "istore " + constantPoolLookUp.lookUp(getSimpleIndex()));
	    break;

	case Opcodes.istore_0:

	    System.out.println("\t\t" + pc + " " + "istore_0");
	    break;
	case Opcodes.istore_1:

	    System.out.println("\t\t" + pc + " " + "istore_1");
	    break;
	case Opcodes.istore_2:

	    System.out.println("\t\t" + pc + " " + "istore_2");
	    break;
	case Opcodes.istore_3:

	    System.out.println("\t\t" + pc + " " + "istore_3");
	    break;
	case Opcodes.ISUB:

	    System.out.println("\t\t" + pc + " " + "isub");
	    break;
	case Opcodes.IUSHR:

	    System.out.println("\t\t" + pc + " " + "iushr");
	    break;
	case Opcodes.IXOR:

	    System.out.println("\t\t" + pc + " " + "ixor");
	    break;
	case Opcodes.JSR:

	    System.out.println("\t\t" + pc + " " + "jsr " + getBranchInstPC());
	    break;
	case Opcodes.JSR_W:

	    pcL = pc;
	    System.out.println("\t\t" + pc + " " + "jsr_w " + (pcL + ByteReader.read_s4(dis)));
	    pc++;
	    pc++;
	    pc++;
	    pc++;
	    break;
	case Opcodes.L2D:

	    System.out.println("\t\t" + pc + " " + "l2d");
	    break;
	case Opcodes.L2F:

	    System.out.println("\t\t" + pc + " " + "l2f");
	    break;
	case Opcodes.L2I:

	    System.out.println("\t\t" + pc + " " + "l2i");
	    break;
	case Opcodes.LADD:

	    System.out.println("\t\t" + pc + " " + "ladd");
	    break;
	case Opcodes.LALOAD:

	    System.out.println("\t\t" + pc + " " + "laload");
	    break;
	case Opcodes.LAND:

	    System.out.println("\t\t" + pc + " " + "land");
	    break;
	case Opcodes.LASTORE:

	    System.out.println("\t\t" + pc + " " + "lastore");
	    break;
	case Opcodes.LCMP:

	    System.out.println("\t\t" + pc + " " + "lcmp");
	    break;
	case Opcodes.LCONST_0:

	    System.out.println("\t\t" + pc + " " + "lconst_0");
	    break;
	case Opcodes.LCONST_1:

	    System.out.println("\t\t" + pc + " " + "lconst_1");
	    break;
	case Opcodes.LDC:

	    System.out.println("\t\t" + pc + " " + "ldc " + constantPoolLookUp.lookUp(ByteReader.read_u1(dis)));
	    pc++;
	    break;
	case Opcodes.LDC_W:

	    System.out.println("\t\t" + pc + " " + "ldc_w " + constantPoolLookUp.lookUp(getConstantPoolIndex()));
	    break;
	case Opcodes.LDC2_W:

	    System.out.println("\t\t" + pc + " " + "ldc2_w " + constantPoolLookUp.lookUp(getConstantPoolIndex()));
	    break;
	case Opcodes.LDIV:

	    System.out.println("\t\t" + pc + " " + "ldiv");
	    break;
	case Opcodes.LLOAD:

	    System.out.println("\t\t" + pc + " " + "lload " + constantPoolLookUp.lookUp(ByteReader.read_u1(dis)));
	    pc++;
	    break;
	case Opcodes.lload_0:

	    System.out.println("\t\t" + pc + " " + "lload_0");
	    break;
	case Opcodes.lload_1:

	    System.out.println("\t\t" + pc + " " + "lload_1");
	    break;
	case Opcodes.lload_2:

	    System.out.println("\t\t" + pc + " " + "lload_2");
	    break;
	case Opcodes.lload_3:

	    System.out.println("\t\t" + pc + " " + "lload_3");
	    break;
	case Opcodes.LMUL:

	    System.out.println("\t\t" + pc + " " + "lmul");
	    break;
	case Opcodes.LNEG:

	    System.out.println("\t\t" + pc + " " + "lneg");
	    break;
	case Opcodes.LOOKUPSWITCH:

	    System.out.println("\t\t" + pc + " " + "lookupswitch");

	    pad();

	    System.out.println("\t\t\t" + "default:" + " " + getIndexWithFourBytes());

	    int npairs = getIndexWithFourBytes();

	    for (int i = 0; i < npairs; i++)
	    {
		System.out.println("\t\t\t" + ByteReader.read_u4(dis) + ":" + ByteReader.read_u4(dis));
	    }

	    break;
	case Opcodes.LOR:

	    System.out.println("\t\t" + pc + " " + "lor");
	    break;
	case Opcodes.LREM:

	    System.out.println("\t\t" + pc + " " + "lrem");
	    break;
	case Opcodes.LRETURN:

	    System.out.println("\t\t" + pc + " " + "lreturn");
	    break;
	case Opcodes.LSHL:

	    System.out.println("\t\t" + pc + " " + "lshl");
	    break;
	case Opcodes.LSHR:

	    System.out.println("\t\t" + pc + " " + "lshr");
	    break;
	case Opcodes.LSTORE:

	    System.out.println("\t\t" + pc + " " + "lstore " + getSimpleIndex() + " in variable array");
	    break;
	case Opcodes.lstore_0:

	    System.out.println("\t\t" + pc + " " + "lstore_0");
	    break;
	case Opcodes.lstore_1:

	    System.out.println("\t\t" + pc + " " + "lstore_1");
	    break;
	case Opcodes.lstore_2:

	    System.out.println("\t\t" + pc + " " + "lstore_2");
	    break;
	case Opcodes.lstore_3:

	    System.out.println("\t\t" + pc + " " + "lstore_3");
	    break;
	case Opcodes.LSUB:

	    System.out.println("\t\t" + pc + " " + "lsub");
	    break;
	case Opcodes.LUSHR:

	    System.out.println("\t\t" + pc + " " + "lushr");
	    break;
	case Opcodes.LXOR:

	    System.out.println("\t\t" + pc + " " + "lxor");
	    break;
	case Opcodes.MONITORENTER:

	    System.out.println("\t\t" + pc + " " + "monitorenter ");
	    break;
	case Opcodes.MONITOREXIT:

	    System.out.println("\t\t" + pc + " " + "monitorexit ");
	    break;
	case Opcodes.MULTIANEWARRAY:

	    System.out.println("\t\t" + pc + " " + "multinewarray " + constantPoolLookUp.lookUp(ByteReader.read_u2(dis)));
	    pc++;
	    pc++;
	    System.out.println("\t\t\tDimension: " + ByteReader.read_u1(dis));
	    pc++;
	    break;
	case Opcodes.NEW:

	    System.out.println("\t\t" + pc + " " + "new " + constantPoolLookUp.lookUp(ByteReader.read_u2(dis)));
	    pc++;
	    pc++;
	    break;
	case Opcodes.NEWARRAY:

	    System.out.println("\t\t" + pc + " " + "newarray " + lookupAType());
	    break;
	case Opcodes.POP:

	    System.out.println("\t\t" + pc + " " + "pop");
	    break;
	case Opcodes.POP2:

	    System.out.println("\t\t" + pc + " " + "pop2");
	    break;
	case Opcodes.PUTFIELD:

	    System.out.println("\t\t" + pc + " " + "putfield " + constantPoolLookUp.lookUp(getDoubleIndex()));
	    break;
	case Opcodes.PUTSTATIC:

	    System.out.println("\t\t" + pc + " " + "putstatic " + constantPoolLookUp.lookUp(getDoubleIndex()));
	    break;
	case Opcodes.RET:

	    System.out.println("\t\t" + pc + " " + "ret " + getSimpleIndex());
	    break;
	case Opcodes.RETURN:

	    System.out.println("\t\t" + pc + " " + "return");
	    break;
	case Opcodes.SALOAD:

	    System.out.println("\t\t" + pc + " " + "saload");
	    break;
	case Opcodes.SASTORE:

	    System.out.println("\t\t" + pc + " " + "sastore");
	    break;
	case Opcodes.SIPUSH:

	    System.out.println("\t\t" + pc + " " + "sipush " + constantPoolLookUp.lookUp(getConstantPoolIndex()));
	    break;
	case Opcodes.SWAP:

	    System.out.println("\t\t" + pc + " " + "swap");
	    break;
	case Opcodes.TABLESWITCH:

	    System.out.println("\t\t" + pc + " " + "tableswitch");

	    pcL = pc;

	    pad();

	    System.out.println("\t\t\t" + "default:" + " " + (pcL + getIndexWithFourBytesSigned()));

	    int low = getIndexWithFourBytesSigned();

	    int high = getIndexWithFourBytesSigned();

	    for (int i = 0; i < (high - low + 1); i++)
	    {
		System.out.println("\t\t\t" + i + ":" + (pcL + ByteReader.read_u4(dis)));
		pc++;
		pc++;
		pc++;
		pc++;
	    }

	    break;
	case Opcodes.WIDE:

	    System.out.println("\t\t" + pc + " " + "wide");
	    lookupWideOpCode(ByteReader.read_u1(dis));
	    break;
	default:
	    System.out.println("Unimplemented OP_CODE:" + opcode);
	}

    }

    public void lookupWideOpCode(int opcode) throws Exception
    {
	switch (opcode)
	{
	case Opcodes.ILOAD:

	    System.out.println("\t\t" + pc + " " + "iload " + getDoubleIndex() + " in variable array");
	    break;

	case Opcodes.ISTORE:

	    System.out.println("\t\t" + pc + " " + "istore " + constantPoolLookUp.lookUp(getConstantPoolIndex()));
	    break;

	case Opcodes.FLOAD:

	    System.out.println("\t\t" + pc + " " + "fload " + getDoubleIndex() + " in variable array");
	    break;

	case Opcodes.FSTORE:

	    System.out.println("\t\t" + pc + " " + "fstore " + getDoubleIndex() + " in variable array");
	    break;

	case Opcodes.ASTORE:

	    System.out.println("\t\t" + pc + " " + "astore " + getDoubleIndex() + "in Variable Array");
	    break;

	case Opcodes.ALOAD:

	    System.out.println("\t\t" + pc + " " + "aload " + getDoubleIndex() + "in Variable Array");
	    break;

	case Opcodes.LLOAD:

	    System.out.println("\t\t" + pc + " " + "lload " + constantPoolLookUp.lookUp(getConstantPoolIndex()));
	    break;

	case Opcodes.LSTORE:

	    System.out.println("\t\t" + pc + " " + "lstore " + getDoubleIndex() + " in variable array");
	    break;

	case Opcodes.DLOAD:

	    System.out.println("\t\t" + pc + " " + "dload" + getDoubleIndex() + " in variable array.");
	    break;

	case Opcodes.DSTORE:

	    System.out.println("\t\t" + pc + " " + "dstore " + getDoubleIndex() + " in variable array");
	    break;

	case Opcodes.RET:

	    System.out.println("\t\t" + pc + " " + "ret " + getDoubleIndex());
	    break;

	case Opcodes.IINC:

	    System.out.println("\t\t" + pc + " " + "iinc " + getDoubleIndex() + " in variable array by " + ByteReader.read_s2(dis));
	    pc++;
	    pc++;
	    break;

	default:
	    System.out.println("Unimplemented OP_CODE:" + opcode);
	}
    }

    private Integer getIndexWithFourBytes() throws IOException
    {
	int indexbyte1 = ByteReader.read_u1(dis) & 0xFF;
	pc++;
	int indexbyte2 = ByteReader.read_u1(dis) & 0xFF;
	pc++;
	int indexbyte3 = ByteReader.read_u1(dis) & 0xFF;
	pc++;
	int indexbyte4 = ByteReader.read_u1(dis) & 0xFF;
	pc++;

	return (indexbyte1 << 24) | (indexbyte2 << 16) | (indexbyte3 << 8) | indexbyte4;
    }

    private Integer getIndexWithFourBytesSigned() throws IOException
    {
	int indexbyte1 = ByteReader.read_s1(dis);
	pc++;
	int indexbyte2 = ByteReader.read_s1(dis);
	pc++;
	int indexbyte3 = ByteReader.read_s1(dis);
	pc++;
	int indexbyte4 = ByteReader.read_s1(dis);
	pc++;

	return (indexbyte1 << 24) | (indexbyte2 << 16) | (indexbyte3 << 8) | indexbyte4;
    }

    private int getSimpleIndex() throws IOException
    {
	pc++;
	return ByteReader.read_u1(dis);
    }

    private int getConstantPoolIndex() throws IOException
    {
	pc++;
	pc++;
	return ByteReader.read_u2(dis);
    }

    private int getDoubleIndex() throws IOException
    {
	int indexbyte1 = ByteReader.read_u1(dis) & 0xFF;
	pc++;
	int indexbyte2 = ByteReader.read_u1(dis) & 0xFF;
	pc++;
	return indexbyte1 << 8 | indexbyte2;
    }

    private int getBranchInstPC() throws IOException
    {
	int pcL = pc;
	pc++;
	pc++;
	return pcL + ByteReader.read_s2(dis);
    }

    private void pad() throws IOException
    {
	switch (pc % 4)
	{
	case 0:
	    for (int i = 1; i <= 3; i++)
	    {
		ByteReader.read_u1(dis);
		pc++;
	    }
	    break;
	case 1:
	    for (int i = 1; i <= 2; i++)
	    {
		ByteReader.read_u1(dis);
		pc++;
	    }
	    break;

	case 2:
	    ByteReader.read_u1(dis);
	    pc++;
	    break;

	case 3:
	    //No nothing
	    break;
	}
    }

    private String lookupAType() throws IOException //Array Type
    {
	int i = ByteReader.read_u1(dis);
	pc++;
	switch (i)
	{
	case 4:
	    return "T_BOOLEAN";
	case 5:
	    return "T_CHAR";
	case 6:
	    return "T_FLOAT";
	case 7:
	    return "T_DOUBLE";
	case 8:
	    return "T_BYTE";
	case 9:
	    return "T_SHORT";
	case 10:
	    return "T_INT";
	case 11:
	    return "T_LONG";
	default:
	    return "";
	}
    }
}
