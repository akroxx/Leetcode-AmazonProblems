/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int writer = 0, readLen = 4;

        char buf4[] = new char[4];

        while(writer < n && readLen == 4){
            readLen = read4(buf4);

            for(int i = 0; i < readLen; i++){
                if(writer == n){
                    return writer;
                }
                buf[writer++] = buf4[i];
            }
        }

        return writer;
    }
}