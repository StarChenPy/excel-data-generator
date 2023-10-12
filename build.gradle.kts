plugins {
    id("java")
}

group = "xyz.starsdust"
version = "1.0-SNAPSHOT"

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
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "utf-8"
}