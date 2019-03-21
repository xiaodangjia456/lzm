package com.source.root.tools.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.CharBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
@SuppressWarnings({ "unused"})
public class SocketClient {  
	  
    public static final Object locked = new Object();  
    public static final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(  
            1024 * 100);  
  
    class SendThread extends Thread{  
        private Socket socket;  
        public SendThread(Socket socket) {  
            this.socket = socket;  
        }  
        @Override  
        public void run() {  
            while(true){  
                try {  
                    String send = getSend();              
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));  
                    pw.write(send);  
                    pw.flush();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        public String getSend() throws InterruptedException{  
            Thread.sleep(3000);  
            return "microclimate,open";  
        }  
    }  
  
    class ReceiveThread extends Thread{  
        private Socket socket;  
          
        public ReceiveThread(Socket socket) {  
            this.socket = socket;  
        }  
  
        @Override  
        public void run() {  
            while(true){  
                try {                     
                    Reader reader = new InputStreamReader(socket.getInputStream());  
                    CharBuffer charBuffer = CharBuffer.allocate(8192);  
                    int index = -1;
                    String readMsg = "";
                    while((index=reader.read(charBuffer))!=-1){  
                        charBuffer.flip();  
                        readMsg = charBuffer.toString();
                        System.out.println("client:"+readMsg);  
                        break;
                    }  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
      
    public void start(Socket socket) throws UnknownHostException, IOException{  
        //Socket socket = new Socket("192.168.0.21",1111);  
        new SendThread(socket).start();  
        new ReceiveThread(socket).start();  
    }  
    public static void main(String[] args) throws UnknownHostException, IOException {  
    	Socket socket = new Socket("192.168.0.21",1111);  
        new SocketClient().start(socket);  
    }  
}  
