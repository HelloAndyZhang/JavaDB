import SqlEngine.*;
import SqlEngine.Parser.ParseException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * DB服务入口类
 */
public class DBServer {

    final static char EOT = 4;

    public static void main(String[] args) throws ParseException {
        String envPort = System.getenv("javaDB.server.port");
        envPort = (envPort == null || envPort.isBlank()) ? "5432" : envPort;
        // 启动服务
        new DBServer(Integer.valueOf(envPort));
    }

    public DBServer(Integer serverPort) throws ParseException {
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

    private void acceptClientMessage(ServerSocket serverSocket) throws ParseException,IOException {
        Socket socket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        SqlRun sqlRun = new SqlRun();
        while (true) {
            // 用户输入命令
            String messageComm = bufferedReader.readLine();
            List<String> resList = sqlRun.Run(messageComm);
            if (resList != null && resList.size() > 0){
                resList.forEach(res -> {
                    try {
                        bufferedWriter.write(res +"\n"+ EOT +"\n");
                        bufferedWriter.flush();
                    } catch (IOException e) {
                        try {
                            bufferedWriter.write("[Error]" + "\n");
                        } catch (IOException ioException) {}
                        e.printStackTrace();
                    }
                });
            }
            // 处理命令
            // Input input = new Input();
            // input.execute(messageComm);
            // 执行输入得到结果进行输出
//            String outMsg = "";
//            bufferedWriter.write(outMsg + "\n");
//            bufferedWriter.flush();
        }
    }
}
