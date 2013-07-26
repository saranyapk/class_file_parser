package classfileparser;

import java.io.DataInputStream;
import java.io.IOException;

public class ByteReader
{
    public static int read_u1( DataInputStream dis ) throws IOException
    {
        return dis.readUnsignedByte();
    }

    public static int read_u2( DataInputStream dis ) throws IOException
    {
        return dis.readUnsignedShort();
    }

    public static int read_u4( DataInputStream dis ) throws IOException
    {
        return dis.readInt();
    }

    public static long read_u8( DataInputStream dis ) throws IOException
    {

        return dis.readLong();
    }
}
