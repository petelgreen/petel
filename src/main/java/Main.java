import readers.Read;
import readers.factory.ReadFactory;
import transform.PositivePeopleTransforming;
import transform.Transform;
import transform.factory.TransformFactory;
import transform.vailidation.SerologyTestsValidation;
import writers.Write;
import writers.factory.WriteFactory;
import writers.keys.KeysCreate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        KeysCreate keys = new KeysCreate();

        ReadFactory readFactory = new ReadFactory();
        TransformFactory transformFactory = new TransformFactory();
        WriteFactory writeFactory = new WriteFactory();

        Read reader = readFactory.getReader("csv");
        List<String[]> serology = reader.read("C:\\Users\\yoles\\Desktop\\petel\\hospital\\src\\main\\resources\\Serology.csv");

        Transform transform = transformFactory.getTransform("serology");
        transform.transform(serology);

        SerologyTestsValidation validation = new SerologyTestsValidation();
        validation.valid(serology);

        Write sqlWriter = writeFactory.getWriter("sql");
        sqlWriter.write(serology, "LabResults_SerologyKits", keys.getSerologyTestsKeys());


//        Read reader = readFactory.getReader("csv");
//        List<String[]> madaReports = reader.read("C:\\Users\\yoles\\Desktop\\petel\\hospital\\src\\main\\resources\\MadaReports.csv");
//        List<String[]> labTests = reader.read("C:\\Users\\yoles\\Desktop\\petel\\hospital\\src\\main\\resources\\LabTests.csv");
//
//        Transform transform = transformFactory.getTransform("lab test");
//        transform.transform(labTests);
//
//        Write jsonWriter = writeFactory.getWriter("json length limit");
//        jsonWriter.write(madaReports, "C:\\Users\\yoles\\Desktop\\petel\\source\\AJson\\mada", keys.getMadaRepoKeys());
//
//        Write xmlWriter = writeFactory.getWriter("xml");
//        xmlWriter.write(labTests, "C:\\Users\\yoles\\Desktop\\petel\\source\\LEBTESTS\\test", keys.getLabKeys());
//
//        String path = "C:\\Users\\yoles\\Desktop\\petel\\source\\POSITIVE_LAB_TESTS\\result";
//        List<String[]> positivePeople = new PositivePeopleTransforming().transform(madaReports, labTests);
//        Write jsonWriterWithSizeLimit = writeFactory.getWriter("json size limit");
//        jsonWriterWithSizeLimit.write(positivePeople, path, keys.getPositivePeopleKeys());



    }


}
