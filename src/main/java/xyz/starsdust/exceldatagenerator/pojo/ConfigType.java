package xyz.starsdust.exceldatagenerator.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ConfigType {
    @SerializedName("inputFilePath")
    private String inputPath;

    @SerializedName("inputConfig")
    private List<DataInputType> inputConfigList;

    @SerializedName("outputFilePath")
    private String outputPath;

    @SerializedName("outputConfig")
    private List<DataOutputType> outputConfigList;
}
