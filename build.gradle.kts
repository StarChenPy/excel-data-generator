plugins {
    id("java")
    id("org.openjfx.javafxplugin") version "0.1.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "xyz.starsdust"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    // junit
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")

    // excel文件操作
    implementation("com.alibaba:easyexcel:3.3.2")

    // json文件解析
    implementation("org.immutables:gson:2.10.0")

    implementation("org.slf4j:slf4j-simple:2.0.9")
}

javafx {
    version = "21"
    modules("javafx.controls", "javafx.fxml")
    setPlatform("windows")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "utf-8"
}