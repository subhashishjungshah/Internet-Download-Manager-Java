import config.Config;
import model.FileInfo;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static int index = 0;

    public static class DownloadThread extends Thread{
        private FileInfo fileInfo;
        private String path = Config.downloadLocation;

        public DownloadThread(FileInfo fileInfo){
            this.fileInfo = fileInfo;
        }

        @Override
        public void run() {
            try {
                fileInfo.setDownloadStatus("Downloading");
                System.out.println(fileInfo.getDownloadStatus());
                long bytesCopied = Files.copy(new URL(fileInfo.getUrl()).openStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
                if (bytesCopied > 0) {
                    fileInfo.setDownloadStatus("Download completed");
                    System.out.println(fileInfo.getDownloadStatus());
                } else {
                    fileInfo.setDownloadStatus("Download failed: no data was copied");
                    System.out.println(fileInfo.getDownloadStatus());
                }
            } catch (IOException e) {
                fileInfo.setDownloadStatus("Download Failed");
                System.out.println(fileInfo.getDownloadStatus());
                throw new RuntimeException(e);
            }

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** Welcome to Internet Download Manager ***");
        System.out.println("Enter the download Url, you want to download:");
        String downloadURL = scanner.nextLine();
        /* http://subhashish.com/python */
        String fileName = downloadURL.substring(downloadURL.lastIndexOf("/")+1);
        String status = "Starting Download";
        FileInfo fileInfo = new FileInfo(index++,fileName,downloadURL,status);
        DownloadThread dw = new DownloadThread(fileInfo);
        dw.start();
    }
}