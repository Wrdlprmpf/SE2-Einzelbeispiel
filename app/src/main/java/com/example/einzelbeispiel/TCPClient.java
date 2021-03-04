package com.example.einzelbeispiel;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;


    public TCPClient(String address, int port){
        this(tryCatch(address, port));
    }

    public TCPClient(Socket socket) {
        this.socket = socket;
        try {
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static Socket tryCatch(String address, int port) {
        try {
            return new Socket(address, port);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String readLine() {
        try {
            return check(reader.readLine());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private String check(String s) {
        if (s == null) {
            throw new UncheckedIOException(new IOException("End of stream"));
        }
        else {
            return s;
        }
    }

    public void writeLine(String text) {
        write(text + "\r\n");
    }

    private void write(String text) {
        try {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void close() {
        try { socket.close(); } catch (IOException ignored) { }
        try { reader.close(); } catch (IOException ignored) { }
        try { writer.close(); } catch (IOException ignored) { }
    }
}