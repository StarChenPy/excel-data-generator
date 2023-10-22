package xyz.starsdust.exceldatagenerator.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import xyz.starsdust.exceldatagenerator.util.log.MyLog;

import java.io.IOException;
import java.net.URL;

public class Resource {
    public static URL getResource(String path) {
        URL url = Resource.class.getResource(path);
        if (url == null) {
            MyLog.err("未找到资源，路径为: " + path);
        }
        return url;
    }

    public static Parent loadParentView(String path) {
        Parent parent;

        try {
            parent = FXMLLoader.load(getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return parent;
    }

    public static Node loadNodeView(String path) {
        Node node;

        try {
            node = FXMLLoader.load(getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return node;
    }
}
