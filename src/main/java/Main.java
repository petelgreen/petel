import readers.Read;
import readers.factory.ReadFactory;
import transform.LabTestTransforming;
import transform.Transform;
import transform.factory.TransformFactory;
import writers.Write;
import writers.factory.WriteFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReadFactory readFactory = new ReadFactory();
        Read reader = readFactory.getReader("csv");
        List<String[]> MadaReports = reader.read("C:\\Users\\yoles\\Desktop\\petel\\hospital\\src\\main\\resources\\MadaReports.csv");

        String writePath = "C:\\Users\\yoles\\Desktop\\petel\\source\\LEBTESTS\\test";
        String resourcePath = "C:\\Users\\yoles\\Desktop\\petel\\hospital\\src\\main\\resources\\LabTests.csv";
        List<String[]> labTests = reader.read(resourcePath);

        TransformFactory transformFactory = new TransformFactory();
        Transform transform = transformFactory.getTransform("lab Test");
        transform.transform(labTests);

        WriteFactory writeFactory = new WriteFactory();
        Write writer = writeFactory.getWriter("xml");
        writer.write(labTests, writePath, getLabKeys());
    }

    public static List<String> getLabKeys() {
        List<String> keys = new ArrayList<>();
        keys.add("IDNum");
        keys.add("IDType");
        keys.add("firstName");
        keys.add("lastName");
        keys.add("resultDate");
        keys.add("birthDate");
        keys.add("labCode");
        keys.add("stickerNumber");
        keys.add("resultTestCorona");
        keys.add("variant");
        keys.add("testType");
        keys.add("joinDate");
        keys.add("healthCareId");
        keys.add("healthCareName");
        return keys;
    }
}
