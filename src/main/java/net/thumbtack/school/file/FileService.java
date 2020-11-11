package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.ColoredRectangle;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileService {

    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            bos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        return readByteArrayFromBinaryFile(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            return fis.readAllBytes();
        }
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(array.length)) {
            baos.writeBytes(array);
            try (ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray())) {
                byte[] array1 = new byte[bais.available() / 2];
                byte[] array2 = bais.readAllBytes();
                for (int i = 0; i < array2.length; i += 2) {
                    array1[i / 2] = array2[i];
                }
                return array1;
            }
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            bos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        return readByteArrayFromBinaryFileBuffered(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            return bufferedInputStream.readAllBytes();
        }
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeInt(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            Rectangle rect = new Rectangle();
            rect.getTopLeft().setX(dis.readInt());
            rect.getTopLeft().setY(dis.readInt());
            rect.getBottomRight().setX(dis.readInt());
            rect.getBottomRight().setY(dis.readInt());
            return rect;
        }
    }

    public static void writeColoredRectangleToBinaryFile(File file, ColoredRectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeUTF(rect.getColor().name());
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeInt(rect.getBottomRight().getY());
        }
    }

    public static ColoredRectangle readColoredRectangleFromBinaryFile(File file) throws IOException, ColorException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            ColoredRectangle coloredRect = new ColoredRectangle();
            coloredRect.setColor(dis.readUTF());
            coloredRect.getTopLeft().setX(dis.readInt());
            coloredRect.getTopLeft().setY(dis.readInt());
            coloredRect.getBottomRight().setX(dis.readInt());
            coloredRect.getBottomRight().setY(dis.readInt());
            return coloredRect;
        }
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (Rectangle rect : rects) {
                dos.writeInt(rect.getTopLeft().getX());
                dos.writeInt(rect.getTopLeft().getY());
                dos.writeInt(rect.getBottomRight().getX());
                dos.writeInt(rect.getBottomRight().getY());
            }
        }
    }


    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            int len = (int) (raf.length() / 16);
            Rectangle[] array = new Rectangle[len];
            for (int i = 0; i < len; i++) {
                raf.seek(len * 16 - 16 * (i + 1));
                Rectangle rect = new Rectangle();
                rect.getTopLeft().setX(raf.readInt());
                rect.getTopLeft().setY(raf.readInt());
                rect.getBottomRight().setX(raf.readInt());
                rect.getBottomRight().setY(raf.readInt());
                array[i] = rect;
            }
            return array;
        }
    }


    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            Gson gson = new Gson();
            gson.toJson(rect, bw);
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException {
        try (BufferedReader br = new BufferedReader((new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)))) {
            Gson gson = new Gson();
            return gson.fromJson(br, Rectangle.class);
        }
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException {
         try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            bw.write(rect.getBottomRight().getX() + "\n");
            bw.write(rect.getBottomRight().getY() + "\n");
            bw.write(rect.getTopLeft().getX() + "\n");
            bw.write(rect.getTopLeft().getY() + "\n");
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException {
        try (BufferedReader br = new BufferedReader((new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)))) {
            Rectangle rect = new Rectangle();
            rect.getBottomRight().setX(Integer.parseInt(br.readLine()));
            rect.getBottomRight().setY(Integer.parseInt(br.readLine()));
            rect.getTopLeft().setX(Integer.parseInt(br.readLine()));
            rect.getTopLeft().setY(Integer.parseInt(br.readLine()));
            return rect;
        }
    }


    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            Gson gson = new Gson();
            gson.toJson(trainee, bw);
        }
    }


    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException {
        try (BufferedReader br = new BufferedReader((new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)))) {
            Gson gson = new Gson();
            return gson.fromJson(br, Trainee.class);
        }
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            bw.write(trainee.getFirstName() + "\n");
            bw.write(trainee.getLastName() + "\n");
            bw.write(trainee.getRating() + "\n");
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        try (BufferedReader br = new BufferedReader((new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)))) {
            return new Trainee(br.readLine(), br.readLine(), Integer.parseInt(br.readLine()));
        }
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(trainee);
        }
    }


    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Trainee) ois.readObject();
        }
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            bw.write(serializeTraineeToJsonString(trainee));
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        try (BufferedReader br = new BufferedReader((new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)))) {
            return deserializeTraineeFromJsonString(br.readLine());
        }
    }


}



