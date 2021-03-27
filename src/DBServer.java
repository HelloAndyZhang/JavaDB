import Interpreter.Input;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * DB服务入口类
 */
public class DBServer {

    public static void main(String[] args) {
        Input input = new Input();
        input.get("CREATE DATABASE markbook;");
        String envPort = System.getenv("javaDB.server.port");
        envPort = (envPort == null || envPort.isBlank()) ? "5432" : envPort;
        // 启动服务
        // new DBServer(Integer.valueOf(envPort));
    }

    public DBServer(Integer serverPort) {
        System.out.println("DB startup...");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("===========================DB start success==========================");
            while (true) {
                acceptClientMessage(serverSocket);
            }

        } catch (IOException e) {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ioException) {
                }
            }
            System.out.println("!!!DB error!!!, msg: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void acceptClientMessage(ServerSocket serverSocket) throws IOException {
        Socket socket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        while (true) {
            // 用户输入命令
            String messageComm = bufferedReader.readLine();
            // 处理命令
            Input input = new Input();
            input.get(messageComm);
            // 执行输入得到结果进行输出
            String outMsg = "";
            bufferedWriter.write(outMsg + "\n");
            bufferedWriter.flush();
        }
    }
}
