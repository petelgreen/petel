import readers.Read;
import readers.factory.ReadFactory;
import transform.LabTestTransforming;
import transform.Transform;
import transform.factory.TransformFactory;
import writers.Write;
import writers.factory.WriteFactory;
import writers.keys.KeysCreate;
import writers.types.JSONWriter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        KeysCreate keys = new KeysCreate();

        ReadFactory readFactory = new ReadFactory();
        TransformFactory transformFactory = new TransformFactory();
        WriteFactory writeFactory = new WriteFactory();

        Read reader = readFactory.getReader("csv");
        List<String[]> madaReports = reader.read("C:\\Users\\yoles\\Desktop\\petel\\hospital\\src\\main\\resources\\MadaReports.csv");
        List<String[]> labTests = reader.read("C:\\Users\\yoles\\Desktop\\petel\\hospital\\src\\main\\resources\\LabTests.csv");

        Transform transform = transformFactory.getTransform("lab test");
        transform.transform(labTests);

        Write jsonWriter = writeFactory.getWriter("json");
        jsonWriter.write(madaReports, "C:\\Users\\yoles\\Desktop\\petel\\source\\AJson\\mada", keys.getMadaRepoKeys());

        Write xmlWriter = writeFactory.getWriter("xml");
        xmlWriter.write(labTests, "C:\\Users\\yoles\\Desktop\\petel\\source\\LEBTESTS\\test", keys.getLabKeys());

    }


}
