package xyz.starsdust.exceldatagenerator.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConfigType {
    @SerializedName("inputFilePath")
    private String inputPath;

    @SerializedName("inputConfig")
    private List<DataInputType> inputConfigList;

    @SerializedName("outputFilePath")
    private String outputPath;

    @SerializedName("outputConfig")
    private List<DataOutputType> outputConfigList;

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public List<DataInputType> getInputConfigList() {
        return inputConfigList;
    }

    public void setInputConfigList(List<DataInputType> inputConfigList) {
        this.inputConfigList = inputConfigList;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public List<DataOutputType> getOutputConfigList() {
        return outputConfigList;
    }

    public void setOutputConfigList(List<DataOutputType> outputConfigList) {
        this.outputConfigList = outputConfigList;
    }
}
