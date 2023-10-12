package xyz.starsdust.exceldatagenerator.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ConfigType {
    @SerializedName("inputConfig")
    private List<DataInputType> inputConfigList;

    @SerializedName("outputConfig")
    private List<DataOutputType> outputConfigList;
}
